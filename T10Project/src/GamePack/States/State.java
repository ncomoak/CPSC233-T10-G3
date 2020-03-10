//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 11
package GamePack.States;

import java.awt.Graphics;

import GamePack.Handler;

//an abstract Sate class
public abstract class State 
{
	 
	private static State currentState = null;
	
	/*Setter method for state
	 * @param State state, sate to set. 
	 */
	public static void setState(State state)
	{
		currentState = state;
	}
	/*Getter method for state. 
	 * @return State currentState. 
	 */
	public static State getState() 
	{
		return currentState;
	}
	
	//Class
	protected  Handler handler;
	/*Constructor for state.
	 */
	public State (Handler handler)
	{
		this.handler = handler;
	}

	/*Abstract Tick method. 
	 * 
	 */
	public abstract void tick();		
	/*Abstract Render Method. 
	 * 
	 */
	public abstract void render(Graphics g);
}
