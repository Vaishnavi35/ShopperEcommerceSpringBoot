package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.ProductModel;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping("/insertProducts")
	public void insertProduct(@RequestBody List<ProductModel> products) {
		System.out.println("insert product : "+products);
		productService.insertProducts(products);
	}

}
