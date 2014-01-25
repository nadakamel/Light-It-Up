
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class Source extends Shapes {

	public Source(String Name, int MinusNum, ImageIcon Img, int maxRange,String setDirections) {
		super(Name, MinusNum, Img, maxRange);
		this.setDirections=setDirections;
	}
		

	@Override
	public void Rotation(Graphics2D g) {
		
		
	}

	@Override
	public void basicDirections() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int points() {
		// TODO Auto-generated method stub
		return 0;
	}

}
