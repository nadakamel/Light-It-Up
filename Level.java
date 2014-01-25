import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
public abstract class Level {
	private int LevelNum;
	private int[][] Current_state;
	private Shapes [][] shapes;
	public Shapes[][] getShapes() {
		return shapes;
	}
	public void setShapes(Shapes[][] shapes) {
		this.shapes = shapes;
	}
	public ImageIcon[][] getLightedIcon() {
		return LightedIcon;
	}
	public void setLightedIcon(ImageIcon[][] lightedIcon) {
		LightedIcon = lightedIcon;
	}
	private ImageIcon [][] LightedIcon;
	public int[][] getCurrent_state() {
		return Current_state;
	}
 private RotateLabel[][]finalLevel_shape;
	public RotateLabel[][] getFinalLevel_shape() {
		return finalLevel_shape;
	}
	public void setFinalLevel_shape(RotateLabel[][] finalLevel_shape) {
		this.finalLevel_shape = finalLevel_shape;
	}
	public void setCurrent_state(int[][] current_state) {
		Current_state = current_state;
	}
	private int row;
	private int col;
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	private int MinimumMoves;
	private int ScoreLevel;
	private int NumOfMoves;
	public Icon[][] LightedIcons;
	public Level(int levelNum, int rows, int cols, int minimumMoves, int scoreLevel)
	{
		this.row=rows;
		this.col=cols;
		this.LevelNum = levelNum;
		this.Current_state = new int [rows][cols];
		this.MinimumMoves = minimumMoves;
		this.ScoreLevel = scoreLevel;
	}
	public void setMinimumMoves(int minimumMoves) {
		MinimumMoves = minimumMoves;
	}
	public int getMinimumMoves() {
		return MinimumMoves;
	}
	public abstract void drawLevel();
	public abstract void SetShapes() throws IOException;
	public abstract int generateMoves();
	public final int Score() {
		this.NumOfMoves = generateMoves();
		int FinalScore = (MinimumMoves/NumOfMoves) * ScoreLevel; 
		return FinalScore;
	}
	public final void connectedComponent()
	{
		
	}
	public Icon[][] getLightedIcons() {
		// TODO Auto-generated method stub
		return LightedIcons;
	}

	
	
}
