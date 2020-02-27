package GamePack.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//checks if a certain key has been pressed
public class KeyManger implements KeyListener
{
	//list of keys
	private boolean[] keys;

	public boolean up,down, left,right;
	
	public void tick() 
	{
		//set to true if any of these keys have been press 
		up = keys[KeyEvent.VK_W];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		down = keys[KeyEvent.VK_S];
	}
	
	public KeyManger ()
	{
		//Initializes the array of keys
		keys = new boolean[256];
	}
	public void keyTyped(KeyEvent e) 
	{
		
	}

	public void keyPressed(KeyEvent e)
	{
		//checks if a key has been pressed
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) 
	{
		//checks if a key has been released
		keys[e.getKeyCode()] = false;
	}
	
}
