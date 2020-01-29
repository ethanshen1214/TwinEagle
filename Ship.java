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
 * Class that controls the ship
 */
public class Ship
{
	private Image image;
	private int x;
	private int y;
	private boolean left, right, up, down, hit;
	
	public static final int SPEED = 2; // add speed as instance field for power ups
	
	/**
	 * Constructs a ship with defaults
	 */
	public Ship()
	{
		left = right = up = down = false;
		try
		{
			image = ImageIO.read(new File("ship.png"));
		}
		catch(Exception e) {}
		x = 100;
		y = 600;
		hit = false;
	}
	
	/**
	 * Draws the ship
	 * @param window the graphics
	 */
	public void draw(Graphics window)
	{
		window.drawImage(image, x, y, null);
		if(left)
			x-=SPEED;
		if(right)
			x+=SPEED;
		if(up)
			y-=SPEED;
		if(down)
			y+=SPEED;
		
	}
	
	/**
	 * moves the ship left
	 * @param b whether or not to move left
	 */
	public void setLeft(boolean b)
	{
		left = b;
	}
	
	/**
	 * moves the ship right
	 * @param b whether or not to move right
	 */
	public void setRight(boolean b)
	{
		right = b;
	}
	
	/**
	 * moves the ship up
	 * @param b whether or not to move up
	 */
	public void setUp(boolean b)
	{
		up = b;
	}
	
	/**
	 * moves the ship down
	 * @param b whether or not to move down
	 */
	public void setDown(boolean b)
	{
		down = b;
	}
	
	/**
	 * returns the x position
	 * @return the x position
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * returns the y position
	 * @return the y position
	 */
	public int getY()
	{
		return y;
	}
}