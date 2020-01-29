/**
 * Twin Eagle game
 * Vinh Corey Ethan
 * Gallatin 1
 * 2018/05/23
 */
 
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Timer;
import javax.swing.JOptionPane;

public class Battlefield extends JComponent implements Runnable, KeyListener
{
	private ScrollingBackground background;
	private Thread thread;
	private Ship playerOne;
	private boolean oneIsShooting;
	private BulletQueue bulletQueue;
	private UsedBullets usedBullets;
	private EnemyPack pack;
	private boolean playerHit;
	private JFrame parentFrame;
	
	public static final int TIMER_DELAY = 5;
	
	public Battlefield(String f)
	{
		
	}
	
	public Battlefield(JFrame frame)
	{
		background = new ScrollingBackground();
		playerOne = new Ship();
		oneIsShooting = false;
		bulletQueue = new BulletQueue();
		bulletQueue.fillBullets();
		pack = new EnemyPack(1);
		pack.startAll();
		usedBullets = new UsedBullets();
		pack.shootAll(playerOne);
		thread = new Thread(this);
		thread.start();
		addKeyListener(this);
		playerHit = false;
		parentFrame = frame;
	}
	
	public void paintComponent(Graphics g)
	{		
		if(!playerHit && oneIsShooting)
		{
			Bullet temp = bulletQueue.removeBullet();
			if(temp!=null)
			{
				temp.setX(playerOne.getX() + 13);
				temp.setY(playerOne.getY());
				usedBullets.add(temp);
			}
			oneIsShooting = false;
		}
		background.draw(g);
		background.move();
		pack.drawAll(g);
		pack.moveAll();
		

		pack.drawAllBullets(g);
		pack.moveAllBullets();
		pack.clearInactive();
		pack.updateAll(playerOne);
		
		if(!playerHit && pack.checkPlayerHit(playerOne))
		{
			playerOne = null;
			playerHit = true;
			parentFrame.dispose();
			JOptionPane.showMessageDialog(null, "YOU LOSE!");
		}
			
			
		
		usedBullets.drawAll(g);
		usedBullets.moveAll();
		usedBullets.clearAll();
		bulletQueue.draw(g);
		pack.clearDead(usedBullets.getList());
		if(playerOne != null)
			playerOne.draw(g);
		
		
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				Thread.sleep(TIMER_DELAY);
				repaint();
			}
		}
		catch(Exception e) {}
	}
	
	public void keyTyped(KeyEvent e) {}
	
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			playerOne.setLeft(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			playerOne.setRight(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			playerOne.setUp(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			playerOne.setDown(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			oneIsShooting = true;
		}
	}

	/**
	 * Updates the keys array based on the key that was released
	 * @param e the KeyEvent representing the released key
	 */
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			playerOne.setLeft(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			playerOne.setRight(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			playerOne.setUp(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			playerOne.setDown(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			oneIsShooting = false;
		}
	}
}