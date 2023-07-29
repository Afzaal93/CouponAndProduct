package com.Utility;

import java.math.BigDecimal;

public class Coupon {
private int id;
private String code;
private BigDecimal Discount;
private String expDate;
public Coupon() {
	super();
	// TODO Auto-generated constructor stub
}
public Coupon(int id, String code, BigDecimal Discount, String expDate) {
	super();
	this.id = id;
	this.code = code;
	this.Discount = Discount;
	this.expDate = expDate;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCode() {
	return code; 
}
public String setCode(String code) {
	this.code = code;
	return code;
}
public BigDecimal getDiscount() {
	return Discount;
}
public void setDiscount(BigDecimal Discount) {
	this.Discount = Discount;
}
public String getExpDate() {
	return expDate;
}
public void setExpDate(String expDate) {
	this.expDate = expDate;
}
@Override
public String toString() {
	return "Coupon [id=" + id + ", code=" + code + ", Discount=" + Discount + ", expDate=" + expDate + "]";
}

}
