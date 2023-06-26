import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

public class TreePanel implements GUI {
	private static TreePanel panel;
    private JTree tree;
    private DefaultMutableTreeNode rootNode;
    
    private JPanel treePanel;

    //singelton so only one tree can exist 
    public static TreePanel panel() {
    	if (panel == null) {
    		panel = new TreePanel();
    	}
    	
    	return panel;
    }

    public TreePanel() {
    	
    }
    
    //intialize 
    public void initialize() {
        this.rootNode = new DefaultMutableTreeNode("Root Node");
        this.tree = new JTree(rootNode);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        this.treePanel = new JPanel();


        formatPanel();
    }
    
    //format the panel 
    public void formatPanel() {
        Border treeBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Tree View");

        treePanel.setBorder(treeBorder);
        treePanel.setPreferredSize(new Dimension(200, 400));
        
        treePanel.setLayout(new BorderLayout());
        treePanel.add(new JScrollPane(tree));
    }
    
    //retrieves the seleceted node in a tree 
    public DefaultMutableTreeNode getSelectedNode() {
        return (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
    }
    
    //adds a group to the tree 
    public void addGroupToTree(String groupName, DefaultMutableTreeNode parentNode) {
        DefaultMutableTreeNode groupNode = new DefaultMutableTreeNode(groupName);
        parentNode.add(groupNode);
        tree.updateUI(); // Refresh the tree model to reflect the changes
    }
    
    //adds a user to the tree 
    public void addUserToTree(String userName, DefaultMutableTreeNode parentNode) {
        DefaultMutableTreeNode userNode = new DefaultMutableTreeNode(userName);
        parentNode.add(userNode);
        tree.updateUI(); // Refresh the tree model to reflect the changes
    }
    
    //renders the tree 
    public JPanel render() {
    	initialize();
    	return this.treePanel;
    }
}
