package GamePack.Tiles;

public class Tile 
{
	//all Tiles in the game 
	public static Tile[] tiles= new Tile[256];
	public static Tile grass = new grassTile(0);
	public static Tile dirt = new dirtTile(1);
	public static Tile rock = new rockTile(2);
	
	
	//CLASS
	//it's id 
	protected final int id;
	
	public Tile(int id)
	{
		this.id = id;
		
		tiles[id] = this;
	}
	
	//Methods
	//check if the tile can be walked on
	public boolean isSolid()
	{
		return false;
	}
	
	//Getter and setter
	public int getID()
	{
		return id;
	}
}
