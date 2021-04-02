package application.transactions.update.address;

import application.login.AlertHelper;
import application.mainapp.BankManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Window;

public class AddressController {

	@FXML
	TextField newAddress;

	@FXML
	Text act;

	@FXML
	Button changeAddress;

	@FXML
	void changeAddress(ActionEvent event) {
		Window user = changeAddress.getScene().getWindow();
		if (newAddress.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, user, "Error!", "Please enter Address");
		} else {
			BankManagement.changeAdd(newAddress.getText());
			act.setText("Address Changed !!");
		}
	}

}
