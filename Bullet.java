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
 * Class for controlling bullet movement
 */
public class Bullet
{
	private int x;
	private int y;
	private String type;
	private Image image;
	private int speed;
	
	/**
	 * Constructs a bullet using an image file
	 * @param t the type of bullet
	 */
	public Bullet(String t)
	{
		type = t;
		x = -1;
		y = -1;
		try
		{
			image = ImageIO.read(new File(type+".png"));
		}
		catch(Exception e) {}
		speed = 5;
	}
	
	/**
	 * Constructs a bullet using an image file
	 * @param t the type
	 * @param x the x position
	 * @param y the y position
	 */
	public Bullet(String t, int x, int y)
	{
		type = t;
		this.x = x;
		this.y = y;
		try
		{
			image = ImageIO.read(new File(type+".png"));
		}
		catch(Exception e) {}
		speed = 1;
	}
	
	/**
	 * Moves the bullet
	 */
	public void move()
	{
		y = y - speed;
	}
	
	/**
	 * Draws the bullet 
	 * @param window the graphics
	 */
	public void draw(Graphics window)
	{
		window.drawImage(image, x, y, null);
	}
	
	/**
	 * Returns the string version of the bullet
	 * @return the string version of the bullet
	 */
	public String toString()
	{
		return type + " bullet";
	}
	
	/**
	 * returns the y position
	 * @return the y position
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * sets the x position
	 * @param x the x position to set
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**
	 * sets the y position
	 * @param y the y position to set
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
	/**
	 * returns the x position
	 * @return the x position
	 */
	public int getX()
	{
		return x;
	}
}