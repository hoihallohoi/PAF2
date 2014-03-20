package userInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		
		JPanel abovePanel = new JPanel();
		JPanel detailsPanel = new JPanel();
		JPanel imagePanel = new JPanel();
		JPanel problemsPanel = new JPanel();
		JPanel consequencesPanel = new JPanel();
		
		name = new JLabel(pattern.getPatternName() + " Pattern");
		image = new JLabel(new ImageIcon(pattern.getImage()));
		context = new JLabel("Context(s): " + Controller.getContextByPattern(pattern).toString());
		summaryLab = new JLabel("Summary: ");
		
		summary = new JTextArea(pattern.getSummary(), 5, 10);
		summary.setPreferredSize(new Dimension(600, 300));
		summary.setEditable(false);
		summary.setLineWrap(true);
		summary.setWrapStyleWord(true);
		
		problemsLab = new JLabel("Problems: ");
		problems = new JComboBox(pattern.getProblems().toArray());
		consequencesLab = new JLabel("Consequences: ");
		consequences = new JComboBox(Controller.getConsequenceByPattern(pattern).toArray());
		
		Object c = problems.getSelectedItem();
        Problem p = (Problem)c;
        
		solution = new JLabel("Solution: " + p.getSolutionContext());
		
		problems.addItemListener(this);
		
		//Add components to Panels
		detailsPanel.add(name, BorderLayout.PAGE_START);
		detailsPanel.add(context, BorderLayout.CENTER);
		//detailsPanel.add(summaryLab);
		detailsPanel.add(summary, BorderLayout.PAGE_END);
		
		imagePanel.add(image, BorderLayout.CENTER);
		
		problemsPanel.add(problemsLab, BorderLayout.LINE_START);
		problemsPanel.add(problems, BorderLayout.AFTER_LAST_LINE);
		problemsPanel.add(solution, BorderLayout.SOUTH);
		
		consequencesPanel.add(consequencesLab, BorderLayout.LINE_START);
		consequencesPanel.add(consequences, BorderLayout.AFTER_LAST_LINE);
		
		abovePanel.add(detailsPanel, BorderLayout.WEST);
		abovePanel.add(imagePanel, BorderLayout.EAST);
		
		//Add Panels
		this.add(abovePanel, BorderLayout.NORTH);
		this.add(problemsPanel, BorderLayout.CENTER);
		this.add(consequencesPanel, BorderLayout.SOUTH);
	}
	
	 public void itemStateChanged(ItemEvent itemEvent) {
	        Object c = problems.getSelectedItem();
	        Problem p = (Problem)c;
	        solution.setText("Solution: " + p.getSolutionContext());
	 }
}
