# Cody 프로젝트

**Cody**는 카테고리별로 의류를 구매하여 코디를 완성하는 API 기반 애플리케이션입니다.  
Layered Architecture 기반으로 설계되었습니다.

---

## Requirements

로컬 환경에서 개발 및 빌드를 위해 아래 소프트웨어가 필요합니다:

- **Java 17**
    - 권장 설치: [Adoptium Eclipse Temurin JDK](https://adoptium.net)

---

## Database

본 프로젝트는 개발 및 테스트 용도로 **H2 In-Memory Database**를 사용합니다.

- **자동 로딩 SQL**
    - `classpath:db/schema.sql` : DB 스키마 정의
    - `classpath:db/data.sql` : 초기 데이터 로딩
- **H2 콘솔 접근 경로**
    - [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- ⚠️ JVM 메모리 위에 생성되므로 애플리케이션 종료 시 모든 데이터가 삭제됩니다.

---

##  Scope

- **카테고리별 최저가 브랜드 및 상품 가격 조회**
    - 각 카테고리별 1개의 브랜드만 조회됩니다.
    - 동일한 가격이 다수일 경우 Brand를 골고루 보여주기 위해 가장 적게 조회된 Brand를 노출시킴
    - 그래도 중복일 경우 브랜드 이름을 오름차순 정렬하여 선택

- **단일 브랜드로 전 카테고리 커버 시 최저가 조합 조회**

- **카테고리 이름으로 최고·최저가 브랜드 및 상품 가격 조회**

- **브랜드/상품 등록, 수정, 삭제 기능 제공**

---

## Getting Started

### Java 17이 필요합니다
```bash
./gradlew bootJar
java -jar build/libs/cody-0.0.1-SNAPSHOT.jar
```

### docker로 실행할 경우
```bash
docker run -p 8080:8080 lducoding/cody:1.0
```

## Build & Test
```bash
./gradlew clean build
./gradlew test
```

## API Reference
Clothes (상품 가격 조회 관련)
```
GET	/clothes/v1/lowest-prices/categories	카테고리별 최저가 브랜드 및 가격 조회
GET	/clothes/v1/lowest-prices/brands	단일 브랜드로 모든 카테고리 커버 가능한 최저가 조회
GET	/clothes/v1/lowest-prices/categories/{categoryName}	특정 카테고리의 최고/최저가 브랜드 및 상품 가격 조회
```
Brands (브랜드 관리)
```
POST	/brands/v1	브랜드 등록
PUT	/brands/v1/{id}	브랜드 수정
DELETE	/brands/v1/{id}	브랜드 삭제
```
Products (상품 관리)
```
POST	/products/v1	상품 등록
PUT	/products/v1/{id}	상품 수정
DELETE	/products/v1/{id}	상품 삭제
```

## Project Structure
```
root/
├── application                  ▶ 비즈니스 로직 계층
│   ├── dto                      ▶ 서비스 내부 전용 DTO
│   ├── Service.java             ▶ 핵심 서비스 클래스
│   └── common.exception         ▶ 글로벌/커스텀 예외 처리
│
├── domain                       ▶ 도메인 모델 계층
│   ├── entity                   ▶ JPA 엔티티 및 레포지토리
│   ├── enums                    ▶ Enum 클래스
│   ├── model                    ▶ VO + 메서드 포함 객체
│   └── vo                       ▶ 불변 VO 객체 (로직 없음)
│
├── infra                        ▶ 외부 연동 및 Repository 확장
│   ├── RepositoryCustom.java
│   └── RepositoryCustomImpl.java
│
├── web                          ▶ API 요청/응답 계층
│   ├── dto                      ▶ API 요청/응답 DTO
│   └── Controller.java          ▶ REST Controller

```
