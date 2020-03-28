package GamePack.World;

import java.io.IOException;

import GamePack.Input.KeyManger;
import GamePack.MazeAi.*;
import GamePack.Tiles.Tile;
import GamePack.utils.Utils;

// the state in which the player plays the game 
public class GameState 
{
	private int width, height;
	private int playerX = 1;
	private int playerY = 1;
	private int[][] worldTiles;
	
	private int mazeWidth = 5;
	private int mazeHeight = 5;
	
	private MazeGeneration mazeGeneration;
	
	private KeyManger keyManger;

	private String player = "0";
	private Display display;
	
	public GameState(String path)
	{
		loadWorld(path);
		keyManger = new KeyManger();
	}
	
	
	//Tick and render Method
	public void tick()
	{
		String direction = keyManger.tick();
		if(direction == "w" && playerY != 0) {
			if(worldTiles[playerX][playerY - 1] == 1) {
				playerX--;
			}
		}
		else if(direction == "s" && playerY != height - 1) {
			if(worldTiles[playerX + 1][playerY] == 1) {
				playerX++;
			}
		}
		else if(direction == "a" && playerX != 0) {
			if(worldTiles[playerX][playerY - 1] == 1) {
				playerY--;
			}
		}
		else if(direction == "d" && playerY != width - 1 ) {
			if(worldTiles[playerX][playerY+ 1] == 1) {
				playerY++;
			}
		}
		
	}
	
	public void render()
	{	
		// render out the world and player movement 
		Display.render(worldTiles, playerX, playerY);
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


	public int getplayerX() 
	{
		return playerX;
	}
	public void setplayerX(int playerX) 
	{
		this.playerX = playerX;
	}


	public int getplayerY() 
	{
		return playerY;
	}
	public void setplayerY(int playerY) 
	{
		this.playerY = playerY;
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
