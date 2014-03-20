package userInterface;

import java.awt.event.ItemEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import domain.Controller;
import domain.Pattern;
import domain.Problem;

public class DetailFrame extends MainFrame{
	
	JLabel name, image, context, solution, consequencesLab, problemsLab, summaryLab;
	JComboBox problems, consequences;
	JTextArea summary;
	
	public DetailFrame(Object patternObject){
		super();
		Pattern pattern = (Pattern)patternObject;
		
		JLabel spacer1 = new JLabel("  ");
		JLabel spacer2 = new JLabel("  ");
		JLabel spacer3 = new JLabel("  ");
		JLabel spacer4 = new JLabel("  ");
		JLabel spacer5 = new JLabel("  ");
		
		name = new JLabel(pattern.getPatternName() + " Pattern");
		//image = new JLabel(new ImageIcon(pattern.getImage()));
		context = new JLabel("Context(s): " + Controller.getContextByPattern(pattern).toString());
		summaryLab = new JLabel("Summary: ");
		summary = new JTextArea(pattern.getSummary());
		summary.setEditable(false);
		problemsLab = new JLabel("Problems: ");
		problems = new JComboBox(pattern.getProblems().toArray());
		consequencesLab = new JLabel("Consequences: ");
		consequences = new JComboBox(Controller.getConsequenceByPattern(pattern).toArray());
		
		Object c = problems.getSelectedItem();
        Problem p = (Problem)c;
        
		solution = new JLabel("Solution: " + p.getSolutionContext());
		
		problems.addItemListener(this);	
		
		add(name);
		add(spacer1);
		//add(image);
		add(spacer2);
		add(context);
		add(spacer3);
		add(summaryLab);
		add(summary);
		add(spacer4);
		add(problemsLab);
		add(problems);
		add(solution);
		add(spacer5);
		add(consequencesLab);
		add(consequences);
		
	}
	
	 public void itemStateChanged(ItemEvent itemEvent) {
	        Object c = problems.getSelectedItem();
	        Problem p = (Problem)c;
	        solution.setText("Solution: " + p.getSolutionContext());
	 }
}
