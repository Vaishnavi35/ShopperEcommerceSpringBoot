package com.example.demo.model;

import java.util.List;

public class ProductModel {
	
	private int companyId;
    private String title;
    private int categoryId;
    private int subCategoryId;
    private String sku;
    private char stockStatus;
    private String description;
    private ColorsModel colors;
	private double price;
    private int quantity;
    private String discountCode;
    private int discountAmount;
    
    
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public char getStockStatus() {
		return stockStatus;
	}
	public void setStockStatus(char stockStatus) {
		this.stockStatus = stockStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDiscountCode() {
		return discountCode;
	}
	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
	public int getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ColorsModel getColors() {
		return colors;
	}
	public void setColors(ColorsModel colors) {
		this.colors = colors;
	}

    
}
