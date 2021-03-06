package domain;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Controller 
{
	public static ArrayList<Pattern> allPatterns = new ArrayList<Pattern>();
	public static ArrayList<Context> allContexts = new ArrayList<Context>(); //Only has main contexts
	public static ArrayList<Context> allSubContexts = new ArrayList<Context>(); //had all except Scope and Purpose
	public static ArrayList<Context> everyContext = new ArrayList<Context>(); //This does actually have all contexts
	public static void Start()
	{
		ImporterAdapter ia = new ImporterAdapter();
		allPatterns = ia.ImportAllPatterns();
		everyContext = ia.ImportAllContext();
		for (Context c : everyContext)
			if(!c.getName().equals("Scope") || !c.getName().equals("Purpose"))
				allContexts.add(c);
		
		System.out.println("All Patterns imported!");
	}
	
	public static Pattern createNewPattern(String name,String summary, Context scope, Context purpose)
	{
		Pattern pat = new Pattern(name, summary);
		scope.addPattern(pat);
		purpose.addPattern(pat);
		allPatterns.add(pat);
		//System.out.println("Arraylist size: " + allPatterns.size());
		return pat;
	}
	
	public static Context createNewContext(String name){
		Context c = new Context(name);
		allContexts.add(c);
		everyContext.add(c);
		return c;
	}
	
	public static Context createNewSubContext(String name){
		Context c = new Context(name);
		allSubContexts.add(c);
		everyContext.add(c);
		return c;
	}
	
	public static ArrayList<Context> getAllContexts(){
		return allContexts;
	}
	
	public static ArrayList<Pattern> getAllPatterns(){
		return allPatterns;
	}
	
	public static ArrayList<Pattern> getPatternsByContext(Object c){
		if(c instanceof Context){
			Context context = (Context) c;
			return context.getPatterns();
		}
		return null;
	}
	
	public static ArrayList<Context> getContextByPattern(Pattern p){
		ArrayList<Context> selectedContexts = new ArrayList<Context>();
		for (Context c : allSubContexts){
			for (Pattern pattern : c.getPatterns()){
				if(pattern.equals(p)){
					selectedContexts.add(c);
				}
			}
		}
		return selectedContexts;
	}
	
	public static ArrayList<String> getConsequenceByPattern(Object c){
		if(c instanceof Pattern){
			Pattern pattern = (Pattern) c;
			return pattern.getConsequences();
		}
		return null;
	}
	
	
	public static void Update()
	{
		ExporterAdapter ea = new ExporterAdapter();
		ea.ExportAllPatterns(allPatterns);
		ea.ExportAllContext(everyContext);
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
	
	public static void importImage(File f , Pattern p){
		ImporterAdapter ia = new ImporterAdapter();
		Image image = ia.importImage(f);
		p.addImage(image);
	}
	
	public static Pattern getPatterByName(String s){
		  for (Pattern p : allPatterns)
		   if (p.getPatternName().equals(s))
		    return p;
		  return null;
		 }
	
	public static Context getContextByName(String s){
		for (Context c : allContexts)
			if (c.getName().equals(s))
				return c;
		return null;
	}

	public static void editPattern(Pattern pattern, String name, String summary, Problem problem, String solution) {
		pattern.setPatternName(name);
		pattern.setSummary(summary);
		problem.setSolutionContext(solution);
		
	}
	
	public static void editPattern(Pattern pattern, String name, File image, String summary, Problem problem, String solution) {
		pattern.setPatternName(name);
		importImage(image, pattern);
		pattern.setSummary(summary);
		problem.setSolutionContext(solution);
	}

	public static void removePattern(Pattern pattern, Problem problem) {
		pattern.removeProblem(problem);
		
	}
	
	public static void removeConsequence(Pattern pattern, String con) {
		pattern.removeConsequences(con);
		
	}

	public static void addNewProblem(Pattern pattern, String problem, String solution) {
		Problem p = new Problem(problem, solution);
		pattern.addProblem(p);
	}
	
	public static void addNewConsequence(Pattern pattern, String con) {
		pattern.addConsequences(con);
	}
	
}
