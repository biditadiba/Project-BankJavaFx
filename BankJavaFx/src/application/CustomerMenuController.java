package application;

import java.io.IOException;

import banking.InvalidAccountException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CustomerMenuController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	static String nid;

	public void NID(String cusNID) {
		nid = cusNID;
	}

	public void accountSumTransaction(ActionEvent event) throws IOException {
		//System.out.println(nid);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerOperation.fxml"));
		root = loader.load();
		CustomerOperationController cusNID2 = loader.getController();
		cusNID2.NID(nid);
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void listOfAccounts(ActionEvent event) throws IOException, InvalidAccountException {
		Main.bank.findAccounts(nid);
		FXMLLoader loader3 = new FXMLLoader(getClass().getResource("CustomerDisplay.fxml"));
		root = loader3.load();
		CustomerDisplayController d3 = loader3.getController();
		d3.cusDisplay(nid);
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void back(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("LogInWindow.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
