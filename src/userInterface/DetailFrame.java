package userInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import domain.Context;
import domain.ContextComponent;
import domain.Controller;
import domain.Pattern;
import domain.Problem;

public class DetailFrame extends MainFrame{
	
	JLabel image, solution, consequencesLab, problemsLab, summaryLab, name, context;;
	JComboBox problems, consequences;
	JTextArea summary;
	JTree tree;
	JPanel treePanel, patternPanel;
	//JTextField name, context;
	
	public DetailFrame(){
		super();
		
		//Define all JPanels
		treePanel = new JPanel();
		patternPanel = new JPanel();
		
		JPanel abovePanel = new JPanel();
		JPanel detailsPanel = new JPanel();
		JPanel imagePanel = new JPanel();
		
		JPanel otherDetailPanel = new JPanel();
		
		JPanel problemsPanel = new JPanel();
		JPanel consequencesPanel = new JPanel();
		
		//Define File Tree
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Select a Pattern");
		createNodes(top);
		tree = new JTree(top);
		
		JScrollPane treeView = new JScrollPane(tree);
		treeView.setPreferredSize(new Dimension(200, this.getHeight()-100));
		
		//Define Labels
		name = new JLabel("Pattern Name");
		image = new JLabel("image");
		context = new JLabel("Pattern Contexts");
		summaryLab = new JLabel("Summary: ");
		
		//Define summary TextArea
		summary = new JTextArea("Summary", 5, 10);
		summary.setPreferredSize(new Dimension(600, 300));
		summary.setEditable(false);
		summary.setLineWrap(true);
		summary.setWrapStyleWord(true);
		JScrollPane summaryView = new JScrollPane(summary);
		summaryView.setPreferredSize(new Dimension(600, 300));
		
		problemsLab = new JLabel("Problems: ");
		problems = new JComboBox();
		consequencesLab = new JLabel("Consequences: ");
		consequences = new JComboBox();
        
		solution = new JLabel("Solution: ");
		
		problems.addItemListener(this);
		
		treePanel.add(treeView);
		patternPanel.setPreferredSize(new Dimension(this.getWidth() - 200, this.getHeight()));
		
		detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
		
		detailsPanel.add(name);
		detailsPanel.add(context);
		detailsPanel.add(summaryView);
		
		imagePanel.add(image, BorderLayout.EAST);
		imagePanel.setPreferredSize(new Dimension(400, 400));
		
		problemsPanel.add(problemsLab);
		problemsPanel.add(problems);
		problemsPanel.add(solution);
		
		consequencesPanel.add(consequencesLab, BorderLayout.LINE_START);
		consequencesPanel.add(consequences, BorderLayout.AFTER_LAST_LINE);
		
		abovePanel.add(detailsPanel, BorderLayout.WEST);
		abovePanel.add(imagePanel, BorderLayout.EAST);
		
		otherDetailPanel.setLayout(new BoxLayout(otherDetailPanel, BoxLayout.Y_AXIS));
		
		otherDetailPanel.add(problemsPanel, BorderLayout.NORTH);
		otherDetailPanel.add(consequencesPanel, BorderLayout.SOUTH);
		
		patternPanel.add(abovePanel, BorderLayout.NORTH);
		patternPanel.add(otherDetailPanel, BorderLayout.CENTER);
		
		this.add(treePanel, BorderLayout.WEST);
		this.add(patternPanel, BorderLayout.CENTER);
		
		//Where the tree is initialized, Only one node can be selected
	    tree.getSelectionModel().setSelectionMode
	            (TreeSelectionModel.SINGLE_TREE_SELECTION);

	    
	    tree.addTreeSelectionListener(this);
	}
	
	// Event handler for JComboBox
	 public void itemStateChanged(ItemEvent itemEvent) {
		 if(problems.getSelectedItem() != null){
	        Object c = problems.getSelectedItem();
	        Problem p = (Problem)c;
	        solution.setText("Solution: " + p.getSolutionContext());
		 }
		 else{
			 solution.setText("Solution: ");
		 }
	 }
	 
	 //JTree event handler
	 public void valueChanged(TreeSelectionEvent e) {
		//Returns the last path element of the selection.
		//This method is useful only when the selection model allows a single selection.
		    DefaultMutableTreeNode node = (DefaultMutableTreeNode)
		                       tree.getLastSelectedPathComponent();

		    if (node == null)
		    //Nothing is selected.     
		    return;

		    Object nodeInfo = node.getUserObject();
		    if (node.isLeaf()) {
		        Pattern pattern = (Pattern)nodeInfo;
		        
		        name.setText(pattern.getPatternName());
		        context.setText(Controller.getContextByPattern(pattern).toString());
		        image.setIcon(new ImageIcon(pattern.getImage()));
		        image.setText("");
		        summary.setText(pattern.getSummary());
		        
		        ArrayList<Problem> problemsList = new ArrayList<Problem>();
		        problemsList = pattern.getProblems();
		        problems.removeAllItems();
		        
		        for (Problem p: problemsList){
		        	problems.addItem(p);
		        }
		        
		        Object c = problems.getSelectedItem();
		        Problem p2 = (Problem)c;
		        solution.setText("Solution: " + p2.getSolutionContext());
		        
		        ArrayList<String> conList = new ArrayList<String>();
		        conList = pattern.getConsequences();
		        consequences.removeAllItems();
		        
		        for (String s: conList){
		        	consequences.addItem(s);
		        }
		    }
		}
}
