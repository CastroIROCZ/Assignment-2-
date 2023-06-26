import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;

public class Admin {
    private static Admin admin;
    private Map<String, User> users;
    private List<String> groups;
    private List<String> positiveWords;
    private double positivityPercentage;
    private int totalUsers;
    private int totalGroups;
    private int totalMessages;
    private int totalPositivity;
    private AdminControlPanel controlPanel;

    //singelton so only one admin is allowed to exist 
    public static Admin getAdmin() {
        if (admin == null) {
            admin = new Admin();
        }
        return admin;
    }

    //initialize all the admin variables 
    private Admin() {
        this.users = new HashMap<>();
        this.groups = new ArrayList<>();
        this.positiveWords = new ArrayList<>();
        this.positiveWords.add("Love");
        this.positiveWords.add("Good");
        this.positiveWords.add("Happy");
        this.positiveWords.add("Awesome");
    }

    //sets the admin control panel to the only admin control panel 
    public void setAdminControlPanel(AdminControlPanel adminControlPanel) {
        this.controlPanel = adminControlPanel;
    }

    //creates a user and sends the name the object and the node 
    public void createUser(String userName, User userObject, DefaultMutableTreeNode selectedNode) {
        users.put(userName, userObject);
        TreePanel.panel().addUserToTree(userName, selectedNode);
        incrementTotalUsers();
    }
   
    //retrieve list of existing users 
    public Map<String, User> getUsers() {
    	return this.users;
    }

    //increment total users by 1 
    public void incrementTotalUsers() {
        this.totalUsers += 1;
    }

    //retrieve total users 
    public int getTotalUsers() {
        return totalUsers;
    }

    //creates a user group 
    public void createUserGroup(String groupName, DefaultMutableTreeNode selectedNode) {
        this.groups.add(groupName);
        TreePanel.panel().addGroupToTree(groupName, selectedNode);
        incrementTotalGroups();
    }

    //increment total groups by 1 
    public void incrementTotalGroups() {
        this.totalGroups += 1;
    }

    //retrieve total groups 
    public int getTotalGroups() {
        return totalGroups;
    }
    
    //gets the list of existing groups 
    public List<String> getGroups() {
    	return groups;
    }
    
    //increments total messages by 1 
    public void addToTotalMessages() {
    	this.totalMessages += 1;
    }
    
    //retrieves total messages 
    public int getTotalMessages() {
    	return this.totalMessages;
    }
    
    
    //retrieve list of positive words 
    public List<String> getListPositiveWords() {
    	return positiveWords;
    }
    
    //adds to total positive words 
    public void addToPositivity() {
    	this.totalPositivity += 1;
    	calculatePositvityPercentage();
    }
    
    //calculate the total positivy percentage 
    public void calculatePositvityPercentage() {
        positivityPercentage = ((double) totalPositivity / totalMessages) * 100;
    }
    
    //retrieve total positvity percentage 
    public double getPositivityPercentage() {
    	return positivityPercentage;
    }
    
    
}
