package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host = "localhost";
		String port = "3306";
		// Connection conn1 =
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/qadb", "root",
		// "12345678");
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qadb", "root",
				"12345678");
		Statement st = conn.createStatement();
		ResultSet resultSet = st.executeQuery("select * from employeeinfo where id=1;");
		/*
		 * // System.out.println(resultSet.getFetchDirection()); resultSet.next();
		 * System.out.println(resultSet.getFetchSize()); String a =
		 * resultSet.getString("name"); System.out.println(a);
		 * System.out.println(resultSet.getObject("age"));
		 */
		// you can fetch values

		while (resultSet.next()) {
			System.out.println("id is: " + resultSet.getObject("id"));
			System.out.println("name is : " + resultSet.getString("name"));
		}

	}

}
