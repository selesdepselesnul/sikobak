package selesdepselesnul.sikobak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberAunthDaoMYSQL implements MemberAunthDao {

	private Connection connection;

	public MemberAunthDaoMYSQL(Connection connection) {
		this.connection = connection;
	}

	@Override
	public MemberAunth read(int idNumber) throws SQLException {
		PreparedStatement preparedStatement = this.connection
				.prepareStatement("SELECT id, password FROM member WHERE id = ?");
		preparedStatement.setInt(1, idNumber);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		return new MemberAunth(resultSet.getInt("id"),
				resultSet.getString("password"));
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
