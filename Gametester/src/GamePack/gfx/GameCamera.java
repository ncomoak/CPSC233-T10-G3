package GamePack.gfx;

import GamePack.Game;
import GamePack.Handler;
import GamePack.GameObject.GameObject;
import GamePack.Tiles.Tile;

public class GameCamera 
{
	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler,float xOffest, float yOffset)
	{
		this.handler = handler;
		this.xOffset = xOffest;
		this.yOffset = yOffset;
	}
	
	//Methods
	public void move(float xAmt, float yAmt)
	{
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	
	public void checkBlankSpace() 
	{
		if(xOffset < 0) 
		{
			xOffset = 0;
		}
		else if (xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()) 
		{
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
		
		if(yOffset < 0) 
		{
			yOffset = 0;
		}
		else if (yOffset > handler.getWorld().getHeight()* Tile.TILEHEIGHT - handler.getHeight()) 
		{
			yOffset = handler.getWorld().getHeight()* Tile.TILEHEIGHT - handler.getHeight();
		}
	}
	
	public void centerOnGameObject(GameObject e)
	{
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth()/2;
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight()/2;
		
		checkBlankSpace();
	}
	
	
	
	//Getters and Setters
	public float getxOffset()
	{
		return xOffset;
	}
	public void setxOffset(float xOffset) 
	{
		this.xOffset = xOffset;
	}

	
	public float getyOffset() 
	{
		return yOffset;
	}
	public void setyOffset(float yOffset) 
	{
		this.yOffset = yOffset;
	}
	
	
}
