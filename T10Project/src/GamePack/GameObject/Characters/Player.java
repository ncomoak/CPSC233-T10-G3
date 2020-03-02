//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 13,14,15,19,21
package GamePack.GameObject.Characters;

import java.awt.Graphics;

import GamePack.Handler;
import GamePack.gfx.Assests;

// The Player
public class Player extends Characters 
{

	public Player(Handler handler, float x, float y)
	{
		super(handler, x, y, Characters.DEFAULT_CHARACTER_WIDTH, Characters.DEFAULT_CHARACTER_HEIGHT);
		
		bounds.x =  0;
		bounds.y =  0;
		bounds.width = Characters.DEFAULT_CHARACTER_WIDTH  - 20;
		bounds.height = Characters.DEFAULT_CHARACTER_HEIGHT - 20;
	}

	//Tick and render Methods
	public void tick() 
	{
		getInput();
		move();
		handler.getGameCamera().centerOnGameObject(this);
	}

	public void render(Graphics g) 
	{
		g.drawImage(Assests.player,(int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width, height, null);
	}
	
	
	// Methods
	
	//gets the KeyBoard input and decides if the play should move.
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
