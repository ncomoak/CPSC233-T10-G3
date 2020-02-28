package GamePack.World;

import java.io.IOException;

import GamePack.Input.KeyManger;
import GamePack.MazeAi.*;
import GamePack.Tiles.Tile;
import GamePack.utils.Utils;

public class GameState 
{
	private int width, height;
	private int spawnX, spawnY;
	private int[][] worldTiles;
	
	private int mazeWidth = 5;
	private int mazeHeight = 5;
	
	private MazeGeneration mazeGeneration;
	
	private KeyManger keyManger;

	private String player = "0";
	
	public GameState(String path)
	{
		loadWorld(path);
		keyManger = new KeyManger();
	}
	
	
	//Tick and render Method
	public void tick()
	{
		keyManger.tick();
	}
	
	public void render()
	{	
		// render out the world and player movement 
		for(int i = 0; i<width; i++)
		{
		    for(int j = 0; j<height; j++)
		    {
		        System.out.print(worldTiles[i][j]);
		    }
		    System.out.println();
		}
	}
		
	
	private void loadWorld(String path)
	{
		//creates the maze 
		mazeGeneration = new MazeGeneration(path, mazeWidth, mazeHeight);
		
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
