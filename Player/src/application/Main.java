package application;
	


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;



public class Main extends Application {
	

	
	@Override
	public void start(Stage primaryStage) {
		
		MainMenu mainmenu = new MainMenu(primaryStage);
		
		
		Scene scene = new Scene(mainmenu, 720, 490);
		scene.getStylesheets().add("/css/application.css");
		
		primaryStage.setTitle("Java Media Player");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
