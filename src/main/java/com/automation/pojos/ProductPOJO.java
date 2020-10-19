package com.automation.pojos;

public class ProductPOJO {
	private String name;
	private String type;
	private String regular_price;
	private String description;
	private String short_description;
	private String [] categories;
	private String [] images;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRegular_price() {
		return regular_price;
	}
	public void setRegular_price(String regular_price) {
		this.regular_price = regular_price;
	}
	public String getShort_description() {
		return short_description;
	}
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String [] getImages() {
		return images;
	}
	public void setImages(String [] images) {
		this.images = images;
	}
	public String [] getCategories() {
		return categories;
	}
	public void setCategories(String [] categories) {
		this.categories = categories;
	}

}
