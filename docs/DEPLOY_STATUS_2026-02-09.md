# starstarsuri_BE 배포 상태 점검 (2026-02-09)

## 결론
현재 운영 서버(43.202.84.110)의 starstarsuri 백엔드는 **소스 프로젝트가 아닌 JAR 파일(/opt/suri/suri.jar) 기반으로만 운영**되고 있음.

## 확인 근거
- systemd: `suri.service` ExecStart가 `java -jar /opt/suri/suri.jar --server.port=8080 ...`
- 서버 전체 검색 결과:
  - `build.gradle / settings.gradle / pom.xml` (star/suri 관련) 미발견
  - star/suri 관련 `.git` 디렉터리 미발견
- `/home/ubuntu/suri.tgz` 내부 확인 결과: `suri.jar`만 존재 (소스 파일 없음)

## 현재 운영 런타임 위치
- JAR: `/opt/suri/suri.jar`
- 설정: `/etc/suri/application.properties`
- 서비스: `/etc/systemd/system/suri.service`

## 리스크
- 레포(`starstarsuri_BE`)와 운영 상태 간 동기화 불가 (소스 미보유)
- 장애/기능 변경 시 소스 기반 유지보수 난이도 증가

## 복구 TODO
1. 원본 소스 위치 확보(개발자 로컬PC, 이전 서버, 팀 백업 저장소)
2. 확보한 소스를 `starstarsuri_BE` 레포에 반영
3. CI/CD 또는 배포 스크립트에 커밋 해시 기록(`REVISION`) 추가
4. 운영 비밀값(.env, application-prod 등) Git 미추적 규칙 유지