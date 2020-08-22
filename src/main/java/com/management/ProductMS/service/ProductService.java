package com.management.ProductMS.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.ProductMS.dto.ProductDTO;

import com.management.ProductMS.entity.Product;

import com.management.ProductMS.repository.ProductRepository;



@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	


	public List<ProductDTO> getproducts() {
		List<Product> product = productRepository.findAll();
		List<ProductDTO> productDTO = new ArrayList<ProductDTO>();
		for (Product p1 : product) {
			ProductDTO product1 = ProductDTO.valueof(p1);
			productDTO.add(product1);
		}
		return productDTO;
	}

	public List<ProductDTO> getproductsonCategory(String category) {
		List<Product> product = productRepository.findAll();
		List<ProductDTO> productDTO = new ArrayList<ProductDTO>();
		for (Product p1 : product) {
			if (p1.getCategory().equals(category)) {
				ProductDTO product1 = ProductDTO.valueof(p1);
				productDTO.add(product1);
			}

		}
		return productDTO;
	}

	public List<ProductDTO> getproductsonName(String productName) {
		List<Product> product = productRepository.findAll();
		List<ProductDTO> productDTO = new ArrayList<ProductDTO>();
		for (Product p1 : product) {
			if (p1.getProductName().equals(productName)) {
				ProductDTO product1 = ProductDTO.valueof(p1);
				productDTO.add(product1);
			}

		}
		return productDTO;

	}

		


	public ProductDTO getProductByProdid(int prodid) {
		ProductDTO productDTO=null;
		List<Product> products= productRepository.findAll();
		
		
		for(Product product : products) {
			if((product.getProdid())==prodid) {
			productDTO=ProductDTO.valueOf(product);
			}
			
		}
		
			
		
		return productDTO;
	}
}
