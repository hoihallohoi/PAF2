package domain;

import java.util.ArrayList;


public class Scope 
{
	private String scopeName;
	private ArrayList<Pattern> patterns = new ArrayList<Pattern>();
	
	public Scope(String name)
	{
		scopeName = name;
	}
	
	public void addPattern(Pattern p)
	{
		patterns.add(p);
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
