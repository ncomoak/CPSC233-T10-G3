//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 17,18,19,20,22,24,26
package GamePack.World;

import java.awt.Graphics;

import GamePack.Game;
import GamePack.Handler;
import GamePack.GameObject.GameObjectManger;
import GamePack.GameObject.Characters.Player;
import GamePack.GameObject.Characters.Monsters.Monster;
import GamePack.Tiles.Tile;
import GamePack.utils.Utils;

public class World 
{
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY; 
	private int[][] worldTiles;
	
	//GameObjects
	private GameObjectManger gameObjectManger;
	
	/*Constructor for world
	 * @param Handler handler
	 * @param String path, path for a world file. 
	 */
	public World(Handler handler, String path)
	{
		this.handler = handler;
		gameObjectManger = new GameObjectManger(handler, new Player(handler, 100,100));
		
		
		
		//creates the world
		loadWorld(path);
		
		//add enemy. 
		int testEnemyX = 0;
		int testEnemyY = 0;
		for(int x = 0; x < worldTiles.length; x++) {
			for(int y = 0; y < worldTiles[x].length; y++) {
				if(worldTiles[x][y] == 6 ) {
					testEnemyX = x*64;
					testEnemyY = y*64;
				}
			}
		}
		Monster testEnemy = new Monster(handler, testEnemyX, testEnemyY,10,10,10);
		
		gameObjectManger.addGameObject(testEnemy);
		gameObjectManger.getPlayer().setX(spawnX);
		gameObjectManger.getPlayer().setY(spawnY);
	}
	
	
	/*tick method. 
	 * 
	 */
	public void tick()
	{
		gameObjectManger.tick();
		
	}
	/*Renders all of the tiles in the world file
	 * @param Graphic g, graphics context. 
	 */
	
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
		
		//GameObjects
		gameObjectManger.render(g);
	}
		
	/*Loads world File
	 * @param String path, path for the worldfile. 
	 */
	private void loadWorld(String path)
	{
		if(!Game.devTestMode)
		{
			populateWorldTiles(path);
		}
		else
		{
			populateWorldTiles("res/Worlds/TestWorld.txt");
		}
		
		
	}
	
	private void populateWorldTiles(String path)
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
	
	
	/*Getter method for tile
	 * @param int x, x coordinate of the tile you want. 
	 * @param int y, y coordinate of the tile you want. 
	 * @return Tile
	 */
	public Tile getTile(int x, int y)
	{
		
		if(x < 0 || y < 0 || x >= width || y >= height)
		{
			return Tile.dirt;
		}
		
		Tile t = Tile.tiles[worldTiles[x][y]];
		// if the tile is null returns dirt on default
		if(t == null)
		{
			return Tile.dirt;
		}
		return t;
	}

	/*Getter method for spawnX
	 * @return spawnX.
	 */
	public int getSpawnX() 
	{
		return spawnX;
	}
	/*Setter method for spawnX
	 * @param spawnX
	 */
	public void setSpawnX(int spawnX) 
	{
		this.spawnX = spawnX;
	}

	/*Getter method for spawnY
	 * @return spawnY
	 */
	public int getSpawnY() {
		return spawnY;
	}
	/*Setter method for SpawnY
	 * @param spawnY
	 */
	public void setSpawnY(int spawnY) 
	{
		this.spawnY = spawnY;
	}

	/*Getter method for width of world tiles
	 * @return width
	 */
	public int getWidth() 
	{
		return width;
	}

	/*Getter method for height of world tiles
	 * @return height
	 */
	public int getHeight() 
	{
		return height;
	}

	// TODO
	public GameObjectManger getGameObjectManger() 
	{
		return gameObjectManger;
	}

	//TODO java docs
	public int[][] getWorldTiles() 
	{
		return worldTiles;
	}		
}
