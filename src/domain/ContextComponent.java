package domain;

import java.util.ArrayList;

//Component
public interface ContextComponent {
	
	public void addPattern(Pattern p);
	public void removePattern(Pattern p);
	public String getName();
	public ArrayList<Pattern> getPatterns();
	public String showChilds();
}

