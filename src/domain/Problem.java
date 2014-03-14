package domain;

public class Problem 
{
	private String problemContext, solutionContext;
	
	public Problem(String problem, String solution)
	{
		problemContext = problem;
		solutionContext = solution;
		
	}

	public Problem() {
		// TODO Auto-generated constructor stub
	}

	public String getProblemContext() {
		return problemContext;
	}

	public void setProblemContext(String problemContext) {
		this.problemContext = problemContext;
	}

	public String getSolutionContext() {
		return solutionContext;
	}

	public void setSolutionContext(String solutionContext) {
		this.solutionContext = solutionContext;
	}
	
}
