package selesdepselenul.sikobak;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Test;
import org.mockito.Mockito;

import selesdepselesnul.sikobak.MemberAunth;
import selesdepselesnul.sikobak.MemberAunthDao;
import selesdepselesnul.sikobak.MemberAunthDaoMYSQL;

public class MemberAunthDaoMYSQLIT {

	@Test
	public void read_withValidId_returnsInstance() throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysqL://localhost/sikobak", "morrisseymarr", "070494");
		;
		final MemberAunthDao memberAunthDaoMYSQL = new MemberAunthDaoMYSQL(
				connection);
		final MemberAunth memberAunthFromDBase = memberAunthDaoMYSQL.read(1);

		String userPassword = "password";
		String passwordFromDB = memberAunthFromDBase.getPassword();
		assertThat(userPassword, is(equalTo(passwordFromDB)));
	}

	@Test
	public void update_withValidId_returnsInstance() throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysqL://localhost/sikobak", "morrisseymarr", "070494");
		;
		final MemberAunthDao memberAunthDaoMYSQL = new MemberAunthDaoMYSQL(
				connection);
		MemberAunth memberAunth = new MemberAunth(3, "russia is awesome");
		memberAunth.setBirthDate(LocalDate.now());
		memberAunth.setBirthPlace("Moskow");
		memberAunth.setEmail("putin@russianisbear.gov");
		memberAunth.setHomePhone("023-3213-313213");
		memberAunth.setHandPhone("0893234214");
		memberAunth.setReligion("katholik");
		memberAunth.setPhoto(null);
		memberAunth.setName("Vladimir Putin");

		memberAunthDaoMYSQL.update(memberAunth);

	}
}
