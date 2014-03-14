package domain;

import java.util.List;


public interface Importer 
{
	public Pattern ImportPattern(Pattern p);
	public List<Pattern> ImportAllPatterns();
	public List<String> ImportPatternNames();
}
