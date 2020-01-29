/**
 * Twin Eagle game
 * Vinh Corey Ethan
 * Gallatin 1
 * 2018/05/23
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Font;


class EndGame extends JFrame implements KeyListener
{
	private boolean win;
	private JLabel end;
	private JPanel thing;
	
    public EndGame(boolean w) 
    {
    	win = w;
    	setSize(400, 500);
    	setTitle("Twin Eagle");
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	
    	if(win == true)
    	{
    		end = new JLabel("You Win!");
    		end.setForeground(Color.GREEN);
    	}
    	else
    	{
    		end = new JLabel("Game Over");
    		end.setForeground(Color.RED);
    	}
    	end.setFont(new Font("Stencil", Font.BOLD, 30));
    	end.setFont(end.getFont().deriveFont(24.0f));
    	end.addKeyListener(this);
    	end.setFocusable(true);
    	    	
    	thing = new JPanel();
    	thing.add(end);
    	thing.setBackground(Color.BLACK);
    	setLayout(new BorderLayout());
    	add(thing, BorderLayout.CENTER);
    	setVisible(true);
    }
    public void keyTyped(KeyEvent e){}
    /**
     * When a key is pressed, the window becomes invisible and it opens up a TwinEagleMenu
     * @param e the keyEvent to listen for
     */
    public void keyPressed(KeyEvent e){TwinEagleMenu menu = new TwinEagleMenu(); setVisible(false);}
    public void keyReleased(KeyEvent e){}
    
}