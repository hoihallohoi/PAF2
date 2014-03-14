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
		int i = 0;
		int j = 0;
		int k = 0;
		try {
			while ((line = br.readLine()) != null) {
				i++;
				System.out.println("i: " + i);
			    p.setPatternName(line);
			    p.setConsequence(br.readLine());
			    ArrayList<String> alts = new ArrayList<String>();
			    while((!(line = br.readLine()).equals("<endAlt>"))){
			    	j++;
			    	System.out.println("j: "+ j);
			    	alts.add(line);
			    }
			    ArrayList<Problem> problems = new ArrayList<Problem>();
			    while((!(line = br.readLine()).equals("<#&$#>"))){
			    	k++;
			    	System.out.println("k: " + k);
			    	Problem prob = new Problem();
			    	prob.setProblemContext(line);
			    	prob.setSolutionContext(br.readLine());
			    	problems.add(prob);
			    }
			    p.setAlternatives(alts);
			    p.setProblems(problems);
			    Controller.AddPattern(p);
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
		return null;
	}

	@Override
	public ArrayList<String> ImportPatternNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
