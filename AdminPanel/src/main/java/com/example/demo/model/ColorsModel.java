package com.example.demo.model;

public class ColorsModel {

	private String color;
    private String name;

	public ColorsModel(String color, String name) {
		super();
		this.color = color;
		this.setName(name);
	}
    
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
