import java.applet.Applet;
import java.applet.AudioClip;
import java.util.Timer;

class beep {
	Thread thread;
	public static final Sound sound1=new Sound("res/b2.wav");	
	private AudioClip AC;
	public beep(String file)
	{
		try
		{
			AC=Applet.newAudioClip(Sound.class.getResource(file));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void play()
	{
		try
		{
		
			new Thread(){
				public void run()
				{
					AC.play();
					
				}
			}.start();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
