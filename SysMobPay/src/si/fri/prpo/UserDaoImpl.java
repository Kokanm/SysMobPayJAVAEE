package si.fri.prpo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDaoImpl implements BaseDao {
	Connection connection = null;
	
	public Connection getConnection() throws SQLException{
		
		try {
			Context initCtx = new InitialContext();
	        DataSource ds = (DataSource) initCtx.lookup("java:jboss/datasources/prpoDS");
	        connection = ds.getConnection();
		}catch(NamingException e){
			System.out.println("JDBC source does not exist!");
			e.printStackTrace();
		}
        return connection;
	}
	
	@Override
	public Entiteta vrni(int id) {
		try {
			connection = getConnection();			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		User ent = new User();
		
		PreparedStatement ps = null;
		try {
			String sql = "select * FROM user where user_ID = ?";
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				ent.setId(id);
				ent.setName((rs.getString("name")));
				ent.setLastname(rs.getString("lastname"));
				ent.setPhone(rs.getString("phone"));
				ent.setEmail(rs.getString("email"));
				ent.setCredit(rs.getDouble("credit"));
				ent.setBonusPoints(rs.getInt("bonusPoints"));
				ent.setMaxDaily(rs.getDouble("maxDaily"));
			}else{
				System.out.println("Can not find user!");
			}
			connection.commit();
		} catch (SQLException e) {
			System.out.println(e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			closeConnection();
		}
		return ent;
	}

	@Override
	public void vstavi(Entiteta ent){
		try {
			connection = getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		User up = (User)ent;
				
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO user (user_ID, name, lastname, credit, bonusPoints, "
					+ "phone, email, maxDaily) values (?,?,?,?,?,?,?,?)";
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, up.getId());
			ps.setString(2, up.getName());
			ps.setString(3, up.getLastname());
			ps.setDouble(4, up.getCredit());
			ps.setInt(5, up.getBonusPoints());
			ps.setString(6, up.getPhone());
			ps.setString(7, up.getEmail());
			ps.setDouble(8, up.getMaxDaily());
			ps.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			System.out.println(e);
			try {
				connection.rollback();
				System.out.println("Rollback");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (ps != null)
				try {
					ps.close();
					System.out.println("Prepared statement tried to be closed.");
				} catch (SQLException e) {
					e.printStackTrace();
				}

			closeConnection();
		}
	}

	@Override
	public void odstrani(int id) {
		try {
			connection = getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
				
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM user where user_ID = ?";
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			System.out.println(e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			closeConnection();
		}
	}
	
	@Override
	public void odstraniVse() {
		try {
			connection = getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
				
		Statement ps = null;
		try {
			ps = connection.createStatement();
			String sql = "DELETE FROM user";			
			ps.executeUpdate(sql);
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
	}

	@Override
	public void posodobi(Entiteta ent) {
		try {
			connection = getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		User up = (User)ent;
				
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE user SET name = ?, lastname = ?, phone = ?, "
					+ "email = ?, bonusPoints = ?, credit = ?, maxDaily = ? WHERE user_ID = ?";
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setString(1, up.getName());
			ps.setString(2, up.getLastname());
			ps.setString(3, up.getPhone());
			ps.setString(4, up.getEmail());
			ps.setInt(5, up.getBonusPoints());
			ps.setDouble(6, up.getCredit());
			ps.setDouble(7, up.getMaxDaily());
			ps.setInt(8, up.getId());
			ps.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			System.out.println(e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			closeConnection();
		}
	}
	
	
	@Override
	public List<Entiteta> vrniVse(){
		try {
			connection = getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		List<Entiteta> lista = new ArrayList<Entiteta>();

		PreparedStatement ps = null;
		try {
			String sql = "select * from user";
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User ent = new User();
				ent.setId((rs.getInt("user_ID")));
				ent.setName((rs.getString("name")));
				ent.setLastname(rs.getString("lastname"));
				ent.setPhone(rs.getString("phone"));
				ent.setEmail(rs.getString("email"));
				ent.setCredit(rs.getDouble("credit"));
				ent.setBonusPoints(rs.getInt("bonusPoints"));
				ent.setMaxDaily(rs.getDouble("maxDaliy"));
				lista.add(ent);
			}
			connection.commit();
		} catch (SQLException e) {
			System.out.println(e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			closeConnection();
		}
		return lista;

	}
	
	private void closeConnection() {
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
