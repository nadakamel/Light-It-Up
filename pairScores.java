
public class pairScores {
	private int Score;
	private String name;
	

	public  pairScores(int s,String n)
	{
		this.Score=s;
		this.name=n;
	}
	
	public int getScore()
	{
		return Score;
	}
	public String getName()
	{
		return name;
	}
	public pairScores[] deepCopy(int [] s,String[] n)
	{
		 pairScores[] copy = new pairScores[s.length];
		  for (int i = 0; i < s.length; ++i) {
			  copy[i] = new pairScores(s[i],n[i]);
		  }
		  return copy;
	}
	

	public pairScores[] compine(int []s,String[]n)
	{	pairScores pairs[] = deepCopy(s, n);
			for(int i=0;i<s.length;i++)
				System.out.print(n[i]);
					return pairs;
	}

}
