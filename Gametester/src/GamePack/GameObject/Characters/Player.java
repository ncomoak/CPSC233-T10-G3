package GamePack.GameObject.Characters;

import java.awt.Graphics;

import GamePack.Game;
import GamePack.Handler;
import GamePack.GameObject.GameObject;
import GamePack.gfx.Assests;

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
	
	
	//Main Methods
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManger().up)
		{
			yMove = -speed; 
		}
		if(handler.getKeyManger().down)
		{
			yMove = speed; 
		}
		if(handler.getKeyManger().left)
		{
			xMove = -speed; 
		}
		if(handler.getKeyManger().right)
		{
			xMove = speed; 
		}
	}
	

}
