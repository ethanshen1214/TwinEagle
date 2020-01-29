/**
 * Twin Eagle game
 * Vinh Corey Ethan
 * Gallatin 1
 * 2018/05/23
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Opening window for the game based on a JFrame
 */
class TwinEagle extends JFrame implements KeyListener
{
	private JLabel start;
	private JPanel thing;
	private JPanel bg;
	
	/**
	 * Constructs a window with a background image and a JLabel
	 */
    public TwinEagle() 
    {
    	setSize(400, 500);
    	setTitle("Twin Eagle");
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		
    	start = new JLabel("Press Any Key to Start");
    	start.setFont(start.getFont().deriveFont(24.0f));
    	start.addKeyListener(this);
    	start.setFocusable(true);
    	start.setForeground(Color.YELLOW);
    	
    	thing = new Background();
    	thing.add(start);
    	setLayout(new BorderLayout());
    	add(thing, BorderLayout.CENTER);
    	setVisible(true);
    }
    
    public void keyTyped(KeyEvent e){}
    /**
     * When a key is pressed, the window becomes invisible and it opens up a TwinEagleMenu
     * @param e the keyEvent to listen for
     */
    public void keyPressed(KeyEvent e){TwinEagleMenu menu = new TwinEagleMenu(); setVisible(false);}
    public void keyReleased(KeyEvent e){}
    
}

/**
 * Class for drawing a background image
 */
class Background extends JPanel
{
	private BufferedImage img;
	
	/**
	 * Constructs an image with a jpg file
	 */
	public Background() 
	{
		try
		{
			img = ImageIO.read(getClass().getResource("th.jpg"));
		}
		catch(Exception e){}
	}
	
	/**
	 * paints the component with the image
	 * @param g the graphics
	 */
	public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    	g.drawImage(img, 0, 0, this);
    }
}