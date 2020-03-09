//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 21
package GamePack;

import GamePack.Input.KeyManger;
import GamePack.World.World;
import GamePack.gfx.GameCamera;

//Gives us important components for the game.
public class Handler 
{
	private Game game;
	private World world;
	 
	/*Constructor, sets up a new Handler
	* @param String, title. the title of the window.
	* @param int, width. the width of the display.
	* @return void,
	*/
	public Handler(Game game)
	{
		this.game = game;
	}
	
	
	//Methods
	
	
	//Getters and Setters
	
	/*gets the Game class
	* @return Game,the Game.
	*/
	public Game getGame()
	{
		return game;
	}
	
	/*sets the Game class
	* @param Game, game.
	* @return void,
	*/
	public void setGame(Game game) 
	{
		this.game = game;
	}

	/*gets the World class
	* @return World,the current World that the player is on.
	*/
	public World getWorld() 
	{
		return world;
	}
	/*sets the World class
	* @param World, world.
	* @return void,
	*/
	public void setWorld(World world) 
	{
		this.world = world;
	}
	
	/*gets the width of the game
	* @return int,the width.
	*/
	public int getWidth()
	{
		return game.getWidth();
	}
	/*gets the height of the game
	* @return int,the height.
	*/
	public int getHeight()
	{
		return game.getHeight();
	}
	
	/*gets the KeyManger
	* @return canvas,the KeyManger.
	*/
	public KeyManger getKeyManger()
	{
		return game.getKeyManger();
	}
	
	/*gets the GameCamera
	* @return GameCamera,the GameCamera.
	*/
	public GameCamera getGameCamera()
	{
		return game.getGameCamera();
	}
	
}
