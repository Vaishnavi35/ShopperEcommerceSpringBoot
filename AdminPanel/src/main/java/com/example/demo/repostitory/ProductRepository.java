package com.example.demo.repostitory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ColorsModel;
import com.example.demo.model.ProductModel;

@Repository
public class ProductRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String insertProductsInDB(List<ProductModel> products){
		
		String sql = "INSERT INTO `products` ( `company_id`,`product_name`,`category_id`,`sub_category_id`,`SKU`,`stock_status`,\r\n"
				+ "`description`,\r\n"
				+ "`color`,\r\n"
				+ "`color_name`,\r\n"
				+ "`sizes`,\r\n"
				+ "`price`,\r\n"
				+ "`quantity`,\r\n"
				+ "`discount_code`,\r\n"
				+ "`discount_amount`)\r\n"
				+ "VALUES\r\n"
				+ "( 1, ?, 1, 1, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		for(ProductModel product : products) {
			ColorsModel colors  = product.getColors();
			
			System.out.println("ColorName : "+colors.getName());
			System.out.println("ColorName : "+product.getStock_status());
			
			for(String size : product.getSizes()) {
				System.out.println("size : "+size);
			}
			
			try {
				jdbcTemplate.update(sql,product.getTitle(),product.getSku(),product.getStock_status(), product.getDescription(), colors.getColor(), colors.getName(),
									product.getSizes(), product.getPrice(), product.getQuantity(), product.getDiscountCode(), product.getDiscountAmount());
			}catch(Exception e) {
				System.out.println("error : "+e);
				return "Failed";
			}
			
		}
		
		return "Success";
		
	}

	public Map<String, Object> getProductsInDB() {
		Map<String,Object> Response = new HashMap<>(); 
		String sql = "select product_name,category_id,sub_category_id, date_format(create_at, '%b %c, %Y') as date_added from products";
		try {
			System.out.println("getProducts try");
			List<Map<String,Object>> result = jdbcTemplate.queryForList(sql);
			Response.put("response", result);
			Response.put("status", "success");
			
		}catch(Exception e) {
			System.out.println("getProducts catch");
			System.out.println("error : "+e);
			Response.put("response", e);
			Response.put("status", "failed");
		}
		System.out.println("getProducts after try catch");
		return Response;
	}
	
	public Map<String,Object> getCategory(){
		Map<String,Object> Response = new HashMap<>(); 
		String category_query = "select category_id as value, category_name as label from category";
		
		try {
			List<Map<String,Object>> Result1 = jdbcTemplate.queryForList(category_query);
			Response.put("categories", Result1);
			Response.put("status", "success");
		}catch(Exception e) {
			System.out.println("error : "+e);
			Response.put("response", e);
			Response.put("status", "failed");
		}
		return Response;
	}
	
	public Map<String,Object> getSubCategory() {
		String sub_category_query = "select sub_category_id as value, `sub_category_name` as label from sub_category where category_id = ?";
		Map<String,Object> Response = new HashMap<>();
		try {
			List<Map<String, Object>> Result = jdbcTemplate.queryForList(sub_category_query,1);
			Response.put("sub_categories", Result);
			Response.put("status", "success");
		}catch(Exception e) {
			System.out.println("error : "+e);
			Response.put("response", e);
			Response.put("status", "failed");
		}
		return Response;
	}
	
	public Map<String,Object> getProductType() {
		String product_type_query = "select product_type_name as value, product_type_name as label from product_type where category_id = ? and sub_category_id = ?"; 
		Map<String,Object> Response = new HashMap<>();
		try {
			List<Map<String, Object>> Result = jdbcTemplate.queryForList(product_type_query, 1, 1);
			Response.put("product_types", Result);
			Response.put("status", "success");
		}catch(Exception e) {
			System.out.println("error : "+e);
			Response.put("response", e);
			Response.put("status", "failed");
		}
		return Response;
	}
	
}
