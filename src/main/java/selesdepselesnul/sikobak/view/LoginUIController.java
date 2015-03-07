package selesdepselesnul.sikobak.view;

import java.sql.DriverManager;


import selesdepselesnul.sikobak.MemberAunth;
import selesdepselesnul.sikobak.MemberAunthDao;
import selesdepselesnul.sikobak.MemberAunthDaoMYSQL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginUIController {
	@FXML
	MenuItem memberMenuItem;
	@FXML
	TextField idNumberTextField;

	@FXML
	TextField passwordTextField;

	@FXML
	MenuButton loginMenuButton;

	private Stage stage;

	@FXML
	public void onClickLoginUserMenuButton() {
		try {
			MemberAunthDao memberAunthDaoMYSQL = new MemberAunthDaoMYSQL(
					DriverManager.getConnection(
							"jdbc:mysqL://localhost/sikobak", "morrisseymarr",
							"070494"));
			MemberAunth memberAunth = memberAunthDaoMYSQL.read(Integer
					.parseInt(idNumberTextField.getText()));
			if (memberAunth.getPassword().equals(passwordTextField.getText())) {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
						"member_ui.fxml"));
				BorderPane root = fxmlLoader.load();
				MemberUIController memberUIController = fxmlLoader
						.getController();
				memberUIController.setMainStage(this.stage);
				memberUIController.setMemberAunth(memberAunth);
				memberUIController.setMemberAunthDAO(memberAunthDaoMYSQL);
				Scene scene = new Scene(root);
				scene.getStylesheets().add(
						getClass().getResource("member_ui.css")
								.toExternalForm());
				this.stage.setScene(scene);
				this.stage.setTitle("Koperasi Batu Akik - BETA -");
			}
		} catch (Exception e) {
		}

	}

	public void setMainStage(Stage stage) {
		this.stage = stage;
	}

}
