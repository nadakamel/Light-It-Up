import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Sorry extends JFrame {

	private JPanel contentPane;
	private final JLabel background = new JLabel("");
	private final JLabel sorry = new JLabel("");
	private final JLabel back = new JLabel("");
	private final JLabel noPlayer = new JLabel("");

		public Sorry() {
			initGUI();
	}
		private void initGUI() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 410, 200);
			setUndecorated(true);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			sorry.setIcon(new ImageIcon("C:\\Users\\Essraa\\Desktop\\glitter\\final\\sorry.gif"));
			sorry.setBounds(128, 25, 201, 69);
			
			contentPane.add(sorry);
			back.setIcon(new ImageIcon("C:\\Users\\Essraa\\Desktop\\glitter\\final\\backS.png"));
			back.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					dispose();
				}
			});
			noPlayer.setIcon(new ImageIcon("C:\\Users\\Essraa\\Desktop\\glitter\\final\\noPlayer.gif"));
			noPlayer.setBounds(21, 80, 410, 67);
			
			contentPane.add(noPlayer);
			back.setBounds(0, 141, 60, 59);
			
			contentPane.add(back);
			background.setIcon(new ImageIcon("C:\\Users\\Essraa\\Desktop\\glitter\\final\\mini.png"));
			background.setBounds(0, 0, 410, 200);
			
			contentPane.add(background);
		}

}
