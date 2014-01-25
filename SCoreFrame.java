
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SCoreFrame extends JFrame {

	private JPanel contentPane;
	
	private final JLabel lblBackground = new JLabel("background");
	private final JLabel textField = new JLabel();
	private final JButton btnNewButton = new JButton("");
	public String JDBC_DRIVER;
	public String DB_URL;
	public int levelNumber;
	Connection conn = null;
	final String USER = "root";
	final String PASS = "mysql";
	Statement stmt = null;
	private final JLabel label = new JLabel("");
	private final JLabel bg = new JLabel("");
	
	
	public SCoreFrame(int score,String name,int levelNum) {
		textField.setBounds(286, 144, 192, 64);
		Font f = new Font("Blod", Font.BOLD,24);
		textField.setFont(f);
		levelNumber=levelNum;
		initGUI(score,name,levelNum);
	}
	private void initGUI(final int score,final String name,int levelNum) {
		 levelNumber=levelNum;
		label.setIcon(new ImageIcon("Submit.gif"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textField.setText(score+"");
		contentPane.add(textField);
		JDBC_DRIVER = "com.mysql.jdbc.Driver";
		DB_URL = "jdbc:mysql://localhost/LightItUp_DB";
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = conn.createStatement();
					 String sql = "UPDATE Players " + 
			                   "SET TotalScore="+score+" WHERE Player_Name ="+"'"+name+"'";
					 stmt.executeUpdate(sql);
					  levelNumber++;
					  sql= "UPDATE Players " + 
			                   "SET PlayedLevels ="+levelNumber+" WHERE Player_Name ="+"'"+name+"'";
					 System.out.println(sql);
			      stmt.executeUpdate(sql);
			      
			      testFrame t=new testFrame(levelNumber+1, score, name); 
				}
			 catch (SQLException se) {

				se.printStackTrace();
			} 
				catch (Exception e1)
				{
				e1.printStackTrace();
				}
			}
		});
		label.setBounds(163, 240, 234, 75);
		
		contentPane.add(label);
		bg.setIcon(new ImageIcon("testit.png"));
		bg.setBounds(0, 0, 575, 346);
		
		contentPane.add(bg);
	}

}


