package userInterface;

import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class SelectorFrame extends MainFrame{
	
	JComboBox scope, problem, pattern;

	public SelectorFrame(){
		super();
		
		scope = new JComboBox();
		this.add(scope);
		
		problem = new JComboBox();
		this.add(scope);
		
		pattern = new JComboBox();
		this.add(pattern);
	}
	
	public void actionPerformed(ActionEvent event) {
		
		
		//menubar actions
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

