package application.transactions.transfer;

import application.login.AlertHelper;
import application.mainapp.BankManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Window;

public class TransferController {

	@FXML
	TextField payeeUName;

	@FXML
	TextField transferAmount;

	@FXML
	Button transferButton;

	@FXML
	Text transferConfirmation;

	@FXML
	Text updatedBalance;

	@FXML
	String bal;

	@FXML
	void transfer(ActionEvent event) {
		Window user = transferButton.getScene().getWindow();

		if (transferAmount.getText().isEmpty() || payeeUName.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, user, "Invalid Input!", "Please put all details");
		} else {
			bal = BankManagement.transfer(payeeUName.getText(), transferAmount.getText());
			if (bal == "0") {
				AlertHelper.showAlert(Alert.AlertType.ERROR, user, "Invalid User", "User doesn't exist");
			} else if (bal == "1") {
				AlertHelper.showAlert(Alert.AlertType.ERROR, user, "Less balance", "Balance not sufficient");
			} else {
				updatedBalance.setText(bal);
				transferConfirmation.setText("Money transferred successfully");
			}
		}
	}
}
