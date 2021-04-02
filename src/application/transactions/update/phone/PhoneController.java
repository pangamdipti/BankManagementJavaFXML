package application.transactions.update.phone;

import application.login.AlertHelper;
import application.mainapp.BankManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Window;

public class PhoneController {

	@FXML
	TextField newPhone;

	@FXML
	Text act;

	@FXML
	Button changePhone;

	@FXML
	void changePhone(ActionEvent event) {
		Window user = changePhone.getScene().getWindow();
		if (newPhone.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, user, "Error!", "Please enter phone");
		} else {
			BankManagement.changePho(newPhone.getText());
			act.setText("Phone Changed !!");
		}
	}

}
