//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 16
package GamePack.Tiles;
// a Tile Class for 
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile 
{
	
	//all Tiles in the game 
	public static Tile[] tiles= new Tile[256];
	public static Tile grass = new grassTile(0);
	public static Tile dirt = new dirtTile(1);
	public static Tile rock = new rockTile(2);
	
	
	//CLASS
	//Tiles texture
	protected BufferedImage texture;
	//it's id 
	protected final int id;
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	public Tile(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	//Methods
	//check if the tile can be walked on
	public boolean isSolid()
	{
		return false;
	}
	
	//Tick and render Method
	public void tick()
	{
		
	}
	
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	
	//Getter and setter
	public int getID()
	{
		return id;
	}
}
