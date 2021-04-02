package application.transactions.userinfo;

import application.mainapp.BankManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class UserInfoController {
	
	@FXML
	Button accountDetailsButton;
	
	@FXML
	Text accountDetailsDisplay;
	
	@FXML
	String accountData;
	
	@FXML
	void showDetails(ActionEvent event) {
		accountData=BankManagement.details();
		accountDetailsDisplay.setText(accountData);
	}

}
