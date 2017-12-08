package view;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class CandyView extends ElementView {	
	
	@Override
	protected File getImageFile() {
		File file;
		int type = ThreadLocalRandom.current().nextInt(0, 4);
		
		switch(type) {
			case 0:
				file = new File("assets/candy-1.png");
				break;
				
			case 1:
				file = new File("assets/candy-2.png");
				break;
				
			case 2:
				file = new File("assets/candy-3.png");
				break;
				
			case 3:
				file = new File("assets/candy-4.png");
				break;
				
			default:
				file = new File("assets/candy-1.png");
				break;				
		}
		
		return file;
	}

}
