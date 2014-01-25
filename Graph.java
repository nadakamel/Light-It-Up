import java.util.*;

public class Graph {
	final boolean UNVISITED =false;
	private int numVertex, numEdge; // Store number of vertices, edges
	private int [][]matrix; // Pointer to adjacency matrix
	private  boolean []mark; // Pointer to mark array
	public int WinningState;

	Graph(int numVert) // Constructor
	{ 
		WinningState=0;
		Init(numVert); 
	}
	public void Init(int n) { // Initialize the graph
		int i;
		numVertex = n;
		numEdge = 0;
		mark = new boolean[n]; // Initialize mark array

		for (i=0; i<numVertex; i++)
			mark[i] = UNVISITED;

		matrix = new int[numVertex][numVertex] ;// Make matrix
		for (i=0; i<numVertex; i++)
			matrix[i] = new int[numVertex];

		for (i=0; i< numVertex; i++) // Initialize to 0 weights
		{	
			for (int j=0; j<numVertex; j++)
				matrix[i][j] = 0;
		}
	}

	public int getVertices() // Number of vertices
	{ 
		return numVertex; 
	}
	public int getEdges() // Number of edges
	{ 
		return numEdge; 
	}

	// Return first neighbor of "v"
	public int first(int v) 
	{
		for (int i=0; i<numVertex; i++)
			if (matrix[v][i] != 0) 
				return i;
		return numVertex; // Return n if none
	}

	// Return v’s next neighbor after w
	public int next(int v, int w) 
	{
		for(int i=w+1; i<numVertex; i++)
			if (matrix[v][i] != 0)
				return i;
		return numVertex; // Return n if none
	}

	// Set edge (v1, v2) to "wt"
	public void setEdge(int v1, int v2, int wt) 
	{
		if (matrix[v1][v2] == 0) 
			numEdge++;
		matrix[v1][v2] = wt;
		matrix[v2][v1] = wt;
	}
	public void delEdge(int v1, int v2) { // Delete edge (v1, v2)
		if (matrix[v1][v2] != 0) 
			numEdge--;
		matrix[v1][v2] = 0;
		matrix[v2][v1] = 0;
	}

	public boolean isEdge(int i, int j) // Is (i, j) an edge?
	{ 
		return matrix[i][j] != 0; 
	}

	public int weight(int v1, int v2) 
	{ 
		return matrix[v1][v2]; 
	}

	public boolean getVisited(int v) 
	{ 
		return mark[v]; 
	}

	public void setVisited(int v, boolean val) 
	{ 
		mark[v] = val; 
	}
	public void getNeighbour(int vertex, ArrayList<Integer> neighbours) // gets all neighbours for vertex and are set in neighbours vector
	{
		for (int i=0; i<numVertex; i++)
		{
			if(matrix[vertex][i] != 0)
				neighbours.add(i);
		}
	}
	public	void getConnectedComponents()

	{
		int numConnectedComponents = 0;

		for(int v=0;v<numVertex;v++)
		{
			if(!mark[v])
			{
				mark[v] = true;

				ArrayList<Integer> neighbours = null;

				Queue<Integer> verticesQueue=new LinkedList<Integer>();
				verticesQueue.add(v);

				while(!verticesQueue.isEmpty())
				{
					int currentVertex = verticesQueue.poll();
					verticesQueue.remove();

					neighbours.clear();
					getNeighbour(currentVertex, neighbours);
					for(int n=0;n<neighbours.size();n++)
					{
						if(!mark[neighbours.get(n)])
						{
							mark[neighbours.get(n)] = true;
							verticesQueue.add(neighbours.get(n));
						}
					}
				}
			}
		}
	}
	public ArrayList<Integer>connectedComponent(int v)
	{
		ArrayList<Integer>component=new ArrayList<Integer>();
		if(!mark[v])
		{
			mark[v] = true;
			ArrayList<Integer> neighbours = new ArrayList<Integer>();

			Queue<Integer> verticesQueue=new LinkedList<Integer>();
			verticesQueue.add(v);
			//component.add(v);
			while(!verticesQueue.isEmpty())
			{
				int currentVertex = verticesQueue.poll();
				if(!verticesQueue.isEmpty())
					verticesQueue.remove();
				if(!neighbours.isEmpty())
					neighbours.clear();
				getNeighbour(currentVertex, neighbours);
				for(int n=0;n<neighbours.size();n++)
				{
					if(!mark[neighbours.get(n)])
					{
						component.add(neighbours.get(n));
						mark[neighbours.get(n)] = true;
						verticesQueue.add(neighbours.get(n));
					}
				}
			}
		}
		return component;
	}
	ArrayList<Integer> DFS(int v)
	{
		ArrayList<Integer> c=new ArrayList<Integer>();
		for(int i = v; i < numVertex; i++)
		{
			if(!mark[i])
				c.addAll(dfsVertex(i,c));      
		}
		return c;
	}

	void setUnVisited()
	{
		for(int i=0;i<numVertex;i++)
			this.mark[i]=UNVISITED;
	}
	
	boolean winning()
	{
		for(int i=0;i<mark.length;i++)
			if(mark[i]==false)
				return mark[i];
		return true;
	}

	ArrayList<Integer> dfsVertex(int vertex, ArrayList<Integer> c)
	{ 
		mark[vertex] = true;
		WinningState++;
		c.add(vertex);
		ArrayList<Integer> v=new ArrayList<Integer>();
		getNeighbour(vertex, v);
		for(int i = 0; i < v.size(); i++)
		{
			if(!mark[ v.get(i) ])
			{
				//c.add(v.get(i));
				dfsVertex(v.get(i),c);
			}
		}
		return c;
	}



}


