# 마네킹 드레이프 3D

옷 실측표 숫자만 넣으면 밑단과 소매 끝이 내 몸 어디에 오는지 보여주는 안드로이드 앱이에요.

- 앱 화면: `app/src/main/assets/index.html` (WebView로 여는 한 장짜리 페이지, 인터넷 권한 없음)
- 패키지 이름: `com.drape.mannequin3d` · 대상 API 36 · 최소 API 26
- 자동 빌드: `main`에 올리면 [Actions](../../actions)에서 `.aab`(스토어용)와 `.apk`(휴대폰 설치용)를 만들어요.
- 스토어 등록 자료: `스토어등록자료/`
- 등록 순서: [등록안내.md](등록안내.md)

## 업로드 키
릴리스 빌드는 아래 값이 있을 때 서명돼요. 키 파일은 저장소에 올리지 않아요.
- GitHub Actions: 저장소 비밀값 `UPLOAD_KEYSTORE_BASE64`, `UPLOAD_STORE_PASSWORD`, `UPLOAD_KEY_ALIAS`, `UPLOAD_KEY_PASSWORD`
- 내 컴퓨터: 맨 위 폴더의 `keystore.properties` (`.gitignore`로 제외)
