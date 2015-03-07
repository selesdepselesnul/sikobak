package selesdepselesnul.sikobak;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.time.LocalDate;

public class MemberAunth {

	private int idNumber;
	private String password;
	private String name;
	private String birthPlace;
	private LocalDate birthDate;
	private String religion;
	private InputStream photo;
	private String homePhone;
	private String handPhone;
	private String email;
	private long photoLength;
	private String photoPath;

	public long getPhotoLength() {
		return photoLength;
	}

	public String getName() {
		return name;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getReligion() {
		return religion;
	}

	public InputStream getPhoto() {
		return photo;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getHandPhone() {
		return handPhone;
	}

	public String getEmail() {
		return email;
	}

	public MemberAunth(int idNumber, String password) {
		this.idNumber = idNumber;
		this.setPassword(password);
	}

	public int getIdNumber() {
		return this.idNumber;
	}

	public String getPassword() {
		return this.password;
	}
	
	

	public String getPhotoPath() {
		return photoPath;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public void setPhoto(InputStream photo) {
		this.photo = photo;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public void setHandPhone(String handPhone) {
		this.handPhone = handPhone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoto(InputStream photoStream, long length) {
		this.photoLength = length;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

}
