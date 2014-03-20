package domain;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

public class ImageImporter{

public Image importImage(File f){
	BufferedImage image = null;
	try {
		image = ImageIO.read(f);
		image = Scalr.resize(image, Scalr.Method.BALANCED, 100, 100);
		if (image == null) {
			System.out.println("File is geen image.");
			return null;
		}
	} catch (IOException ex) {
		System.out.println("Kan bestand niet openen");
	}
	return image;
	
}

}
