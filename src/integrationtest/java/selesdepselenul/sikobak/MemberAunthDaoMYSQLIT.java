package selesdepselenul.sikobak;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.mockito.Mockito;

import selesdepselesnul.sikobak.MemberAunth;
import selesdepselesnul.sikobak.MemberAunthDao;
import selesdepselesnul.sikobak.MemberAunthDaoMYSQL;

public class MemberAunthDaoMYSQLIT {

	@Test
	public void test() throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysqL://localhost/sikobak", "morrisseymarr", "070494");;
		final MemberAunthDao memberAunthDaoMYSQL = new MemberAunthDaoMYSQL(
				connection);
		final MemberAunth memberAunthFromUser = new MemberAunth(1, "password");
		final MemberAunth memberAunthFromDBase = memberAunthDaoMYSQL
				.read(memberAunthFromUser.getIdNumber());

		assertThat(memberAunthFromDBase, is(equalTo(memberAunthFromUser)));
	}

}
