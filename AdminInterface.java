import java.util.List;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;

public interface AdminInterface {
	public void setAdminControlPanel(AdminControlPanel adminControlPanel);
	
	public Map<String, User> getUsers();
	
	void createUser();
	
	void incrementTotalUsers();
	
	int getTotalUsers();
	
	void createUserGroup(String groupName, DefaultMutableTreeNode selectedNode);
	
	void incrementTotalGroups();
	
	int getTotalGroups();
	
	public void addToTotalMessages();
	
	public int getTotalMessages();
	
	public List<String> getListPositiveWords();
	
	public void addToPositivity();
	
	public void calculatePositvityPercentage();
	
	public double getPositivityPercentage();
	
}
