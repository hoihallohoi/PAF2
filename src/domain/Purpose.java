package domain;

import java.util.ArrayList;

public class Purpose {

	private String purposeName;
	private ArrayList<Pattern> patterns;
	
	public Purpose(String name)
	{
		purposeName = name;
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
