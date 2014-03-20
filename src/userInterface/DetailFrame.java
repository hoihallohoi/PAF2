package userInterface;

import java.awt.event.ItemEvent;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import domain.Controller;
import domain.Pattern;
import domain.Problem;

public class DetailFrame extends MainFrame{
	
	JLabel name, context, summary, solution, consequences, spacer;
	JComboBox problems;
	
	public DetailFrame(Object patternObject){
		super();
		Pattern pattern = (Pattern)patternObject;
		
		spacer = new JLabel("                  ");
		
		name = new JLabel(pattern.getPatternName());
		context = new JLabel(Controller.getContextByPattern(pattern).toString());
		summary = new JLabel(pattern.getSummary());
		problems = new JComboBox(pattern.getProblems().toArray());
		consequences = new JLabel(Controller.getConsequenceByPattern(pattern).toString());
		
		Object c = problems.getSelectedItem();
        Problem p = (Problem)c;
        
		solution = new JLabel(p.getSolutionContext());
		
		problems.addItemListener(this);	
		
		add(name);
		add(spacer);
		add(context);
		add(spacer);
		add(summary);
		add(spacer);
		add(problems);
		add(spacer);
		add(solution);
		add(consequences);
		
	}
	
	 public void itemStateChanged(ItemEvent itemEvent) {
	        Object c = problems.getSelectedItem();
	        Problem p = (Problem)c;
	        solution.setText(p.getSolutionContext());
	 }
}
