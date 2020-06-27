package com.example.demo;

public class ProductNotFoundException extends RuntimeException {

	ProductNotFoundException(String id) {
    super("Could not find Details for " + id);
  }
}