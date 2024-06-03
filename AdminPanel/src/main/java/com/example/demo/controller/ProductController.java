package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductModel;

@RestController
@RequestMapping("products")
public class ProductController {

	@PostMapping("/insertProducts")
	public void insertProduct(@RequestBody List<ProductModel> products) {
		System.out.println("insert product : "+products);
	}

}
