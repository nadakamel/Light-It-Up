import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class testFrame extends JFrame {
	private JPanel contentPane;
	public RotateLabel label = new RotateLabel("");

	RotateLabel[][] allLabels;
	
	public static int level;
	public int levelNum=0;
	public static int totalScore = 0;
	public static String playerName;	
	LevelOne level1 = new LevelOne(1, 3, 3, 80, 1000);
	LevelTow level2 = new LevelTow(2, 5, 5, 80, 2500);
	LevelThree level3 = new LevelThree(3, 7, 7, 80, 4000);
	LevelFour level4 = new LevelFour(4, 7, 9, 80, 5500);
	LevelFive level5 = new LevelFive(5, 7, 9, 80, 7000);
	LevelSix level6 = new LevelSix(6, 7, 9, 80, 8500);
	LevelSeven level7 = new LevelSeven(7, 7, 9, 80, 10000);
	
	// 2D array of integers that represent generated numbers of left rotate
	public int [][] cur_stat;
	public int winingState = 0;

	public int total_moves_counter = 0;
	
	private Graph graph;

	final class pair<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;

		public pair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V old = this.value;
			this.value = value;
			return old;
		}
	}

	Set<pair<Integer,Integer>> currLighted=new HashSet<pair<Integer,Integer>>();
	Set<pair<Integer,Integer>> prevLighted=new HashSet<pair<Integer,Integer>>();

	//public map< int, array >
	Map<Integer,pair<Integer,Integer>>mp=new HashMap<Integer,pair<Integer,Integer>>();

	private void lightOff(Set<pair<Integer,Integer>> LightedSet) throws IOException
	{
		java.util.Iterator<pair<Integer, Integer>> it = LightedSet.iterator();
	
		if(level == 1) {
			while(it.hasNext())
			{
				pair<Integer,Integer>tmpNode=it.next();
				this.allLabels[tmpNode.key][tmpNode.value].setIcon(level1.shapes[tmpNode.key][tmpNode.value].getImage());
			}
		}
		else if(level == 2)	{
			while(it.hasNext())
			{
				pair<Integer,Integer>tmpNode=it.next();
				this.allLabels[tmpNode.key][tmpNode.value].setIcon(level2.shapes[tmpNode.key][tmpNode.value].getImage());
			}
		}
		else if(level == 3) {
			while(it.hasNext())
			{
				pair<Integer,Integer>tmpNode=it.next();
				this.allLabels[tmpNode.key][tmpNode.value].setIcon(level3.shapes[tmpNode.key][tmpNode.value].getImage());
			}
		}
		else if(level == 4) { 
			while(it.hasNext())
			{
				pair<Integer,Integer>tmpNode=it.next();
				this.allLabels[tmpNode.key][tmpNode.value].setIcon(level4.shapes[tmpNode.key][tmpNode.value].getImage());
			}
		}
		else if(level == 5) { 
			while(it.hasNext())
			{
				pair<Integer,Integer>tmpNode=it.next();
				this.allLabels[tmpNode.key][tmpNode.value].setIcon(level5.shapes[tmpNode.key][tmpNode.value].getImage());
			}
		}
		else if(level == 6)	{
			while(it.hasNext())
			{
				pair<Integer,Integer>tmpNode=it.next();
				this.allLabels[tmpNode.key][tmpNode.value].setIcon(level6.shapes[tmpNode.key][tmpNode.value].getImage());
			}
		}
		else if(level == 7)	{
			while(it.hasNext())
			{
				pair<Integer,Integer>tmpNode=it.next();
				this.allLabels[tmpNode.key][tmpNode.value].setIcon(level7.shapes[tmpNode.key][tmpNode.value].getImage());
			}
		}
	}

	private void lightUp(Set<pair<Integer,Integer>> LightedSet) throws IOException
	{
		java.util.Iterator<pair<Integer, Integer>> it = LightedSet.iterator();
		
		if(level == 1){
			while(it.hasNext())
			{
				pair<Integer,Integer>tmpNode=it.next();
				this.allLabels[tmpNode.key][tmpNode.value].setIcon(level1.LightedIcons[tmpNode.key][tmpNode.value]);
			}
		}
		else if(level == 2){
			while(it.hasNext())
			{
				pair<Integer,Integer>tmpNode=it.next();
				this.allLabels[tmpNode.key][tmpNode.value].setIcon(level2.LightedIcons[tmpNode.key][tmpNode.value]);
			}
		}
		if(level == 3){
			while(it.hasNext())
			{
				pair<Integer,Integer>tmpNode=it.next();
				this.allLabels[tmpNode.key][tmpNode.value].setIcon(level3.LightedIcons[tmpNode.key][tmpNode.value]);
			}
		}
		if(level == 4){
			while(it.hasNext())
			{
				pair<Integer,Integer>tmpNode=it.next();
				this.allLabels[tmpNode.key][tmpNode.value].setIcon(level4.LightedIcons[tmpNode.key][tmpNode.value]);
			}
		}
		if(level == 5){
			while(it.hasNext())
			{
				pair<Integer,Integer>tmpNode=it.next();
				this.allLabels[tmpNode.key][tmpNode.value].setIcon(level5.LightedIcons[tmpNode.key][tmpNode.value]);
			}
		}
		if(level == 6)
		{
			while(it.hasNext())
			{
				pair<Integer,Integer>tmpNode=it.next();
				this.allLabels[tmpNode.key][tmpNode.value].setIcon(level6.LightedIcons[tmpNode.key][tmpNode.value]);
			}
		}
		if(level == 7)
		{
			while(it.hasNext())
			{
				pair<Integer,Integer>tmpNode=it.next();
				this.allLabels[tmpNode.key][tmpNode.value].setIcon(level7.LightedIcons[tmpNode.key][tmpNode.value]);
			}
		}
		
	}

	private void getLightedNodes(Graph g) throws IOException
	{
		Set<pair<Integer,Integer>>on = new HashSet<pair<Integer,Integer>>();
		Set<pair<Integer,Integer>>of = new HashSet<pair<Integer,Integer>>();
		ArrayList<Integer>LightedComponent = new ArrayList<Integer>();

		/** DFS Vertex */
		if(level == 1)
			LightedComponent = g.dfsVertex(4,LightedComponent);
		else if(level == 2)
			LightedComponent = g.dfsVertex(16,LightedComponent);
		else if(level == 3)
			LightedComponent = g.dfsVertex(9,LightedComponent);
		else if(level == 4)
			LightedComponent = g.dfsVertex(21,LightedComponent);
		else if(level == 5)
			LightedComponent = g.dfsVertex(28,LightedComponent);
		else if(level == 6)
			LightedComponent = g.dfsVertex(34,LightedComponent);
		else if(level == 7)
			LightedComponent = g.dfsVertex(32,LightedComponent);
				
		
		for(int i=0;i<LightedComponent.size();i++)
		{
			int nodeNum=LightedComponent.get(i);
			pair<Integer, Integer>lightedNode = null;
			
			if(level == 1)
				lightedNode = new pair<Integer, Integer>(nodeNum/level1.getCol(), nodeNum%level1.getCol());
			else if(level == 2)
				lightedNode = new pair<Integer, Integer>(nodeNum/level2.getCol(), nodeNum%level2.getCol());
			else if(level == 3)
				lightedNode = new pair<Integer, Integer>(nodeNum/level3.getCol(), nodeNum%level3.getCol());
			else if(level == 4)
				lightedNode = new pair<Integer, Integer>(nodeNum/level4.getCol(), nodeNum%level4.getCol());
			else if(level == 5)
				lightedNode = new pair<Integer, Integer>(nodeNum/level5.getCol(), nodeNum%level5.getCol());
			else if(level == 6)
				lightedNode = new pair<Integer, Integer>(nodeNum/level6.getCol(), nodeNum%level6.getCol());
			else if(level == 7)
				lightedNode = new pair<Integer, Integer>(nodeNum/level7.getCol(), nodeNum%level7.getCol());
					
			this.currLighted.add(lightedNode);
		}
		Set<pair<Integer,Integer>>cur=new HashSet<pair<Integer,Integer>>(this.currLighted);
		Set<pair<Integer,Integer>>prev=new HashSet<pair<Integer,Integer>>(this.prevLighted);
		on=cur;
		of=prev;
		this.lightOff(of);
		this.lightUp(on);
				
		java.util.Iterator<pair<Integer, Integer>> it2 = of.iterator();
		while(it2.hasNext())
		{
			pair<Integer,Integer>tmpNode=it2.next();
			System.out.println("of: "+tmpNode.key+"  "+tmpNode.value);
		}
		System.out.println("///////////////////////");
				
		this.prevLighted.clear();
		this.prevLighted.addAll(this.currLighted);
		this.currLighted.clear();
				
		/** When the level is completed. */
		if(graph.winning() == true)
		{			
			if(level == 1)
			{
				totalScore += level1.Score();
				SCoreFrame Score=new SCoreFrame(totalScore, playerName,level);
				Score.setVisible(true);
				System.out.println(totalScore);
			}
			else if(level == 2)
			{
				totalScore += level2.Score();
				SCoreFrame Score=new SCoreFrame(totalScore, playerName,level);
				Score.setVisible(true);
				System.out.println(totalScore);
			}
			else if(level == 3)
			{
				totalScore += level3.Score();
				SCoreFrame Score=new SCoreFrame(totalScore, playerName,level);
				Score.setVisible(true);
				System.out.println(totalScore);
			}
			else if(level == 4)
			{
				totalScore += level4.Score();
				SCoreFrame Score=new SCoreFrame(totalScore, playerName,level);
				Score.setVisible(true);
				System.out.println(totalScore);
			}
			else if(level == 5)
			{
				totalScore += level5.Score();
				SCoreFrame Score=new SCoreFrame(totalScore, playerName,level);
				Score.setVisible(true);
				System.out.println(totalScore);
			}
			else if(level == 6)
			{
				totalScore += level6.Score();
				SCoreFrame Score=new SCoreFrame(totalScore, playerName,level);
				Score.setVisible(true);
				System.out.println(totalScore);
			}
			else if(level == 7)
			{
				totalScore += level7.Score();
				SCoreFrame Score=new SCoreFrame(totalScore, playerName,level);
				Score.setVisible(true);
				System.out.println(totalScore);
			}
			
			level++;
			System.out.println(level);
		
		}
		
		this.graph.setUnVisited();

	}

	class EventPressLabel extends MouseAdapter 
	{
		int x;
		int y;
		RotateLabel eventLabel;

		public EventPressLabel(int x, int y, RotateLabel eventLabel) {
			this.x = x;
			this.y = y;
			this.eventLabel = eventLabel;
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			total_moves_counter++;
			eventLabel.rotateRight();
			eventLabel.paint(eventLabel.getGraphics());
						
			String direction;
			char str;
			
			if(level == 1){			
				cur_stat[y][x]=cur_stat[y][x]-level1.shapes[y][x].getMinusNum();
				direction = level1.shapes[y][x].setDirections;
				str=direction.charAt(direction.length()-1);
				direction=str+direction;
				direction=direction.substring(0,direction.length()-1);
				level1.shapes[y][x].setDirections=direction;
				for(int k=0;k<=3;k++)
				{
					int currow=mp.get(k).key;
					int curcol=mp.get(k).value;
					if((y+currow>=0)&&(y+currow<level1.getRow())&&(x+curcol>=0)&&(x+curcol<level1.getCol())&&(direction.charAt(k)=='1'))
					{
						if((level1.shapes[y+currow][x+curcol].setDirections.charAt(((k+2)%4)))=='1')
							graph.setEdge(level1.getCol()*y+x,level1.getCol()*(y+currow)+(x+curcol),1);	
					}
					else if((y+currow>=0)&&(y+currow<level1.getRow())&&(x+curcol>=0)&&(x+curcol<level1.getCol())&&(direction.charAt(k)!='1'))
					{
						graph.delEdge(level1.getCol()*y+x,level1.getCol()*(y+currow)+(x+curcol));
					}
				}
			}
			else if(level == 2){
				cur_stat[y][x]=cur_stat[y][x]-level2.shapes[y][x].getMinusNum();
				direction = level2.shapes[y][x].setDirections;
				str=direction.charAt(direction.length()-1);
				direction=str+direction;
				direction=direction.substring(0,direction.length()-1);
				level2.shapes[y][x].setDirections=direction;
				for(int k=0;k<=3;k++)
				{
					int currow=mp.get(k).key;
					int curcol=mp.get(k).value;
					if((y+currow>=0)&&(y+currow<level2.getRow())&&(x+curcol>=0)&&(x+curcol<level2.getCol())&&(direction.charAt(k)=='1'))
					{
						if((level2.shapes[y+currow][x+curcol].setDirections.charAt(((k+2)%4)))=='1')
							graph.setEdge(level2.getCol()*y+x,level2.getCol()*(y+currow)+(x+curcol),1);	
					}
					else if((y+currow>=0)&&(y+currow<level2.getRow())&&(x+curcol>=0)&&(x+curcol<level2.getCol())&&(direction.charAt(k)!='1'))
					{
						graph.delEdge(level2.getCol()*y+x,level2.getCol()*(y+currow)+(x+curcol));
					}
				}
			}
			else if(level == 3){
				cur_stat[y][x]=cur_stat[y][x]-level3.shapes[y][x].getMinusNum();
				direction = level3.shapes[y][x].setDirections;
				str=direction.charAt(direction.length()-1);
				direction=str+direction;
				direction=direction.substring(0,direction.length()-1);
				level3.shapes[y][x].setDirections=direction;
				for(int k=0;k<=3;k++)
				{
					int currow=mp.get(k).key;
					int curcol=mp.get(k).value;
					if((y+currow>=0)&&(y+currow<level3.getRow())&&(x+curcol>=0)&&(x+curcol<level3.getCol())&&(direction.charAt(k)=='1'))
					{
						if((level3.shapes[y+currow][x+curcol].setDirections.charAt(((k+2)%4)))=='1')
							graph.setEdge(level3.getCol()*y+x,level3.getCol()*(y+currow)+(x+curcol),1);	
					}
					else if((y+currow>=0)&&(y+currow<level3.getRow())&&(x+curcol>=0)&&(x+curcol<level3.getCol())&&(direction.charAt(k)!='1'))
					{
						graph.delEdge(level3.getCol()*y+x,level3.getCol()*(y+currow)+(x+curcol));
					}
				}
			}
			else if(level == 4){
				cur_stat[y][x]=cur_stat[y][x]-level4.shapes[y][x].getMinusNum();
				direction = level4.shapes[y][x].setDirections;
				str=direction.charAt(direction.length()-1);
				direction=str+direction;
				direction=direction.substring(0,direction.length()-1);
				level4.shapes[y][x].setDirections=direction;
				for(int k=0;k<=3;k++)
				{
					int currow=mp.get(k).key;
					int curcol=mp.get(k).value;
					if((y+currow>=0)&&(y+currow<level4.getRow())&&(x+curcol>=0)&&(x+curcol<level4.getCol())&&(direction.charAt(k)=='1'))
					{
						if((level4.shapes[y+currow][x+curcol].setDirections.charAt(((k+2)%4)))=='1')
							graph.setEdge(level4.getCol()*y+x,level4.getCol()*(y+currow)+(x+curcol),1);	
					}
					else if((y+currow>=0)&&(y+currow<level4.getRow())&&(x+curcol>=0)&&(x+curcol<level4.getCol())&&(direction.charAt(k)!='1'))
					{
						graph.delEdge(level4.getCol()*y+x,level4.getCol()*(y+currow)+(x+curcol));
					}
				}
			}
			else if(level == 5){
				cur_stat[y][x]=cur_stat[y][x]-level5.shapes[y][x].getMinusNum();
				direction = level5.shapes[y][x].setDirections;
				str=direction.charAt(direction.length()-1);
				direction=str+direction;
				direction=direction.substring(0,direction.length()-1);
				level5.shapes[y][x].setDirections=direction;
				for(int k=0;k<=3;k++)
				{
					int currow=mp.get(k).key;
					int curcol=mp.get(k).value;
					if((y+currow>=0)&&(y+currow<level5.getRow())&&(x+curcol>=0)&&(x+curcol<level5.getCol())&&(direction.charAt(k)=='1'))
					{
						if((level5.shapes[y+currow][x+curcol].setDirections.charAt(((k+2)%4)))=='1')
							graph.setEdge(level5.getCol()*y+x,level5.getCol()*(y+currow)+(x+curcol),1);	
					}
					else if((y+currow>=0)&&(y+currow<level5.getRow())&&(x+curcol>=0)&&(x+curcol<level5.getCol())&&(direction.charAt(k)!='1'))
					{
						graph.delEdge(level5.getCol()*y+x,level5.getCol()*(y+currow)+(x+curcol));
					}
				}
			}
			else if(level == 6){
				cur_stat[y][x]=cur_stat[y][x]-level6.shapes[y][x].getMinusNum();
				direction = level6.shapes[y][x].setDirections;
				str=direction.charAt(direction.length()-1);
				direction=str+direction;
				direction=direction.substring(0,direction.length()-1);
				level6.shapes[y][x].setDirections=direction;
				for(int k=0;k<=3;k++)
				{
					int currow=mp.get(k).key;
					int curcol=mp.get(k).value;
					if((y+currow>=0)&&(y+currow<level6.getRow())&&(x+curcol>=0)&&(x+curcol<level6.getCol())&&(direction.charAt(k)=='1'))
					{
						if((level6.shapes[y+currow][x+curcol].setDirections.charAt(((k+2)%4)))=='1')
							graph.setEdge(level6.getCol()*y+x,level6.getCol()*(y+currow)+(x+curcol),1);	
					}
					else if((y+currow>=0)&&(y+currow<level6.getRow())&&(x+curcol>=0)&&(x+curcol<level6.getCol())&&(direction.charAt(k)!='1'))
					{
						graph.delEdge(level6.getCol()*y+x,level6.getCol()*(y+currow)+(x+curcol));
					}
				}
			}
			else if(level == 7){
				cur_stat[y][x]=cur_stat[y][x]-level7.shapes[y][x].getMinusNum();
				direction = level7.shapes[y][x].setDirections;
				str=direction.charAt(direction.length()-1);
				direction=str+direction;
				direction=direction.substring(0,direction.length()-1);
				level7.shapes[y][x].setDirections=direction;
				for(int k=0;k<=3;k++)
				{
					int currow=mp.get(k).key;
					int curcol=mp.get(k).value;
					if((y+currow>=0)&&(y+currow<level7.getRow())&&(x+curcol>=0)&&(x+curcol<level7.getCol())&&(direction.charAt(k)=='1'))
					{
						if((level7.shapes[y+currow][x+curcol].setDirections.charAt(((k+2)%4)))=='1')
							graph.setEdge(level7.getCol()*y+x,level7.getCol()*(y+currow)+(x+curcol),1);	
					}
					else if((y+currow>=0)&&(y+currow<level7.getRow())&&(x+curcol>=0)&&(x+curcol<level7.getCol())&&(direction.charAt(k)!='1'))
					{
						graph.delEdge(level7.getCol()*y+x,level7.getCol()*(y+currow)+(x+curcol));
					}
				}
			}
			try {
				getLightedNodes(graph);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	// Main Function
	

	// Constructor
	public testFrame(int level, int ToTalScore,String name) throws IOException {
		this.level=level; 
		playerName=name;
		pair<Integer,Integer>p,p1,p2,p3;
		p=new pair<Integer, Integer>(-1, 0);
		mp.put(0, p);
		p1=new pair<Integer, Integer>(0,1);
		mp.put(1, p1);
		p2=new pair<Integer, Integer>(1,0);
		mp.put(2, p2);
		p3=new pair<Integer, Integer>(0,-1);
		mp.put(3, p3);
		initGUI();
	}
	
	private void initGUI() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		int cols = 9; //v1.getCol()
		int rows = 7; //v1.getRow()
		ColumnSpec[] arrCol = new ColumnSpec[cols];
		for (int i = 0; i < cols; i++)
			arrCol[i] = FormFactory.DEFAULT_COLSPEC;

		RowSpec[] arrRow = new RowSpec[rows];
		for (int i = 0; i < rows; i++)
			arrRow[i] = FormFactory.DEFAULT_ROWSPEC;
		contentPane.setLayout(new FormLayout(arrCol, arrRow));

		if(level == 1){	
			// Set frame size.
			setBounds(350, 300, 210, 222);
			setVisible(true);
			level1.SetShapes();
			level1.drawLevel();
			level1.generateMoves();
			graph =  new Graph(level1.getCol()*level1.getRow());
			cur_stat = level1.getCurrent_state();

			// Initialize the graph 
			for(int i=0;i<level1.getRow();i++)
				for(int j=0;j<level1.getCol();j++)
				{
					String direction = level1.shapes[i][j].setDirections;
					for(int k=0;k<4;k++)
					{
						if(direction.charAt(k)=='1')
						{
							int currow=mp.get(k).key;
							int curcol=mp.get(k).value;
							if((i+currow>=0)&&(i+currow<level1.getRow())&&(j+curcol>=0)&&(j+curcol<level1.getCol()))
							{
								if((level1.shapes[i+currow][j+curcol].setDirections.charAt(((k+2)%4)))=='1')
								{
									graph.setEdge(level1.getCol()*i+j,level1.getCol()*(i+currow)+(j+curcol),1);
								}
							}
						}
					}		
				}

			allLabels = level1.getFinalLevel_shape();
			getLightedNodes(this.graph);

			for (int i = 0; i < level1.getRow(); i++) {
				for (int j = 0; j < level1.getCol(); j++) {

					EventPressLabel a = new EventPressLabel(j, i, allLabels[i][j]);

					allLabels[i][j].addMouseListener(a);
					contentPane.add(allLabels[i][j], (j + 1) + ", " + (i + 1));
					
				}
			}
						
		}
		else if(level == 2){	
			// Set frame size.
			setBounds(100, 100, 328, 358);
						
			level2.SetShapes();
			level2.drawLevel();
			level2.generateMoves();
			graph =  new Graph(level2.getCol()*level2.getRow());
			cur_stat = level2.getCurrent_state();

			// Initialize the graph 
			for(int i=0;i<level2.getRow();i++)
				for(int j=0;j<level2.getCol();j++)
				{
					String direction = level2.shapes[i][j].setDirections;
					for(int k=0;k<4;k++)
					{
						if(direction.charAt(k)=='1')
						{
							int currow=mp.get(k).key;
							int curcol=mp.get(k).value;
							if((i+currow>=0)&&(i+currow<level2.getRow())&&(j+curcol>=0)&&(j+curcol<level2.getCol()))
							{
								if((level2.shapes[i+currow][j+curcol].setDirections.charAt(((k+2)%4)))=='1')
								{
									graph.setEdge(level2.getCol()*i+j,level2.getCol()*(i+currow)+(j+curcol),1);
								}
							}
						}
					}		
				}

			allLabels = level2.getFinalLevel_shape();
			getLightedNodes(this.graph);

			for (int i = 0; i < level2.getRow(); i++) {
				for (int j = 0; j < level2.getCol(); j++) {

					EventPressLabel a = new EventPressLabel(j, i, allLabels[i][j]);

					allLabels[i][j].addMouseListener(a);
					contentPane.add(allLabels[i][j], (j + 1) + ", " + (i + 1));

				}
			}
			
		}
		else if(level == 3){	
			// Set frame size.
			setBounds(100, 100, 520, 420);
						
			level3.SetShapes();
			level3.drawLevel();
			level3.generateMoves();
			graph =  new Graph(level3.getCol()*level3.getRow());
			cur_stat = level3.getCurrent_state();

			// Initialize the graph 
			for(int i=0;i<level3.getRow();i++)
				for(int j=0;j<level3.getCol();j++)
				{
					String direction = level3.shapes[i][j].setDirections;
					for(int k=0;k<4;k++)
					{
						if(direction.charAt(k)=='1')
						{
							int currow=mp.get(k).key;
							int curcol=mp.get(k).value;
							if((i+currow>=0)&&(i+currow<level3.getRow())&&(j+curcol>=0)&&(j+curcol<level3.getCol()))
							{
								if((level3.shapes[i+currow][j+curcol].setDirections.charAt(((k+2)%4)))=='1')
								{
									graph.setEdge(level3.getCol()*i+j,level3.getCol()*(i+currow)+(j+curcol),1);
								}
							}
						}
					}		
				}

			allLabels = level3.getFinalLevel_shape();
			getLightedNodes(this.graph);

			for (int i = 0; i < level3.getRow(); i++) {
				for (int j = 0; j < level3.getCol(); j++) {

					EventPressLabel a = new EventPressLabel(j, i, allLabels[i][j]);

					allLabels[i][j].addMouseListener(a);
					contentPane.add(allLabels[i][j], (j + 1) + ", " + (i + 1));

				}
			}
			
		}
		else if(level == 4){	
			// Set frame size.
			setBounds(100, 100, 520, 420);
						
			level4.SetShapes();
			level4.drawLevel();
			level4.generateMoves();
			graph =  new Graph(level4.getCol()*level4.getRow());
			cur_stat = level4.getCurrent_state();

			// Initialize the graph 
			for(int i=0;i<level4.getRow();i++)
				for(int j=0;j<level4.getCol();j++)
				{
					String direction = level4.shapes[i][j].setDirections;
					for(int k=0;k<4;k++)
					{
						if(direction.charAt(k)=='1')
						{
							int currow=mp.get(k).key;
							int curcol=mp.get(k).value;
							if((i+currow>=0)&&(i+currow<level4.getRow())&&(j+curcol>=0)&&(j+curcol<level4.getCol()))
							{
								if((level4.shapes[i+currow][j+curcol].setDirections.charAt(((k+2)%4)))=='1')
								{
									graph.setEdge(level4.getCol()*i+j,level4.getCol()*(i+currow)+(j+curcol),1);
								}
							}
						}
					}		
				}
			
			allLabels = level4.getFinalLevel_shape();
			getLightedNodes(this.graph);

			for (int i = 0; i < level4.getRow(); i++) {
				for (int j = 0; j < level4.getCol(); j++) {

					EventPressLabel a = new EventPressLabel(j, i, allLabels[i][j]);

					allLabels[i][j].addMouseListener(a);
					contentPane.add(allLabels[i][j], (j + 1) + ", " + (i + 1));

				}
			}
			
		}
		else if(level == 5){
			// Set frame size.
			setBounds(100, 100, 520, 420);
						
			level5.SetShapes();
			level5.drawLevel();
			level5.generateMoves();
			graph =  new Graph(level5.getCol()*level5.getRow());
			cur_stat = level5.getCurrent_state();

			// Initialize the graph 
			for(int i=0;i<level5.getRow();i++)
				for(int j=0;j<level5.getCol();j++)
				{
					String direction = level5.shapes[i][j].setDirections;
					for(int k=0;k<4;k++)
					{
						if(direction.charAt(k)=='1')
						{
							int currow=mp.get(k).key;
							int curcol=mp.get(k).value;
							if((i+currow>=0)&&(i+currow<level5.getRow())&&(j+curcol>=0)&&(j+curcol<level5.getCol()))
							{
								if((level5.shapes[i+currow][j+curcol].setDirections.charAt(((k+2)%4)))=='1')
								{
									graph.setEdge(level5.getCol()*i+j,level5.getCol()*(i+currow)+(j+curcol),1);
								}
							}
						}
					}		
				}

			allLabels = level5.getFinalLevel_shape();
			getLightedNodes(this.graph);

			for (int i = 0; i < level5.getRow(); i++) {
				for (int j = 0; j < level5.getCol(); j++) {

					EventPressLabel a = new EventPressLabel(j, i, allLabels[i][j]);

					allLabels[i][j].addMouseListener(a);
					contentPane.add(allLabels[i][j], (j + 1) + ", " + (i + 1));

				}
			}
			
		}
		else if(level == 6){
			// Set frame size.
			setBounds(100, 100, 520, 420);
						
			level6.SetShapes();
			level6.drawLevel();
			level6.generateMoves();
			graph =  new Graph(level6.getCol()*level6.getRow());
			cur_stat = level6.getCurrent_state();

			// Initialize the graph 
			for(int i=0;i<level6.getRow();i++)
				for(int j=0;j<level6.getCol();j++)
				{
					String direction = level6.shapes[i][j].setDirections;
					for(int k=0;k<4;k++)
					{
						if(direction.charAt(k)=='1')
						{
							int currow=mp.get(k).key;
							int curcol=mp.get(k).value;
							if((i+currow>=0)&&(i+currow<level6.getRow())&&(j+curcol>=0)&&(j+curcol<level6.getCol()))
							{
								if((level6.shapes[i+currow][j+curcol].setDirections.charAt(((k+2)%4)))=='1')
								{
									graph.setEdge(level6.getCol()*i+j,level6.getCol()*(i+currow)+(j+curcol),1);
								}
							}
						}
					}		
				}

			allLabels = level6.getFinalLevel_shape();
			getLightedNodes(this.graph);

			for (int i = 0; i < level6.getRow(); i++) {
				for (int j = 0; j < level6.getCol(); j++) {

					EventPressLabel a = new EventPressLabel(j, i, allLabels[i][j]);

					allLabels[i][j].addMouseListener(a);
					contentPane.add(allLabels[i][j], (j + 1) + ", " + (i + 1));

				}
			}
			
		}
		else if(level == 7){
			// Set frame size.
			setBounds(100, 100, 520, 420);
						
			level7.SetShapes();
			level7.drawLevel();
			level7.generateMoves();
			graph =  new Graph(level7.getCol()*level7.getRow());
			cur_stat = level7.getCurrent_state();

			// Initialize the graph 
			for(int i=0;i<level7.getRow();i++)
				for(int j=0;j<level7.getCol();j++)
				{
					String direction = level7.shapes[i][j].setDirections;
					for(int k=0;k<4;k++)
					{
						if(direction.charAt(k)=='1')
						{
							int currow=mp.get(k).key;
							int curcol=mp.get(k).value;
							if((i+currow>=0)&&(i+currow<level7.getRow())&&(j+curcol>=0)&&(j+curcol<level7.getCol()))
							{
								if((level7.shapes[i+currow][j+curcol].setDirections.charAt(((k+2)%4)))=='1')
								{
									graph.setEdge(level7.getCol()*i+j,level7.getCol()*(i+currow)+(j+curcol),1);
								}
							}
						}
					}		
				}

			allLabels = level7.getFinalLevel_shape();
			getLightedNodes(this.graph);

			for (int i = 0; i < level7.getRow(); i++) {
				for (int j = 0; j < level7.getCol(); j++) {

					EventPressLabel a = new EventPressLabel(j, i, allLabels[i][j]);

					allLabels[i][j].addMouseListener(a);
					contentPane.add(allLabels[i][j], (j + 1) + ", " + (i + 1));

				}
			}
			
		}

	}//end of intGUI 
	
}
