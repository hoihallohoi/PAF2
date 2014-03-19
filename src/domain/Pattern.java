package domain;

import java.util.ArrayList;

public class Pattern {
	private String patternName, consequence;
	private ArrayList<Problem> problems;
	private ArrayList<String> alternatives;
	
	public Pattern(String name, String con){
		patternName = name;
		consequence = con;
		problems = new ArrayList<Problem>();
		alternatives = new ArrayList<String>();
	}
	
	public Pattern(){
		problems = new ArrayList<Problem>();
		alternatives = new ArrayList<String>();
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

	public ArrayList<String> getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(ArrayList<String> alternatives) {
		this.alternatives = alternatives;
	}

	public ArrayList<Problem> getProblems() {
		return problems;
	}

	public void setProblems(ArrayList<Problem> problems) {
		this.problems = problems;
	}
	
	
}
