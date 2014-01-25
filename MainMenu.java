import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Window.Type;

public class MainMenu extends JFrame {
        private JPanel contentPane;
        private final JLabel MainLabel = new JLabel("");
        private final JLabel lblPlay = new JLabel("");
        private final JLabel lblBackground = new JLabel("background");
        private final JLabel options = new JLabel("");
        private final JLabel about = new JLabel("");
        private final JLabel highScore = new JLabel("");
        private final JLabel HowToPlay = new JLabel("");
        private final JLabel quit = new JLabel("");
        private final JLabel soundBtn = new JLabel("");
        private final JLabel MusicBtn = new JLabel("");
        private final JLabel back = new JLabel("");
        public boolean Beep = false;
        public String JDBC_DRIVER;
        public String DB_URL;
        Connection conn = null;
        Connection conn2 = null;
        Statement stmt = null;
        Statement stmt2 = null;
        final String USER = "root";
        final String PASS = "mysql";
        private final JLabel Credits = new JLabel("");
        private final JComboBox songs = new JComboBox();

        public static void main(String[] args) {
                EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        MainMenu frame = new MainMenu();

                                        frame.setVisible(true);
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                });
        }

        public MainMenu() throws Exception {

                conn = null;
                conn2 = null;
                stmt = null;
                stmt2 = null;
                JDBC_DRIVER = "com.mysql.jdbc.Driver";
                DB_URL = "jdbc:mysql://localhost/LightItUp_DB";

                initGUI();
        }

        private void initGUI() throws Exception {

                soundBtn.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                songs.setVisible(true);
                                if (Beep == true) {
                                        Toolkit.getDefaultToolkit().beep();
                                }
                                String song = songs.getSelectedItem().toString();
                                switch (song) {
                                case "Jungle": {
                                        Sound.sound1 = new Sound("res/1.wav");
                                        Sound.sound1.play();
                                        break;
                                }
                                case "Dizzy": {
                                        Sound.sound1.stop();
                                        Sound.sound1 = new Sound("res/2.wav");
                                        Sound.sound1.play();
                                        break;
                                }
                                case "Adventure": {
                                        Sound.sound1.stop();
                                        Sound.sound1 = new Sound("res/3.wav");
                                        Sound.sound1.play();
                                        break;
                                }
                                case "Night": {
                                        Sound.sound1.stop();
                                        Sound.sound1 = new Sound("res/4.wav");
                                        Sound.sound1.play();
                                        break;
                                }
                                case "Bubble": {
                                        Sound.sound1.stop();
                                        Sound.sound1 = new Sound("res/5.wav");
                                        Sound.sound1.play();
                                        break;
                                }
                                }
                        }
                });

                MusicBtn.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent arg0) {
                                if (Beep == true) {
                                        Toolkit.getDefaultToolkit().beep();
                                        Beep = false;
                                } else {
                                        Beep = true;
                                }
                        }
                });

                back.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                if (Beep == true) {
                                        Toolkit.getDefaultToolkit().beep();
                                }
                                songs.setVisible(false);
                                Credits.setVisible(false);
                                lblPlay.setVisible(true);
                                options.setVisible(true);
                                about.setVisible(true);
                                highScore.setVisible(true);
                                HowToPlay.setVisible(true);
                                quit.setVisible(true);

                                soundBtn.setVisible(false);
                                MusicBtn.setVisible(false);
                                back.setVisible(false);

                        }
                });

                lblPlay.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent arg0) {
                                try {
                                        
                                        Class.forName("com.mysql.jdbc.Driver");
                                        conn = DriverManager.getConnection(DB_URL, USER, PASS);
                                        stmt = conn.createStatement();
                                        ResultSet rs = stmt
                                                        .executeQuery("SELECT Player_Name From Players");
                                        int cont = 0;
                                        // Search
                                        while (rs.next()) {
                                                cont++;
                                        }
                                        if (cont == 0) {         // Database is empty
                                                EmptyDBPlayMiniFrame p = new EmptyDBPlayMiniFrame();
                                                p.setVisible(true);

                                        } else {
                                                String[] Players_Selectors = null;
                                                try {

                                                        Players_Selectors = new String[cont];
                                                        int i = 0;
                                                        while (rs.previous()) {
                                                                // filling them in array to display it in the list
                                                                Players_Selectors[i] = rs.getString("Player_Name"); 
                                                                i++;
                                                        }
                                                } catch (SQLException e1) {
                                                        e1.printStackTrace();
                                                }
                                                FilledDBPlayMiniFrame p = new FilledDBPlayMiniFrame(
                                                                Players_Selectors);
                                                p.setVisible(true);
                                        }
                                } catch (SQLException se) {

                                        se.printStackTrace();
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                });
                
                options.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                if (Beep == true) {
                                        Toolkit.getDefaultToolkit().beep();
                                }
                                back.setBounds(128, 294, 112, 137);
                                lblPlay.setVisible(false);
                                options.setVisible(true);
                                about.setVisible(false);
                                highScore.setVisible(false);
                                HowToPlay.setVisible(false);
                                quit.setVisible(false);

                                soundBtn.setVisible(true);
                                MusicBtn.setVisible(true);
                                back.setVisible(true);
                        }
                });

                about.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent arg0) {
                                if (Beep == true) {
                                        Toolkit.getDefaultToolkit().beep();
                                }
                                lblPlay.setVisible(false);
                                options.setVisible(false);
                                about.setVisible(false);
                                highScore.setVisible(false);
                                HowToPlay.setVisible(false);
                                quit.setVisible(false);
                                Credits.setVisible(true);
                                soundBtn.setVisible(false);
                                MusicBtn.setVisible(false);
                                back.setVisible(false);

                                back.setBounds(580, 130, 112, 137);
                                back.setVisible(true);
                                back.addMouseListener(new MouseAdapter() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {

                                                lblPlay.setVisible(true);
                                                options.setVisible(true);
                                                about.setVisible(true);
                                                highScore.setVisible(true);
                                                HowToPlay.setVisible(true);
                                                quit.setVisible(true);

                                                soundBtn.setVisible(false);
                                                MusicBtn.setVisible(false);
                                                back.setVisible(false);

                                        }
                                });
                        }
                });

                HowToPlay.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent arg0) {
                                if (Beep == true) {
                                        Toolkit.getDefaultToolkit().beep();
                                }
                                JFrame framePlay=new JFrame("how to play");
                                JMFPlayer HTP =new JMFPlayer(framePlay);
                                Container continer=framePlay.getContentPane();
                                framePlay.add(BorderLayout.CENTER,HTP);
                                framePlay.setVisible(true);
                        }
                });

                highScore.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent arg0) {
                                try {
                                        String[] Players_Selectors_NameAndScore = null;
                                        Integer[] Players_Scores = null;
                                        Class.forName("com.mysql.jdbc.Driver");
                                        conn = DriverManager.getConnection(DB_URL, USER, PASS);
                                        conn2 = DriverManager.getConnection(DB_URL, USER, PASS);
                                        stmt = conn.createStatement();
                                        stmt2 = conn2.createStatement();

                                        ResultSet rs = stmt
                                                        .executeQuery("SELECT Player_Name From Players");
                                        ResultSet rs2 = stmt2
                                                        .executeQuery("SELECT TotalScore From Players");
                                        int contName = 0;
                                        int contScore = 0;
                                        // Search
                                        while (rs.next()) {
                                                contName++;
                                        }
                                        while (rs2.next()) {
                                                contScore++;
                                        }
                                        if (contName == 0) {                // Database is empty
                                                Sorry s = new Sorry();
                                                s.setVisible(true);
                                        } 
                                        else {
                                        // Search
                                        try {
                                                Players_Scores = new Integer[contName];
                                                Players_Selectors_NameAndScore = new String[contName];
                                                int i = 0;
                                                while (rs.previous()) {
                                                        // filling them in array to display it in the list
                                                        Players_Selectors_NameAndScore[i] = rs.getString("Player_Name"); 
                                                        i++;
                                                }
                                                i = 0;
                                                String tmp1, tmp2;
                                                while (rs2.previous()) {
                                                        tmp1 = Players_Selectors_NameAndScore[i] + '\t';
                                                        Players_Scores[i] = rs2.getInt("TotalScore");
                                                        tmp2 = tmp1 + Players_Scores[i].toString();
                                                        Players_Selectors_NameAndScore[i] = tmp2;
                                                        i++;
                                                }
                                        } 
                                        catch (SQLException e1) {
                                                e1.printStackTrace();
                                        }
                                        
                                        MiniFrame m = new MiniFrame(Players_Selectors_NameAndScore);
                                        m.setVisible(true);
                                        }
                                
                                } catch (SQLException se) {
                                        se.printStackTrace();
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                });

                quit.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent arg0) {
                                if (Beep == true) {
                                        Toolkit.getDefaultToolkit().beep();
                                }
                                ExitFrame frame = new ExitFrame();
                                frame.setVisible(true);

                        }
                });

                setResizable(false);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setBounds(100, 100, 720, 610);
                contentPane = new JPanel();
                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

                soundBtn.setVisible(false);

                setContentPane(contentPane);
                contentPane.setLayout(null);
                Credits.setIcon(new ImageIcon("Credits.png"));
                Credits.setBounds(32, 82, 600, 519);
                Credits.setVisible(false);
                back.setVisible(false);

                back.setVisible(false);
                back.setIcon(new ImageIcon("back.png"));
                back.setBounds(128, 294, 112, 137);

                contentPane.add(back);
                contentPane.add(Credits);

                MainLabel.setIcon(new ImageIcon("Label.png"));
                MainLabel.setBounds(0, 0, 730, 601);

                contentPane.add(MainLabel);
                MusicBtn.setVisible(false);

                lblPlay.setIcon(new ImageIcon("play.gif"));
                lblPlay.setBounds(272, 143, 171, 72);

                contentPane.add(lblPlay);

                options.setIcon(new ImageIcon("options.gif"));
                options.setBounds(221, 211, 263, 72);

                contentPane.add(options);

                about.setIcon(new ImageIcon("about.gif"));
                about.setBounds(242, 433, 219, 72);

                contentPane.add(about);

                HowToPlay.setIcon(new ImageIcon("how to play.gif"));
                HowToPlay.setBounds(156, 283, 424, 80);

                contentPane.add(HowToPlay);

                highScore.setIcon(new ImageIcon("high score.gif"));
                highScore.setBounds(177, 363, 376, 80);

                contentPane.add(highScore);

                quit.setIcon(new ImageIcon("quit.gif"));
                quit.setBounds(259, 504, 163, 55);

                contentPane.add(quit);
                soundBtn.setIcon(new ImageIcon("soundIcon.png"));
                soundBtn.setBounds(299, 311, 112, 100);

                contentPane.add(soundBtn);
                MusicBtn.setIcon(new ImageIcon("Sound.png"));
                MusicBtn.setBounds(491, 311, 118, 100);

                contentPane.add(MusicBtn);
                songs.setVisible(false);
                songs.setModel(new DefaultComboBoxModel(new String[] { "Jungle",
                                "Dizzy", "Adventure", "Night", "Bubble" }));
                songs.setSelectedIndex(0);
                songs.setBounds(288, 411, 128, 20);

                contentPane.add(songs);
                lblBackground.setIcon(new ImageIcon("background.png"));
                lblBackground.setBounds(32, 124, 664, 435);

                contentPane.add(lblBackground);
                contentPane.setSize(getWidth(), getHeight());
        }
}
