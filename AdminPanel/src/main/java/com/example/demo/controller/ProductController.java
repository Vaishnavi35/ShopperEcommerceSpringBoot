package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.ProductModel;
import com.example.demo.service.ProductService;
import com.google.gson.Gson;

@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	Gson g = new Gson();

	@PostMapping("/insertProducts")
	public ResponseEntity<String> insertProduct(@RequestBody List<ProductModel> products) {
		String msg = " ";
		HttpStatus status_code = HttpStatus.OK;
//		System.out.println("insert product : "+products);
		String status = productService.insertProducts(products);
		if(status == "Success") {
			msg = "Product(s) inserted successfully.";
		}else {
			msg = "Something went wrong.";
			status_code = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return ResponseEntity.status(status_code).body(msg);
	}
	
	@GetMapping("/getProducts")
	public ResponseEntity<String> getProducts() {
		String msg = " ";
		HttpStatus status_code = HttpStatus.OK;
		Gson gson = new Gson();
		
		Map<String, Object> Result = productService.getAllProducts();
		if(Result.get("status")  == "failed") {
			status_code = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		String jsonResponse = gson.toJson(Result);
		return ResponseEntity.status(status_code).body(jsonResponse);
	}

}
