package si.fri.prpo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BaseDao {

	public Connection getConnection() throws SQLException;

	public Entiteta vrni(int id) throws SQLException;

	public void vstavi(Entiteta ent) throws SQLException;

	public void odstrani(int id) throws SQLException;

	public void posodobi(Entiteta ent) throws SQLException;

	public List<Entiteta> vrniVse() throws SQLException;

	void odstraniVse();
	
}
