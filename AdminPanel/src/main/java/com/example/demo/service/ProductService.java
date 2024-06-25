package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ProductModel;
import com.example.demo.repostitory.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public String insertProducts(List<ProductModel> products){
		return productRepo.insertProductsInDB(products);
	}

	public Map<String, Object> getAllProducts() {
		return productRepo.getProductsInDB();
		
	}

}
