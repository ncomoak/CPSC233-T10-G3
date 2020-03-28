package GamePack.Tiles;


public class rockTile extends Tile 
{
	public rockTile(int id) 
	{
		super(id);
	}
	
	public boolean isSolid()
	{
		return true;
	}
}