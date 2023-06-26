import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AdminControlPanel {
    private static AdminControlPanel adminPanel;

    private JFrame adminControl;

    //singleton to allow for only one control panel 
    public static AdminControlPanel getFrame() {
        if (adminPanel == null) {
            adminPanel = new AdminControlPanel();
        }

        return adminPanel;
    }

    //name the frame 
    public AdminControlPanel() {
        this.adminControl = new JFrame("Admin Control Panel");

    }

    //initialize the frame and layout 
    private void initializeGUI() {
        adminControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminControl.setLayout(new BorderLayout());
        
        adminControl.add(TreePanel.panel().render(), BorderLayout.WEST);
        adminControl.add(ButtonContainerPanel.panel().render(), BorderLayout.CENTER);

        adminControl.pack();
        adminControl.setVisible(true);

    }

    //runs the control panel
    public void runAdmin() {
        initializeGUI();
        adminControl.setVisible(true);
    }
    
    //show message for when a pop up message is needed 
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(adminControl, message);
    }

}
