import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.SQLException;
public class EmptyDBPlayMiniFrame extends JFrame {
	public java.sql.ResultSet res;
	public String JDBC_DRIVER;
	public String DB_URL;
	java.sql.Connection conn = null;
	java.sql.Statement stmt = null;
	private JPanel contentPane;
	private final JLabel background = new JLabel("");
	private final JLabel playtxt = new JLabel("");
	private final JTextField PlayerTxt = new JTextField();
	private final JLabel NewPlayer = new JLabel("");
	private final JLabel welcome = new JLabel("");
	Thread t;
	public EmptyDBPlayMiniFrame() {
		JDBC_DRIVER = "com.mysql.jdbc.Driver";
		DB_URL = "jdbc:mysql://localhost/LightItUp_DB";
		initGUI();
	}
	private void initGUI() {

		// Database credentials
		final String USER = "root";
		final String PASS = "mysql";
		conn = null;
		stmt = null;
		welcome.setVisible(false);
		PlayerTxt.setBounds(37, 108, 171, 49);
		PlayerTxt.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 410, 220);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		playtxt.setIcon(new ImageIcon("C:\\Users\\Essraa\\Desktop\\glitter\\final\\playtxt.gif"));
		playtxt.setBounds(0, 23, 410, 57);
		
		contentPane.add(playtxt);
		
		contentPane.add(PlayerTxt);
		NewPlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) { 

				String s=PlayerTxt.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = conn.createStatement();
					String sql = "INSERT INTO Players " + 
		                   "VALUES (0,'"+s+"', 1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)";
						stmt.executeUpdate(sql);
				} catch (SQLException | ClassNotFoundException e1) {
					Toolkit.getDefaultToolkit().beep();
					e1.printStackTrace();
				}finally{ 
				      //finally block used to close resources 
				      try{ 
				         if(stmt!=null) 
				            conn.close(); 
				      }catch(SQLException se){ 
				      }// do nothing 
				   }//end try 
				playtxt.setVisible(false);
				PlayerTxt.setVisible(false);
				NewPlayer.setVisible(false);
				welcome.setVisible(true);
				setVisible(false);//be mogarad das 3ala + yero7 2afel el msg
			}
			});   
		NewPlayer.setIcon(new ImageIcon("C:\\Users\\Essraa\\Desktop\\glitter\\final\\addS.png"));
		NewPlayer.setBounds(248, 100, 67, 57);
		contentPane.add(NewPlayer);
		welcome.setIcon(new ImageIcon("C:\\Users\\Essraa\\Desktop\\glitter\\final\\welcome.gif"));
		welcome.setBounds(85, 53, 253, 114);
		contentPane.add(welcome);
		background.setIcon(new ImageIcon("C:\\Users\\Essraa\\Desktop\\glitter\\final\\mini.png"));
		background.setBounds(0, 0, 410, 200);
		contentPane.add(background);
	}
}
