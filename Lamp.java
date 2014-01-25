import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Lamp extends Shapes {

	public Lamp(String Name, int MinusNum, ImageIcon Img,int maxRange,String setDirections) {
		super(Name, MinusNum, Img, 3);
		this.setDirections=setDirections;
	}

	@Override
	public void Rotation(Graphics2D g) {
		
	}

	@Override
	public int points() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void basicDirections() {
		// TODO Auto-generated method stub
		
	}
	
	

	

}
