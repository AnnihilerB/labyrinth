package view;

import java.io.File;

public class DoorView extends ElementView {

	@Override
	protected File getImageFile() {
		return new File("assets/door_open.png");
	}
	
}
