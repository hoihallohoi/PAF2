package domain;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;


public class Controller 
{
	public static ArrayList<Pattern> allPatterns = new ArrayList<Pattern>();
	public static ArrayList<Context> allContexts = new ArrayList<Context>(); //Does not include the main contexts "Scope" and "Purpose"
	
	public static void Start()
	{
		ImporterAdapter ia = new ImporterAdapter();
		allPatterns = ia.ImportAllPatterns();
		System.out.println("All Patterns imported!");
	}
	
	public static Pattern createNewPattern(String name,String summary, String con, Context scope, Context purpose)
	{
		Pattern pat = new Pattern(name, summary, con);
		scope.addPattern(pat);
		purpose.addPattern(pat);
		allPatterns.add(pat);
		//System.out.println("Arraylist size: " + allPatterns.size());
		return pat;
	}
	
	public static Context createNewContext(String name){
		Context c = new Context(name);
		allContexts.add(c);
		return c;
	}
	
	public static ArrayList<Context> getAllContexts(){
		return allContexts;
	}
	
	public static ArrayList<Pattern> getPatternsByContext(Object c){
		if(c instanceof Context){
			Context context = (Context) c;
			return context.getPatterns();
		}
		return null;
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
