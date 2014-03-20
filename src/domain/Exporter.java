package domain;

import java.util.ArrayList;


public interface Exporter 
{
	public void ExportAllPatterns(ArrayList<Pattern> patterns);
	public void ExportAllContext(ArrayList<Context> contexts);
}
