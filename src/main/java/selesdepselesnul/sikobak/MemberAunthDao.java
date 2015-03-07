package selesdepselesnul.sikobak;

import java.sql.Connection;
import java.sql.SQLException;

public interface MemberAunthDao {

	public abstract MemberAunth read(int idNumber) throws SQLException;

	public abstract void update(MemberAunth memberAunth) throws SQLException;

	public abstract Connection getConnection();

	public abstract void setConnection(Connection connection);

}
