module BankJavaFx {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires BankingSystemLibrary;
	
	opens application to javafx.graphics, javafx.fxml;
}
