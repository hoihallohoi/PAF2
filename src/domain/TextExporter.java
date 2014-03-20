package domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class TextExporter implements Exporter 
{
	
	@Override
	public void ExportAllPatterns(ArrayList<Pattern> patterns) {
		try {
			File f = new File("Patterns.txt");
			PrintWriter pw = new PrintWriter(f);
			for(Pattern p : patterns)
			{
				pw.println(p.getPatternName());
				pw.println(p.getSummary());
				for(String c : p.getConsequences()){
					System.out.println("CONSEQ: " + c);
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
				pw.println("<End>");
				System.out.println("Finished Export");
				ImageExporter ie = new ImageExporter();
				ie.exportImage(p);	
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("hoi");
		
	}

	@Override
	public void ExportAllContext(ArrayList<Context> contexts) {
		try {
			System.out.println("EXPORTING CONTEXT");
			PrintWriter pw = new PrintWriter("Context.txt");
			for(Context c : contexts){
				pw.println(c.getName());
				for(ContextComponent cc : c.getChildContexts()){
					Context co = (Context)cc;
					pw.println(co.getName());					
				}
				pw.println("<endChilds>");
				for(Pattern p : c.getPatterns()){
					pw.println(p.getPatternName());
				}
				pw.println("<End>");
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
