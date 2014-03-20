package userInterface;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener, ItemListener {

	JMenuBar menuBar;
	JMenu selectorMenu;
	JMenu editorMenu;
	JMenuItem selectorMenuItem;
	JMenuItem editorMenuItem;
	@SuppressWarnings("serial")
	public MainFrame() {
		setLayout(new BorderLayout());
		setTitle("Patternized");

		// menubar
		menuBar = new JMenuBar();
		selectorMenu = new JMenu("Selector");
		editorMenu = new JMenu("Editor");
		selectorMenuItem = new JMenuItem("Search Patterns");
		editorMenuItem = new JMenuItem("Edit Patterns");
		
		menuBar.add(selectorMenu);
		menuBar.add(editorMenu);
		selectorMenu.add(selectorMenuItem);
		editorMenu.add(editorMenuItem);
		
		setJMenuBar(menuBar);

		selectorMenuItem.addActionListener(this);
		editorMenuItem.addActionListener(this);
		
		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = ((int) tk.getScreenSize().getHeight());  
		setSize(xSize,ySize-30);  
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == selectorMenuItem){
			this.dispose();
			new SelectorFrame();
		}
		
		if (event.getSource() == editorMenuItem){
			this.dispose();
			new EditFrame();
		}

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
