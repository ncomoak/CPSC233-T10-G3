package GamePack.Tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile 
{
	
	//Static Stuff
	public static Tile[] tiles= new Tile[256];
	public static Tile grass = new grassTile(0);
	public static Tile dirt = new dirtTile(1);
	public static Tile rock = new rockTile(2);
	
	
	//CLASS
	protected BufferedImage texture;
	protected final int id;
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	public Tile(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	//Methods
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
