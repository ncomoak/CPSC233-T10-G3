package GamePack.States;

import java.awt.Graphics;

import GamePack.Game;
import GamePack.Handler;
import GamePack.GameObject.Characters.Player;
import GamePack.Tiles.Tile;
import GamePack.World.World;
import GamePack.gfx.Assests;

public class GameState extends State
{
	private Player player;
	private World world;
	
	public GameState(Handler handler) 
	{
		super(handler);
		world = new World(handler,"res/Worlds/WorldOne.txt");
		handler.setWorld(world);
		
		player = new Player(handler, world.getSpawnX(), world.getSpawnY());
	}

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
