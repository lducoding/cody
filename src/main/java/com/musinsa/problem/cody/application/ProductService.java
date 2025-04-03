package com.musinsa.problem.cody.application;

import com.musinsa.problem.cody.domain.entity.Brand;
import com.musinsa.problem.cody.domain.entity.BrandRepository;
import com.musinsa.problem.cody.domain.entity.Product;
import com.musinsa.problem.cody.domain.entity.ProductRepository;
import com.musinsa.problem.cody.web.dto.ProductDataRequest;
import com.musinsa.problem.cody.web.dto.ProductResponse;
import jakarta.persistence.EntityNotFoundException;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  private final BrandRepository brandRepository;

  public ProductResponse createProduct(ProductDataRequest productDataRequest) {
    Brand brand =
        brandRepository
            .findById(productDataRequest.brandId())
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "Brand not found with id: " + productDataRequest.brandId()));

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
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Brand not found with id: " + id));

    Brand brand =
        brandRepository
            .findById(productDataRequest.brandId())
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "Brand not found with id: " + productDataRequest.brandId()));

    product.updateAll(
        productDataRequest.category(),
        productDataRequest.price(),
        productDataRequest.categoryOrderNumber(),
        brand);

    return ProductResponse.of(product);
  }
}
