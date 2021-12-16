package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import banking.BankAccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateAccountController implements Initializable {
	@FXML
	TextField tUserName;
	@FXML
	TextField tAccBalance;
	@FXML
	TextField tUserId;
	@FXML
	TextField tUserNID;
	@FXML
	TextField tMaxWithLimit;
	@FXML
	TextField tInstName;
	@FXML
	TextField tTradeNum;
	@FXML
	Label lAccType;
	@FXML
	Label lUserId;
	@FXML
	Label lUserNID;
	@FXML
	Label lMaxWithLimit;
	@FXML
	Label lInstName;
	@FXML
	Label lTradeNum;
	@FXML
	ListView<String> listView;
	@FXML
	Label inValid;
	Stage stage;
	Scene scene;
	Parent root;

	double AccBalance, maxWithLimit;
	String instName, tradeNum, id, nid;
	public ComboBox<String> comboBox;
	ObservableList<String> list = FXCollections.observableArrayList("Student", "Current", "Savings");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		comboBox.setItems(list);
	}

	public void setType(ActionEvent event) {
		String type = comboBox.getValue();
		switch (type) {
		case "Student":
			lAccType.setText("Student Account");
			lInstName.setVisible(true);
			tInstName.setVisible(true);
			tUserId.setVisible(true);
			lUserId.setVisible(true);
			lMaxWithLimit.setVisible(false);
			tMaxWithLimit.setVisible(false);
			lUserNID.setVisible(true);
			tUserNID.setVisible(true);
			lTradeNum.setVisible(false);
			tTradeNum.setVisible(false);
			break;

		case "Current":
			lAccType.setText("Current Account");
			lTradeNum.setVisible(true);
			tTradeNum.setVisible(true);
			lUserNID.setVisible(true);
			tUserNID.setVisible(true);
			tUserId.setVisible(false);
			lUserId.setVisible(false);
			tInstName.setVisible(false);
			lInstName.setVisible(false);
			lMaxWithLimit.setVisible(false);
			tMaxWithLimit.setVisible(false);
			break;

		case "Savings":
			lAccType.setText("Savings Account");
			lUserNID.setVisible(true);
			tUserNID.setVisible(true);
			lMaxWithLimit.setVisible(true);
			tMaxWithLimit.setVisible(true);
			tUserId.setVisible(false);
			lUserId.setVisible(false);
			tInstName.setVisible(false);
			lInstName.setVisible(false);
			lTradeNum.setVisible(false);
			tTradeNum.setVisible(false);
			break;

		}

	}

	public void submit(ActionEvent event) throws IOException {
		listView.getItems().clear();
		String name = tUserName.getText();
		String type = comboBox.getValue();
		switch (type) {
		case "Student":
			id = tUserId.getText();
			nid = tUserNID.getText();
			instName = (tInstName.getText());
			try {
				AccBalance = Double.parseDouble(tAccBalance.getText());
				String num1 = "Account Number: " + Main.bank.addAccount(name, nid, AccBalance, instName, id);
				Main.bank.saveData();
				listView.getItems().addAll(num1);
				inValid.setText("Successful!");
			} catch (Exception e) {
				inValid.setText("Invalid Information");
			}
			break;

		case "Current":
			nid = tUserNID.getText();
			tradeNum = (tTradeNum.getText());
			try {
				AccBalance = Double.parseDouble(tAccBalance.getText());
				String num2 = "Account Number: " + Main.bank.addAccount(name, nid, AccBalance, tradeNum);
				Main.bank.saveData();
				listView.getItems().addAll(num2);
				inValid.setText("Successful!");
			} catch (Exception e) {
				inValid.setText("Invalid Information");
			}
			break;

		case "Savings":
			nid = tUserNID.getText();
			maxWithLimit = Double.parseDouble(tMaxWithLimit.getText());
			try {
				AccBalance = Double.parseDouble(tAccBalance.getText());
				String num3 = "Account Number: " + Main.bank.addAccount(name, nid, AccBalance, maxWithLimit);
				Main.bank.saveData();
				listView.getItems().addAll(num3);
				inValid.setText("Successful!");
			} catch (Exception e) {
				inValid.setText("Invalid Information");
			}
			break;

		}
		tUserName.clear();
		tAccBalance.clear();
		tUserId.clear();
		tUserNID.clear();
		tMaxWithLimit.clear();
		tInstName.clear();
		tTradeNum.clear();
	}

	public void back(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("EmployeeMenu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
