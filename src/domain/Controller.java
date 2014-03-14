package domain;

import java.util.ArrayList;


public class Controller 
{
	private static ArrayList<Pattern> allPatterns;
	
	public static void Start()
	{
		allPatterns = new ArrayList<Pattern>();
	}
	
	public static String GetPatternDocumentation(Pattern p)
	{
		ImporterAdapter ia = new ImporterAdapter();
		Pattern pa = ia.ImportPattern(p);
		return pa.getPatternName() + "\nThe problem is: " + pa.getProblem() + "\nThe solution is: " + pa.getSolution();
	}
	
	public static void Update()
	{
		for(Pattern p : allPatterns){
			UpdatePattern(p);
		}
	}
	
	public static void UpdatePattern(Pattern p)
	{
		ExporterAdapter ea = new ExporterAdapter();
		ea.ExportPattern(p);
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
	
	
	
}
