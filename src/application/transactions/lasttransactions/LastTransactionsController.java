package application.transactions.lasttransactions;

import application.mainapp.BankManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class LastTransactionsController {
	
	@FXML
	Text lastTransactionDisplay;
	
	@FXML
	Button lastTransactionButton;
	
	@FXML
	String transact;
	
	@FXML
	void showTransaction(ActionEvent event) {
		transact=BankManagement.lastTransactions();
		lastTransactionDisplay.setText(transact);
	}

}
