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
 * Class for maintaining the collection of enemy bullets
 */
public class EnemyBullets
{
	private ArrayList<EnemyBullet> bullets;
		
		/**
		 * Makes an arraylist of enemy bullets
		 */
		public EnemyBullets()
		{
			bullets = new ArrayList<EnemyBullet>();
		}
		
		/**
		 * Adds an enemy bullet
		 * @param e the bullet to add
		 */
		public void add(EnemyBullet e)
		{
			bullets.add(e);
		}
		
		/**
		 * Returns the list of bullets
		 * @return the list of bullets
		 */
		public ArrayList<EnemyBullet> getList()
		{
			return bullets;
		}
}