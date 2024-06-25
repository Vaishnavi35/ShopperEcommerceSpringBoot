package com.example.demo.repostitory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;

import com.example.demo.model.ColorsModel;
import com.example.demo.model.ProductModel;

@Repository
public class ProductRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String insertProductsInDB(List<ProductModel> products){
//		SELECT `products`.`product_id`,
//	    `products`.`company_id`,
//	    `products`.`product_name`,
//	    `products`.`category_id`,
//	    `products`.`sub_category_id`,
//	    `products`.`SKU`,
//	    `products`.`stock_status`,
//	    `products`.`description`,
//	    `products`.`color`,
//	    `products`.`color_name`,
//	    `products`.`price`,
//	    `products`.`quantity`,
//	    `products`.`discount_code`,
//	    `products`.`discount_amount`,
//	    `products`.`create_at`,
//	    `products`.`updated_at`
//	FROM `shopperadminpanel`.`products`;
		
//		String sql_test = "insert into products (company_id,`product_name`,`category_id`,`sub_category_id`) values (1, 'product name', 2,3)";
		
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
//		try {
//			jdbcTemplate.update(sql_test);
//		}catch(Exception e) {
//			System.out.println("error : "+e);
//			return "Failed";
//		}
		
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
//	SELECT `products`.`product_id`,
//    `products`.`company_id`,
//    `products`.`product_name`,
//    `products`.`category_id`,
//    `products`.`sub_category_id`,
//    `products`.`SKU`,
//    `products`.`stock_status`,
//    `products`.`description`,
//    `products`.`color`,
//    `products`.`color_name`,
//    `products`.`sizes`,
//    `products`.`price`,
//    `products`.`quantity`,
//    `products`.`discount_code`,
//    `products`.`discount_amount`,
//    `products`.`create_at`,
//    `products`.`updated_at`
//FROM `admin_panel`.`products`;

	public Map<String, Object> getProductsInDB() {
//		ArrayList<Map<String,Object>> result = new ArrayList<>(); 
		Map<String,Object> Response = new HashMap<>(); 
		String sql = "select product_name,category_id,sub_category_id, date_format(create_at, '%b %c, %Y') as date_added from products";
//		BeanPropertyRowMapper<ProductModel> productRowMapper = new BeanPropertyRowMapper<ProductModel>(ProductModel.class);
		try {
			List<Map<String,Object>> result = jdbcTemplate.queryForList(sql);
			Response.put("response", result);
			Response.put("status", "success");
//			 List<Map<String,Object>> result = jdbcTemplate.queryForList(sql);
//			 System.out.println("result : "+result);
//			return jdbcTemplate.queryForList(sql);
			
		}catch(Exception e) {
			System.out.println("error : "+e);
			Response.put("response", e);
			Response.put("status", "failed");
//			return null;
		}
		return Response;
	}
	
//	private static class ProductRowMapper implements RowMapper<ProductModel>{
//		@Override
//		public ProductModel mapRow(ResultSet rs, int rowNum) {
//			int categoryId = rs.getInt("category_id");
//		    int subCategoryId  = rs.getInt("sub_category_id");
//		    return new ProductModel(categoryId, subCategoryId);
//		}
//	}
	
}
