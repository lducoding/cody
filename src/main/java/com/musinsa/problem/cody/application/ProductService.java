package com.musinsa.problem.cody.application;

import static com.musinsa.problem.cody.common.exception.ExceptionConstants.ERROR_BRAND_NOT_FOUND;
import static com.musinsa.problem.cody.common.exception.ExceptionConstants.ERROR_PRODUCT_NOT_FOUND;

import com.musinsa.problem.cody.common.exception.NotFoundException;
import com.musinsa.problem.cody.domain.entity.Brand;
import com.musinsa.problem.cody.domain.entity.BrandRepository;
import com.musinsa.problem.cody.domain.entity.Product;
import com.musinsa.problem.cody.domain.entity.ProductRepository;
import com.musinsa.problem.cody.web.dto.ProductDataRequest;
import com.musinsa.problem.cody.web.dto.ProductResponse;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

  private final ProductRepository productRepository;
  private final BrandRepository brandRepository;

  public ProductService(ProductRepository productRepository, BrandRepository brandRepository) {
    this.productRepository = productRepository;
    this.brandRepository = brandRepository;
  }

  public ProductResponse createProduct(ProductDataRequest productDataRequest) {
    Brand brand =
        brandRepository
            .findByIdAndDeletedAtIsNull(productDataRequest.brandId())
            .orElseThrow(
                () ->
                    new NotFoundException(
                        ERROR_BRAND_NOT_FOUND,
                        "삭제되지 않은 Brand가 존재하지 않습니다 id: " + productDataRequest.brandId()));

    Product product =
        new Product(
            productDataRequest.category(),
            productDataRequest.price(),
            productDataRequest.categoryOrderNumber(),
            brand);

    return ProductResponse.of(productRepository.save(product));
  }

  public ProductResponse updateProduct(Long id, ProductDataRequest productDataRequest) {
    Product product =
        productRepository
            .findByIdAndDeletedAtIsNull(id)
            .orElseThrow(
                () ->
                    new NotFoundException(
                        ERROR_PRODUCT_NOT_FOUND, "삭제되지 않은 Product가 존재하지 않습니다 id: " + id));

    Brand brand =
        brandRepository
            .findByIdAndDeletedAtIsNull(productDataRequest.brandId())
            .orElseThrow(
                () ->
                    new NotFoundException(
                        ERROR_BRAND_NOT_FOUND,
                        "삭제되지 않은 Brand가 존재하지 않습니다 id: " + productDataRequest.brandId()));

    product.updateAll(
        productDataRequest.category(),
        productDataRequest.price(),
        productDataRequest.categoryOrderNumber(),
        brand);

    return ProductResponse.of(product);
  }

  public Instant deleteProduct(Long id) {
    Product product =
        productRepository
            .findByIdAndDeletedAtIsNull(id)
            .orElseThrow(
                () ->
                    new NotFoundException(
                        ERROR_PRODUCT_NOT_FOUND, "삭제되지 않은 Product가 존재하지 않습니다 id: " + id));

    return product.delete();
  }
}
