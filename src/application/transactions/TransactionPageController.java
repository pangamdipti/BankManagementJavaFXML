package application.transactions;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TransactionPageController {
	
	@FXML
	private GridPane actionTarget;
	
	@FXML
	Button logoutButton;
	
	@FXML
	void deposit(ActionEvent event) throws IOException {
		GridPane pane = FXMLLoader.load(getClass().getResource("../transactions/deposit/DepositLayout.fxml"));
		actionTarget.getChildren().setAll(pane);
	}
	
	@FXML
	void transfer(ActionEvent event) throws IOException {
		GridPane pane = FXMLLoader.load(getClass().getResource("../transactions/transfer/TransferLayout.fxml"));
		actionTarget.getChildren().setAll(pane);
		
	}
	
	@FXML
	void lastTransactions(ActionEvent event) throws IOException {
		GridPane pane = FXMLLoader.load(getClass().getResource("../transactions/lasttransactions/LastTransactionLayout.fxml"));
		actionTarget.getChildren().setAll(pane);
		
	}
	
	@FXML
	void update(ActionEvent event) throws IOException{
		GridPane pane = FXMLLoader.load(getClass().getResource("../transactions/update/updateLayout.fxml"));
		actionTarget.getChildren().setAll(pane);
	}
	
	@FXML
	void userInfo(ActionEvent event) throws IOException {
		GridPane pane = FXMLLoader.load(getClass().getResource("../transactions/userinfo/userInfoLayout.fxml"));
		actionTarget.getChildren().setAll(pane);
		
	}
	
	@FXML
	void logout(ActionEvent event) throws IOException {
		Stage stageRegister=(Stage) logoutButton.getScene().getWindow();
		BorderPane pane = FXMLLoader.load(getClass().getResource("../login/loginPage.fxml"));
		Scene sceneRegister = new Scene(pane,1000,600);
		sceneRegister.getStylesheets().add(getClass().getResource("../login/application.css").toExternalForm());
		stageRegister.setScene(sceneRegister);
		stageRegister.setTitle("User login");
	}

}
