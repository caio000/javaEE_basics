package banco;

import java.sql.ResultSet;

public interface IBancoDeDados {

	public boolean connect();
	public boolean disconect();
	public ResultSet query();
	public boolean insert();
	public boolean update();
	public boolean delete();
}
