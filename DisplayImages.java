
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
////////////////////////////////////////////////////


public class DisplayImages extends JFrame {
	 final JLabel label_05 = new JLabel("");
	private final JLabel label_01 = new JLabel("");
	private final JLabel label_06 = new JLabel("");
	private final JLabel label_02 = new JLabel("");
	private final JLabel label_03 = new JLabel("");
	private final JLabel label_04 = new JLabel("");
	private final JLabel label_08 = new JLabel("");
	private final JLabel label_63 = new JLabel("");
	private final JLabel label_00 = new JLabel("");
	private final JLabel label_09 = new JLabel("");
	private final JLabel label_10 = new JLabel("");
	private final JLabel label_11 = new JLabel("");
	private final JLabel label_12 = new JLabel("");
	private final JLabel label_13 = new JLabel("");
	private final JLabel label_14 = new JLabel("");
	private final JLabel label_15 = new JLabel("");
	private final JLabel label_16 = new JLabel("");
	private final JLabel label_17 = new JLabel("");
	private final JLabel label_18 = new JLabel("");
	private final JLabel label_20 = new JLabel("");
	private final JLabel label_21 = new JLabel("");
	private final JLabel label_22 = new JLabel("");
	private final JLabel label_23 = new JLabel("");
	private final JLabel label_24 = new JLabel("");
	private final JLabel label_25 = new JLabel("");
	private final JLabel label_26 = new JLabel("");
	private final JLabel label_27 = new JLabel("");
	private final JLabel label_28 = new JLabel("");
	private final JLabel label_30 = new JLabel("");
	private final JLabel label_31 = new JLabel("");
	private final JLabel label_32 = new JLabel("");
	private final JLabel label_33 = new JLabel("");
	private final JLabel label_34 = new JLabel("");
	private final JLabel label_35 = new JLabel("");
	private final JLabel label_36 = new JLabel("");
	private final JLabel label_37 = new JLabel("");
	private final JLabel label_38 = new JLabel("");
	private final JLabel label_40 = new JLabel("");
	private final JLabel label_41 = new JLabel("");
	private final JLabel label_42 = new JLabel("");
	private final JLabel label_43 = new JLabel("");
	private final JLabel label_44 = new JLabel("");
	private final JLabel label_45 = new JLabel("");
	private final JLabel label_46 = new JLabel("");
	private final JLabel label_47 = new JLabel("");
	private final JLabel label_48 = new JLabel("");
	private final JLabel label_50 = new JLabel("");
	private final JLabel label_51 = new JLabel("");
	private final JLabel label_52 = new JLabel("");
	private final JLabel label_53 = new JLabel("");
	private final JLabel label_54 = new JLabel("");
	private final JLabel label_58 = new JLabel("");
	private final JLabel label_60 = new JLabel("");
	private final JLabel label_61 = new JLabel("");
	private final JLabel label_62 = new JLabel("");
	private final JLabel label_64 = new JLabel("");
	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayImages frame = new DisplayImages();
					frame.setVisible(true);
					frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
					
				}
		
			}
		});
	}

	*/
	public DisplayImages() {
		
		initGUI();
		
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 420);
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().setLayout(new GridLayout(7, 9, 0, 0));
		label_00.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				BufferedImage dimg =null;
				try{
				ImageIO.read(new File("C:\\Users\\Nada\\Java Workspace\\Light It Up\\src\\Pics\\Straight.png"));
				}
				catch( Exception e)
				{
					e.printStackTrace();
				}
			    @SuppressWarnings("null")
				Graphics2D g = dimg.createGraphics();
			    //House house1 = new House(Name, MinusNum, Img, Pos_x, Pos_y);
			}
		});
		
		label_00.setIcon(new ImageIcon("C:\\Users\\Nada\\Java Workspace\\Light It Up\\src\\Pics\\Straight.png"));
		getContentPane().add(label_00);
		
		getContentPane().add(label_01);
		
		getContentPane().add(label_02);
		
		getContentPane().add(label_03);
		
		getContentPane().add(label_04);
		
		getContentPane().add(label_05);
		
		getContentPane().add(label_06);
		
		getContentPane().add(label_08);
		
		getContentPane().add(label_09);
		
		getContentPane().add(label_10);
		
		getContentPane().add(label_11);
		
		getContentPane().add(label_12);
		
		getContentPane().add(label_13);
		
		getContentPane().add(label_14);
		
		getContentPane().add(label_15);
		
		getContentPane().add(label_16);
		
		getContentPane().add(label_17);
		
		getContentPane().add(label_18);
		
		getContentPane().add(label_20);
		
		getContentPane().add(label_21);
		
		getContentPane().add(label_22);
		
		getContentPane().add(label_23);
		
		getContentPane().add(label_24);
		
		getContentPane().add(label_25);
		
		getContentPane().add(label_26);
		
		getContentPane().add(label_27);
		
		getContentPane().add(label_28);
		
		getContentPane().add(label_30);
		
		getContentPane().add(label_31);
		
		getContentPane().add(label_32);
		
		getContentPane().add(label_33);
		
		getContentPane().add(label_34);
		
		getContentPane().add(label_35);
		
		getContentPane().add(label_36);
		
		getContentPane().add(label_37);
		
		getContentPane().add(label_38);
		
		getContentPane().add(label_40);
		
		getContentPane().add(label_41);
		
		getContentPane().add(label_42);
		
		getContentPane().add(label_43);
		
		getContentPane().add(label_44);
		
		getContentPane().add(label_46);
		
		getContentPane().add(label_45);
		
		getContentPane().add(label_47);
		
		getContentPane().add(label_48);
		
		getContentPane().add(label_50);
		
		getContentPane().add(label_53);
		
		getContentPane().add(label_51);
		
		getContentPane().add(label_52);
		
		getContentPane().add(label_54);
		
		getContentPane().add(label_58);
		
		getContentPane().add(label_60);
		
		getContentPane().add(label_61);
		
		getContentPane().add(label_62);
		
		getContentPane().add(label_63);
		
		getContentPane().add(label_64);
	}
	
	/*
	 * Images.
	 */
	
    
	
}
