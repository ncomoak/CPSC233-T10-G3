package GamePack.World;

import java.awt.Graphics;
import GamePack.Handler;
import GamePack.Tiles.Tile;
import GamePack.utils.Utils;

public class World 
{
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] worldTiles;
	
	public World(Handler handler, String path)
	{
		this.handler = handler;
		//creates the world
		loadWorld(path);	
	}
	
	
	//Tick and render Method
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		int xStart = (int)Math.max(0, handler.getGameCamera().getxOffset()/ Tile.TILEWIDTH);
		int xEnd =  (int)Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth())/ Tile.TILEWIDTH + 1);
		int yStart = (int)Math.max(0, handler.getGameCamera().getyOffset()/ Tile.TILEHEIGHT);
		int yEnd = (int)Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight())/ Tile.TILEHEIGHT + 1);
		
		//renders all the tiles 
		for(int y = yStart; y < yEnd; y++)
		{
			for(int x = xStart; x < xEnd; x++)
			{
				getTile(x, y).render(g, (int)(x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}
		
	
	private void loadWorld(String path)
	{
		//gets the world file as a String 
		String file = Utils.loadFileAsString(path);
		//Splits the strings into an array list
		String [] tokens = file.split("\\s+");
		
		//get the width, height, spawn X and y position
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		//adds tiles to the worldtTiles array
		worldTiles = new int [width][height];
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				worldTiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]); 
			}
		}
		
	}
	
	
	//Getters and Setters
	public Tile getTile(int x, int y)
	{
		
		if(x < 0 || y < 0 || x >= width || y >= height)
		{
			return Tile.grass;
		}
		
		Tile t = Tile.tiles[worldTiles[x][y]];
		// if the tile is null returns dirt on default
		if(t == null)
		{
			return Tile.dirt;
		}
		return t;
	}


	public int getSpawnX() 
	{
		return spawnX;
	}
	public void setSpawnX(int spawnX) 
	{
		this.spawnX = spawnX;
	}


	public int getSpawnY() {
		return spawnY;
	}
	public void setSpawnY(int spawnY) 
	{
		this.spawnY = spawnY;
	}


	public int getWidth() 
	{
		return width;
	}


	public int getHeight() 
	{
		return height;
	}
}
