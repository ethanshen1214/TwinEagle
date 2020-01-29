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

public class BulletQueue
{
	private Timer timer;
	private LinkedList <Bullet> bullets;
	private LinkedList<Bullet> bulletDisplay;
	
	public static int SECONDS = 1;
	public static int BULLET_COUNT = 0;
	public static int MAX_BULLETS = 10;
	public static int NUM_BULLETS = 0;
	
	public BulletQueue()
	{
		bullets = new LinkedList<Bullet>();
		bulletDisplay = new LinkedList<Bullet>();
	}
	
	public void fillBullets()
	{
		timer = new Timer();
		timer.schedule(new BulletTask(), 1000, SECONDS * 1000);
	}
	
	public LinkedList<Bullet> getBulletQueue()
	{
		return bullets;
	}
	
	public void draw(Graphics window)
	{
		for(int i = 0; i < bulletDisplay.size(); i++)
		{
			Bullet temp = bulletDisplay.get(i);
			temp.setX(i*50 + 10);
			temp.setY(700);
			temp.draw(window);
		}
	}
	
	public Bullet removeBullet()
	{
		if(NUM_BULLETS > 0)
			NUM_BULLETS--;
		bulletDisplay.pollFirst();
		return bullets.pollFirst();
	}
	class BulletTask extends TimerTask
	{
		public void run()
		{
			if(NUM_BULLETS < MAX_BULLETS)
			{
				Bullet temp;
				Bullet temp2; // temp display bullet
				BULLET_COUNT++;
				if(BULLET_COUNT == 3)
				{
					temp = new Bullet("strong");
					temp2 = new Bullet("strong_display");
					BULLET_COUNT = 0;
				}
				else
				{
					temp = new Bullet("basic");
					temp2 = new Bullet("basic_display");
				}	
				bullets.add(temp);
				bulletDisplay.add(temp2);
				NUM_BULLETS++;	
			}
					
		}
	}
}