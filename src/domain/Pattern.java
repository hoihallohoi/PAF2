package domain;

import java.util.ArrayList;

public class Pattern {
	private String patternName, consequence;
	private ArrayList<Problem> problems;
	private ArrayList<Pattern> alternatives;
	
	public Pattern(String name, String con){
		patternName = name;
		consequence = con;
		problems = new ArrayList<Problem>();
		alternatives = new ArrayList<Pattern>();
	}
	
	public Pattern(){
		problems = new ArrayList<Problem>();
		alternatives = new ArrayList<Pattern>();
	}
	
	public void addProblem(Problem p){
		if (problems.contains(p)){
			System.out.println("ERROR: Problem already exists");
		}
		else{
			problems.add(p);
		}
	}
	
	public void removeProblem(Problem p){
		if (problems.contains(p)){
			problems.remove(p);
		}
		else{
			System.out.println("ERROR: Problem doesn't exist");
		}
	}
	
	public void addAlternatives(Pattern p){
		if (alternatives.contains(p)){
			System.out.println("ERROR: Problem already exists");
		}
		else{
			alternatives.add(p);
		}
	}
	
	public void removeAlternatives(Pattern p){
		if (alternatives.contains(p)){
			alternatives.remove(p);
		}
		else{
			System.out.println("ERROR: Problem doesn't exist");
		}
	}
	
	public String getPatternName() {
		return patternName;
	}

	public void setPatternName(String patternName) {
		this.patternName = patternName;
	}

	public String getConsequence() {
		return consequence;
	}

	public void setConsequence(String consequence) {
		this.consequence = consequence;
	}

	public ArrayList<Pattern> getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(ArrayList<Pattern> alternatives) {
		this.alternatives = alternatives;
	}

	public ArrayList<Problem> getProblems() {
		return problems;
	}

	public void setProblems(ArrayList<Problem> problems) {
		this.problems = problems;
	}
	
	public String toString(){
		String s  = patternName + " \n" + "Consequences: " + consequence + "\n Problems:";
		for(Problem p : problems){
			s = s + p.toString();
		}
		return s;
	}
}
