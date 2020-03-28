//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 13,15,21,31
package GamePack.GameObject;

import java.awt.Graphics;
import java.awt.Rectangle;

import GamePack.Handler;
// An abstract GameObject in which all entities of the game will inherit. 
public abstract class GameObject 
{
	protected Handler handler;
	
	//Location
	protected float x, y;
	
	//Dimensions
	protected int width, height;
	
	//Collision Bounds
	protected Rectangle bounds;
	
	//Health
	public static final int DEFAULT_HEALTH = 10;
	protected int health;
	
	//If The gameObject is Active (On the Screen)
	protected boolean isActive = true;
	
	//name of the gameObject
	protected String name = "";


	/* Sets up a new GameObject
	* @param Handler, handler. the game handler.
	* @param float, x. the x position of the Game Object.
	* @param float, y. the y position of the Game Object.
	* @param int, width. the width of the display.
	* @param int, height. the height of the display.
	* @return void,
	*/
	public GameObject(Handler handler, float x, float y, int width, int height)  
	{
		this.handler = handler;
		
		this.x = x;
		this.y = y;
		 
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0,0,width, height);
		
		health = DEFAULT_HEALTH;

	}
	
	public GameObject()
	{
		
	}
	
	
	/* The Tick method to be called in the game.
	* @return void,
	*/
	public abstract void tick();
	
	/* The Render method to be called in the game.
	* @return void,
	*/
	public abstract void render(Graphics g);
	
	// TODO Java docs 
	protected abstract void die();
	
	// TODO Java docs 
	public void hurt (int damageAmount)
	{
		health -= damageAmount;
		System.out.println( name + " has been hit, Current Health Value " + health);
		
		// if the GameObject has died
		if(health <= 0)
		{
			setActive(false);
			die();
		}
	}
	
	

	// TODO Java Docs
	//if the GameObject is about to collied any other GameObject returns true
	public boolean checkGameObjectCollision(float xOffset, float yOffset)
	{
		for(GameObject e : handler.getWorld().getGameObjectManger().getGameObjects())
		{
			//if the GameObject it is looking at is it's self. move on to the next GameObject 
			if(e.equals(this))
			{
				continue;
			}
			
			//if the GameObject is about to collied any other GameObject returns true
			if(e.getCollisionBound(0, 0).intersects(getCollisionBound(xOffset, yOffset)))
			{
				return true;	
			}
		}
		return false;
	}
	
	// TODO Java docs 
	public Rectangle getCollisionBound(float xOffset, float yOffset)
	{
		return new Rectangle((int)(x + xOffset), (int)(y + yOffset), bounds.width, bounds.height);
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

	
	/*gets the x position of the Game Object. 
	* @return float, x position of the Game Object.
	*/
	public float getX() 
	{
		return x;
	}
	/*sets the x position of the Game Object.
	* @param float, x. The x position of the Game Object to set.
	* @return void,
	*/
	public void setX(float x) 
	{
		this.x = x;
	}

	/*gets the y position of the Game Object. 
	* @return float, y position of the Game Object.
	*/
	public float getY() 
	{
		return y;
	}
	/*sets the y position of the Game Object.
	* @param float, y. The y position of the Game Object to set.
	* @return void,
	*/
	public void setY(float y)
	{
		this.y = y;
	}

	/*gets the width of the Game Object.  
	* @return int, The width of the Game Object.
	*/
	public int getWidth() 
	{
		return width;
	}
	/*sets the width of the Game Object. 
	* @param int, width. The width of the Game Object.
	* @return void,
	*/
	public void setWidth(int width) 
	{
		this.width = width;
	}

	/*Constructor, gets the height of the Game Object.  
	* @return int, The height of the Game Object.
	*/
	public int getHeight() 
	{
		return height;
	}
	/*sets the height of the Game Object. 
	* @param int, height. The height of the Game Object.
	* @return void,
	*/
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	// TODO Java Docs
	public boolean isActive() 
	{
		return isActive;
	}

	public void setActive(boolean isActive) 
	{
		this.isActive = isActive;
	}
}
