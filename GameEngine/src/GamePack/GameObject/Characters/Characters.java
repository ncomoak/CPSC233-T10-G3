package GamePack.GameObject.Characters;

import GamePack.Handler;
import GamePack.GameObject.GameObject;
import GamePack.Tiles.Tile;
//An living creature in the game will inherit this abstract class
public abstract class Characters extends GameObject
{
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 5.0f;
	public static final int DEFAULT_CHARACTER_WIDTH = 54;
	public static final int DEFAULT_CHARACTER_HEIGHT = 54;
	
	protected int health;
	protected float speed;
	protected float xMoveAmount, yMoveAmount;	
	

	public Characters(Handler handler,float x, float y, int width, int height) 
	{
		super(handler,x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMoveAmount = 0;
		yMoveAmount = 0;
	}
	
	//Methods
	
	//Movement
	public void move()
	{
		moveX();
		moveY();
	}
	
	public void moveX() 
	{
		if(xMoveAmount > 0) //moving right
		{
			//Checks for collision in the upper and lower right hand side of the bounds  
			int tx = (int) (x + xMoveAmount + bounds.x + bounds.width) / Tile.TILEWIDTH;
			if(!collionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) && !collionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
			{
				//Moves the Character right
				x += xMoveAmount;
			}
			else
			{
				// Puts the character up against the tile 
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
		}
		else if(xMoveAmount < 0)//moving left
		{
			//Checks for collision in the upper and lower left hand side of the bounds 
			int tx = (int) (x + xMoveAmount + bounds.x) / Tile.TILEWIDTH;
			if(!collionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) && !collionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
			{
				//Moves the Character left
				x += xMoveAmount;
			}
			else
			{
				// Puts the character up against the tile 
				x = tx * Tile.TILEWIDTH  + Tile.TILEWIDTH - bounds.x;
			}
		}
	}
	public void moveY() 
	{
		if(yMoveAmount < 0) //moving up
		{
			//Checks for collision in the left and right top side of the bounds 
			int ty = (int) (y + yMoveAmount + bounds.y) / Tile.TILEHEIGHT;
			if(!collionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, ty) && !collionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
			{
				//Moves the Character up
				y += yMoveAmount;
			}
			else
			{
				// Puts the character up against the tile 
				y = ty * Tile.TILEHEIGHT  + Tile.TILEHEIGHT - bounds.y;
			}
		}
		else if(yMoveAmount > 0)//moving down
		{
			//Checks for collision in the left and right Bottom side of the bounds 
			int ty = (int) (y + yMoveAmount + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			if(!collionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, ty) && !collionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
			{
				//Moves the Character down
				y += yMoveAmount;
			}
			else
			{
				// Puts the character up against the tile 
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}
	
	//Checks if there is a collision with a given tile
	protected boolean collionWithTile(int x, int y)
	{
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	
	//Getters and Setters 
	public int getHealth() 
	{
		return health;
	}
	public void setHealth(int health) 
	{
		this.health = health;
	}


	public float getSpeed() 
	{
		return speed;
	}
	public void setSpeed(float speed) 
	{
		this.speed = speed;
	}


	public float getxMove() 
	{
		return xMoveAmount;
	}
	public void setxMove(float xMoveAmount) 
	{
		this.xMoveAmount = xMoveAmount;
	}


	public float getyMove() 
	{
		return yMoveAmount;
	}
	public void setyMove(float yMoveAmount) 
	{
		this.yMoveAmount = yMoveAmount;
	}
}
