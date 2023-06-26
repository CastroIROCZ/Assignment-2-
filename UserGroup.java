import java.util.ArrayList;
import java.util.List;

public class UserGroup extends User implements UserInterface{
	List <String> groupMembers; 
	private String groupID;
	
	//initializes the list 
	public UserGroup() {
		groupMembers = new ArrayList<String>();
	}
	
	//adds user to the group 
	public void addUserToGroup(String user) {
		groupMembers.add(user);
	}
	
	//retrieve list of users in group
	public List<String> getMembers() {
		return groupMembers;
	}
	
	//set the group name 
	public void setID(String groupID) {
		this.groupID = groupID;
	}
	
}
