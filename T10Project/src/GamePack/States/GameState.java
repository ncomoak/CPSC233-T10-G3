package GamePack.States;

import java.awt.Graphics;
import java.io.IOException;

import GamePack.Handler;
import GamePack.GameObject.Characters.Player;
import GamePack.MazeAl.Maze;
import GamePack.World.World;

// this is the state where the gameplay will happen
public class GameState extends State
{
	private Player player;
	private World world;
	
	private int mazeWidth = 5;
	private int mazeHeight = 5;
	
	public GameState(Handler handler) 
	{
		super(handler);
		
		//Creates a new randomly generated maze
		String MazeDataPath =  "res/Worlds/WorldOne.txt";
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

	
	//Tick and Render Methods 
	public void tick() 
	{
		world.tick();
		player.tick();
	}

	public void render(Graphics g) 
	{
		world.render(g);
		player.render(g);
	}
	
	

}
