package userInterface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
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
		
		Object c = contextSelect.getSelectedItem();
	    		
		selectPatternLabel = new JLabel("Select Pattern: ");
		selectPattern = new JComboBox(Controller.getPatternsByContext(c).toArray());
		selectPattern.addItemListener(this);
		
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
	        selectPattern.setModel(new DefaultComboBoxModel(Controller.getPatternsByContext(c).toArray()));
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
				this.dispose();
				new EditFrame();
			}
	  }
}

