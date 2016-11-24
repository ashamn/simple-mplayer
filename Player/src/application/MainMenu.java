package application;


import java.io.File;
import java.net.MalformedURLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainMenu extends BorderPane{

	
	Player player;
	FileChooser fileChooser = new FileChooser();
	
	MenuItem open;
	Menu mediaFile;
	MenuBar menu;
	
	public MainMenu(Stage primaryStage){
		open = new MenuItem("Open");
		mediaFile = new Menu("File");
		menu = new MenuBar();
		
		mediaFile.getItems().add(open);
		menu.getMenus().add(mediaFile);
		
		setTop(menu);
		
		open.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e) {
				// player.player.pause();
				File file = fileChooser.showOpenDialog(primaryStage);
				
				if(file != null){
					try {
						BorderPane bp = new BorderPane();
						MainMenu mainmenu = new MainMenu(primaryStage);
						player = new Player(file.toURI().toURL().toExternalForm());
						bp.setTop(mainmenu);
						bp.setCenter(player);
						Scene scene = new Scene(bp, 720 ,200, javafx.scene.paint.Color.BLACK);
						scene.getStylesheets().add("/css/application.css");
						primaryStage.setTitle("Java Media Player");
						primaryStage.setScene(scene);						

					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
}
