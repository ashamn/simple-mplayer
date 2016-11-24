package application;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Player extends StackPane {
	
	Media media;
	MediaPlayer player;
	MediaView view;
	StackPane mpane;
	MediaBar bar;
	BorderPane bp;

	
	public Player(String file){
		
		media = new Media(file);
		player = new MediaPlayer(media);		
		view = new MediaView(player);

	    DoubleProperty width = view.fitWidthProperty();
	    DoubleProperty height = view.fitHeightProperty();
	    
	    width.bind(Bindings.selectDouble(view.sceneProperty(), "width"));
	    height.bind(Bindings.selectDouble(view.sceneProperty(), "height"));

	    view.setPreserveRatio(true);

		mpane = new StackPane();
		mpane.getChildren().add(view);
		
	 	bp = new BorderPane();
		bar = new MediaBar(player);
		bp.setBottom(bar);
		bp.setPadding(new Insets(0,0,50,0));
		
		getChildren().addAll(mpane, bp);

		setStyle("-fx-background-color: #000000");
		
		
	}
	
	
	
}
