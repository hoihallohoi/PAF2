package domain;

import java.util.ArrayList;

public class Purpose {

	private String purposeName;
	private ArrayList<Pattern> patterns = new ArrayList<Pattern>();
	
	public Purpose(String name)
	{
		purposeName = name;
	}
	
	public void addPattern(Pattern p)
	{
		patterns.add(p);
	}
	
	public String getPurposeName() {
		return purposeName;
	}
	public void setPurposeName(String purposeName) {
		this.purposeName = purposeName;
	}
	public ArrayList<Pattern> getPatterns() {
		return patterns;
	}
	public void setPatterns(ArrayList<Pattern> patterns) {
		this.patterns = patterns;
	}
}
