/**
 * Twin Eagle game
 * Vinh Corey Ethan
 * Gallatin 1
 * 2018/05/23
 */
 
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * Class that controls the background
 */
public class ScrollingBackground
{
	private Image image;
	private int x;
	private int y;
	private int delayCount;
	
	/**
	 * Constructs a background using an image file
	 */
	public ScrollingBackground()
	{
		delayCount = 0;
		try
		{
			image = ImageIO.read(new File("unblurred-grass.png"));
		}
		catch(Exception e) {}
		x = 0;
		y = -850;
		
	}
	
	/**
	 * Draws the background
	 * @param window the graphics
	 */
	public void draw(Graphics window)
	{
		window.drawImage(image, x, y, null);
	}
	
	/**
	 * Scrolls the background
	 */
	public void move()
	{
		delayCount++;
		if(delayCount == 7)
		{
			y = y + 1;
			delayCount = 0;
		}
		if(y == 0)
			delayCount = 11;
	}
}