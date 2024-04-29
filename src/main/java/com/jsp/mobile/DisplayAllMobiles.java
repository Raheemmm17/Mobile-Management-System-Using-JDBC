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

@WebServlet("/DisplayMobiles")
public class DisplayAllMobiles extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp){
		final String QUERY ="SELECT * FROM mobilejdbcgrooming.mobile ";
		final String URL = "jdbc:mysql://localhost:3306";
		final String USER ="root";
		final String PASS = "root";
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		Connection con=null;
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement statement = con.prepareStatement(QUERY);
			ResultSet rs = statement.executeQuery();

			req.setAttribute("mobileList", rs);
			RequestDispatcher dispatcher = req.getRequestDispatcher("DisplayMobiles.jsp");
			dispatcher.forward(req, resp);

		}catch (Exception e) {e.printStackTrace();
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
