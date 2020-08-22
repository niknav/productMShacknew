package com.management.ProductMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.management.ProductMS.dto.ProductDTO;

import com.management.ProductMS.service.ProductService;


@RestController
@CrossOrigin
public class ProductController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ProductService productService;
	

	@GetMapping(value = "/products")
	public List<ProductDTO> getproducts() {
		List<ProductDTO> productDto = productService.getproducts();
		return productDto;
	}
	@GetMapping(value = "/products/{prodid}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO getProductByProductid(@PathVariable int prodid) {
		return productService.getProductByProdid(prodid);
	}
	@GetMapping(value = "/products/category/{category}")
	public List<ProductDTO> getproductsonCategory(@PathVariable String category) {
		List<ProductDTO> productDto = productService.getproductsonCategory(category);
		return productDto;
	}
	@GetMapping(value = "/products/name/{productname}")
	public List<ProductDTO> getproductsonName(@PathVariable("productname") String productName) {
		List<ProductDTO> productDto = productService.getproductsonName(productName);
		return productDto;
	}
	
	

	

}