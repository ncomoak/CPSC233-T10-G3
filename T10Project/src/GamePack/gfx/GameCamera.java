package GamePack.gfx;

<<<<<<< Updated upstream
=======
import GamePack.Game;
>>>>>>> Stashed changes
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
	//Moves the game Camera
	public void move(float xAmt, float yAmt)
	{
		//Moves the camera left and right 
		xOffset += xAmt;
		yOffset += yAmt;
		//Checks and makes sure the camera does not move into a blank space;
		checkBlankSpace();
	}
	
	// Checks and makes sure the camera does not move into a blank space;
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
	
	//Centers the camera on the players location
	public void centerOnGameObject(GameObject Player)
	{
		xOffset = Player.getX() - handler.getWidth() / 2 + Player.getWidth()/2;
		yOffset = Player.getY() - handler.getHeight() / 2 + Player.getHeight()/2;
		
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
