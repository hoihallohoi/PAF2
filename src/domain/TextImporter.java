package domain;

import java.io.BufferedReader;
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
			    String name = line;
			    String sum = line;
			    Pattern p = new Pattern(name ,sum);
			    while((line = br.readLine()).equals("endCon")){
			    	String con = line;
			    	p.addConsequences(con);
			    }
			    while((!(line = br.readLine()).equals("<endAlt>"))){
			    	String pname = line;
			    	String psum = line;
			    	Pattern pa = new Pattern(pname, psum);
			    	p.addAlternatives(pa);
			    }
			    while((!(line = br.readLine()).equals("<#&$#>"))){
			    	String problem = line;
			    	String sol = line;
			    	Problem prob = new Problem(problem, sol);
			    	p.addProblem(prob);
			    }
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

}
