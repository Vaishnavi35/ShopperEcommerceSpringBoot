package com.example.demo.repostitory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProductModel;

@Repository
public class ProductRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public int insertProductsInDB(List<ProductModel> products){
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
		
		String sql = "INSERT INTO `shopperadminpanel`.`products` ( `company_id`,`product_name`,`category_id`,`sub_category_id`,`SKU`,`stock_status`,\r\n"
				+ "`description`,\r\n"
				+ "`color`,\r\n"
				+ "`color_name`,\r\n"
				+ "`price`,\r\n"
				+ "`quantity`,\r\n"
				+ "`discount_code`,\r\n"
				+ "`discount_amount`)\r\n"
				+ "VALUES\r\n"
				+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		for(ProductModel product : products) {
			List<Object> colors  = product.getColors();
//			System.out.println("name : "+colors.getName());
//			jdbcTemplate.update(sql,1, product.getTitle(),1,1,product.getSku(), product.getStockStatus(), product.getDescription(), product.get);
		}
		
		
		return 0;
		
	}
}
