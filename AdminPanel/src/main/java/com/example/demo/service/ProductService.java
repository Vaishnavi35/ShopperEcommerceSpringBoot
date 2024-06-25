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

	public Map<String, Object> getCategory() {
		// TODO Auto-generated method stub
		return productRepo.getCategory();
	}

	public Map<String, Object> getSubCategory() {
		// TODO Auto-generated method stub
		return productRepo.getSubCategory();
	}

	public Map<String, Object> getProductType() {
		// TODO Auto-generated method stub
		return productRepo.getProductType();
	}
}
