package application.register;

import java.io.IOException;

import application.login.AlertHelper;
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
import javafx.stage.Stage;
import javafx.stage.Window;

public class RegisterPageController {
	
	@FXML
	BorderPane parent;
	
	@FXML
	TextField name;
	
	@FXML
	TextField address;
	
	@FXML
	TextField phone;
	
	@FXML
	TextField uname;
	
	@FXML
	PasswordField pass;
	
	@FXML
	TextField iDeposit;
	
	@FXML
	Button registerButton;
	
	@FXML
	String status;
	
	@FXML
	Button loginButton;

	@FXML
	void register(ActionEvent event) throws IOException {
		Window user = registerButton.getScene().getWindow();
		
		if(name.getText().isEmpty() || address.getText().isEmpty() || phone.getText().isEmpty() || 
				uname.getText().isEmpty() || pass.getText().isEmpty() || iDeposit.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, user, "Register Error!", "Please enter all details");
		}
		else {
			status=BankManagement.registerUser(name.getText(),address.getText(),phone.getText(),uname.getText(),pass.getText(),iDeposit.getText());
			
			if(status=="0") {
				AlertHelper.showAlert(Alert.AlertType.ERROR, user, "Register Error!", "Username already exist");
			}
			else if(status=="1") {
				AlertHelper.showAlert(Alert.AlertType.ERROR, user, "Register Error!", "Password Condtion doesn't match \n - Minimum 8 chars \n - Minimum 1 digit \n - Minimum 1 lowercase \n - Minimum 1 uppercase \n - Minimum 1 special character !@#$%^&*_");
			}
			else if(status=="2") {
				Stage stageRegister=(Stage) registerButton.getScene().getWindow();
				BorderPane pane = FXMLLoader.load(getClass().getResource("../login/loginPage.fxml"));
				Scene sceneRegister = new Scene(pane,1000,600);
				sceneRegister.getStylesheets().add(getClass().getResource("../login/application.css").toExternalForm());
				stageRegister.setScene(sceneRegister);
				stageRegister.setTitle("User login");
			}
			
//			BorderPane pane = FXMLLoader.load(getClass().getResource("../login/loginPage.fxml"));
//			parent.getChildren().setAll(pane);
			
			
		}
		
	}
	
	@FXML
	void login(ActionEvent event)throws IOException{
		Stage stageRegister=(Stage) loginButton.getScene().getWindow();
		BorderPane pane = FXMLLoader.load(getClass().getResource("../login/loginPage.fxml"));
		Scene sceneRegister = new Scene(pane,1000,600);
		sceneRegister.getStylesheets().add(getClass().getResource("../login/application.css").toExternalForm());
		stageRegister.setScene(sceneRegister);
		stageRegister.setTitle("User login");
	}
}
