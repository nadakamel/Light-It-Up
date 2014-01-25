import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ImagedPane extends JPanel{
	public JList list;
    private BufferedImage background;
    private final JLabel back = new JLabel("");

    public ImagedPane(String[] v) {
        
        list = new JList(v);
    	initGUI();
    }
    private void initGUI() {
    	
        setLayout(new BorderLayout());
    	try {
    	    background = ImageIO.read(new File("C:/Users/Essraa/Desktop/glitter/final/list.png"));
    	} catch (IOException ex) {
    	    ex.printStackTrace();
    	}
    	list.setOpaque(false);
    	list.setBackground(new Color(0, 0, 0, 0));
    	list.setForeground(Color.WHITE);
    	list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    	list.setLayoutOrientation(JList.VERTICAL);
    	list.setVisibleRowCount(-1);
    	JScrollPane scrollPane = new JScrollPane(list);
    	scrollPane.setOpaque(false);
    	scrollPane.getViewport().setOpaque(false);
    	
    	        add(scrollPane);
    	JButton Add = new JButton();
    }
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (background != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                int x = getWidth() - background.getWidth();
                int y = getHeight() - background.getHeight();
                g2d.drawImage(background, x, y, this);
                g2d.dispose();
            }
}
    }
