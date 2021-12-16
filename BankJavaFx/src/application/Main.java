package application;
import java.util.ArrayList;
import banking.Bank;
import banking.BankAccount;
import banking.DataHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	public static Bank bank = new Bank("UAP Bank");
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("LogInWindow.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("UAP Bank");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			bank = DataHandler.readData();
//			ArrayList<BankAccount>b = bank.getAccounts();
//			for(BankAccount x: b) {
//				System.out.println(x);
			//}
		} catch (Exception e) {
			bank = new Bank("UAP Bank");
		}
		launch(args);
	}
}
