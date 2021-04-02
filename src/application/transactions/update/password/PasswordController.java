package application.transactions.update.password;

import application.login.AlertHelper;
import application.mainapp.BankManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.stage.Window;

public class PasswordController {

	@FXML
	PasswordField newPassword;

	@FXML
	Text act;

	@FXML
	Button changePassword;
	
	@FXML
	String status;

	@FXML
	void changePassword(ActionEvent event) {
		Window user = changePassword.getScene().getWindow();
		if (newPassword.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, user, "Error!", "Please enter password");
		} else {
			status=BankManagement.changePass(newPassword.getText());
			if(status=="1") {
				AlertHelper.showAlert(Alert.AlertType.ERROR, user, "Invalid Password!", "Password Condtion doesn't match \n - Minimum 8 chars \n - Minimum 1 digit \n - Minimum 1 lowercase \n - Minimum 1 uppercase \n - Minimum 1 special character !@#$%^&*_");
			}
			else {
				act.setText("Password Changed !!");
			}
			
		}
	}

}
