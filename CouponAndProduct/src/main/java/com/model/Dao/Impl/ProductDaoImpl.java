package com.model.Dao.Impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.Utility.Product;
import com.Utility.Util.Connect;
import com.model.Dao.ProductDao;

public class ProductDaoImpl implements ProductDao {

	@Override
	public void save(Product product) {
		Connection connect = Connect.getConnect();
		System.out.println("kshksh");
		try {
			System.out.println("before");
			PreparedStatement st = connect.prepareStatement("insert into product(name,Discription,Price,Couponcode) values(?,?,?,?)");
			st.setString(1, product.getName());
			st.setString(2, product.getDescription());
			st.setBigDecimal(3, product.getPrice());
			st.setString(4, product.getCouponcode());
			st.executeUpdate();
			System.out.println("after");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
