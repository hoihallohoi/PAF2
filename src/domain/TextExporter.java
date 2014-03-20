package domain;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class TextExporter implements Exporter 
{

	@Override
	public void ExportAllPatterns(ArrayList<Pattern> patterns) {
		System.out.println("Starting export");
		System.out.println(patterns);
		try {
			PrintWriter pw = new PrintWriter("Patterns.txt");
			for(Pattern p : patterns)
			{
				pw.println(p.getPatternName());
				pw.println(p.getSummary());
				for(String c : p.getConsequences()){
					pw.println(c);
				}
				pw.println("<endCon>");
				for(Pattern pa : p.getAlternatives()){
					pw.println(pa.getPatternName());
					pw.println(pa.getSummary());
				}
				pw.println("<endAlt>");
				for(Problem problem : p.getProblems()){
					pw.println(problem.getProblemContext());
					pw.println(problem.getSolutionContext());
				}
				pw.println("<#&$#>");
				System.out.println("Finished Export");
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("hoi");
		
	}

}
