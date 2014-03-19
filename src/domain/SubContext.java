package domain;

import java.util.ArrayList;

public class SubContext implements ContextComponent{

	private String name;
	private ArrayList<Pattern> patterns = new ArrayList<Pattern>();
	
	public SubContext(String name){
		this.name = name;
	}
	
	@Override
	public String showChilds(){
		String s = "Sub Context: \n" +name+ "\n Patterns: ";
		for (Pattern p : patterns){
			s = s + p.toString() + "\n";
		}
		return s;
	}
	
	@Override
	public void addPattern(Pattern p){
		if (patterns.contains(p)){
			System.out.println("ERROR: Problem already exists");
		}
		else{
			patterns.add(p);
		}
	}
	
	@Override
	public void removePattern(Pattern p){
		if (patterns.contains(p)){
			patterns.remove(p);
		}
		else{
			System.out.println("ERROR: Problem doesn't exist");
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ArrayList<Pattern> getPatterns() {
		return patterns;
	}	
}
