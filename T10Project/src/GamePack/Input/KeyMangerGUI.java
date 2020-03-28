//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 14
package GamePack.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//checks if a certain key has been pressed
public class KeyMangerGUI implements KeyListener
{
	//list of keys
	private boolean[] keys;
	//MOVEMENT
	public boolean up,down, left,right;
	//ATTACK
	public boolean attackUp, attackDown, attackLeft, attackRight;
	
	
	/*Checks to see if any keys have been pressed. No return types or parameters. 
	*/
	public void tick() 
	{
		//MOVMENT
		up = keys[KeyEvent.VK_W];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		down = keys[KeyEvent.VK_S];
		
		//ATTACK
		attackUp = keys[KeyEvent.VK_UP];
		attackDown = keys[KeyEvent.VK_DOWN];
		attackLeft = keys[KeyEvent.VK_LEFT];
		attackRight = keys[KeyEvent.VK_RIGHT];
	}
	/*Constructor to initizalize an array of keys. 
	*/
	public KeyMangerGUI ()
	{
		keys = new boolean[256];
	}

	/*event handler for keyBeing typed.
	 * 
	 */
	public void keyTyped(KeyEvent e) 
	{
		
	}
	/*Checks to see if any given key has been pressed.
	*@Param KeyEvent e, a key to check if it's being pressed.
	*/
	public void keyPressed(KeyEvent e)
	{
		//checks if a key has been pressed
		keys[e.getKeyCode()] = true;
	}
	/*Checks to see any given key has been released. 
	*@Param KeyEvent e, a key to check if it's been released. 
	*/
	public void keyReleased(KeyEvent e) 
	{
		//checks if a key has been released
		keys[e.getKeyCode()] = false;
	}
	
}
