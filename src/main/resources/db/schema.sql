-- 브랜드 테이블 생성
CREATE TABLE IF NOT EXISTS brand
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(100),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
    );

-- 상품 테이블 생성
CREATE TABLE IF NOT EXISTS product
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    category   VARCHAR(100) NOT NULL,
    price      INT NOT NULL,
    category_order_number INT NOT NULL,
    brand_id   BIGINT NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT fk_product_brand FOREIGN KEY (brand_id) REFERENCES brand (id)
    );
