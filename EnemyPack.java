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
 * Class for controlling level design and enemies
 */
public class EnemyPack
{
	private ArrayList<Enemy> enemyPack;
	
	/**
	 * Constructs different packs based on the level selected
	 * @param level the level chosen
	 */
	public EnemyPack(int level)
	{
		enemyPack = new ArrayList<Enemy>();
		if(level == 1)
		{
			Enemy one = new Enemy("enemy_plane", 400, -75, 2);
			Enemy two = new Enemy("enemy_plane", 100, -75, 5);
			Enemy three = new Enemy("enemy_plane", 150, -75, 7);
			Enemy four = new Enemy("enemy_plane", 200, -75, 10);
			Enemy five = new Enemy("enemy_plane", 400, -100, 10);
			enemyPack.add(one);
			enemyPack.add(two);
			enemyPack.add(three);
			enemyPack.add(four);
			enemyPack.add(five);
		}
		else if(level  == 2)
		{
			Enemy one = new Enemy("enemy_plane", 300, -75, 2);
			Enemy two = new Enemy("enemy_plane", 100, -75, 5);
			Enemy three = new Enemy("enemy_plane", 234, -75, 7);
			Enemy four = new Enemy("enemy_plane", 470, -75, 10);
			Enemy five = new Enemy("enemy_plane", 50, -100, 10);
			Enemy six = new Enemy("enemy_plane", 200, -75, 2);
			Enemy seven = new Enemy("enemy_plane", 400, -100, 4);
			enemyPack.add(one);
			enemyPack.add(two);
			enemyPack.add(three);
			enemyPack.add(four);
			enemyPack.add(five);
			enemyPack.add(six);
			enemyPack.add(seven);
		}
		else if(level == 3)
		{
			Enemy one = new Enemy("enemy_plane", 300, -75, 2);
			Enemy two = new Enemy("enemy_plane", 100, -75, 5);
			Enemy three = new Enemy("enemy_plane", 234, -75, 7);
			Enemy four = new Enemy("enemy_plane", 470, -75, 10);
			Enemy five = new Enemy("enemy_plane", 50, -100, 10);
			Enemy six = new Enemy("enemy_plane", 200, -75, 2);
			Enemy seven = new Enemy("enemy_plane", 400, -100, 4);
			Enemy eight = new Enemy("enemy_plane", 320, -100, 10);
			Enemy nine = new Enemy("enemy_plane", 10, -75, 6);
			Enemy ten = new Enemy("enemy_plane", 50, -100, 4);
			enemyPack.add(one);
			enemyPack.add(two);
			enemyPack.add(three);
			enemyPack.add(four);
			enemyPack.add(five);
			enemyPack.add(six);
			enemyPack.add(seven);
			enemyPack.add(eight);
			enemyPack.add(nine);
			enemyPack.add(ten);
		}
	}
	
	/**
	 * Starts everything moving
	 */
	public void startAll()
	{
		for(Enemy e: enemyPack)
			e.startTime();
	}
	
	/**
	 * Tells the enemies to shoot the ship
	 * @param the ship to shoot at
	 */
	public void shootAll(Ship ship)
	{
		if(ship!=null)
		{
			for(Enemy e: enemyPack)
			e.shoot(ship);
		}
		
	}
	
	/**
	 * Draws eveything
	 * @param window the graphics
	 */
	public void drawAll(Graphics window)
	{
		for(Enemy e: enemyPack)
			e.draw(window);
	}
	
	/**
	 * Draws all the bullets
	 * @param window the graphics
	 */
	public void drawAllBullets(Graphics window)
	{
		for(Enemy e: enemyPack)
		{	
			for(int i = 0; i < e.getBullets().getList().size(); i++)
			{
				if(e.getBullets().getList().get(i) != null)
				{
					e.getBullets().getList().get(i).draw(window);
				}
			}
		}
	}
	
	/**
	 * Moves all the bullets
	 */
	public void moveAllBullets()
	{
		for(Enemy e: enemyPack)
		{
			for(int i = 0; i < e.getBullets().getList().size(); i++)
			{
				e.getBullets().getList().get(i).move();
			}
		}
	}
	
	/**
	 * Moves the enemies
	 */
	public void moveAll()
	{
		for(Enemy e: enemyPack)
			e.move();
	}
	
	/**
	 * Clears the bullets
	 */
	public void clearBullets()
	{
		for(Enemy e: enemyPack)
		{
			for(int i = 0; i < e.getBullets().getList().size(); i++)
			{
				if(e.getBullets().getList().get(i) != null)
				{
					if(e.getBullets().getList().get(i).getY() > 850 || e.getBullets().getList().get(i).getY() < 0)
						e.getBullets().getList().remove(i);
				}
			}
		}
	}
	
	/**
	 * Clears the dead enemies
	 * @param bullets the arraylist of bullets look for collision
	 */
	public void clearDead(ArrayList<Bullet> bullets)
	{
		for(int i = 0; i < enemyPack.size(); i++)
		{
			for(int j = 0; j < bullets.size(); j++)
			{
				if(enemyPack.get(i).getY() >= 0 && bullets.get(j).getY() >= enemyPack.get(i).getY() && bullets.get(j).getY() <= enemyPack.get(i).getY()+84 && bullets.get(j).getX() >= enemyPack.get(i).getX() && bullets.get(j).getX() <= enemyPack.get(i).getX()+84)
				{
					enemyPack.remove(i);
					bullets.remove(j);
				}
			}
		}
	}
	
	/**
	 * Stops the enemy from moving too far off the screen
	 */
	public void clearInactive()
	{
		for(Enemy e: enemyPack)
		{
			if(e.getY() > 850)
				e.setActive(false);
		}
	}
	
	/**
	 * Updates the position and state of everything
	 * @param ship the ship to update
	 */
	public void updateAll(Ship ship)
	{
		if(ship!=null)
		{
			for(Enemy e: enemyPack)
			{
				e.setShipX(ship.getX());
				e.setShipY(ship.getY());
				if(e.getY()>850)
					e.setActive(false);
			}
		}
		
	}
	
	/**
	 * Collision detection for the player
	 * @param ship the ship to check
	 * @return whether the player was hit
	 */
	public boolean checkPlayerHit(Ship ship)
	{
		for(int i = 0; i < enemyPack.size(); i++)
		{
			for(int j = 0; j < enemyPack.get(i).getBullets().getList().size(); j++)
			{
				if(enemyPack.get(i).getBullets().getList().get(j).getY() >= ship.getY() && enemyPack.get(i).getBullets().getList().get(j).getY() <= ship.getY()+68 && enemyPack.get(i).getBullets().getList().get(j).getX() >= ship.getX() && enemyPack.get(i).getBullets().getList().get(j).getX()<=ship.getX()+42)
				{
					enemyPack.get(i).getBullets().getList().remove(j);
					return true;
				}
			}
		}
		return false;
	}
}