package domain;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class TextExporter implements Exporter 
{

	private PrintWriter pw = null;
	
	private void printTo(String s){
		System.out.println("PRINTING TO FILE: " + s);
		pw.println(s);
	}
	
	@Override
	public void ExportAllPatterns(ArrayList<Pattern> patterns) {
		try {
			pw = new PrintWriter("Patterns.txt");
			for(Pattern p : patterns)
			{
				printTo(p.getPatternName());
				printTo(p.getSummary());
				for(String c : p.getConsequences()){
					System.out.println("CONSEQ: " + c);
					printTo(c);
				}
				printTo("<endCon>");
				for(Pattern pa : p.getAlternatives()){
					printTo(pa.getPatternName());
					printTo(pa.getSummary());
				}
				printTo("<endAlt>");
				for(Problem problem : p.getProblems()){
					printTo(problem.getProblemContext());
					printTo(problem.getSolutionContext());
				}
				printTo("<#&$#>");
				System.out.println("Finished Export");
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("hoi");
		
	}

}
