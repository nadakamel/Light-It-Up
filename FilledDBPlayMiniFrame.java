import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import com.jgoodies.forms.layout.FormLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class FilledDBPlayMiniFrame extends JFrame {

	private JPanel contentPane;
	public static int level=1;
	public static int Score=0;
	private JLabel []Levels;
	private ImagedPane imgList;
	private final JLabel BackGround = new JLabel("");
	private final JLabel newPlayer = new JLabel("");
	private final JLabel exisistingPlayer = new JLabel("");
	private final JLabel back = new JLabel("");
	String[] Players_Selectors = null;
	ResultSet rs = null;
	public java.sql.ResultSet res;
	public String JDBC_DRIVER;
	public String DB_URL;
	public static String player;
	java.sql.Connection conn = null;
	java.sql.Statement stmt = null;

	public FilledDBPlayMiniFrame(String [] names ) throws ClassNotFoundException, SQLException {
		// Database credentials
		Class.forName("com.mysql.jdbc.Driver");
		JDBC_DRIVER = "com.mysql.jdbc.Driver";
		DB_URL = "jdbc:mysql://localhost/LightItUp_DB";
		initGUI(names);
	}

	private void initGUI(final String [] names) {
		final String USER = "root";
		final String PASS = "mysql";
		conn = null;
		stmt = null;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 410, 220);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		newPlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false); // you can't see me!
				dispose(); // Destroy the JFrame object
				EmptyDBPlayMiniFrame m = new EmptyDBPlayMiniFrame();
				m.setVisible(true);
			}
		});
		newPlayer.setIcon(new ImageIcon(
				"C:\\Users\\Essraa\\Desktop\\glitter\\final\\newPlayer.gif"));
		newPlayer.setBounds(92, 23, 280, 60);
		contentPane.add(newPlayer);
		
		
		exisistingPlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				BackGround.setVisible(false);
				newPlayer.setVisible(false);
				exisistingPlayer .setVisible(false);/////////////////////////////////////////////////////////////////////////////////
				setBounds(700, 300, 534, 420);
				imgList.setVisible(true);
				
			     imgList.list.addMouseListener(new MouseAdapter() {
			        	@Override
			        	public void mouseClicked(MouseEvent arg0) {
			        		try {
			        			Class.forName("com.mysql.jdbc.Driver");
								conn = DriverManager.getConnection(DB_URL, USER, PASS);
								stmt = conn.createStatement();
							} catch (SQLException | ClassNotFoundException e) {
								e.printStackTrace();
							} 
			        		finally{
								ResultSet rs,rs2;
								player=imgList.list.getSelectedValue().toString();
				        		System.out.print(player);
				        		
								try {
									rs = stmt
											.executeQuery("SELECT * From Players");
									rs2=stmt.executeQuery("Select PlayedLevels From Players " +
											"where Player_Name="+"'"+player+"'");
									int count=0;
									int Playedlevels = 0;
									while(rs2.next())
									{
										Playedlevels=rs2.getInt("PlayedLevels");
									}
									
									
									
									setBounds(700, 300, 410, 220);
									imgList.setVisible(false);
									Levels=new JLabel[Playedlevels];
									for(int i=0;i<Playedlevels;i++)
									{
										if(i==0)
										{
										Levels[i]=new JLabel("");
										Levels[i].setBounds(0, 0, 50, 60);							
										Levels[i].setIcon(new ImageIcon("C:\\Users\\Essraa\\Desktop\\glitter\\final\\1.GIF"));
										Levels[i].setVisible(true);
										contentPane.add(Levels[i]);
										Levels[i].addMouseListener(new MouseAdapter() {
											public void mouseClicked(MouseEvent arg0) {
												
												try {
													int levels=Levels.length;
													testFrame t=new testFrame(1, Score, player);
													t.setVisible(true);
													setVisible(false);
												} catch (IOException e) {
													e.printStackTrace();
												}
											System.out.print("level");
											}
										});
								
										

										}
										else if(i==1)
										{
											Levels[i]=new JLabel("");
											Levels[i].setBounds(50, 0, 50, 60);							
											Levels[i].setIcon(new ImageIcon("C:\\Users\\Essraa\\Desktop\\glitter\\final\\2.GIF"));
											Levels[i].setVisible(true);
											contentPane.add(Levels[i]);
											Levels[i].addMouseListener(new MouseAdapter() {
												public void mouseClicked(MouseEvent arg0) {
													
													try {
														int levels=Levels.length;
														testFrame t=new testFrame(2, Score, player);
														t.setVisible(true);
														setVisible(false);
													} catch (IOException e) {
														e.printStackTrace();
													}
												System.out.print("level");
												}
											});
									
											
											
										}
											else if(i==2)
											{
												Levels[i]=new JLabel("");
												Levels[i].setBounds(150, 0, 50, 60);							
												Levels[i].setVisible(true);
												Levels[i].setIcon(new ImageIcon("C:\\Users\\Essraa\\Desktop\\glitter\\final\\3.gif"));
												contentPane.add(Levels[i]);
												Levels[i].addMouseListener(new MouseAdapter() {
													public void mouseClicked(MouseEvent arg0) {
														
														try {
															int levels=Levels.length;
															testFrame t=new testFrame(3, Score, player);
															t.setVisible(true);
															setVisible(false);
														} catch (IOException e) {
															e.printStackTrace();
														}
													System.out.print("level");
													}
												});
										
											}
												else if(i==3)
												{
													Levels[i]=new JLabel("");
													Levels[i].setBounds(0,50, 50, 60);							
													Levels[i].setVisible(true);
													Levels[i].setIcon(new ImageIcon("C:\\Users\\Essraa\\Desktop\\glitter\\final\\4.GIF"));
													contentPane.add(Levels[i]);
													Levels[i].addMouseListener(new MouseAdapter() {
														public void mouseClicked(MouseEvent arg0) {
															
															try {
																int levels=Levels.length;
																testFrame t=new testFrame(4, Score, player);
																t.setVisible(true);
																setVisible(false);
															} catch (IOException e) {
																e.printStackTrace();
															}
														System.out.print("level");
														}
													});
											
												}
													else if(i==4)
													{
														Levels[i]=new JLabel("5");
														Levels[i].setBounds(50, 50, 50, 60);							
														Levels[i].setVisible(true);
														//Levels[i].setIcon(new ImageIcon("C:\\Users\\Essraa\\Desktop\\glitter\\final\\5.GIF"));
														contentPane.add(Levels[i]);
														Levels[i].addMouseListener(new MouseAdapter() {
															public void mouseClicked(MouseEvent arg0) {
																
																try {
																	int levels=Levels.length;
																	testFrame t=new testFrame(5, Score, player);
																	t.setVisible(true);
																	setVisible(false);
																} catch (IOException e) {
																	e.printStackTrace();
																}
															System.out.print("level");
															}
														});
												
													}
													else if(i==5)
													{
														Levels[i]=new JLabel("6");
														Levels[i].setBounds(100, 50, 50, 60);							
														Levels[i].setVisible(true);
														//Levels[i].setIcon(new ImageIcon("C:\\Users\\Essraa\\Desktop\\glitter\\final\\5.GIF"));
														contentPane.add(Levels[i]);
														Levels[i].addMouseListener(new MouseAdapter() {
															public void mouseClicked(MouseEvent arg0) {
																
																try {
																	int levels=Levels.length;
																	testFrame t=new testFrame(6, Score, player);
																	t.setVisible(true);
																	setVisible(false);
																} catch (IOException e) {
																	e.printStackTrace();
																}
															System.out.print("level");
															}
														});
												
													}
													else if(i==6)
													{
														Levels[i]=new JLabel("7");
														Levels[i].setBounds(0, 150, 50, 60);							
														Levels[i].setVisible(true);
														//Levels[i].setIcon(new ImageIcon("C:\\Users\\Essraa\\Desktop\\glitter\\final\\5.GIF"));
														contentPane.add(Levels[i]);
														Levels[i].addMouseListener(new MouseAdapter() {
															public void mouseClicked(MouseEvent arg0) {
																
																try {
																	int levels=Levels.length;
																	testFrame t=new testFrame(7, Score, player);
																	t.setVisible(true);
																	setVisible(false);
																} catch (IOException e) {
																	e.printStackTrace();
																}
															System.out.print("level");
															}
														});
												
													}
									} 
								} catch (SQLException e4) {
								
									e4.printStackTrace();
								}
								
			        		setVisible(true);
			        
			        		}
			        		
			        	}
			        });
				back.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent arg0) {
						newPlayer.setVisible(true);
						exisistingPlayer .setVisible(true);
						setBounds(700, 300, 410, 220);
		        	}
		        });
			}
		});
		
		back.setIcon(new ImageIcon("C:\\Users\\Essraa\\Desktop\\glitter\\final\\left.png"));
		back.setBounds(0, 300, 75, 75);
		contentPane.add(back);
		exisistingPlayer
				.setIcon(new ImageIcon(
						"C:\\Users\\Essraa\\Desktop\\glitter\\final\\exsistingPlayer.gif"));
		exisistingPlayer.setBounds(55, 107, 280, 60);

		contentPane.add(exisistingPlayer);
		
		
		
		BackGround.setIcon(new ImageIcon(
				"C:\\Users\\Essraa\\Desktop\\glitter\\final\\mini.png"));
		BackGround.setBounds(0, 0, 410, 200);

		contentPane.add(BackGround);
		
		imgList=new ImagedPane(names);
		imgList.setBounds(0, 0, 534, 420);
		imgList.setVisible(false);
		contentPane.add(imgList);
	}
}
