package userInterface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.Controller;

@SuppressWarnings("serial")
public class SelectorFrame extends MainFrame{
	
	JComboBox contextSelect, problem, selectPattern;
	JLabel contextSelectLabel, problemLabel, selectPatternLabel;
	JButton selectButton;

	public SelectorFrame(){
		super();
		
		JPanel firstSelection = new JPanel();
		JPanel secondSelection = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		contextSelectLabel = new JLabel("Select Scope/Purpose: ");
		contextSelect = new JComboBox(Controller.getAllContexts().toArray());
		contextSelect.addItemListener(this);
		
		Object c = contextSelect.getSelectedItem();
	    		
		selectPatternLabel = new JLabel("Select Pattern: ");
		selectPattern = new JComboBox(Controller.getPatternsByContext(c).toArray());
		selectPattern.addItemListener(this);
		
		selectButton = new JButton("Select Pattern");
		selectButton.addActionListener(this);
		
		//Add all the items to panels
		firstSelection.add(contextSelectLabel, BorderLayout.LINE_START);
		firstSelection.add(contextSelect, BorderLayout.CENTER);
		secondSelection.add(selectPatternLabel, BorderLayout.LINE_START);
		secondSelection.add(selectPattern, BorderLayout.CENTER);
		buttonPanel.add(selectButton, BorderLayout.CENTER);
		
		//Add Panels
		this.add(firstSelection, BorderLayout.NORTH);
		this.add(secondSelection, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
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

