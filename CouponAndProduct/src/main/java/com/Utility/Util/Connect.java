package com.Utility.Util;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Connect {
	

	public static Connection getConnect() {
		 Connection con = null;
		try {
			InitialContext context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/myds");
			con=dataSource.getConnection();
			System.out.println(dataSource);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return con;
	}

}
