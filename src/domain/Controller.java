package domain;

import java.io.File;
import java.util.ArrayList;


public class Controller 
{
	public static ArrayList<Pattern> allPatterns = new ArrayList<Pattern>();
	
	public static void Start()
	{
		ImporterAdapter ia = new ImporterAdapter();
		allPatterns = ia.ImportAllPatterns();
		System.out.println("All Patterns imported!");
	}
	
	public static Pattern createNewPattern(String name, String con, Scope s, Purpose p)
	{
		Pattern pat = new Pattern(name,con);
		s.addPattern(pat);
		p.addPattern(pat);
		allPatterns.add(pat);
		System.out.println("Arraylist size: " + allPatterns.size());
		return pat;
	}
	
	public static String GetPatternDocumentation(String p)
	{
		ImporterAdapter ia = new ImporterAdapter();
		Pattern pa = ia.ImportPattern(p);
		return "";
	}
	
	public static void Update()
	{
		ExporterAdapter ea = new ExporterAdapter();
		ea.ExportAllPatterns(allPatterns);
	}
	
	public static void AddPattern(Pattern p)
	{
		allPatterns.add(p);
	}
	
	public static void Changepattern(Pattern p, Pattern p2)
	{
		allPatterns.remove(p);
		allPatterns.add(p2);
	}
	
	public static Object[] getProblemByPattern(Pattern p){
		return p.getProblems().toArray();
	}
	public static void importImage(File f){
		ImporterAdapter ia = new ImporterAdapter();
		Image image = ia.importImage(f);
	}
	
}
