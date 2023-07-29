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
import com.Utility.Product;
import com.model.Dao.CouponDao;
import com.model.Dao.ProductDao;
import com.model.Dao.Impl.CouponDaoImpl;
import com.model.Dao.Impl.ProductDaoImpl;

@WebServlet("/products")
public class ProductController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("done");
		Product product = new Product();
		product.setName(request.getParameter("name"));

		product.setDescription(request.getParameter("discription"));

		product.setCouponcode(request.getParameter("couponCode"));

		CouponDao impl = new CouponDaoImpl();
		Coupon code = impl.findByCode(product.getCouponcode());
		if(code==null) {
			out.print("code expired");
			response.setContentType("text/html");
			out.print("<br/><a href='index.html'>Home</a>");
		}else {
		System.out.println(product.getCouponcode());

		product.setPrice(new BigDecimal(request.getParameter("price")));
		System.out.println(product.getPrice());
		BigDecimal price = product.getPrice();
		BigDecimal discount = code.getDiscount();
		BigDecimal dis = price.multiply(discount);
		BigDecimal divide = dis.divide(new BigDecimal(100));
		BigDecimal subtract = product.getPrice().subtract(divide);
		product.setPrice(subtract);
		ProductDao impl2 = new ProductDaoImpl();
		impl2.save(product);

		
		response.setContentType("text/html");
		out.print("<b>Product Created</b>");
		out.print("<br/><a href='index.html'>Home</a>");
	}
	}

}
