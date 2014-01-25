

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RotateLabel extends JLabel {
		
		public int theta=0;
	
		public RotateLabel(String text) {
			super(text);
		}
		public void rotateRight(){
			theta++;
		}
		public void rotateLeft(){
			theta--;
		}
		public void paintComponent(Graphics g) {
			Graphics2D gx = (Graphics2D) g;
			gx.rotate(theta*(Math.PI/2),  getWidth() / 2,  getHeight() / 2);//pi--> 180
			// lama a2olo left teb2a ++ masaln 1 aw 2 aw ...  madroba fe theta w bona2an 3aleha halef :D
			System.out.println(theta);
			super.paintComponent(g);
		}
		
	}

