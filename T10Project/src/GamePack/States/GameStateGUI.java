//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 11,13,16,17,18,21
package GamePack.States;

import java.awt.Graphics;
import java.io.IOException;

import GamePack.Handler;
import GamePack.GameObject.Characters.Player;
import GamePack.MazeAi.Maze;
import GamePack.World.World;

// this is the state where the gameplay will happen
public class GameStateGUI extends State
{
	private Player player;
	private World world;
	
	private int mazeWidth = 5;
	private int mazeHeight = 5;
	/*Constructor which creates a new game state with a fully generated maze object, world and player.
	*@param Handler handler
	*/
	public GameStateGUI(Handler handler) 
	{
		super(handler);
		
		//Creates a new randomly generated maze
		String MazeDataPath =  "res/Worlds/MazeData.txt";
		try
		{
			Maze maze = new Maze(mazeWidth, mazeHeight, MazeDataPath);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		//Initializes and sets world
		world = new World(handler, MazeDataPath);
		handler.setWorld(world);
		
		//Initializing the player
		player = new Player(handler, world.getSpawnX(), world.getSpawnY());
	}

	
	/*Calls world and player tick methods. No return types. 
	*
	*/
	public void tick() 
	{
		world.tick();
		player.tick();
	}
	/*Render's player and world. 
	*
	*/

	public void render(Graphics g) 
	{
		world.render(g);
		player.render(g);
	}
	
	

}
