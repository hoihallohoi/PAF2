package userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import domain.Controller;

@SuppressWarnings("serial")
public class SelectorFrame extends MainFrame{
	
	JComboBox contextSelect, problem, selectPattern;
	JLabel contextSelectLabel, problemLabel, selectPatternLabel;
	JButton selectButton;

	public SelectorFrame(){
		super();
		
		contextSelectLabel = new JLabel("Select Scope/Purpose: ");
		contextSelect = new JComboBox(Controller.getAllContexts().toArray());
		contextSelect.addItemListener(this);
		
		selectPatternLabel = new JLabel("Select Pattern: ");
		selectPattern = new JComboBox();
		selectPattern.addItemListener(this);
		
		selectPatternLabel.setVisible(false);
		selectPattern.setVisible(false);
		
		selectButton = new JButton("Select Pattern");
		selectButton.addActionListener(this);
		
		//Add all the items
		this.add(contextSelectLabel);
		this.add(contextSelect);
		this.add(selectPatternLabel);
		this.add(selectPattern);
		this.add(selectButton);
	}
	
	  public void itemStateChanged(ItemEvent itemEvent) {
	        Object c = contextSelect.getSelectedItem();
	        DefaultComboBoxModel patterns = new DefaultComboBoxModel(Controller.getPatternsByContext(c).toArray());
	        selectPattern.setModel(patterns);
	        selectPatternLabel.setVisible(true);
	        selectPattern.setVisible(true);
	  }
	  
	  public void actionPerformed(ActionEvent event){
		  if (event.getSource() == selectButton){
			  Object pattern = selectPattern.getSelectedItem();
			  this.dispose();
			  new DetailFrame(pattern);
		  }
		  
		  //menubar
		  if (event.getSource() == selectorMenuItem){
				this.dispose();
				new SelectorFrame();
			}
			
			if (event.getSource() == editorMenuItem){
				//open editorFrame
				JOptionPane.showMessageDialog(this,"This feature is not yet implemented");
			}
	  }
}

