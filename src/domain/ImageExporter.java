package domain;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageExporter{
	
	private static final String formatName = "jpg";

public void exportImage(Pattern p){
	BufferedImage image = (BufferedImage) p.getImage();
	if (image == null)
		return;
	try {
		ImageIO.write(image, formatName, new File(p.getPatternName() + " image"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
