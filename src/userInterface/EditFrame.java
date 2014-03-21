package userInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import domain.Controller;
import domain.Pattern;
import domain.Problem;

public class EditFrame extends MainFrame {

	JComboBox problems, consequences;;
	JTextField name, solution;
	JTextArea summary;
	JButton save, addProblem, removeProblem, addCon, removeCon,
			chooseImageButton;
	JLabel choosePattern, changeName, changeSummary, problemsLabel,
			changeSolution, consequencesLabel, chooserLabel;
	JFileChooser imageChooser;
	JPanel treePanel, editPanel;
	JTree tree;
	File file;

	public EditFrame() {
		super();

		treePanel = new JPanel();
		editPanel = new JPanel();

		// Define File Tree
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(
				"Select a Pattern");
		createNodes(top);
		tree = new JTree(top);

		JScrollPane treeView = new JScrollPane(tree);
		treeView.setPreferredSize(new Dimension(200, this.getHeight() - 100));

		JPanel namePanel = new JPanel();
		JPanel imagePanel = new JPanel();
		JPanel summaryPanel = new JPanel();
		JPanel problemPanel = new JPanel();
		JPanel solutionPanel = new JPanel();
		JPanel problemButtonPanel = new JPanel();
		JPanel conPanel = new JPanel();
		JPanel conButtonPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		treePanel.add(treeView);
		this.add(treePanel, BorderLayout.WEST);

		changeName = new JLabel("Change Name: ");
		changeSummary = new JLabel("Change Summary: ");
		problemsLabel = new JLabel("Choose Problem: ");
		changeSolution = new JLabel("Change Solution: ");
		consequencesLabel = new JLabel("Choose Consequence: ");

		name = new JTextField("Pattern Name", 20);

		summary = new JTextArea("Write new summary....", 5, 10);
		summary.setPreferredSize(new Dimension(600, 300));
		summary.setEditable(true);
		summary.setLineWrap(true);
		summary.setWrapStyleWord(true);
		JScrollPane summaryView = new JScrollPane(summary);
		summaryView.setPreferredSize(new Dimension(600, 200));

		problems = new JComboBox();
		solution = new JTextField("Solution", 20);
		consequences = new JComboBox();

		chooseImageButton = new JButton("Choose New Image");
		chooserLabel = new JLabel("No File Choosen");
		imageChooser = new JFileChooser();

		save = new JButton("Save Changes");
		addProblem = new JButton("Add New Problem");
		removeProblem = new JButton("Remove Selected Problem");
		addCon = new JButton("Add New Consequence");
		removeCon = new JButton("Add New Consequence");

		chooseImageButton.addActionListener(this);
		problems.addItemListener(this);
		save.addActionListener(this);
		addProblem.addActionListener(this);
		removeProblem.addActionListener(this);
		addCon.addActionListener(this);
		removeCon.addActionListener(this);

		// Where the tree is initialized, Only one node can be selected
		tree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addTreeSelectionListener(this);

		namePanel.add(changeName, BorderLayout.NORTH);
		namePanel.add(name, BorderLayout.SOUTH);

		imagePanel.add(chooseImageButton, BorderLayout.NORTH);
		imagePanel.add(chooserLabel, BorderLayout.SOUTH);

		summaryPanel.add(summaryView);

		problemPanel.add(problemsLabel, BorderLayout.NORTH);
		problemPanel.add(problems, BorderLayout.CENTER);

		solutionPanel.add(changeSolution);
		solutionPanel.add(solution);

		problemButtonPanel.add(addProblem);
		problemButtonPanel.add(removeProblem);

		conPanel.add(consequences);

		conButtonPanel.add(addCon);
		conButtonPanel.add(removeCon);

		buttonPanel.add(save);

		editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.Y_AXIS));
		editPanel.add(namePanel);
		//editPanel.add(imagePanel);
		editPanel.add(summaryPanel);
		editPanel.add(problemPanel);
		editPanel.add(solutionPanel);
		editPanel.add(problemButtonPanel);
		editPanel.add(conPanel);
		editPanel.add(conButtonPanel);
		editPanel.add(buttonPanel);

		this.add(editPanel, BorderLayout.CENTER);

	}

	public void itemStateChanged(ItemEvent itemEvent) {
		 Object c = problems.getSelectedItem();
		 Problem p = (Problem)c;
		 solution.setText(p.getSolutionContext());
	}

	// JTree event handler
	public void valueChanged(TreeSelectionEvent e) {
		// Returns the last path element of the selection.
		// This method is useful only when the selection model allows a single
		// selection.
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();

		if (node == null)
			// Nothing is selected.
			return;

		Object nodeInfo = node.getUserObject();
		if (node.isLeaf()) {
			Pattern pattern = (Pattern) nodeInfo;

			name.setText(pattern.getPatternName());
			summary.setText(pattern.getSummary());

			ArrayList<Problem> problemsList = new ArrayList<Problem>();
			problemsList = pattern.getProblems();
			problems.removeAllItems();

			for (Problem p : problemsList) {
				problems.addItem(p);
			}

			Object c = problems.getSelectedItem();
			Problem p2 = (Problem) c;
			solution.setText(p2.getSolutionContext());

			ArrayList<String> conList = new ArrayList<String>();
			conList = pattern.getConsequences();
			consequences.removeAllItems();

			for (String s : conList) {
				consequences.addItem(s);
			}
		}
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == selectorMenuItem) {
			this.dispose();
			new DetailFrame();
		}

		if (event.getSource() == editorMenuItem) {
			this.dispose();
			new EditFrame();
		}

		if (event.getSource() == chooseImageButton) {
			int returnVal = imageChooser.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = imageChooser.getSelectedFile();
				chooserLabel.setText("File Selected : " + file.getName());
			}
		}
		
		if (event.getSource() == save){
			String nameText = name.getText();
			String summaryText = summary.getText();
			Problem prob = (Problem) problems.getSelectedItem();
			String solutionText = solution.getText();
			
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			Object nodeInfo = node.getUserObject();
			Pattern pattern = (Pattern) nodeInfo;
			
			//if(file.equals(null)){
			//File image = file;
			//Controller.editPattern(pattern, nameText, image, summaryText, prob, solutionText);
			//}
			//else{
				Controller.editPattern(pattern, nameText, summaryText, prob, solutionText);
			//}
		}

	}
}
