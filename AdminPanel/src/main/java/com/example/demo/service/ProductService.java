package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ProductModel;
import com.example.demo.repostitory.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public void insertProducts(List<ProductModel> products){
		productRepo.insertProductsInDB(products);
	}

}
