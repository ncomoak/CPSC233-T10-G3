//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 13,15,21
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

	//Getters and Setters
	
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
}
