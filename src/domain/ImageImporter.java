package domain;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImageImporter{

public Image importImage(File f){
	BufferedImage image = null;
	try {
		image = ImageIO.read(f);
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
