package si.fri.prpo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class IzpisUserov {

	private static Connection connection = null;

	public static List<User> getAllUsers() {
		establishConnection();
		List<User> listOfUsers = new ArrayList<User>();

		PreparedStatement ps = null;
		try {
			String sql = "select * from User";
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("user_ID"));
				u.setName(rs.getString("name"));
				u.setLastname(rs.getString("lastname"));
				u.setPhone(rs.getString("phone"));
				u.setEmail(rs.getString("email"));
				u.setCredit(rs.getDouble("credit"));
				listOfUsers.add(u);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			closeConnection();
		}
		return listOfUsers;
	}

	private static void establishConnection() {

		if (connection == null) {
			try {
				System.out.println("Establishing connection...");
				Context initCtx = new InitialContext();
				DataSource ds = (DataSource) initCtx.lookup("java:jboss/datasources/prpoDS");
				connection = ds.getConnection();
			} catch (NamingException e) {
				System.out.println("JDBC source doesn't exist!");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("An error while establishing the conection!");
				e.printStackTrace();
			}
		}
	}

	private static void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				try {
					System.out.println("Closing connection...");
					connection.close();
					connection = null;
				} catch (SQLException e) {
					System.out.println("An error while closing the connection!");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}