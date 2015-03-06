package selesdepselesnul.sikobak;

public class MemberAunth {

	private int idNumber;
	private String password;

	public MemberAunth(int idNumber, String password) {
		this.idNumber = idNumber;
		this.setPassword(password);
	}

	public int getIdNumber() {
		return this.idNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idNumber;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberAunth other = (MemberAunth) obj;
		if (idNumber != other.idNumber)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}
