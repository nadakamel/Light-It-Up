import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.GridLayout;


public class frame extends JFrame {
	private final Panel panel = new Panel();
	private final JLabel frameLabel = new JLabel("");
	private final JLabel cell_16 = new JLabel("");
	private final JLabel cell_00 = new JLabel("");
	private final JLabel cell_01 = new JLabel("");
	private final JLabel cell_02 = new JLabel("");
	private final JLabel cell_03 = new JLabel("");
	private final JLabel cell_04 = new JLabel("");
	private final JLabel cell_05 = new JLabel("");
	private final JLabel cell_07 = new JLabel("");
	private final JLabel cell_06 = new JLabel("");
	private final JLabel cell_10 = new JLabel("");
	private final JLabel cell_08 = new JLabel("");
	private final JLabel cell_13 = new JLabel("");
	private final JLabel cell_12 = new JLabel("");
	private final JLabel cell_15 = new JLabel("");
	private final JLabel cell_11 = new JLabel("");
	private final JLabel cell_14 = new JLabel("");
	private final JLabel cell_40 = new JLabel("");
	private final JLabel cell_41 = new JLabel("");
	private final JLabel cell_17 = new JLabel("");
	private final JLabel cell_18 = new JLabel("");
	private final JLabel cell_20 = new JLabel("");
	private final JLabel cell_21 = new JLabel("");
	private final JLabel cell_22 = new JLabel("");
	private final JLabel cell_23 = new JLabel("");
	private final JLabel cell_24 = new JLabel("");
	private final JLabel cell_25 = new JLabel("");
	private final JLabel cell_26 = new JLabel("");
	private final JLabel cell_27 = new JLabel("");
	private final JLabel cell_28 = new JLabel("");
	private final JLabel cell_30 = new JLabel("");
	private final JLabel cell_31 = new JLabel("");
	private final JLabel cell_32 = new JLabel("");
	private final JLabel cell_33 = new JLabel("");
	private final JLabel cell_34 = new JLabel("");
	private final JLabel cell_35 = new JLabel("");
	private final JLabel cell_36 = new JLabel("");
	private final JLabel cell_37 = new JLabel("");
	private final JLabel cell_38 = new JLabel("");
	private final JLabel cell_42 = new JLabel("");
	private final JLabel cell_43 = new JLabel("");
	private final JLabel cell_44 = new JLabel("");
	private final JLabel cell_45 = new JLabel("");
	private final JLabel cell_46 = new JLabel("");
	private final JLabel cell_47 = new JLabel("");
	private final JLabel cell_48 = new JLabel("");
	private final JLabel cell_50 = new JLabel("");
	private final JLabel cell_51 = new JLabel("");
	private final JLabel cell_52 = new JLabel("");
	private final JLabel cell_53 = new JLabel("");
	private final JLabel cell_54 = new JLabel("");
	private final JLabel cell_55 = new JLabel("");
	private final JLabel cell_56 = new JLabel("");
	private final JLabel cell_57 = new JLabel("");
	private final JLabel cell_58 = new JLabel("");
	private final JLabel cell_60 = new JLabel("");
	private final JLabel cell_61 = new JLabel("");
	private final JLabel cell_62 = new JLabel("");
	private final JLabel cell_63 = new JLabel("");
	private final JLabel cell_64 = new JLabel("");
	private final JLabel cell_65 = new JLabel("");
	private final JLabel cell_66 = new JLabel("");
	private final JLabel cell_67 = new JLabel("");
	private final JLabel cell_68 = new JLabel("");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame frame = new frame();
					frame.setUndecorated(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frame() {
		
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 639);
		getContentPane().setLayout(null);
		panel.setBounds(109, 119, 540, 420);
		
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(7, 9, 0, 0));
		
		panel.add(cell_00);
		
		panel.add(cell_01);
		
		panel.add(cell_02);
		
		panel.add(cell_03);
		
		panel.add(cell_04);
		
		panel.add(cell_05);
		
		panel.add(cell_06);
		
		panel.add(cell_07);
		
		panel.add(cell_08);
		
		panel.add(cell_10);
		
		panel.add(cell_11);
		
		panel.add(cell_12);
		
		panel.add(cell_13);
		
		panel.add(cell_14);
		
		panel.add(cell_15);
		
		panel.add(cell_16);
		
		panel.add(cell_17);
		
		panel.add(cell_18);
		
		panel.add(cell_20);
		
		panel.add(cell_21);
		
		panel.add(cell_22);
		
		panel.add(cell_23);
		
		panel.add(cell_24);
		
		panel.add(cell_25);
		
		panel.add(cell_26);
		
		panel.add(cell_27);
		
		panel.add(cell_28);
		
		panel.add(cell_30);
		
		panel.add(cell_31);
		
		panel.add(cell_32);
		
		panel.add(cell_33);
		
		panel.add(cell_34);
		
		panel.add(cell_35);
		
		panel.add(cell_36);
		
		panel.add(cell_37);
		
		panel.add(cell_38);
		
		panel.add(cell_40);
		
		panel.add(cell_41);
		
		panel.add(cell_42);
		
		panel.add(cell_43);
		
		panel.add(cell_44);
		
		panel.add(cell_45);
		
		panel.add(cell_46);
		
		panel.add(cell_47);
		
		panel.add(cell_48);
		
		panel.add(cell_50);
		
		panel.add(cell_51);
		
		panel.add(cell_52);
		
		panel.add(cell_53);
		
		panel.add(cell_54);
		
		panel.add(cell_55);
		
		panel.add(cell_56);
		
		panel.add(cell_57);
		
		panel.add(cell_58);
		
		panel.add(cell_60);
		
		panel.add(cell_61);
		
		panel.add(cell_62);
		
		panel.add(cell_63);
		
		panel.add(cell_64);
		
		panel.add(cell_65);
		
		panel.add(cell_66);
		
		panel.add(cell_67);
		
		panel.add(cell_68);
		frameLabel.setIcon(new ImageIcon("C:\\Users\\Essraa\\Desktop\\light it up\\test (2).png"));
		frameLabel.setBounds(0, 0, 726, 575);
		
		getContentPane().add(frameLabel);
		}
}
