/**
 * Twin Eagle game
 * Vinh Corey Ethan
 * Gallatin 1
 * 2018/05/23
 */
 
import javax.swing.*;
import java.awt.*;


/**
 * The class that runs the game
 */
public class TwinEagleGame extends JFrame 
{
	private Battlefield component;
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 850;
	
	/**
	 * Constructs the game
	 */
	public TwinEagleGame()
	{
		super("Twin Eagle");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		component = new Battlefield(this);
		add(component, BorderLayout.CENTER);
		component.setFocusable(true);
		setVisible(true);
	}	
}