package domain;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageExporter{
	
	private static final String formatName = "jpg";

public void exportImage(Pattern p){
	File f = new File(p.getPatternName() + " image."+formatName);
	BufferedImage image = (BufferedImage) p.getImage();
	if (image == null)
		return;
	try {
		System.out.println("file name wordt: " + p.getPatternName() + " image");
		ImageIO.write(image, formatName, f);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
