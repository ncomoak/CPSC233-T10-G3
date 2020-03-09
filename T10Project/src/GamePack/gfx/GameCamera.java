//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 19,24
package GamePack.gfx;

import GamePack.Handler;
import GamePack.GameObject.GameObject;
import GamePack.Tiles.Tile;

public class GameCamera 
{
	private Handler handler;
	private float xOffset, yOffset;
	/*Constructor for the GameCamera Class. 
	*@param Handler handler
	*@param xOffset current xOffset to follow player.
	*@param yOffset current yOffset to follow player. 
	*/
	public GameCamera(Handler handler,float xOffest, float yOffset)
	{
		this.handler = handler;
		this.xOffset = xOffest;
		this.yOffset = yOffset;
	}
	
	/*Moves the camera left or right. 
	*@param float xAmt, how much you want to move camera to right. 
	*@param float yAmt, how much you want to move the camera to the left. 
	*/
	public void move(float xAmt, float yAmt)
	{
		//Moves the camera left and right 
		xOffset += xAmt;
		yOffset += yAmt;
		//Checks and makes sure the camera does not move into a blank space;
		checkBlankSpace();
	}
	
	/* Checks and makes sure the camera does not move into a blank space. No return types or parameters. 
	*/
	public void checkBlankSpace() 
	{
		//Checks and centers the top left corner
		if(xOffset < 0) 
		{
			xOffset = 0;
		}
		//Checks and centers the bottom left corner
		else if (xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()) 
		{
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
		
		//Checks and centers the top right corner
		if(yOffset < 0) 
		{
			yOffset = 0;
		}
		//Checks and centers the bottom right corner
		else if (yOffset > handler.getWorld().getHeight()* Tile.TILEHEIGHT - handler.getHeight()) 
		{
			yOffset = handler.getWorld().getHeight()* Tile.TILEHEIGHT - handler.getHeight();
		}
	}
	
	/*Centers camera on players location. 
	*@param GameObject Player 
	*/
	public void centerOnGameObject(GameObject Player)
	{
		xOffset = Player.getX() - handler.getWidth() / 2 + Player.getWidth()/2;
		yOffset = Player.getY() - handler.getHeight() / 2 + Player.getHeight()/2;
		
		checkBlankSpace();
	}
	
	
	
	/*returns player's xOffset
	*@return float xOffset
	*/
	public float getxOffset()
	{
		return xOffset;
	}
	/*sets player's xOffset. 
	*@param float xOffset 
	*/
	public void setxOffset(float xOffset) 
	{
		this.xOffset = xOffset;
	}

	/*returns player's yOffset
	*@return float yOffset
	*/
	public float getyOffset() 
	{
		return yOffset;
	}
	/*sets player's yOffset
	*@param float yOffset
	*/
	public void setyOffset(float yOffset) 
	{
		this.yOffset = yOffset;
	}
	
	
}
