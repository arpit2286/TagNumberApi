package com.example.demo;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ProductController {

  private final ProductRepository repository;

  ProductController(ProductRepository repository) {
    this.repository = repository;
  }

  // Aggregate root

  @GetMapping("/tagNumbers")
  List<Product> all() {
    return repository.findAll();
  }

  @PostMapping("/tagNumbers")
  List<Object> getProductLineItems(@RequestBody ProductRequest newProduct) {
	List<Object> response =new ArrayList<>();
	  for(String tag:newProduct.getTagNumber()) {
		 response.add (repository.findById(tag));	      
	}
	return response;
  }

  // Single item

  @GetMapping("/sku/{tagNumber}")
  Product one(@PathVariable String tagNumber) {

    return repository.findById(tagNumber)
      .orElseThrow(() -> new ProductNotFoundException(tagNumber));
  }

}
