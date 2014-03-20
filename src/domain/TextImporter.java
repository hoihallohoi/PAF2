package domain;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;


public class TextImporter implements Importer 
{

	@Override
	public Pattern ImportPattern(String p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Pattern> ImportAllPatterns() {
		InputStream    fis = null;
		BufferedReader br;
		String         line;
		ArrayList<Pattern> patterns = new ArrayList<Pattern>();

		try {
			fis = new FileInputStream("Patterns.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
		try {
			while ((line = br.readLine()) != null) {
				System.out.println("IMPORTING name: " + line);
			    String name = line;
			    line = br.readLine();
			    System.out.println("IMPORTING summ: " + line);
			    String sum = line;
			    Pattern p = new Pattern(name ,sum);
			    while(!(line = br.readLine()).equals("<endCon>")){
			    	System.out.println("IMPORTING: " + line);
			    	String con = line;
			    	p.addConsequences(con);
			    }
			    while((!(line = br.readLine()).equals("<endAlt>"))){
			    	System.out.println("IMPORTING: " + line);
			    	String pname = line;
			    	line = br.readLine();
			    	System.out.println("IMPORTING: " + line);
			    	String psum = line;
			    	Pattern pa = new Pattern(pname, psum);
			    	p.addAlternatives(pa);
			    }
			    while((!(line = br.readLine()).equals("<#&$#>"))){
			    	System.out.println("IMPORTING1: " + line);
			    	String problem = line;
			    	line = br.readLine();
			    	System.out.println("IMPORTING1: " + line);
			    	String sol = line;
			    	Problem prob = new Problem(problem, sol);
			    	p.addProblem(prob);
			    }
			    
		    	ImageImporter ii = new ImageImporter();
		    	Image i = ii.importImage(new File(p.getPatternName() + " image"));
			    
			    
			    patterns.add(p);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Done with the file
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = null;
		fis = null;
		return patterns;
	}

	@Override
	public ArrayList<Context> ImportAllContext() {
		InputStream    fis = null;
		BufferedReader br;
		String         line;
		ArrayList<Context> context = new ArrayList<Context>(); //this is temporarily used
		//ArrayList<Context> contexts = new ArrayList<Context>(); //this is returned
		if(Controller.allPatterns.isEmpty()){
			System.out.println("PATTERNS ARE EMPTY IMPORTING THOSE FIRST");
			Controller.allPatterns = ImportAllPatterns();
		}

		try {
			fis = new FileInputStream("Context.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
		try {
			while ((line = br.readLine()) != null) {
				System.out.println("IMPORTING name: " + line);
			    String name = line;
			    Context c = new Context(name);
			    while(!(line = br.readLine()).equals("<endChilds>")){
			    	System.out.println("IMPORTING: " + line);
			    	String con = line;
			    	Context co = new Context(con);
			    	c.addComponent(co);
			    }
			    while(!(line = br.readLine()).equals("<End>")){
			    	System.out.println("IMPORTING: " + line);
			    	String pattern = line;
			    	Pattern p = Controller.getPatterByName(pattern);
			    	c.addPattern(p);
			    }
			    
			    context.add(c);
			}
			
			/*for (Context c : context){
				Context newContext = new Context(c.getName());
					for (ContextComponent co : c.getChildContexts()){
					Context con = (Context)co;
					Context newCon = Controller.getContextByName(con.getName());
					//c.getChildContexts().add(newCon);
					newContext.addComponent(newCon);
				}
				newContext.setPatterns(c.getPatterns());
				contexts.add(newContext);
			}*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Done with the file
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = null;
		fis = null;
		return context;
	}

}
