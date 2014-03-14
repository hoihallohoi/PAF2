package domain;

public class Pattern {
	private String patternName, problem, solution;
	
	public Pattern(String name, String prob, String sol){
		name = patternName;
		prob = problem;
		sol = solution;
	}

	public String getPatternName() {
		return patternName;
	}

	public void setPatternName(String patternName) {
		this.patternName = patternName;
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
