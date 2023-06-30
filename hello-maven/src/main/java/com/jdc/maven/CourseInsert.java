package com.jdc.maven;

import java.sql.DriverManager;
import java.sql.SQLException;

public class CourseInsert {
	private static final String PASS = "123456";
	private static final String USER = "root";
	private static final String URL = "jdbc:mysql://localhost:3306/hello_maven";
	private static final String SQL = "insert into course (name, fees, duration) values (?, ?, ?)";

	public void insert(Course c) {

		try (var conn = DriverManager.getConnection(URL, USER, PASS); var stmt = conn.prepareStatement(SQL)) {

			stmt.setString(1, c.getName());
			stmt.setInt(2, c.getFees());
			stmt.setInt(3, c.getDuration());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
