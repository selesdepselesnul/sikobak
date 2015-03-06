package selesdepselesnul.sikobak.view;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;

import selesdepselesnul.sikobak.MemberAunth;
import selesdepselesnul.sikobak.MemberAunthDaoMYSQL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginUIController {
	@FXML
	TextField idNumberTextField;

	@FXML
	TextField passwordTextField;

	@FXML
	MenuButton loginMenuButton;

	private Stage stage;

	@FXML
	public void onClickLoginUserMenuButton() {
		MemberAunth userMemberAunth = new MemberAunth(
				Integer.parseInt(idNumberTextField.getText()),
				passwordTextField.getText());
		MemberAunth dbMemberAunth;
		try {
			dbMemberAunth = new MemberAunthDaoMYSQL(
					DriverManager.getConnection(
							"jdbc:mysqL://localhost/sikobak", "morrisseymarr",
							"070494")).read(userMemberAunth.getIdNumber());
			if (dbMemberAunth.equals(userMemberAunth)) {
				BorderPane root = (BorderPane) FXMLLoader.load(getClass()
						.getResource("member_ui.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets()
						.add(getClass().getResource("member_ui.css")
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
