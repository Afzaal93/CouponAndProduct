package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Utility.Coupon;
import com.model.Dao.CouponDao;
import com.model.Dao.Impl.CouponDaoImpl;

@WebServlet("/coupons")
public class CouponController extends HttpServlet {
	Coupon coupon = new Coupon();
	CouponDao Dao = new CouponDaoImpl();

	public CouponController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		if (action.equals("create")) {
			createCoupon(request, response);
		} else if (action.equals("find")) {
			findCoupon(request, response);
		}

	}

	private void findCoupon(HttpServletRequest request, HttpServletResponse response) {
		try {
			String code = coupon.setCode(request.getParameter("couponCode"));
			Coupon coupon2 = Dao.findByCode(code);
			System.out.println(coupon.getCode());
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<b>Coupon Details:</b>");
			out.print(coupon2);
			out.print("<br/><a href='index.html'>Home</a>");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

	}

	private void createCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {

		coupon.setCode(request.getParameter("Code"));
		coupon.setDiscount(new BigDecimal(request.getParameter("Discount")));
		coupon.setExpDate(request.getParameter("expiryDate"));

		Dao.save(coupon);
		System.out.println(coupon);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Product Created!!</b>");
		out.print("<br/><a href='index.html'>Home</a>");
	}

}
