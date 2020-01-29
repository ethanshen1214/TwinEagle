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

public class Enemy
{
	private Image image;
	private int x;
	private int y;
	private String type;
	public boolean isActive;
	private int delay;
	private int bulletDelay;
	private EnemyBullets bullets;
	private int shipX;
	private int shipY;
	
	
	public static final int SPEED = 1; // add speed as instance field for power ups
	public static int MOVE_COUNT = 0;
	public static boolean MOVE_CHOSEN_LEFT = false;
	public static boolean MOVE_CHOSEN_RIGHT = false;
	
	public Enemy(String t, int x, int y, int d)
	{
		type = t;
		isActive = false;
		try
		{
			image = ImageIO.read(new File(type+".png"));
		}
		catch(Exception e) {}
		this.x = x;
		this.y = y;
		delay = d * 1000;
		//bulletDelay = (int) (1 + Math.random()*3) * 1000;
		bulletDelay = 1000;
		bullets = new EnemyBullets();
	}
	

	
	public void move()
	{
		if(isActive)
		{
			if(MOVE_COUNT >= 25)
				MOVE_COUNT = 0;
			y = y + SPEED;
			if(MOVE_COUNT == 0)
			{
				if(Math.random() > 0.5)
				{
					MOVE_CHOSEN_LEFT = true;
					MOVE_CHOSEN_RIGHT = false;
					MOVE_COUNT++;
				}
				else
				{
					MOVE_CHOSEN_LEFT = false;
					MOVE_CHOSEN_RIGHT = true;
					MOVE_COUNT++;
				}
			}
			else
			{
				if(MOVE_CHOSEN_LEFT)
				{
					x = x - SPEED;
					MOVE_COUNT++;
				}
				else
				{
					x = x + SPEED;
					MOVE_COUNT++;
				}
			}			
		}
	}
	
	public void draw(Graphics window)
	{
		window.drawImage(image, x, y, null);
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setActive(boolean b)
	{
		isActive = b;
	}
	
	public int getDelay()
	{
		return delay;
	}
	
	public void startTime()
	{
		Timer timer = new Timer();
		timer.schedule(new EnemyTask(), delay);
	}
	class EnemyTask extends TimerTask
	{
		public void run()
		{
			setActive(true);
		}
	}
	
	public EnemyBullets getBullets()
	{
		return bullets;
	}
	
	public void shoot(Ship ship)
	{
		Timer timer = new Timer();
		timer.schedule(new ShootTask(), delay,  bulletDelay);
		shipX = ship.getX();
		shipY = ship.getY();	
	}
	
	class ShootTask extends TimerTask
	{
		public void run()
		{
			if(isActive)
				bullets.add(new EnemyBullet(getX()+25, getY()+30, shipX+20, shipY+30));
	
			
		}
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
	
	/**
	 * Sets the x position
	 * @param x the new x position
	 */
	public void setShipX(int x)
	{
		shipX = x;
	}
	
	/**
	 * Sets the y position
	 * @param y the new y position
	 */
	public void setShipY(int y)
	{
		shipY = y;
	}
}