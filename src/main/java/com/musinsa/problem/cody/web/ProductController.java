package com.musinsa.problem.cody.web;

import com.musinsa.problem.cody.application.ProductService;
import com.musinsa.problem.cody.web.dto.ProductDataRequest;
import com.musinsa.problem.cody.web.dto.ProductResponse;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/v1")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("")
  public ResponseEntity<ProductResponse> createProduct(
      @RequestBody ProductDataRequest productDataRequest) {
    return ResponseEntity.ok(productService.createProduct(productDataRequest));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductResponse> updateProduct(
      @PathVariable Long id, @RequestBody ProductDataRequest productDataRequest) {
    return ResponseEntity.ok(productService.updateProduct(id, productDataRequest));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Instant> deleteProduct(@PathVariable Long id) {
    return ResponseEntity.ok(productService.deleteProduct(id));
  }
}
