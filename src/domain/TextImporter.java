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
		Pattern p = new Pattern();
		try {
			while ((line = br.readLine()) != null) {
			    p.setPatternName(line);
			    p.setConsequence(br.readLine());
			    ArrayList<String> alts = new ArrayList<String>();
			    while((!(line = br.readLine()).equals("<endAlt>"))){
			    	alts.add(line);
			    }
			    ArrayList<Problem> problems = new ArrayList<Problem>();
			    while((!(line = br.readLine()).equals("<#&$#>"))){
			    	Problem prob = new Problem();
			    	prob.setProblemContext(line);
			    	prob.setSolutionContext(br.readLine());
			    	problems.add(prob);
			    }
			    p.setAlternatives(alts);
			    p.setProblems(problems);
			    patterns.add(p);
			    p = new Pattern();
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
