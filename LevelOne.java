
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LevelOne extends Level{
	public Shapes[][] shapes;
	public ImageIcon source=null;
	 ImageIcon[][] LightedIcons;
	public LevelOne(int levelNum, int rows, int cols, int minimumMoves,
			int scoreLevel) {
		super(levelNum, rows, cols, minimumMoves, scoreLevel);
		shapes=new Shapes[this.getRow()][this.getCol()];
		LightedIcons=new ImageIcon[this.getRow()][this.getCol()];
		
	}
	
	@Override
	
	public void SetShapes() {
				 // Houseimg1 = null;
	    try {
	    	
	    	ImageIcon Lampimg = new ImageIcon(ImageIO.read(new File("Pic/Lamp_0.png")));
	    	ImageIcon Lampimg3 = new ImageIcon(ImageIO.read(new File("Pic/Lamp_3.png")));
	    	ImageIcon Straightimg1= new ImageIcon(ImageIO.read(new File("Pic/Straight_1.png")));/////////////
	    	ImageIcon Straightimg = new ImageIcon(ImageIO.read(new File("Pic/Straight_0.png")));
	    	ImageIcon Timg1= new ImageIcon(ImageIO.read(new File("Pic/T_1.png")));
	    	ImageIcon Cornerimg=new ImageIcon(ImageIO.read(new File("Pic/Corner_0.png")));
	    	ImageIcon Cornerimg1=new ImageIcon(ImageIO.read(new File("Pic/Corner_1.png")));
	    	ImageIcon Cornerimg3=new ImageIcon(ImageIO.read(new File("Pic/Corner_3.png")));
	       ImageIcon source=new ImageIcon(ImageIO.read(new File("Pic/Source_1.png")));
	       shapes[0][0] =new Corner("Corner_3", 1, Cornerimg3,3,"0110");
	       shapes[0][1] =new Lamp("Lamp_3", 1, Lampimg3,3,"0001");
	       shapes[0][2] = new Lamp("Lamp_0", 1, Lampimg,3,"0010");
	       shapes[1][0] =new T("T_1", 1, Timg1,3,"1110");
	       
	       shapes[1][1]=new Source("Source_0",1,source,0,"0010");
	       shapes[1][2]  = new Straight("Straight_0", 2,Straightimg, 1,"1010");
	       shapes[2][0] =new Corner("Corner_0", 1, Cornerimg,3,"1100");
	       shapes[2][1] =new Straight("Straight_1", 2,Straightimg1 ,1,"0101");/////////////
	       shapes[2][2] =new Corner("Corner_1", 1, Cornerimg1,3,"1001");
	       LightedIcons[0][0]=new ImageIcon(ImageIO.read(new File("Pic/Corner_33.png")));
	       LightedIcons[0][1]=new ImageIcon(ImageIO.read(new File("Pic/Lamp_33.png")));
	       LightedIcons[0][2]=new ImageIcon(ImageIO.read(new File("Pic/Lamp_00.png")));
	       LightedIcons[1][0]=new ImageIcon(ImageIO.read(new File("Pic/T_11.png")));
	       LightedIcons[1][1]=new ImageIcon(ImageIO.read(new File("Pic/Source_1.png")));
	       LightedIcons[1][2]=new ImageIcon(ImageIO.read(new File("Pic/Straight_00.png")));
	       LightedIcons[2][0]=new ImageIcon(ImageIO.read(new File("Pic/Corner_00.png")));
	       LightedIcons[2][1]=new ImageIcon(ImageIO.read(new File("Pic/Straight_11.png")));///////////////////
	       LightedIcons[2][2]=new ImageIcon(ImageIO.read(new File("Pic/Corner_11.png")));
	    		    }
	    catch(IOException e)
	      {
	    	System.out.print("NOOO");
	    	e.printStackTrace();
	    	System.exit(0);
	    	
	    	
	      }
		
		
	}

	@Override
	public int generateMoves() {
		int [][]currState=new int[this.getRow()][this.getCol()];
		RotateLabel[][] lblsarr=new RotateLabel[this.getRow()][this.getCol()];
		int totalMoves=0;
		int generatedNum;
		Random random	=new Random();
		lblsarr=this.getFinalLevel_shape();
		for(int i=0;i<this.getRow();i++)
		{
			for(int j=0;j<this.getCol();j++)
			{
				if(i==1 && j==1)
				{
					continue;
				}
				generatedNum=random.nextInt(shapes[i][j].getMaxRnge()+1);
				for(int k=0;k<generatedNum;k++)
				{
					lblsarr[i][j].rotateLeft();
					String direction=shapes[i][j].setDirections;
					direction+=direction.charAt(0);
					direction=direction.substring(1, direction.length());
					shapes[i][j].setDirections=direction;
				}
				currState[i][j]=generatedNum*shapes[i][j].getMinusNum();
				
				totalMoves+=generatedNum;
			}
		}
		this.setMinimumMoves(totalMoves);
		this.setCurrent_state(currState);
		return totalMoves;
		
	}

	
	public void drawLevel() {
		RotateLabel[][] labelarray=new RotateLabel[this.getRow()][this.getCol()];
		for(int i=0;i<this.getRow();i++)
		{
			for(int j=0;j<this.getCol();j++)
			{
				
					labelarray[i][j]=new RotateLabel("");
					labelarray[i][j].setIcon( shapes[i][j].getImage());
			}
		}
		
		this.setFinalLevel_shape(labelarray);
		
	}
}
