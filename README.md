# 🌟 별별집수리 Backend

집수리 홈페이지 프론트엔드와 연동되는 게시판/문의 웹 서비스의 백엔드 레포지토리입니다.

http://starstarsuri.o-r.kr/

## 🖥️ 소개

- RESTful API로 게시글/문의 CRUD를 제공합니다.
- **MySQL** 데이터베이스와 연동되어 데이터를 관리합니다.
- 보안 및 확장성을 고려한 구조로 설계되었습니다.

## 🚀 주요 기능

- 게시글/문의글 등록, 조회, 수정, 삭제 API 제공
- 게시글 목록 페이징/검색
- 프론트엔드 배포 파일(정적 리소스) 서비스 지원

## 🛠️ 사용 기술

- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL**
- **Gradle**
- **Spring Security**
- **Azure VM** 배포 경험

## 📦 프로젝트 실행 방법

```bash
# 1. 레포지토리 클론
git clone https://github.com/yourname/starstarsuri_BE.git
cd starstarsuri_BE

# 2. 환경 변수(.env) 또는 application.yml/properties 설정
# 예시: src/main/resources/application.properties

# 3. 빌드 및 실행
./gradlew build
java -jar build/libs/board-0.0.1-SNAPSHOT.jar
