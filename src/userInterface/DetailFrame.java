package userInterface;

import java.awt.event.ItemEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import domain.Controller;
import domain.Pattern;
import domain.Problem;

public class DetailFrame extends MainFrame{
	
	JLabel name, context, summary, solution, consequences;
	JComboBox problems;
	
	public DetailFrame(Object patternObject){
		super();
		Pattern pattern = (Pattern)patternObject;
		
		name = new JLabel(pattern.getPatternName());
		context = new JLabel(Controller.getContextByPattern(pattern).toString());
		summary = new JLabel(pattern.getSummary());
		problems = new JComboBox(pattern.getProblems().toArray());
		solution = new JLabel("");
		
		problems.addItemListener(this);	
		
		add(name);
		add(context);
		add(summary);
		add(problems);
		add(solution);
		
	}
	
	 public void itemStateChanged(ItemEvent itemEvent) {
	        Object c = problems.getSelectedItem();
	        Problem p = (Problem)c;
	        solution.setText(p.getSolutionContext());
	 }
}
