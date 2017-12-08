package view;

import java.io.File;

public class MonsterView extends ElementView {

	@Override
	protected File getImageFile() {
		return new File("assets/bad.png");
	}
	
}