package GamePack.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManger implements KeyListener
{
	private boolean[] keys;
	public boolean up,down, left,right;
	
	public void tick() 
	{
		up = keys[KeyEvent.VK_W];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		down = keys[KeyEvent.VK_S];
	}
	
	public KeyManger ()
	{
		keys = new boolean[256];
	}
	public void keyTyped(KeyEvent e) 
	{
		
	}

	public void keyPressed(KeyEvent e)
	{
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) 
	{
		keys[e.getKeyCode()] = false;
	}
	
}
