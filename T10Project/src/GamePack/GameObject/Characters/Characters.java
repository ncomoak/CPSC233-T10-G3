//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 13,15,21,22
package GamePack.GameObject.Characters;

import GamePack.Handler;
import GamePack.GameObject.GameObject;
import GamePack.Tiles.Tile;
//An living creature in the game will inherit this abstract class
public abstract class Characters extends GameObject
{
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 5.0f;
	public static final int DEFAULT_CHARACTER_WIDTH = 43*2;
	public static final int DEFAULT_CHARACTER_HEIGHT = 58*2;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;	
	
	
	/*Constructor, sets up a new Characters
	* @param Handler, handler. the game handler.
	* @param float, x. the x position of the Game Object.
	* @param float, y. the y position of the Game Object.
	* @param int, width. the width of the display.
	* @param int, height. the height of the display.
	* @return void,
	*/
	public Characters(Handler handler,float x, float y, int width, int height) 
	{
		super(handler,x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	
	
	//Methods
	
	public Characters() 
	{
		// TODO Auto-generated constructor stub
	}



	/* Handles X and Y Movement 
	* @return void,
	*/
	public void move()
	{
		moveX();
		moveY();
	}
	
	/* Handles X  Movement 
	* @return void,
	*/
	public void moveX() 
	{
		if(xMove > 0) //moving right
		{
			//Checks for collision in the upper and lower right hand side of the bounds  
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			if(!collionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) && !collionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
			{
				//Moves the Character right
				x += xMove;
			}
			else
			{
				// Puts the character up against the tile 
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
		}
		else if(xMove < 0)//moving left
		{
			//Checks for collision in the upper and lower left hand side of the bounds 
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			if(!collionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) && !collionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
			{
				//Moves the Character left
				x += xMove;
			}
			else
			{
				// Puts the character up against the tile 
				x = tx * Tile.TILEWIDTH  + Tile.TILEWIDTH - bounds.x;
			}
		}
	}
	
	/* Handles Y  Movement 
	* @return void,
	*/
	public void moveY() 
	{
		if(yMove < 0) //moving up
		{
			//Checks for collision in the left and right top side of the bounds 
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			if(!collionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, ty) && !collionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
			{
				//Moves the Character up
				y += yMove;
			}
			else
			{
				// Puts the character up against the tile 
				y = ty * Tile.TILEHEIGHT  + Tile.TILEHEIGHT - bounds.y;
			}
		}
		else if(yMove > 0)//moving down
		{
			//Checks for collision in the left and right Bottom side of the bounds 
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			if(!collionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, ty) && !collionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
			{
				//Moves the Character down
				y += yMove;
			}
			else
			{
				// Puts the character up against the tile 
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}
	
	
	/* Checks if there is a collision with a given tile.
	* @param int, x. checks if there is a collision in the x.
	* @param int, y. checks if there is a collision in the y.
	* @return boolean, checks if there is a collision with a given tile.
	*/
	protected boolean collionWithTile(int x, int y)
	{
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	
	//Getters and Setters
	
	/*gets the health of the Character.  
	* @return int, The health of the Character.
	*/
	public int getHealth() 
	{
		return health;
	}
	/*sets the health of the Character. 
	* @param int, health. The health of the Character.
	* @return void,
	*/
	public void setHealth(int health) 
	{
		this.health = health;
	}

	
	/*gets the speed of the Character.  
	* @return float, The speed of the Character.
	*/
	public float getSpeed() 
	{
		return speed;
	}
	/*sets the speed of the Character. 
	* @param float, health. The health of the Character.
	* @return void,
	*/
	public void setSpeed(float speed) 
	{
		this.speed = speed;
	}

	/*gets the x move amount of the Character.  
	* @return float, The the x move amount of the Character.
	*/
	public float getxMove() 
	{
		return xMove;
	}
	/*sets the  the x move amount of the Character. 
	* @param float, xMove. The  the x move amount of the Character.
	* @return void,
	*/
	public void setxMove(float xMove) 
	{
		this.xMove = xMove;
	}

	/*gets the y move amount of the Character.  
	* @return float, The the y move amount of the Character.
	*/
	public float getyMove() 
	{
		return yMove;
	}
	/*sets the  the y move amount of the Character. 
	* @param float, yMove. The  the y move amount of the Character.
	* @return void,
	*/
	public void setyMove(float yMove) 
	{
		this.yMove = yMove;
	}
}
