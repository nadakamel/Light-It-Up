
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

	public abstract class Shapes extends JFrame{
		public  String setDirections;
	private int maxRnge;                //max generated number
	public int getMaxRnge() {
		return maxRnge;
	}


	private String name; 				// name of the shape.
	public String getName() {
		return name;
	}

	private ImageIcon image;			// image.
	public ImageIcon getImage() {
		return image;
	}

	private final int minusNum; 			// stores new number subtracted each time after clicking.
	public int getMinusNum() {
		return minusNum;
	}	

	private boolean[] current_direction;
	public void setCurrent_direction(boolean[] current_direction) {
		this.current_direction = current_direction;
	}
	
	// Constructor
	public Shapes(String Name,int MinusNum,ImageIcon Img,int maxRange)
	{	
		this.maxRnge=maxRange;
		this.name = Name;
		this.minusNum = MinusNum;
		this.image = Img;
		this.current_direction=new boolean[4];
		
	}	
	
	// Rotation
	public abstract void Rotation(Graphics2D g);
	public abstract void basicDirections();  //fill 0 and 1 in direction array
	public abstract int points();

}
