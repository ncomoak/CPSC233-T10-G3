//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 16
package GamePack.Tiles;
// a Tile Class for 
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import GamePack.Tiles.PortalTiles.portalTile0;

public class Tile 
{ 
	
	//all Tiles in the game 
	public static Tile[] tiles= new Tile[256];
	public static Tile portal = new portalTile0(0);
	public static Tile dirt = new dirtTile(1);
	public static Tile rock = new rockTile(2);
	
	
	//CLASS
	//Tiles texture
	protected BufferedImage texture;
	//it's id 
	protected final int id;
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	/*Constructor for Tile
	 * @param BufferedImage texture, takes an image to display on screen
	 * @param id, takes a given id depending on weather tile is dirt, portal, rock, etc. 
	 */
	public Tile(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	/*Checks to see if tile can be walked on. 
	 * @return False. 
	 */
	public boolean isSolid()
	{
		return false;
	}
	
	/*Tick method. 
	 * 
	 */
	public void tick()
	{
		
	}
	/*Render method, to draw a tile. 
	 * @param Graphics g, takes a graphics context. 
	 * @param int x takes x position of tile
	 * @param int y takes y position of tile
	 */
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	
	/*Getter method for id
	 * @return id
	 */
	public int getID()
	{
		return id;
	}
}
