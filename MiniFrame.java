
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class MiniFrame extends JFrame {
	public JPanel contentPane;
	public MiniFrame(String[] v) {
		initGUI(v);
	}
	private void initGUI(String[] v) {
		getContentPane().add(new ImagedPane(v));
		setBounds(100, 100, 534, 420);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		setVisible(true);
	}
}
