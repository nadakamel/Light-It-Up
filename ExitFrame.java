import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ExitFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel BG = new JLabel("");
	private final JLabel yes = new JLabel("");
	private final JLabel no = new JLabel("");
	public int x;
	public ExitFrame()
	{
		initGUI();
	}

	private void  initGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		setBounds(100, 100, 390, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		BG.setIcon(new ImageIcon("C:\\Users\\Essraa\\Desktop\\glitter\\final\\Exit.png"));
		BG.setBounds(-46, 0, 436, 214);
		
		contentPane.add(BG);
		yes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			x=0;
			}
		});
		yes.setBounds(90, 98, 76, 77);
		
		contentPane.add(yes);
		no.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false); //you can't see me!!
				x=1;	
			}
		});
		no.setBounds(216, 98, 76, 77);
		
		contentPane.add(no);
		}
}
