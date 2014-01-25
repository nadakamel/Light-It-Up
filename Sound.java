import java.applet.Applet;
import java.applet.AudioClip;
import java.util.Timer;

class Sound {
	
	public static  Sound sound1;//=new Sound("res/3.wav");	
	private AudioClip AC;
	public Sound(String file)
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
					AC.loop();
				}
			}.start();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void stop()
	{
		AC.stop();
	}
	
}
