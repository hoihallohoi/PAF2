package userInterface;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener {

	JMenuBar menuBar;
	JMenu selectorMenu;
	JMenu editorMenu;
	JMenuItem selectorMenuItem;
	JMenuItem editorMenuItem;
	@SuppressWarnings("serial")
	public MainFrame() {
		setLayout(new FlowLayout());
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
		
		setSize(400, 400);
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
			//open editorFrame
			JOptionPane.showMessageDialog(this,"This feature is not yet implemented");
		}

	}
}
