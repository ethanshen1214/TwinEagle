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
 * Controls the used bullets
 */
public class UsedBullets
{
	private ArrayList<Bullet> bullets;
	
	/**
	 * Creates an arraylist of used bullets
	 */
	public UsedBullets()
	{
		bullets = new ArrayList<Bullet>();
	}
	
	/**
	 * Adds bullets
	 * @param b the bullet to add
	 */
	public void add(Bullet b)
	{
		bullets.add(b);
	}
	
	/**
	 * Draws everything
	 * @param window the graphics
	 */
	public void drawAll(Graphics window)
	{
		for(Bullet b: bullets)
			b.draw(window);
	}
	
	/**
	 * Moves the bullets
	 */
	public void moveAll()
	{
		for(Bullet b: bullets)
			b.move();
	}
	
	/**
	 * Clears the bullets
	 */
	public void clearAll()
	{
		for(int i = 0; i < bullets.size(); i++)
			if(bullets.get(i).getY() < 0)
				bullets.remove(i);
	}
	
	/**
	 * Returns the list of bullets
	 * @return the list of bullets
	 */
	public ArrayList<Bullet> getList()
	{
		return bullets;
	}
	
	
}