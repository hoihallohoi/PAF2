package domain;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class TextExporter implements Exporter 
{

	@Override
	public void ExportAllPatterns() {
		System.out.println("Starting export");
		try {
			PrintWriter pw = new PrintWriter("Patterns.txt");
			for(Pattern p : Controller.allPatterns)
			{
				pw.println(p.getPatternName());
				pw.println(p.getConsequence());
				for(String s : p.getAlternatives())
					pw.println(s);
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
