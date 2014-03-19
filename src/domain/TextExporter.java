package domain;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class TextExporter implements Exporter 
{

	@Override
	public void ExportAllPatterns(ArrayList<Pattern> patterns) {
		System.out.println("Starting export");
		try {
			PrintWriter pw = new PrintWriter("Patterns.txt");
			for(Pattern p : patterns)
			{
				pw.println(p.getPatternName());
				pw.println(p.getConsequence());
				for(Pattern pa : p.getAlternatives()){
					pw.println(pa.getPatternName());
					pw.println(pa.getConsequence());
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
