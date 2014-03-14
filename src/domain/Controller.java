package domain;

import java.util.ArrayList;


public class Controller 
{
	public static ArrayList<Pattern> allPatterns = new ArrayList<Pattern>();
	
	public static void Start()
	{
		ImporterAdapter ia = new ImporterAdapter();
		ArrayList<Pattern> patterns = ia.ImportAllPatterns();
		for (Pattern p : patterns)
		{
			allPatterns.add(p);
		}
	}
	
	public static Pattern createNewPattern(String name, Problem pr, String con, ArrayList<String> alt, Scope s, Purpose p)
	{
		Pattern pat = new Pattern(name,pr,con,alt);
		s.addPattern(pat);
		p.addPattern(pat);
		allPatterns.add(pat);
		System.out.println("Arraylist size: " + allPatterns.size());
		return pat;
	}
	
	public static Pattern createNewPattern(String name, ArrayList<Problem> pr, String con, ArrayList<String> alt, Scope s, Purpose p)
	{
		Pattern pat = new Pattern(name,pr,con,alt);
		s.addPattern(pat);
		p.addPattern(pat);
		allPatterns.add(pat);
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
		for(Pattern p : allPatterns){
			UpdatePattern(p);
		}
	}
	
	public static void UpdatePattern(Pattern p)
	{
		ExporterAdapter ea = new ExporterAdapter();
		ea.ExportAllPatterns();
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
