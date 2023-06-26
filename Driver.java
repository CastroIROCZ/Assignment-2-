import javax.swing.SwingUtilities;

//driver code starts the entire program contains the main method 
public class Driver {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Admin.getAdmin().setAdminControlPanel(AdminControlPanel.getFrame());
				AdminControlPanel.getFrame().runAdmin();
				}
			});
		}
	}