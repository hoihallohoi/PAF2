package userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import domain.Controller;
import domain.Pattern;
import domain.Problem;

public class EditFrame extends MainFrame{
	
	JComboBox allPatterns, problems, consequences;;
	JTextField name, solution;
	JTextArea summary;
	JButton save, addProblem, removeProblem, addConsequence, removeConsequence, chooseImageButton;
	JLabel choosePattern, changeName, changeSummary, problemsLabel, changeSolution, consequencesLabel, chooserLabel;
	JFileChooser imageChooser;

	public EditFrame(){
		super();
		
		JLabel spacer1 = new JLabel("  ");
		JLabel spacer2 = new JLabel("  ");
		JLabel spacer3 = new JLabel("  ");
		JLabel spacer4 = new JLabel("  ");
		JLabel spacer5 = new JLabel("  ");
		
		choosePattern = new JLabel("Choose Pattern: ");
		changeName = new JLabel("Change Name: ");
		changeSummary = new JLabel("Change Summary: ");
		problemsLabel = new JLabel("Choose Problem: ");
		changeSolution = new JLabel("Change Solution: ");
		consequencesLabel = new JLabel("Choose Consequence: ");
		
		allPatterns = new JComboBox(Controller.getAllPatterns().toArray());
		Object c = allPatterns.getSelectedItem();
        Pattern p = (Pattern)c;
        
        name = new JTextField(p.getPatternName());
        summary = new JTextArea(p.getSummary());
        problems = new JComboBox(p.getProblems().toArray());
        Object o = problems.getSelectedItem();
        Problem problem = (Problem)o;
        solution = new JTextField(problem.getSolutionContext());
        consequences = new JComboBox(p.getConsequences().toArray());
        
        chooseImageButton = new JButton("Choose New Image");
        chooserLabel = new JLabel("No File Choosen");
        imageChooser = new JFileChooser();
        
        save = new JButton("Save Changes");
        
        chooseImageButton.addActionListener(this);
        
        add(choosePattern);
        add(allPatterns);
        add(spacer1);
        add(changeName);
        add(name);
        add(spacer2);
        add(chooseImageButton);
        add(chooserLabel);
        add(spacer5);
        add(changeSummary);
        add(summary);
        add(spacer3);
        add(problemsLabel);
        add(problems);
        add(changeSolution);
        add(solution);
        add(spacer4);
        add(consequencesLabel);
        add(consequences);
        add(save);
        
        allPatterns.addItemListener(this);
        problems.addItemListener(this);	
	}
	
	public void itemStateChanged(ItemEvent itemEvent) {
		Object o = allPatterns.getSelectedItem();
		Pattern pattern = (Pattern)o;
		name.setText(pattern.getPatternName());
		summary.setText(pattern.getSummary());
		problems.setModel(new DefaultComboBoxModel(pattern.getProblems().toArray()));
		consequences.setModel(new DefaultComboBoxModel(pattern.getConsequences().toArray()));
		
		
        Object c = problems.getSelectedItem();
        Problem p = (Problem)c;
        solution.setText(p.getSolutionContext());
 }
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == selectorMenuItem){
			this.dispose();
			new SelectorFrame();
		}
		
		if (event.getSource() == editorMenuItem){
			this.dispose();
			new EditFrame();
		}
		
		if (event.getSource() == chooseImageButton){
			int returnVal = imageChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
               java.io.File file = imageChooser.getSelectedFile();
               chooserLabel.setText("File Selected : "  + file.getName());
            }
		}

	}
}
