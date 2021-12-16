package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import banking.InvalidAccountException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SumTranController implements Initializable {
	@FXML
	TextField tField;
	@FXML
	Button Button1;
	@FXML
	Button Button2;
	@FXML
	Label inValid;

	Stage stage;
	Scene scene;
	Parent root;

	public ComboBox<String> comboBox1;
	ObservableList<String> list1 = FXCollections.observableArrayList("Summary", "Transaction");
	public ComboBox<String> comboBox2;
	ObservableList<String> list2 = FXCollections.observableArrayList("Saving", "Current", "Student");

	String accountNum;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		comboBox1.setItems(list1);
		comboBox2.setItems(list2);
	}

	public void getChoice1(ActionEvent event) {
		String choice1 = comboBox1.getValue();
	}

	public void submit1(ActionEvent event) throws InvalidAccountException, IOException {
		String choice1 = comboBox1.getValue();
		switch (choice1) {
		case "Summary":
			accountNum = tField.getText();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeDisplay.fxml"));
			root = loader.load();
			emDisplayController d = loader.getController();
			d.displaySummary(accountNum);
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			break;

		case "Transaction":
			accountNum = tField.getText();
			FXMLLoader loader2 = new FXMLLoader(getClass().getResource("EmployeeDisplay.fxml"));
			root = loader2.load();
			emDisplayController d2 = loader2.getController();
			d2. displayTransaction(accountNum);
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

			break;
		}
		tField.clear();
	}

	public void getChoice2(ActionEvent event) {
		String choice2 = comboBox2.getValue();
	}

	public void submit2(ActionEvent event) throws IOException {
		String choice2 = comboBox2.getValue();
		Main.bank.getAccounts(choice2);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeDisplay.fxml"));
		root = loader.load();
		emDisplayController d = loader.getController();
		d.displayType(choice2);
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	public void back(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("EmployeeMenu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
