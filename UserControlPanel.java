import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class UserControlPanel {
	private User user;
	private String name;
	
	private JFrame userFrame;
	
	private JTextArea userID; 
	private JButton follow;
	
	private JTextArea following;
	
	private JTextArea tweet;
	private JButton postTweet;
	
	private JTextArea posts;
	
	private JPanel upperPanel;
	private JPanel followingPanel;
	private JPanel tweetingPanel;
	private JPanel postsPanel;
	
	private JPanel containerPanel;

	//initialize the user control panel
	public void initializeUI(String userName, User user) {
		this.user = user;
		this.name = userName;
		userFrame = new JFrame(userName);
		userFrame.setSize(400, 300);
		userFrame.setVisible(true);
		
		this.userID = new JTextArea();
		this.follow = new JButton("Follow");
		
		this.following = new JTextArea();
		this.following.setPreferredSize(new Dimension(175, 350));
		this.following.setEditable(false);
		
		this.tweet = new JTextArea();
		this.postTweet = new JButton("Post");
		
		this.posts = new JTextArea();
		this.posts.setPreferredSize(new Dimension(275, 325));
		this.posts.setEditable(false);
		
		this.upperPanel = new JPanel();
		this.followingPanel = new JPanel();
		this.followingPanel.setPreferredSize(new Dimension(200, 300));
		
		this.tweetingPanel = new JPanel();
		this.postsPanel = new JPanel();
		
		this.containerPanel = new JPanel();
        containerPanel.setPreferredSize(new Dimension(300, 400));

		
		renderWindow();
	}
	
	//renders the window with all panels added 
	private void renderWindow() {
        Border followingBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Live View (Current Following)");
        Border upperPanelBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN), "Follow Users");
        Border tweetingPanelBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Tweet a message");
        Border postsPanelBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.YELLOW), "Live View (News Feed)");
        
		upperPanel.setLayout((new GridLayout(1, 2)));
		upperPanel.add(new JScrollPane(userID));
		upperPanel.add(follow);
		upperPanel.setBorder(upperPanelBorder);
		
		followingPanel.setLayout(new BorderLayout());
		followingPanel.add(new JScrollPane(following));
		followingPanel.setBorder(followingBorder);
		
		tweetingPanel.setLayout((new GridLayout(1, 2)));
		tweetingPanel.add(new JScrollPane(tweet));
		tweetingPanel.add(postTweet);
		tweetingPanel.setBorder(tweetingPanelBorder);
		
		postsPanel.add(new JScrollPane(posts));
		postsPanel.setBorder(postsPanelBorder);
		
        userFrame.setLayout(new BorderLayout());
        
        containerPanel.setLayout(new BorderLayout());
        
        containerPanel.add(upperPanel, BorderLayout.NORTH);
        containerPanel.add(tweetingPanel, BorderLayout.SOUTH);
        containerPanel.add(postsPanel, BorderLayout.CENTER);
        
        userFrame.add(followingPanel, BorderLayout.WEST);
        userFrame.add(containerPanel, BorderLayout.CENTER);
        
        setUpButtons();
        userFrame.pack();
        userFrame.setVisible(true);

	}
	
	//get user ID 
	public JTextArea getUserID() {
		return this.userID;
	}
	
	//get follow button
	public JButton getFollowButton() {
		return this.follow;
	}
	
	//get the text in tweet 
	public JTextArea getTweet() {
		return this.tweet;
	}
	
	//get post tweet button
	public JButton getPostTweetButton() {
		return this.postTweet;
	}
	
	//upadates the following tree 
	public void updateFollowingTree(String userID) {
		following.append(userID + "\n");
	}
	
	//updates the panel where posts are displayed 
	public void updatePostsPanel(String userID, String tweet) {
		posts.append(userID + ": " + tweet + "\n");
	}
	
	//sets up button actions 
	public void setUpButtons() {
		getFollowButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userID = getUserID().getText();
				//User userFollowed = new User();
				//System.out.println(userID);
				if ((user.followUser(userID) == true) && (userID != name)) {
					updateFollowingTree(userID);
					user.followUser(userID);
					getUserID().setText("");
				}
			}
		});
		
		getPostTweetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = getTweet().getText();
				user.postTweet(message);
				getTweet().setText("");
			}
		});
		
	}
}
