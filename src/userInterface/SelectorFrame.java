package userInterface;

import java.awt.event.ItemEvent;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import domain.Controller;

@SuppressWarnings("serial")
public class SelectorFrame extends MainFrame{
	
	JComboBox contextSelect, problem, selectPattern;
	JLabel contextSelectLabel, problemLabel, selectPatternLabel;

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
		
		//Add all the items
		this.add(contextSelectLabel);
		this.add(contextSelect);
		this.add(selectPatternLabel);
		this.add(selectPattern);
	}
	
	  public void itemStateChanged(ItemEvent itemEvent) {
	        //int state = itemEvent.getStateChange();
	        Object c = contextSelect.getSelectedItem();
	        DefaultComboBoxModel patterns = new DefaultComboBoxModel(Controller.getPatternsByContext(c).toArray());
	        selectPattern.setModel(patterns);
	        selectPatternLabel.setVisible(true);
	        selectPattern.setVisible(true);
	        
	  }
}

