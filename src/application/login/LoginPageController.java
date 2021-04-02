package application.login;
import java.io.IOException;

import application.mainapp.BankManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginPageController {

	@FXML
	private TextField uname;

	@FXML
	private PasswordField password;

	@FXML
	private Button loginButton;

	@FXML
	private Button newRegisterButton;
	
	@FXML
	String status;
	
	@FXML
	Text logintext;
	
	

	@FXML
	protected void login(ActionEvent event) throws IOException {
		Window user = loginButton.getScene().getWindow();
	
		if(uname.getText().isEmpty() || password.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, user, "Login Error!", "Please enter correct login credentials");
		}
		else {
			status=BankManagement.loginUser(uname.getText(),password.getText());
			
			if(status=="0") {
				AlertHelper.showAlert(Alert.AlertType.ERROR, user, "Login Error!", "Incorrect Password");
			}
			else if(status=="1") {
				AlertHelper.showAlert(Alert.AlertType.ERROR, user, "Login Error!", "Invalid Username");
			}
			else {
				Stage stageRegister=(Stage) loginButton.getScene().getWindow();
				BorderPane pane = FXMLLoader.load(getClass().getResource("../transactions/TransactionPage.fxml"));
				Scene sceneRegister = new Scene(pane,1000,600);
				sceneRegister.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stageRegister.setScene(sceneRegister);
				stageRegister.setTitle("Banking Application");
			}		
		}
	}
	
	@FXML
	void newRegister(ActionEvent event) throws IOException {
//		BorderPane pane = FXMLLoader.load(getClass().getResource("../register/RegisterPage.fxml"));
//		rootPane.getChildren().setAll(pane);
		
		Stage stageRegister=(Stage) newRegisterButton.getScene().getWindow();
		BorderPane pane = FXMLLoader.load(getClass().getResource("../register/RegisterPage.fxml"));
		Scene sceneRegister = new Scene(pane,1000,600);
		sceneRegister.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stageRegister.setScene(sceneRegister);
		stageRegister.setTitle("New Account Register");
	}

}
