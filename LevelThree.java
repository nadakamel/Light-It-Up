import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class LevelThree extends Level{
	public Shapes[][] shapes;
	 ImageIcon[][] LightedIcons;

	public LevelThree(int levelNum, int rows, int cols, int minimumMoves,
			int scoreLevel) {
		super(levelNum, rows, cols, minimumMoves, scoreLevel);
		shapes=new Shapes[this.getRow()][this.getCol()];
		LightedIcons=new ImageIcon[this.getRow()][this.getCol()];
	}

	@Override
	public void SetShapes() throws IOException {
		 try {
			 ImageIcon Lamp_img = new ImageIcon(ImageIO.read(new File("pic/Lamp_0.png")));
			ImageIcon Lamp_img1 = new ImageIcon(ImageIO.read(new File("pic/Lamp_1.png")));
	    	ImageIcon Lamp_img2 = new ImageIcon(ImageIO.read(new File("pic/Lamp_2.png")));
	    	ImageIcon Lamp_img3 = new ImageIcon(ImageIO.read(new File("pic/Lamp_3.png")));
	    		
	    	ImageIcon Corner_img2=new ImageIcon(ImageIO.read(new File("pic/Corner_2.png")));
	    	ImageIcon Corner_img3=new ImageIcon(ImageIO.read(new File("pic/Corner_3.png")));
	    	ImageIcon Corner_img=new ImageIcon(ImageIO.read(new File("pic/Corner_0.png")));
	    	ImageIcon Corner_img1=new ImageIcon(ImageIO.read(new File("pic/Corner_1.png")));
	    	ImageIcon T_img= new ImageIcon(ImageIO.read(new File("pic/T_0.png")));
	    	ImageIcon T_img1= new ImageIcon(ImageIO.read(new File("pic/T_1.png")));
	    	ImageIcon T_img2= new ImageIcon(ImageIO.read(new File("pic/T_2.png")));
	    	ImageIcon T_img3= new ImageIcon(ImageIO.read(new File("pic/T_3.png")));
	        ImageIcon Straight_img= new ImageIcon(ImageIO.read(new File("pic/Straight_0.png")));
	        ImageIcon Straight_img1= new ImageIcon(ImageIO.read(new File("pic/Straight_1.png")));
	        ImageIcon Cross_img=new ImageIcon(ImageIO.read(new File("pic/Cross_0.png")));	
	        ImageIcon Source=new ImageIcon(ImageIO.read(new File("pic/Source_3.png")));
		shapes[0][0]=new Lamp("Lamp_0", 1, Lamp_img,3,"0010");
		shapes[0][1]=new Corner("Corner_3", 1, Corner_img3,3,"0110");
		shapes[0][2]=new Straight("Straight_1", 2,Straight_img1 ,1,"0101");
	    shapes[0][3]=new T("T_0", 1, T_img,3,"0111");
		shapes[0][4]=new Corner("Corner_2", 1, Corner_img2,3,"0011");
		shapes[0][5]=new Corner("Corner_3", 1, Corner_img3,3,"0110");
		shapes[0][6]=new Lamp("Lamp_3", 1, Lamp_img3,3,"0001");
		
		shapes[1][0]=new Straight("Straight_0", 2,Straight_img ,1,"1010");
		shapes[1][1]=new T("T_1", 1, T_img1,3,"1110");
		shapes[1][2]=new Source("Source_0", 1, Source,3,"0001");
		shapes[1][3]=new Lamp("Lamp_2", 1, Lamp_img2,3,"1000");
		shapes[1][4]=new Corner("Corner_0", 1, Corner_img,3,"1100");	
		shapes[1][5]=new Cross("Cross_0",1,Cross_img,0,"1111");
		shapes[1][6]=new Lamp("Lamp_3", 1, Lamp_img3,3,"0001");
		
		shapes[2][0]=new Corner("Corner_0", 1, Corner_img,3,"1100");
		shapes[2][1]=new Cross("Cross_0",1,Cross_img,0,"1111");
		shapes[2][2]=new Straight("Straight_1", 2,Straight_img1 ,1,"0101");
		shapes[2][3]=new Lamp("Lamp_3", 1, Lamp_img,3,"0001");
		shapes[2][4]=new Lamp("Lamp_0", 1, Lamp_img,3,"0010");
		shapes[2][5]=new T("T_1", 1, T_img1,3,"1110");
		shapes[2][6]=new Lamp("Lamp_3", 1, Lamp_img3,3,"0001");
		
		shapes[3][0]=new Corner("Corner_3", 1, Corner_img3,3,"0110");
		shapes[3][1]=new Cross("Cross_0",1,Cross_img,0,"1111");
		shapes[3][2]=new T("T_0", 1, T_img,3,"0111");
		shapes[3][3]=new Corner("Corner_2", 1, Corner_img2,3,"0011");
		shapes[3][4]=new Straight("Straight_0", 2,Straight_img ,1,"1010");
		shapes[3][5]=new Corner("Corner_0", 1, Corner_img,3,"1100");
		shapes[3][6]=new Lamp("Lamp_3", 1, Lamp_img3,3,"0001");
		
		shapes[4][0]=new Lamp("Lamp_2", 1, Lamp_img2,3,"1000");
		shapes[4][1]=new Straight("Straight_0", 2,Straight_img ,1,"1010");		
		shapes[4][2]=new Straight("Straight_0", 2,Straight_img ,1,"1010");
		shapes[4][3]=new Corner("Corner_0", 1, Corner_img,3,"1100");
		shapes[4][4]=new T("T_2", 1, T_img2,3,"1101");
		shapes[4][5]=new Straight("Straight_1", 2,Straight_img1 ,1,"0101");
		shapes[4][6]=new Corner("Corner_2", 1, Corner_img2,3,"0011");
		
		shapes[5][0]=new Corner("Corner_3", 1, Corner_img3,3,"0110");
		shapes[5][1]=new Corner("Corner_2", 1, Corner_img2,3,"0011");
		shapes[5][2]=new Corner("Corner_0", 1, Corner_img,3,"1100");
		shapes[5][3]=new T("T_0", 1, T_img,3,"0111");
		shapes[5][4]=new T("T_0", 1, T_img,3,"0111");
		shapes[5][5]=new Corner("Corner_2", 1, Corner_img2,3,"0011");
		shapes[5][6]=new Straight("Straight_0", 2,Straight_img ,1,"1010");
		
		shapes[6][0]=new Lamp("Lamp_2", 1, Lamp_img2,3,"1000");
		shapes[6][1]=new Lamp("Lamp_1", 1, Lamp_img1,3,"0100");
		shapes[6][2]=new Straight("Straight_1", 2,Straight_img1 ,1,"0101");
		shapes[6][3]=new Corner("Corner_1", 1, Corner_img1,3,"1001");
		shapes[6][4]=new Lamp("Lamp_2", 1, Lamp_img2,3,"1000");
		shapes[6][5]=new Lamp("Lamp_2", 1, Lamp_img2,3,"1000");
		shapes[6][6]=new Lamp("Lamp_2", 1, Lamp_img2,3,"1000");
		
		
		
		LightedIcons[0][0]=new ImageIcon(ImageIO.read(new File("pic/Lamp_00.png")));
		LightedIcons[0][1]=new ImageIcon(ImageIO.read(new File("pic/Corner_33.png")));
		LightedIcons[0][2]=new ImageIcon(ImageIO.read(new File("pic/Straight_11.png")));
		LightedIcons[0][3]=new ImageIcon(ImageIO.read(new File("pic/T_00.png")));
		LightedIcons[0][4]=new ImageIcon(ImageIO.read(new File("pic/Corner_22.png")));
		LightedIcons[0][5]=new ImageIcon(ImageIO.read(new File("pic/Corner_33.png")));
		LightedIcons[0][6]=new ImageIcon(ImageIO.read(new File("pic/Lamp_33.png")));
		
		LightedIcons[1][0]=new ImageIcon(ImageIO.read(new File("pic/Straight_00.png")));
		LightedIcons[1][1]=new ImageIcon(ImageIO.read(new File("pic/T_11.png")));
		LightedIcons[1][2]=new ImageIcon(ImageIO.read(new File("pic/Source_3.png")));
		LightedIcons[1][3]=new ImageIcon(ImageIO.read(new File("pic/Lamp_22.png")));
		LightedIcons[1][4]=new ImageIcon(ImageIO.read(new File("pic/Corner_00.png")));
		LightedIcons[1][5]=new ImageIcon(ImageIO.read(new File("pic/Cross_00.png")));
		LightedIcons[1][6]=new ImageIcon(ImageIO.read(new File("pic/Lamp_33.png")));
		
		LightedIcons[2][0]=new ImageIcon(ImageIO.read(new File("pic/Corner_00.png")));
		LightedIcons[2][1]=new ImageIcon(ImageIO.read(new File("pic/Cross_00.png")));
		LightedIcons[2][2]=new ImageIcon(ImageIO.read(new File("pic/Straight_11.png")));
		LightedIcons[2][3]=new ImageIcon(ImageIO.read(new File("pic/Lamp_33.png")));
		LightedIcons[2][4]=new ImageIcon(ImageIO.read(new File("pic/Lamp_00.png")));
		LightedIcons[2][5]=new ImageIcon(ImageIO.read(new File("pic/T_11.png")));
		LightedIcons[2][6]=new ImageIcon(ImageIO.read(new File("pic/Lamp_33.png")));
		
	  LightedIcons[3][0]=new ImageIcon(ImageIO.read(new File("pic/Corner_33.png")));
	  LightedIcons[3][1]=new ImageIcon(ImageIO.read(new File("pic/Cross_00.png")));
	  LightedIcons[3][2]=new ImageIcon(ImageIO.read(new File("pic/T_00.png")));
	  LightedIcons[3][3]=new ImageIcon(ImageIO.read(new File("pic/Corner_22.png")));
	  LightedIcons[3][4]=new ImageIcon(ImageIO.read(new File("pic/Straight_00.png")));
	LightedIcons[3][5]=new ImageIcon(ImageIO.read(new File("pic/Corner_00.png")));
		LightedIcons[3][6]=new ImageIcon(ImageIO.read(new File("pic/Lamp_33.png")));
		
		 LightedIcons[4][0]=new ImageIcon(ImageIO.read(new File("pic/Lamp_22.png")));
 LightedIcons[4][1]= new ImageIcon(ImageIO.read(new File("pic/Straight_00.png")));
	 LightedIcons[4][2]=new ImageIcon(ImageIO.read(new File("pic/Straight_00.png")));
	 LightedIcons[4][3]=new ImageIcon(ImageIO.read(new File("pic/Corner_00.png")));
	 LightedIcons[4][4]=new ImageIcon(ImageIO.read(new File("pic/T_22.png")));
		LightedIcons[4][5]=new ImageIcon(ImageIO.read(new File("pic/Straight_11.png")));
		LightedIcons[4][6]=new ImageIcon(ImageIO.read(new File("pic/Corner_22.png")));
		
		LightedIcons[5][0]=new ImageIcon(ImageIO.read(new File("pic/Corner_33.png")));
		LightedIcons[5][1]=new ImageIcon(ImageIO.read(new File("pic/Corner_22.png")));
		LightedIcons[5][2]=new ImageIcon(ImageIO.read(new File("pic/Corner_00.png")));
		LightedIcons[5][3]=new ImageIcon(ImageIO.read(new File("pic/T_00.png")));
		LightedIcons[5][4]=new ImageIcon(ImageIO.read(new File("pic/T_00.png")));
		LightedIcons[5][5]=new ImageIcon(ImageIO.read(new File("pic/Corner_22.png")));
		LightedIcons[5][6]=new ImageIcon(ImageIO.read(new File("pic/Straight_00.png")));
		
		LightedIcons[6][0]=new ImageIcon(ImageIO.read(new File("pic/Lamp_22.png")));
	LightedIcons[6][1]=new ImageIcon(ImageIO.read(new File("pic/Lamp_11.png")));
	LightedIcons[6][2]=new ImageIcon(ImageIO.read(new File("pic/Straight_11.png")));
	LightedIcons[6][3]=new ImageIcon(ImageIO.read(new File("pic/Corner_11.png")));
	LightedIcons[6][4]=new ImageIcon(ImageIO.read(new File("pic/Lamp_22.png")));
	LightedIcons[6][5]=new ImageIcon(ImageIO.read(new File("pic/Lamp_22.png")));
	LightedIcons[6][6]=new ImageIcon(ImageIO.read(new File("pic/Lamp_22.png")));
		
		
		 }
		 catch(IOException e)
	      {
	    	System.out.print("NOOO");
	    	System.exit(0);
	    	
	      }
		
	}

	@Override
	public int generateMoves() {
		int [][]currState=new int[this.getRow()][this.getCol()];
		RotateLabel[][] lbls_arr=new RotateLabel[this.getRow()][this.getCol()];
		int totalMoves=0;
		int generatedNum;
		Random random	=new Random();
		lbls_arr=this.getFinalLevel_shape();
		for(int i=0;i<this.getRow();i++)
		{
			for(int j=0;j<this.getCol();j++)
			{
				if(i==1 && j==2)
				{
					continue;
				}
				generatedNum=random.nextInt(shapes[i][j].getMaxRnge()+1);
				for(int k=0;k<generatedNum;k++)
				{
					lbls_arr[i][j].rotateLeft();
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
	@Override
	public void drawLevel() {
		RotateLabel[][] label_array=new RotateLabel[this.getRow()][this.getCol()];
		for(int i=0;i<this.getRow();i++)
		{
			for(int j=0;j<this.getCol();j++)
			{
				
					label_array[i][j]=new RotateLabel("");
					label_array[i][j].setIcon( shapes[i][j].getImage());
			}
		}
		
		this.setFinalLevel_shape(label_array);
		
	
	
		
	}


}
