package domain;

import java.util.ArrayList;


public interface Importer 
{
	public Pattern ImportPattern(String p);
	public ArrayList<Pattern> ImportAllPatterns();
	public ArrayList<Context> ImportAllContext();
}
