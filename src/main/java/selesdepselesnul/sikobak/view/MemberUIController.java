package selesdepselesnul.sikobak.view;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import selesdepselesnul.sikobak.MemberAunth;
import selesdepselesnul.sikobak.MemberAunthDao;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MemberUIController {

	private MemberAunthDao memberAunthDao;
	private MemberAunth memberAunth;

	public List<Control> generateControls() {
		return Arrays.asList(this.birthDatePicker, this.birthPlaceChoiceBox,
				this.birthPlaceTextField, this.emailTextField,
				this.handPhoneTextField, this.homePhoneTextField,
				this.memberNameTextField, this.religionChoiceBox);
	}

	@FXML
	TextField memberIdTextField;

	@FXML
	TextField memberNameTextField;

	@FXML
	ChoiceBox<String> birthPlaceChoiceBox;

	@FXML
	TextField birthPlaceTextField;

	@FXML
	ImageView memberPhotoImageView;

	@FXML
	Button memberPhotoButton;

	@FXML
	TextField memberPhotoTextField;

	@FXML
	DatePicker birthDatePicker;

	@FXML
	ChoiceBox<String> religionChoiceBox;

	@FXML
	TextField homePhoneTextField;

	@FXML
	TextField handPhoneTextField;

	@FXML
	TextField emailTextField;

	@FXML
	Button editButton;

	@FXML
	Button saveButton;
	private Stage stage;
	private InputStream photoStream;
	private Path photoPath;

	public MemberAunth getMemberAunth() {
		return memberAunth;
	}

	public void setMemberAunth(MemberAunth memberAunth) {
		this.memberAunth = memberAunth;
		this.memberIdTextField.setText(Integer.toString(this.memberAunth
				.getIdNumber()));
		this.memberNameTextField.setText(this.memberAunth.getName());
		setBirthPlace(memberAunth);
		this.birthDatePicker.setValue(memberAunth.getBirthDate());
		setReligion(memberAunth);
		this.homePhoneTextField.setText(memberAunth.getHomePhone());
		this.handPhoneTextField.setText(memberAunth.getHandPhone());
		this.emailTextField.setText(memberAunth.getEmail());

	}

	private void setReligion(MemberAunth memberAunth) {
		ObservableList<String> religionList = FXCollections
				.observableArrayList("islam", "protestan", "katholik", "hindu",
						"budha", "konghuchu");
		this.religionChoiceBox.setItems(religionList);
		this.religionChoiceBox.setValue(memberAunth.getReligion());
	}

	private void setBirthPlace(MemberAunth memberAunth) {
		ObservableList<String> birthPlaceList = FXCollections
				.observableArrayList("Serang", "Jakarta", "Bandung",
						"Yogyakarta", "Semarang", "Surabaya");
		this.birthPlaceChoiceBox.setItems(birthPlaceList);

		if (new HashSet<String>(birthPlaceList).contains(memberAunth
				.getBirthPlace())) {
			this.birthPlaceChoiceBox.setValue(memberAunth.getBirthPlace());
		} else {
			this.birthPlaceTextField.setText(memberAunth.getBirthPlace());
		}
	}

	@FXML
	public void onClickEditButton() {
		setEnable(generateControls(), true);
	}

	private void setEnable(List<Control> controlList, boolean isEnable) {
		controlList.forEach(control -> control.setDisable(!isEnable));
	}

	@FXML
	public void onClickSaveButton() throws SQLException {

		updateMemberAunth(this.memberAunth);
		this.memberAunthDao.update(this.memberAunth);
		setEnable(generateControls(), false);
	}

	private void updateMemberAunth(MemberAunth memberAunth) {
		memberAunth.setBirthDate(this.birthDatePicker.getValue());
		memberAunth.setEmail(this.emailTextField.getText());
		memberAunth.setHandPhone(this.handPhoneTextField.getText());
		memberAunth.setHomePhone(this.homePhoneTextField.getText());
		memberAunth.setName(this.memberNameTextField.getText());
		memberAunth.setReligion(this.religionChoiceBox.getValue());

	}

	public void setMemberAunthDAO(MemberAunthDao memberAunthDao) {
		this.memberAunthDao = memberAunthDao;
	}

	@FXML
	public void onClickMemberPhotoButton() {
		FileChooser fileChooser = new FileChooser();
		photoPath = fileChooser.showOpenDialog(this.stage).toPath();
		this.memberPhotoTextField.setText(photoPath.toString());
		try {
			this.photoStream = Files.newInputStream(photoPath);
			this.memberPhotoImageView.setImage(new Image(this.photoStream));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setMainStage(Stage stage) {
		this.stage = stage;
	}

	@FXML
	public void onClickCloseMenu() {
		Platform.exit();
	}

}
