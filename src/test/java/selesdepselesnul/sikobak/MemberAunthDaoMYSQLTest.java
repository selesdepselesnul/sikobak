package selesdepselesnul.sikobak;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

public class MemberAunthDaoMYSQLTest {

	@Ignore
	public void read_WithCorrectIdNumberAndPass_ReturnsEqual()
			throws SQLException {
		Connection mockedConnection = Mockito.mock(Connection.class);
		final MemberAunthDao memberAunthDaoMYSQL = new MemberAunthDaoMYSQL(
				mockedConnection);
		final MemberAunth memberAunthFromUser = new MemberAunth(1, "password");
		final MemberAunth memberAunthFromDBase = memberAunthDaoMYSQL
				.read(memberAunthFromUser.getIdNumber());

		assertThat(memberAunthFromDBase, is(equalTo(memberAunthFromUser)));
	}

}
