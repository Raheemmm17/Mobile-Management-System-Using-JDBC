package com.jsp.mobile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/afterUpdateMobile")
public class UpdateMobile extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req ,HttpServletResponse resp) {

		int mobileId = Integer.parseInt(req.getParameter("mId"));

		final String QUERY ="SELECT * from mobilejdbcgrooming.mobile where mobileId = ?";
		final String URL = "jdbc:mysql://localhost:3306";
		final String USER ="root";
		final String PASS = "root";
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		Connection con= null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement prepareStatement = con.prepareStatement(QUERY);
			prepareStatement.setInt(1, mobileId);
			ResultSet resultSet = prepareStatement.executeQuery();

			req.setAttribute("Mobile", resultSet);
			RequestDispatcher dispatcher = req.getRequestDispatcher("UpdateMobile.jsp");
			dispatcher.forward(req, resp);	

			DisplayAllMobiles dam = new DisplayAllMobiles();
			dam.doGet(req, resp);

			prepareStatement.close();con.close();
		}catch (Exception e) {
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
