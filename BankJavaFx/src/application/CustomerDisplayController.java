package application;

import java.io.IOException;

import banking.BankAccount;
import banking.InvalidAccountException;
import banking.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class CustomerDisplayController {
	@FXML
	ListView<String>listView;
	Stage stage;
	Scene scene;
	Parent root;

	public void cusDisplaySummary(String nid, String num) throws InvalidAccountException {
		ObservableList<BankAccount> bankList = FXCollections.observableArrayList(Main.bank.findAccount(nid, num));
		listView.getItems().clear();
		listView.getItems().addAll(bankList.toString());
	}

	public void cusDisplayTransaction(String nid, String num) throws InvalidAccountException {
		ObservableList<Transaction> tran = FXCollections.observableArrayList(Main.bank.getAccTransactions(nid, num));
		listView.getItems().clear();
		listView.getItems().addAll(tran.toString());
	}
	
	public void cusDisplay(String nid) throws InvalidAccountException {
		ObservableList<BankAccount> bankList = FXCollections.observableArrayList(Main.bank.findAccounts(nid));
		listView.getItems().clear();
		listView.getItems().addAll(bankList.toString());
	}
	
	public void back(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("CustomerMenu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
