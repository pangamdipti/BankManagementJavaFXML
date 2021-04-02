package application.transactions.update;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class UpdateController {
	
	@FXML
	GridPane action;
	
	@FXML
	Button updatepassword;
	
	@FXML
	void updatePassword(ActionEvent event) throws IOException {
		GridPane pane = FXMLLoader.load(getClass().getResource("../update/password/PasswordLayout.fxml"));
		action.getChildren().setAll(pane);
		
	}
	
	@FXML
	void updateAddress(ActionEvent event) throws IOException {
		GridPane pane = FXMLLoader.load(getClass().getResource("../update/address/AddressLayout.fxml"));
		action.getChildren().setAll(pane);
	}
	
	@FXML
	void updatePhone(ActionEvent event) throws IOException {
		GridPane pane = FXMLLoader.load(getClass().getResource("../update/phone/PhoneLayout.fxml"));
		action.getChildren().setAll(pane);
	}

}
