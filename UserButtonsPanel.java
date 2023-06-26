import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;

public class UserButtonsPanel implements GUI {
	private static UserButtonsPanel panel; 
	
    private JTextArea userID;
    private JTextArea userGroup;
    private JButton addUser;
    private JButton addGroup;
    private JButton userView;
    
    private JPanel userPanel;
    
    //singleton so only one user button panel is avaliable 
    public static UserButtonsPanel panel() {
    	if (panel == null) {
    		panel = new UserButtonsPanel();
    	}
    	
    	return panel;
    }

    public UserButtonsPanel() {
    	
    }

    //initialize 
    public void initialize() {	
        this.userID = new JTextArea();
        this.addUser = new JButton("Add User");
        this.userGroup = new JTextArea();
        this.addGroup = new JButton("Add Group");
        this.userView = new JButton("Show User View");
        
        this.userPanel = new JPanel();
        
        formatPanel();
    }
    
    //formats all the buttons and text areas neatly 
    public void formatPanel() {
        Border userBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN), "User");
        userPanel.setBorder(userBorder);
        
        userPanel.setLayout(new GridLayout(3, 2));
        userPanel.add(new JScrollPane(userID));
        userPanel.add(addUser);
        userPanel.add(new JScrollPane(userGroup));
        userPanel.add(addGroup);
        userPanel.add(userView, BorderLayout.CENTER);
        
        setUpButtonActions();

    }
    
    //retrieve user id
    public JTextArea getUserID() {
        return userID;
    }

    //retrieve add user button
    public JButton getAddUserButton() {
        return addUser;
    }

    //retrieve user group 
    public JTextArea getUserGroup() {
        return userGroup;
    }

    //retrieve add group button
    public JButton getAddGroupButton() {
        return addGroup;
    }

    //retrieve get user view button
    public JButton getUserViewButton() {
        return userView;
    }
    
    //shows message for when a message pop up is needed 
    public void showMessage(String message) {
        AdminControlPanel.getFrame().showMessage(message);
    }
    
    //gets the node that is selected so that a user or group may be added under it 
    public DefaultMutableTreeNode getSelectedNode() {
    	return TreePanel.panel().getSelectedNode();
    	
    }

    //sets up all the button actions 
    public void setUpButtonActions() {
        getAddUserButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userID = getUserID().getText();
                DefaultMutableTreeNode selectedNode = getSelectedNode();

                if (selectedNode != null) {
                	User user = new User();
                    Admin.getAdmin().createUser(userID, user, selectedNode);
                    getUserID().setText("");
                    
                } else {
                    showMessage("Please select a parent node.");
                }
            }
        });

        getAddGroupButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String groupName = getUserGroup().getText();
                DefaultMutableTreeNode selectedNode = getSelectedNode();

                if (selectedNode != null) {
                    Admin.getAdmin().createUserGroup(groupName, selectedNode);
                    getUserGroup().setText("");
                } else {
                    showMessage("Please select a parent node.");
                }
            }
        });
        
        getUserViewButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode selectedNode = getSelectedNode();

                if (selectedNode != null) {
                    String nodeName = selectedNode.getUserObject().toString();
                    if (Admin.getAdmin().getUsers().containsKey(nodeName)) {
                    	Admin.getAdmin().getUsers().get(nodeName).openUser(nodeName, Admin.getAdmin().getUsers().get(nodeName));
                    }
                    else {
                    	User user = new User();
                    	user.openUser(nodeName, user);
                    }
                    
                } else {
                    showMessage("Please select a node.");
                }
            }
        });
        
    }
    
    //renders the panel 
    public JPanel render() {
    	initialize();
    	return userPanel;
    }
    
}
