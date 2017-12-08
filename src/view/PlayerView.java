package view;

import java.io.File;

public class PlayerView extends ElementView {

	static PlayerView playerView = null;

	public static PlayerView getInstance(){
		if(playerView == null)
			playerView = new PlayerView();
		return playerView;
	}

	private PlayerView(){

	}


	@Override
	protected File getImageFile() {
		return new File("assets/player.png");
	}
	
}