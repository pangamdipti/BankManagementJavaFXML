package application.transactions.deposit;

import application.login.AlertHelper;
import application.mainapp.BankManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Window;

public class DepositController {
	@FXML
	TextField amount;
	
	@FXML
	Text updatedBalance;
	
	@FXML
	Text depositConfirmation;
	
	@FXML
	Button depositButton;
	
	@FXML
	String bal;
	
	@FXML
	void deposit(ActionEvent event) {
		Window user = depositButton.getScene().getWindow();
		
		if(amount.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, user, "Invalid Input !", "Please put proper amount");
		}
		else {
			bal=BankManagement.depositAmount(amount.getText());
			updatedBalance.setText(bal);
			depositConfirmation.setText("Money deposited successfully.");
			
		}		
	}

}
