package view;

import java.io.File;

public class ButtonView extends ElementView {
	String closeButtonPath;
	String openButtonPath;
	
	@Override
	protected File getImageFile() {
		closeButtonPath = "assets/button_close.png";
		openButtonPath = "assets/button_open.png";
		
		return new File(closeButtonPath);
	}
	
	public void openButton() {
		super.updateSprite(new File(openButtonPath));
	}
	
	public void closeButton() {
		super.updateSprite(new File(closeButtonPath));
	}

}
