package com.musinsa.problem.cody.web;

import com.musinsa.problem.cody.application.BrandService;
import com.musinsa.problem.cody.web.dto.BrandDataRequest;
import com.musinsa.problem.cody.web.dto.BrandResponse;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands/v1")
@RequiredArgsConstructor
public class BrandController {

  private final BrandService brandService;

  @PostMapping("")
  public ResponseEntity<BrandResponse> createBrand(@RequestBody BrandDataRequest brandDataRequest) {
    return ResponseEntity.ok(brandService.createBrand(brandDataRequest));
  }

  @PutMapping("/{id}")
  public ResponseEntity<BrandResponse> updateBrand(
      @PathVariable Long id, @RequestBody BrandDataRequest request) {
    return ResponseEntity.ok(brandService.updateBrand(id, request));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Instant> deleteBrand(@PathVariable Long id) {
    return ResponseEntity.ok(brandService.deleteBrand(id));
  }
}
