# JavaCampus Identity Notes

이 버전은 ASP.NET Core Identity의 기본 흐름을 참고하여 다음 기능을 Spring Boot 4 + Spring Security + JPA + H2 조합으로 구성했습니다.

## 적용된 경로
- 로그인: `/Identity/Account/Login`
- 회원가입: `/Identity/Account/Register`
- 회원정보: `/Identity/Account/Manage/Index`
- 로그아웃: `/Identity/Account/Logout`
- 관리자 대시보드: `/Dashboard`, `/Administrations/Dashboard`

## 기본 시드 데이터
- Role: `Administrators`
- Role: `Users`
- User: `Administrator`
- Password: `Pa$$w0rd`

## 테이블
- `AspNetUsers`
- `AspNetRoles`
- `AspNetUserRoles`

## 참고
- 기존 JavaCampus 데모 페이지를 최대한 유지하기 위해 CSRF는 비활성화했습니다.
- 개발 및 데모 용도이므로 H2 인메모리 데이터베이스를 사용합니다.
- 애플리케이션을 다시 시작하면 인메모리 데이터는 초기화됩니다.
