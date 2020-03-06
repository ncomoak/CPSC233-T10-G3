//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 13,14,15,19,21,22,23
package GamePack.GameObject.Characters;

import java.awt.Graphics;

import GamePack.Handler;
import GamePack.gfx.Assests;

// The Player
public class Player extends Characters 
{
	
	/* Sets up a new Player
	* @param Handler, handler. the game handler.
	* @param float, x. the x position of the Game Object.
	* @param float, y. the y position of the Game Object.
	* @return void,
	*/
	public Player(Handler handler, float x, float y)
	{
		super(handler, x, y, Characters.DEFAULT_CHARACTER_WIDTH, Characters.DEFAULT_CHARACTER_HEIGHT);
		
		bounds.x =  0;
		bounds.y =  0;
		bounds.width = Characters.DEFAULT_CHARACTER_WIDTH  - 20;
		bounds.height = Characters.DEFAULT_CHARACTER_HEIGHT - 20;
	}

	/* This Method is called every frame and is used for all the logic 
	* @return void,
	*/
	public void tick() 
	{
		getInput();
		move();
		handler.getGameCamera().centerOnGameObject(this);
	}
	
	/* This Method is called every frame and it show the  renders all the graphics.
	* @return void,
	*/
	public void render(Graphics g) 
	{
		g.drawImage(Assests.player,(int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width, height, null);
	}
	
	
	// Methods
	
	/*gets the KeyBoard input and decides if the play should move.  
	* @return void, 
	*/
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		
		//Move up
		if(handler.getKeyManger().up)
		{
			yMove = -speed; 
		}
		
		//Move down
		if(handler.getKeyManger().down)
		{
			yMove = speed; 
		}
		
		//Move Left
		if(handler.getKeyManger().left)
		{
			xMove = -speed; 
		}
		
		//Move Right
		if(handler.getKeyManger().right)
		{
			xMove = speed; 
		}
	}
	

}
