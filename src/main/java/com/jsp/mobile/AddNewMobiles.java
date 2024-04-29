package com.jsp.mobile;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saveMobile")
public class AddNewMobiles extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){

		int mobileId = Integer.parseInt(req.getParameter("mobileId"));
		String mobileModel = req.getParameter("mobileModel");
		String mobileBrand = req.getParameter("mobileBrand");
		int mobilePrice = Integer.parseInt(req.getParameter("mobilePrice"));

		final String QUERY ="INSERT INTO  mobilejdbcgrooming.mobile values(?,?,?,?)";
		final String URL = "jdbc:mysql://localhost:3306";
		final String USER ="root";
		final String PASS = "root";
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		Connection con=null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement prepareStatement = con.prepareStatement(QUERY);
			prepareStatement.setInt(1, mobileId);
			prepareStatement.setString(2, mobileModel);
			prepareStatement.setString(3, mobileBrand);
			prepareStatement.setInt(4, mobilePrice);
			int update = prepareStatement.executeUpdate();

			PrintWriter out = resp.getWriter();
			if(update == 0) {
				out.print("Not inserted");
			}else {
				out.print("Inserted succesfully");
			}
		}catch (Exception e) {e.getMessage();}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}

