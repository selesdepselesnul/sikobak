package selesdepselesnul.sikobak;

import java.sql.Connection;
import java.sql.Date;
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
				.prepareStatement("SELECT * FROM member WHERE id = ?");
		preparedStatement.setInt(1, idNumber);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		MemberAunth memberAunth = new MemberAunth(resultSet.getInt("id"),
				resultSet.getString("password"));
		memberAunth.setName(resultSet.getString("name"));
		memberAunth.setBirthPlace(resultSet.getString("birth_place"));
		memberAunth.setBirthDate(resultSet.getDate("birth_date").toLocalDate());
		memberAunth.setReligion(resultSet.getString("religion"));
//		memberAunth.setPhoto(resultSet.getBlob("photo").getBinaryStream());
		memberAunth.setHomePhone(resultSet.getString("home_phone"));
		memberAunth.setHandPhone(resultSet.getString("hand_phone"));
		memberAunth.setEmail(resultSet.getString("email"));
		return memberAunth;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Connection getConnection() {
		return connection;
	}

	@Override
	public void update(MemberAunth memberAunth) throws SQLException {

		PreparedStatement updatePreparedStatement = this.connection
				.prepareStatement("UPDATE member SET name = ?,"
						+ " password = ?, birth_place = ?, birth_date = DATE(?),"
						+ " religion = ?, photo = LOAD_FILE(?), home_phone = ?, hand_phone = ?"
						+ ", email = ? WHERE id = ?");
		updatePreparedStatement.setString(1, memberAunth.getName());
		updatePreparedStatement.setString(2, memberAunth.getPassword());
		updatePreparedStatement.setString(3, memberAunth.getBirthPlace());
		updatePreparedStatement.setDate(4,
				Date.valueOf(memberAunth.getBirthDate()));
		updatePreparedStatement.setString(5, memberAunth.getReligion());
		updatePreparedStatement.setString(6, memberAunth.getPhotoPath());
		updatePreparedStatement.setString(7, memberAunth.getHomePhone());
		updatePreparedStatement.setString(8, memberAunth.getHandPhone());
		updatePreparedStatement.setString(9, memberAunth.getEmail());
		updatePreparedStatement.setInt(10, memberAunth.getIdNumber());
		updatePreparedStatement.executeUpdate();

	}

}
