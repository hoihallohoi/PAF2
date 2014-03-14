package domain;

import java.util.ArrayList;

public class Pattern {
	private String patternName, problem, solution,consequence;
	private ArrayList<String> alternatives = new ArrayList<String>();
	
	public Pattern(String name, String prob, String sol, String con, ArrayList<String> alt){
		name = patternName;
		prob = problem;
		sol = solution;
		con = consequence;
		alt = alternatives;
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

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}
	
	
}
