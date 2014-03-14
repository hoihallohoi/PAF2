package domain;

import java.util.ArrayList;

public class Pattern {
	private String patternName, consequence;
	private ArrayList<Problem> problems = new ArrayList<Problem>();
	private ArrayList<String> alternatives = new ArrayList<String>();
	
	public Pattern(String name, Problem p, String con, ArrayList<String> alt){
		patternName = name;
		problems.add(p);
		consequence = con;
		alternatives = alt;
	}
	
	public Pattern(){
		
	}
	
	public Pattern(String name, ArrayList<Problem> p, String con, ArrayList<String> alt){
		patternName = name;
		problems = p;
		consequence = con;
		alternatives = alt;
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
