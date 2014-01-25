import java.awt.*;
import javax.swing.*;
import java.net.*;
import javax.media.*;

public class JMFPlayer extends JPanel implements ControllerListener {

	/** The player object */
	Player thePlayer = null;

	/** The parent Frame we are in. */
	JFrame parentFrame = null;

	/** Our contentpane */
	Container cp;

	/** The visual component (if any) */
	Component visualComponent = null;

	/** The default control component (if any) */
	Component controlComponent = null;


	/** The URL representing this media file. */
	 URL theURL;
	 
	 /** The back label to this stop the video. */
	 private final JLabel back = new JLabel("");

	/** Construct the player object and the GUI. */
		public JMFPlayer(JFrame pf) {
			parentFrame = pf;
		// mediaName = media;
		// cp = getContentPane();
		cp = this;
		cp.setLayout(new BorderLayout());
	
		
		try {
		theURL=new URL("file:/C:/Users/Essraa/adt-bundle-windows-x86/LightItUp/res/Light.mpg");
	} catch (MalformedURLException malformedURLException) {
		System.err.println("Could not create URL for the file");
	}
		
		
		try {
			
			thePlayer = Manager.createPlayer(theURL);
			thePlayer.addControllerListener(this);
		} catch (MalformedURLException e) {
			System.err.println("JMF URL creation error: " + e);
		} catch (Exception e) {
			System.err.println("JMF Player creation error: " + e);
			return;
		}
		System.out.println("theURL = " + theURL);
		
		// Start the player: this will notify our ControllerListener.
		thePlayer.start();
		// start playing
	}

	/** Called to stop the audio, as from a Stop button or menuitem */
	public void stop() {
		if (thePlayer == null)
			return;
		thePlayer.stop(); // stop playing!
		thePlayer.deallocate(); // free system resources
	}

	/** Called when we are really finished (as from an Exit button). */
	public void destroy() {
		if (thePlayer == null)
			return;
		thePlayer.close();
	}

	/** Called by JMF when the Player has something to tell us about. */
	public synchronized void controllerUpdate(ControllerEvent event) {
		// System.out.println("controllerUpdate(" + event + ")");
		if (event instanceof RealizeCompleteEvent) {
			if ((visualComponent = thePlayer.getVisualComponent()) != null)
				cp.add(BorderLayout.CENTER, visualComponent);
			/*if ((controlComponent = thePlayer.getControlPanelComponent()) != null)
				cp.add(BorderLayout.SOUTH, controlComponent);*/
			// re-size the main window
			if (parentFrame != null) {
				parentFrame.setSize(720, 610);
				}
		}
	}

	
}

