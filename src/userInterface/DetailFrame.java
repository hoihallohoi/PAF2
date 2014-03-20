package userInterface;

import java.awt.event.ItemEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import domain.Controller;
import domain.Pattern;
import domain.Problem;

public class DetailFrame extends MainFrame{
	
	JLabel name, image, context, summary, solution, consequences, spacer;
	JComboBox problems;
	
	public DetailFrame(Object patternObject){
		super();
		Pattern pattern = (Pattern)patternObject;
		
		name = new JLabel(pattern.getPatternName());
		image = new JLabel(new ImageIcon(pattern.getImage()));
		context = new JLabel(Controller.getContextByPattern(pattern).toString());
		summary = new JLabel(pattern.getSummary());
		problems = new JComboBox(pattern.getProblems().toArray());
		consequences = new JLabel(Controller.getConsequenceByPattern(pattern).toString());
		
		Object c = problems.getSelectedItem();
        Problem p = (Problem)c;
        
		solution = new JLabel(p.getSolutionContext());
		
		problems.addItemListener(this);	
		
		add(name);
		//add(image);
		add(context);
		add(summary);
		add(problems);
		add(solution);
		add(consequences);
		
	}
	
	 public void itemStateChanged(ItemEvent itemEvent) {
	        Object c = problems.getSelectedItem();
	        Problem p = (Problem)c;
	        solution.setText(p.getSolutionContext());
	 }
}
