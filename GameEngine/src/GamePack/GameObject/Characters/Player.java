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
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 50;
		bounds.height = 50;
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
		xMoveAmount = 0;
		yMoveAmount = 0;
		
		//Move up
		if(handler.getKeyManger().up)
		{
			yMoveAmount = -speed; 
		}
		
		//Move down
		if(handler.getKeyManger().down)
		{
			yMoveAmount = speed; 
		}
		
		//Move Left
		if(handler.getKeyManger().left)
		{
			xMoveAmount = -speed; 
		}
		
		//Move Right
		if(handler.getKeyManger().right)
		{
			xMoveAmount = speed; 
		}
	}
	

}
