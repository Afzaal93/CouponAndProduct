package com.model.Dao.Impl;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import com.Utility.Coupon;
import com.Utility.Util.Connect;
import com.model.Dao.CouponDao;

public class CouponDaoImpl implements CouponDao {
	Connection con = Connect.getConnect();

	@Override
	public void save(Coupon coupon) {
		System.out.println(coupon);
		System.out.println(coupon.getExpDate());

		System.out.println(con);

		try {

			PreparedStatement st = con.prepareStatement("insert into coupon(code,Discount,expDate) values(?,?,?)");
			st.setString(1, coupon.getCode());
			st.setBigDecimal(2, coupon.getDiscount());
			st.setString(3, coupon.getExpDate());
			st.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public Coupon findByCode(String code) {
		Coupon coupon = null; // Initialize coupon as null

		try {
			// Assuming con is a valid database connection
			PreparedStatement st = con.prepareStatement("SELECT * FROM coupon WHERE code=?");
			st.setString(1, code);

			ResultSet set = st.executeQuery();
			if (set.next()) {
				coupon = new Coupon(); // Create a new Coupon object

				coupon.setId(set.getInt(1));
				coupon.setCode(set.getString(2));
				coupon.setDiscount(set.getBigDecimal(3));
				coupon.setExpDate(set.getString(4));

				// Check coupon expiration
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				Date expirationDate = format.parse(coupon.getExpDate());

				if (date.before(expirationDate)) {
					return coupon; // Return the valid coupon
				} else {
					System.out.println("coupon expired");
					return null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Handle the exception or rethrow it if necessary
		}

		// Coupon not found or expired, return null
		return coupon;
	}

	public CouponDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

}
