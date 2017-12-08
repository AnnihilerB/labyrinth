package view;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonView extends ElementView {
	String openButton = "assets/button_open.png";
	String closeButton = "assets/button_close.png";
	
	@Override
	protected File getImageFile() {
		return new File("assets/button_close.png");
	}
	
	public void openButton() {
		Image image = new Image(getImageFile().toURI().toString());
		sprite = new ImageView(image);		
	}

}
