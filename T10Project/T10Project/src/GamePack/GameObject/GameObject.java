package GamePack.GameObject;

import java.awt.Graphics;
import java.awt.Rectangle;

import GamePack.Game;
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
	
	public GameObject(Handler handler, float x, float y, int width, int height)  
	{
		this.handler = handler;
		
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0,0,width, height);
	}
	
	//Tick and Render methods 
	public abstract void tick();
	
	public abstract void render(Graphics g);

	//Getters and Setters
	public float getX() 
	{
		return x;
	}
	public void setX(float x) 
	{
		this.x = x;
	}

	
	public float getY() 
	{
		return y;
	}
	public void setY(float y)
	{
		this.y = y;
	}

	
	public int getWidth() 
	{
		return width;
	}
	public void setWidth(int width) 
	{
		this.width = width;
	}

	
	public int getHeight() 
	{
		return height;
	}
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	
}
