
public class Visitor implements VisitorInterface {
    private int userCount = 0;
    private int groupCount = 0;

    public void visit(User user) {
        userCount++;
    }

    //visits group to keep track
    public void visit(UserGroup group) {
        groupCount++;
        for (Object member : group.getMembers()) {
            if (member instanceof User) {
                visit((User) member);
            } else if (member instanceof UserGroup) {
                visit((UserGroup) member);
            }
        }
    }
    
    //get the user count
    public int getUserCount() {
        return userCount;
    }

    //get group count 
    public int getGroupCount() {
        return groupCount;
    }
}