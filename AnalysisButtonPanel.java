import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class AnalysisButtonPanel implements GUI {
	private static AnalysisButtonPanel panel;
    private JButton showUserTotal;
    private JButton showGroupTotal;
    private JButton showMessagesTotal;
    private JButton showPositivePercentage;
    private JPanel analysisPanel;
    
    //singleton so only one analysis panel exists 
    public static AnalysisButtonPanel panel() {
    	if (panel == null) {
    		panel = new AnalysisButtonPanel();
    	}
    	
    	return panel;
    }

    public AnalysisButtonPanel() {
    	
    }

    //initialize the panel 
    public void initialize() {
        this.showUserTotal = new JButton("Total Users");
        this.showGroupTotal = new JButton("Total Groups");
        this.showMessagesTotal = new JButton("Total Messages");
        this.showPositivePercentage = new JButton("Total Positivity");
        
        this.analysisPanel = new JPanel();
        
        formatPanel();
    }
    
    //format the panel 
    public void formatPanel() {
        Border analysisBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Analysis");
        analysisPanel.setBorder(analysisBorder);

        analysisPanel.setLayout(new GridLayout(2, 2));
        analysisPanel.add(showUserTotal);
        analysisPanel.add(showGroupTotal);
        analysisPanel.add(showMessagesTotal);
        analysisPanel.add(showPositivePercentage);
        
        setUpButtonActions();     
    }
    
    //get the show total users button
    public JButton getShowTotalUsersButton() {
        return showUserTotal;
    }

    //get the show total groups button 
    public JButton getShowTotalGroupsButton() {
        return showGroupTotal;
    }

    //get the show total messages button
    public JButton getShowMessagesTotalButton() {
        return showMessagesTotal;
    }

    //get the show positive percentage button 
    public JButton getShowPositivePercentageButton() {
        return showPositivePercentage;
    }
    
    //set up the button actions 
    public void setUpButtonActions() {
        getShowTotalUsersButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int totalUsers = Admin.getAdmin().getTotalUsers();
                AdminControlPanel.getFrame().showMessage("Total Users: " + totalUsers);
            }
        });

        getShowTotalGroupsButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int totalGroups = Admin.getAdmin().getTotalGroups();
                AdminControlPanel.getFrame().showMessage("Total Groups: " + totalGroups);
            }
        });

        getShowMessagesTotalButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int totalMessages = Admin.getAdmin().getTotalMessages();
                AdminControlPanel.getFrame().showMessage("Total Messages: " + totalMessages);
            }
        });

        getShowPositivePercentageButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double positivePercentage = Admin.getAdmin().getPositivityPercentage();
                AdminControlPanel.getFrame().showMessage("Positive Percentage: " + positivePercentage + "%");
            }
        });
    }
    
    //render the panel 
    public JPanel render() {
    	initialize();
    	return this.analysisPanel;
    }
}
