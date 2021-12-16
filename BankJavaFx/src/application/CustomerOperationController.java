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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerOperationController implements Initializable {

	@FXML
	Label accLab;
	@FXML
	TextField accField;
	@FXML
	public ComboBox<String> comboBox;
	ObservableList<String> list = FXCollections.observableArrayList("Check account summary", "Transation of account");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		comboBox.setItems(list);
	}

	Stage stage;
	Scene scene;
	Parent root;
	static String nid;

	public void NID(String cusNID) {
		nid = cusNID;
		// System.out.println(nid);
	}

	public void submit(ActionEvent event) throws InvalidAccountException, IOException {
		// System.out.println(nid);
		String type = comboBox.getValue();
		switch (type) {
		case "Check account summary":
			String accountNum = accField.getText();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerDisplay.fxml"));
			root = loader.load();
			CustomerDisplayController d = loader.getController();
			d.cusDisplaySummary(nid,accountNum);
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			break;

		case "Transation of account":
			String accountNum2 = accField.getText();
			FXMLLoader loader2 = new FXMLLoader(getClass().getResource("CustomerDisplay.fxml"));
			root = loader2.load();
			CustomerDisplayController d2 = loader2.getController();
			d2.cusDisplayTransaction(nid,accountNum2);
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			break;
		}

	}

	public void back(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("CustomerMenu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
