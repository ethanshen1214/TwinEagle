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
import java.util.Timer;

/**
 * Class for maintaining the actions of the enemy bullets
 */
public class EnemyBullet
{
	private Image image;
	private int x;
	private int y;
	private int tX;
	private int tY;
	private int xInc;
	private int yInc;
	
	/**
	 * Constructs a bullet using coordinates
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param tx the change in x
	 * @param ty the change in y
	 */
	public EnemyBullet(int x, int y, int tx, int ty)
	{
		try
		{
			image = ImageIO.read(new File("enemybullet.png"));
		}
		catch(Exception e) {}
		this.x = x;
		this.y = y;
		tX = tx;
		tY = ty;
		xInc = (tX - x);
		yInc = (tY - y);
		double angle = Math.atan2(xInc, yInc);
		xInc = (int) (5 * Math.sin(angle));
		yInc = (int) (5 * Math.cos(angle));
		
	}
	
	/**
	 * Draws the window
	 * @param window the graphic to draw
	 */
	public void draw(Graphics window)
	{
		window.drawImage(image, x, y, 10, 10, null);
	}
	
	/**
	 * Moves the bullet
	 */
	public void move()
	{
		x = x + xInc;
		y = y + yInc;
	}
	
	/**
	 * Returns the x coordinate
	 * @return the x coordinate
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * Returns the y coordinate
	 * @return the y coordinate
	 */
	public int getY()
	{
		return y;
	}
	
}