package userInterface;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import domain.Context;
import domain.ContextComponent;
import domain.Controller;
import domain.Pattern;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener, ItemListener, TreeSelectionListener {

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
			new DetailFrame();
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

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	protected void createNodes(DefaultMutableTreeNode top){
		 DefaultMutableTreeNode category = null;
		 DefaultMutableTreeNode subContext = null;
		 DefaultMutableTreeNode pattern = null;
		 
		 ArrayList<Context> contexts = new ArrayList<Context>();
		 contexts = Controller.getAllContexts();
		 for(Context c : contexts){
			 category = new DefaultMutableTreeNode(c);
			 top.add(category);
			 for (ContextComponent c2 : c.getChildContexts()){
			 	subContext = new DefaultMutableTreeNode(c2);
			 	category.add(subContext);
			 	for( Pattern p : c2.getPatterns()){
			 		pattern = new DefaultMutableTreeNode(p);
			 		subContext.add(pattern);
			 	}
			 }
		 }
	 }
	
}
