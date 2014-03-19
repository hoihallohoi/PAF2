package domain;

import java.util.ArrayList;


public class Scope 
{
	private String scopeName;
	private ArrayList<Pattern> patterns = new ArrayList<Pattern>();
	
	public Scope(String name)
	{
		scopeName = name;
		patterns = new ArrayList<Pattern>();
	}
	
	public void addProblem(Pattern p){
		if (patterns.contains(p)){
			System.out.println("ERROR: Problem already exists");
		}
		else{
			patterns.add(p);
		}
	}
	
	public void removeProblem(Pattern p){
		if (patterns.contains(p)){
			patterns.remove(p);
		}
		else{
			System.out.println("ERROR: Problem doesn't exist");
		}
	}
	
	public String getScopeName() {
		return scopeName;
	}
	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}
	public ArrayList<Pattern> getPatterns() {
		return patterns;
	}
	public void setPatterns(ArrayList<Pattern> patterns) {
		this.patterns = patterns;
	}
}
