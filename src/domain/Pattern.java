package domain;

import java.util.ArrayList;

public class Pattern {
	private String patternName,summary;
	private ArrayList<Problem> problems;
	private ArrayList<Pattern> alternatives;
	private ArrayList<String> consequences;
	
	public Pattern(String name, String sum){
		patternName = name;
		summary = sum;
		problems = new ArrayList<Problem>();
		alternatives = new ArrayList<Pattern>();
		consequences = new ArrayList<String>();
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
			System.out.println("ERROR: Alternative already exists");
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
			System.out.println("ERROR: Alternative doesn't exist");
		}
	}
	
	public void addConsequences(String p){
		if (consequences.contains(p)){
			System.out.println("ERROR: Consequence already exists");
		}
		else{
			consequences.add(p);
		}
	}
	
	public void removeConsequences(String p){
		if (consequences.contains(p)){
			consequences.remove(p);
		}
		else{
			System.out.println("ERROR: Consequence doesn't exist");
		}
	}
	
	public String getPatternName() {
		return patternName;
	}

	public void setPatternName(String patternName) {
		this.patternName = patternName;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
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
		return patternName;
	}
}
