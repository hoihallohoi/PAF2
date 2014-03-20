package domain;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

//Composite
public class Context implements ContextComponent{
	
	private String name;
	private ArrayList<Pattern> patterns = new ArrayList<Pattern> ();
	
	private List<ContextComponent> childContexts = new ArrayList<ContextComponent>();

	public Context(String name){
		this.name = name;
	}
	
	public void addComponent(ContextComponent component) {
    	childContexts.add(component);
    }
 
    public void removeComponent(ContextComponent component) {
    	childContexts.remove(component);
    }
    
    @Override
    public String showChilds(){
    	String s = "\nName: " + name + "\nPatterns for this Context: \n";
    	for (Pattern p : patterns){
    		s = s + p.toString() + "\n";
    	}
    	s = s + "\n";
    	for (ContextComponent component : childContexts) {
        	s = s + component.showChilds() + "\n";
        }
    	return s;
    	
    }

	@Override
	public void addPattern(Pattern p){
		if (patterns.contains(p)){
			System.out.println("ERROR: Problem already exists");
		}
		else{
			patterns.add(p);
		}
	}
	
	@Override
	public void removePattern(Pattern p){
		if (patterns.contains(p)){
			patterns.remove(p);
		}
		else{
			System.out.println("ERROR: Problem doesn't exist");
		}
	}
	
	public String toString(){
		return name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ArrayList<Pattern> getPatterns() {
		return patterns;
	}	
	
	public List<ContextComponent> getChildContexts(){
		return childContexts;
	}
	
	public void setChildContexts(ArrayList<ContextComponent> cc){
		childContexts = cc;
	}
	
	public void setPatterns(ArrayList<Pattern> pats){
		patterns = pats;
	}
}
