package selesdepselesnul.sikobak;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface MemberAunthDao {

	public abstract MemberAunth read(int idNumber) throws SQLException;

}
