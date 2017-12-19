package view;

import java.io.File;

public class MonsterView extends ElementView {

	/** 
	 * Returns a File object that points to an image file representing
	 * a monster. The File is meant to be used elsewhere in order
	 * to generate a proper sprite that can be printed on the screen. <p>
	 * 
	 * If the file doesn't exist, an empty File will be returned.
	 *
	 * @return 			a File object that contains an image of a monster
	 * @see 			view.ElementView
	 * @see 			java.io.File
	 */	
	
	@Override
	protected File getImageFile() {
		return new File("assets/bad.png");
	}
	
}