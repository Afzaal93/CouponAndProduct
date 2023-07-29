package com.Utility;

import java.math.BigDecimal;

public class Product {
private int id;
private String name;
private String description;
private BigDecimal price;
private String couponcode;
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
public Product(int id, String name, String description, BigDecimal price, String couponcode) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.price = price;
	this.couponcode = couponcode;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public BigDecimal getPrice() {
	return price;
}
public void setPrice(BigDecimal price) {
	this.price = price;
}
public String getCouponcode() {
	return couponcode;
}
public String setCouponcode(String couponcode) {
	this.couponcode = couponcode;
	return couponcode;
}
@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
			+ ", couponcode=" + couponcode + "]";
}

}
