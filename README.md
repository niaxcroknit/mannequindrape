# 마네킹 드레이프 3D

옷 실측표 숫자만 넣으면 밑단과 소매 끝이 내 몸 어디에 오는지 보여주는 안드로이드 앱이에요.

- 앱 화면: `app/src/main/assets/index.html` (WebView로 여는 한 장짜리 페이지, 인터넷 권한 없음)
- 패키지 이름: `com.drape.mannequin3d` · 대상 API 36 · 최소 API 26
- 스토어용 .aab: 안드로이드 스튜디오에서 내 업로드 키로 만들어요 (**Build → Generate Signed App Bundle**)
- 자동 빌드: `main`에 올리면 [Actions](../../actions)에서 빌드를 확인하고 휴대폰 설치용 `.apk`를 만들어요.
- 개인정보처리방침: https://niaxcroknit.github.io/mannequindrape/privacy.html (`docs/`, GitHub Pages)
- 스토어 등록 자료: `스토어등록자료/`
- 등록 순서: [등록안내.md](등록안내.md)

키 파일(`*.jks`)과 `keystore.properties`는 저장소에 올라가지 않게 막혀 있어요.
