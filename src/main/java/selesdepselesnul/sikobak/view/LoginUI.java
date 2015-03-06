package selesdepselesnul.sikobak.view;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;

public class LoginUI extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fXmlLoader = new FXMLLoader(getClass().getResource(
					"login_ui.fxml"));
			GridPane root = (GridPane) fXmlLoader.load();
			LoginUIController loginController = (LoginUIController) fXmlLoader
					.getController();
			loginController.setMainStage(primaryStage);

			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(
					getClass().getResource("login_ui.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
