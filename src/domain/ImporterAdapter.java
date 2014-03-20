package domain;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;


public class ImporterAdapter implements Importer
{

	@Override
	public Pattern ImportPattern(String p) {
		TextImporter ti = new TextImporter();
		return ti.ImportPattern(p);
	}

	//If this is called set the returning value to the Controller's list of patterns.
	@Override
	public ArrayList<Pattern> ImportAllPatterns() {
		TextImporter ti = new TextImporter();
		return ti.ImportAllPatterns();

	}
	public Image importImage(File f){
		ImageImporter ii = new ImageImporter();
		return ii.importImage(f);
	}

	@Override
	public ArrayList<Context> ImportAllContext() {
		TextImporter ti = new TextImporter();
		return ti.ImportAllContext();
	}

}
