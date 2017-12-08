package view;

import java.io.File;

public class PlayerView extends ElementView {

	@Override
	protected File getImageFile() {
		return new File("assets/player.png");
	}
	
}