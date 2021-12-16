package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import banking.InSufficientBalanceException;
import banking.InvalidAccountException;
import banking.MaxWithdawException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TrWiDeController implements Initializable {
	@FXML
	TextField taNum1;
	@FXML
	TextField taNum2;
	@FXML
	TextField taNum3;
	@FXML
	Label aNumL1;
	@FXML
	Label aNumL2;
	@FXML
	Label aNumL3;
	@FXML
	Label inValid;

	Stage stage;
	Scene scene;
	Parent root;
	String accountNum, toAccountNum;
	double withAmu, depAmu, tranAmu;
	public ComboBox<String> comboBox;
	ObservableList<String> list = FXCollections.observableArrayList("Transfer", "Withdraw", "Deposit");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		comboBox.setItems(list);
	}

	public void setType(ActionEvent event) {
		String type = comboBox.getValue();
		switch (type) {
		case "Transfer":
			aNumL3.setVisible(true);
			taNum3.setVisible(true);
			// *
			aNumL1.setText("From Account Number");
			aNumL3.setText("To Account Number");
			aNumL2.setText("Transfer Amount");
			break;
		case "Withdraw":
			aNumL3.setVisible(false);
			taNum3.setVisible(false);
			// *
			aNumL1.setText("Account Number");
			aNumL2.setText("Withdraw Amount");
			break;
		case "Deposit":
			aNumL3.setVisible(false);
			taNum3.setVisible(false);
			// *
			aNumL1.setText("Account Number");
			aNumL2.setText("Deposit Amount");
			break;
		}
	}

	public void submit(ActionEvent event) {
		String type = comboBox.getValue();
		switch (type) {
		case "Transfer":
			accountNum = taNum1.getText();
			toAccountNum = taNum3.getText();
			tranAmu = Double.parseDouble(taNum2.getText());
			try {
				Main.bank.transfer(accountNum, toAccountNum, tranAmu);
				inValid.setText("Successful!");
			} catch (Exception e) {
				inValid.setText("Invalid Information");
			} 
			Main.bank.saveData();
			break;

		case "Withdraw":
			accountNum = taNum1.getText();
			withAmu = Double.parseDouble(taNum2.getText());
			try {
				Main.bank.withdraw(accountNum, withAmu);
				inValid.setText("Successful!");
			} catch (Exception e) {
				inValid.setText("Invalid Information");
			} 
			Main.bank.saveData();
			break;

		case "Deposit":
			accountNum = taNum1.getText();
			depAmu = Double.parseDouble(taNum2.getText());
			try {
				Main.bank.deposit(accountNum, depAmu);
				inValid.setText("Successful!");
			} catch (Exception e) {
				inValid.setText("Invalid Information");
			}
			Main.bank.saveData();
			break;
		}
		taNum1.clear();
		taNum2.clear();
		taNum3.clear();

	}

	public void back(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("EmployeeMenu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
