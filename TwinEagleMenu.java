/**
 * Twin Eagle game
 * Vinh Corey Ethan
 * Gallatin 1
 * 2018/05/23
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Container;
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Menu for the Twin Eagle game made from a jFrame
 */
public class TwinEagleMenu extends JFrame implements ActionListener
{
	private JButton play;
	private JButton help;
	private JButton levels;
	private JButton quit;
	private JPanel game;
	
	/**
	 * Constructs a JFrame that has four options 
	 */
    public TwinEagleMenu() 
    {	
    	setTitle("Twin Eagle");
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	
    	game = new Background();
    	game.setLayout(new BoxLayout(game, BoxLayout.Y_AXIS));
    	play = new JButton("Play");
    	help = new JButton("Help");
    	levels = new JButton("Level Select");
    	quit = new JButton("Quit");
    	
    	play.addActionListener(this);
    	help.addActionListener(this);
    	levels.addActionListener(this);
    	quit.addActionListener(this);
    	
    	play.setMaximumSize(new Dimension(150, 30));
    	help.setMaximumSize(new Dimension(150, 30));
    	levels.setMaximumSize(new Dimension(150, 30));
    	quit.setMaximumSize(new Dimension(150, 30));
    	
    	game.add(Box.createRigidArea(new Dimension(0,300)));
    	game.add(play);
    	game.add(Box.createRigidArea(new Dimension(0,5)));
    	game.add(levels);
    	game.add(Box.createRigidArea(new Dimension(0,5)));
    	game.add(help);
    	game.add(Box.createRigidArea(new Dimension(0,5)));
    	game.add(quit);
    	
    	play.setAlignmentX(Component.CENTER_ALIGNMENT);
    	help.setAlignmentX(Component.CENTER_ALIGNMENT);
    	levels.setAlignmentX(Component.CENTER_ALIGNMENT);
    	quit.setAlignmentX(Component.CENTER_ALIGNMENT);
    	
    	play.setAlignmentY(Component.CENTER_ALIGNMENT);
    	help.setAlignmentY(Component.CENTER_ALIGNMENT);
    	levels.setAlignmentY(Component.CENTER_ALIGNMENT);
    	quit.setAlignmentY(Component.CENTER_ALIGNMENT);
    	
    	
    	
    	setSize(400, 500);
    	add(game);
    	setVisible(true);
    }
    
    /**
     * Determines what to do when the buttons are clicked.
     * "Quit" closes the program
     * "Help" opens a help dialog to explain the game
     * "Play" starts the game on a given level
     * "Level Select" allows the user to choose a level before playing
     * @param e the action to listen for
     */
    public void actionPerformed(ActionEvent e)
    {
    	String menuName = e.getActionCommand();
    	
    	if (menuName.equals("Quit"))
    		System.exit(0);
    	else if(menuName.equals("Help"))
    	{
    		ImageIcon icon = new ImageIcon("images.png");
    		JOptionPane.showMessageDialog(null, String.format("Twin Eagle is a top-down, scrolling, arcade shooter. Players take control of an attack \nhelicopter and must advance through multiple levels by defeating enemies as they\ncome. The player starts with a basic attack and can power up their bullets as the game\nprogresses by picking up special power up boxes."), "Help", JOptionPane.INFORMATION_MESSAGE, icon);
    		JOptionPane.showMessageDialog(null, String.format("Either the arrow keys or the WASD keys can be used to move the helicopter and the space bar will fire the bullets.\nBullets are only reloaded every “x” seconds depending on the level chosen, and they cannot continuously fire."), "Help", JOptionPane.INFORMATION_MESSAGE, icon);
    		JOptionPane.showMessageDialog(null, String.format("Certain power-ups are available during the game. To activate a powerup, the user must shoot the power-up, which upon \nbeing shot will activate instantly."), "Help", JOptionPane.INFORMATION_MESSAGE, icon);
    	}
    	else if(menuName.equals("Play"))
    	{
    		TwinEagleGame thing = new TwinEagleGame();
    	}
    	else if(menuName.equals("Level Select"))
    	{
    		ImageIcon icon = new ImageIcon("images.png");
    		Object[] possibilities = {"Level 1", "Level 2", "Level 3"};
			String s = (String)JOptionPane.showInputDialog(null,"Choose a level: ", "Level Select", JOptionPane.PLAIN_MESSAGE, icon, possibilities, possibilities[0]);
			//System.out.println (s);
			
			//TwinEagleFrame game = new TwinEagleFrame(s);
    	}
    }
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