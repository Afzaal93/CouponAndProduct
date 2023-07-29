package com.model.Dao;

import com.Utility.Coupon;

public interface CouponDao {
public void save(Coupon coupon);
public Coupon findByCode(String code);

}
