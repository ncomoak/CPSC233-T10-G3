package GamePack;

import GamePack.Input.KeyManger;
import GamePack.World.World;
import GamePack.gfx.GameCamera;

public class Handler 
{
	private Game game;
	private World world;
	 
	public Handler(Game game)
	{
		this.game = game;
	}
	
	
	//Methods
	
	
	//Getters and Setters
	public Game getGame()
	{
		return game;
	}
	public void setGame(Game game) 
	{
		this.game = game;
	}


	public World getWorld() 
	{
		return world;
	}
	public void setWorld(World world) 
	{
		this.world = world;
	}
	
	
	public int getWidth()
	{
		return game.getWidth();
	}
	public int getHeight()
	{
		return game.getHeight();
	}
	
	
	public KeyManger getKeyManger()
	{
		return game.getKeyManger();
	}
	
	
	public GameCamera getGameCamera()
	{
		return game.getGameCamera();
	}
	
}
