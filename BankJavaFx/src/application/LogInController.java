package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class LogInController {
	@FXML
	TextField employeeID;
	@FXML
	TextField customerNID;
	Stage stage;
	Scene scene;
	Parent root;
  
	public void LogEmployee(ActionEvent event) throws IOException {
		String empID = employeeID.getText();
		root = FXMLLoader.load(getClass().getResource("EmployeeMenu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	public void LogCustomer(ActionEvent event) throws IOException {
		String cusNID = customerNID.getText();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerMenu.fxml"));
		root = loader.load();
		CustomerMenuController cusMenu = loader.getController();
		cusMenu.NID(cusNID);
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	
	public void exit(ActionEvent event) throws IOException {
		System.exit(0);
	}
	

}
