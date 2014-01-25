import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class T extends Shapes{

	public T (String Name, int MinusNum, ImageIcon Img,int maxRange,String setDirections) {
		super(Name, MinusNum, Img,3);
		this.setDirections=setDirections;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Rotation(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int points() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	boolean []safaaSamy=new boolean[4];
	public void basicDirections()
	{
		safaaSamy[0]=true;
		safaaSamy[1]=false;
		safaaSamy[2]=false;
		safaaSamy[3]=true;
		this.setCurrent_direction(safaaSamy);
		
	}


}
