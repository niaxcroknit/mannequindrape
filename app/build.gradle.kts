import java.util.Properties
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

// 업로드 키 정보: 내 컴퓨터에서는 keystore.properties 파일에서, GitHub 자동 빌드에서는 저장소 비밀값에서 읽어요.
// 두 곳 다 없으면 서명 없는 빌드를 만들어요 (실행 확인용으로는 문제없어요).
val keystoreProps = Properties().apply {
    val f = rootProject.file("keystore.properties")
    if (f.exists()) f.inputStream().use { load(it) }
}
fun signing(key: String, env: String): String? =
    keystoreProps.getProperty(key) ?: System.getenv(env)?.takeIf { it.isNotBlank() }
val uploadStoreFile = signing("storeFile", "UPLOAD_STORE_FILE")

android {
    // 패키지 이름: 플레이 스토어에 처음 올린 뒤에는 바꿀 수 없어요. 바꾸려면 첫 업로드 전에 applicationId를 바꾸세요.
    namespace = "com.drape.mannequin3d"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.drape.mannequin3d"
        minSdk = 26
        targetSdk = 36
        // 업데이트를 올릴 때마다 versionCode는 1씩 올려요. versionName은 사람이 읽는 버전 이름이에요.
        versionCode = 1
        versionName = "1.0.0"
    }

    signingConfigs {
        if (uploadStoreFile != null) {
            create("upload") {
                storeFile = rootProject.file(uploadStoreFile)
                storePassword = signing("storePassword", "UPLOAD_STORE_PASSWORD")
                keyAlias = signing("keyAlias", "UPLOAD_KEY_ALIAS")
                keyPassword = signing("keyPassword", "UPLOAD_KEY_PASSWORD")
            }
        }
    }

    buildTypes {
        release {
            if (uploadStoreFile != null) signingConfig = signingConfigs.getByName("upload")
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

dependencies {
    implementation("androidx.activity:activity-ktx:1.9.3")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.webkit:webkit:1.12.1")
}
