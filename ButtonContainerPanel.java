import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class ButtonContainerPanel {
	private static ButtonContainerPanel panel;
	
    private JPanel containerPanel;

    //singleton so only one container can exist 
    public static ButtonContainerPanel panel() {
    	if (panel == null) {
    		panel = new ButtonContainerPanel();
    	}
    	
    	return panel;
    }
    

    public ButtonContainerPanel() {
    	
    }
    
    //initialize 
    public void initialize() {
        this.containerPanel = new JPanel();

        formatPanel();
    }
    
    //format the panel 
    public void formatPanel() {
        containerPanel.setLayout(new BorderLayout());
        containerPanel.setPreferredSize(new Dimension(300, 400));
        
        containerPanel.add(UserButtonsPanel.panel().render(), BorderLayout.NORTH);
        containerPanel.add(AnalysisButtonPanel.panel().render(), BorderLayout.SOUTH);

    }
    
    //render the panel 
    public JPanel render() {
    	initialize();
    	return this.containerPanel;
    }
}
