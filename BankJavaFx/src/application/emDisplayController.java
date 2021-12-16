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

public class emDisplayController {
   @FXML
   ListView <String> listView;
   Stage stage;
   Scene scene;
   Parent root;
   
   public void display() {
	   ObservableList<BankAccount> bankList = FXCollections.observableArrayList(Main.bank.getAccounts());
	   listView.getItems().clear();
	   for( int i = 0; i<bankList.size(); i++) {
		   listView.getItems().addAll(bankList.get(i).toString());
	   }
   }
   
	public void back(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("EmployeeMenu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	 public void displaySummary(String accNum) throws InvalidAccountException {
		   ObservableList<BankAccount> bankList = FXCollections.observableArrayList(Main.bank.findAccount(accNum));
		   listView.getItems().clear();
		   listView.getItems().addAll(bankList.toString());
		   
	   }
	
	 public void displayType(String type) {
		   ObservableList<BankAccount> bankList = FXCollections.observableArrayList(Main.bank.getAccounts(type));
		   listView.getItems().clear();
		   listView.getItems().addAll(bankList.toString());
		   
	   }
	   
	 public void displayTransaction(String num) throws InvalidAccountException {
		   ObservableList<Transaction> tran = FXCollections.observableArrayList(Main.bank.getAccTransactions(num));
		   listView.getItems().clear();
		   listView.getItems().addAll(tran.toString());
		   
	   }
	   
   
}
