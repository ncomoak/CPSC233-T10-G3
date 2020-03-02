//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 11
package GamePack.States;

import java.awt.Graphics;

import GamePack.Handler;

//an abstract Sate class
public abstract class State 
{
	
	private static State currentState = null;
	
	//Getters and Setters
	public static void setState(State state)
	{
		currentState = state;
	}
	
	public static State getState() 
	{
		return currentState;
	}
	
	//Class
	protected  Handler handler;
	
	public State (Handler handler)
	{
		this.handler = handler;
	}
	
	//Tick and Render Methods
	public abstract void tick();		
	
	public abstract void render(Graphics g);
}
