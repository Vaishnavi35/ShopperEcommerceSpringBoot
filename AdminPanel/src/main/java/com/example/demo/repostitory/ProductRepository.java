package com.example.demo.repostitory;

import java.util.List;

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
						product.getPrice(), product.getQuantity(), product.getDiscountCode(), product.getDiscountAmount());
			}catch(Exception e) {
				System.out.println("error : "+e);
				return "Failed";
			}
			
		}
		
		return "Success";
		
	}
}
