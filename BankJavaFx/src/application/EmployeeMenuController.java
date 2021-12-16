package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmployeeMenuController {
	Stage stage;
	Scene scene;
	Parent root;
	public void addNewAccount(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void depositWithdrawTransfer(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TrWiDe.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void summaryAccountTransactionListOfSpecific(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("SummaryTran.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void ListOffAllAccount(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeDisplay.fxml"));
		root = loader.load();
		emDisplayController d = loader.getController();
		d.display();
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
