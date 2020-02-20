package GamePack.Tiles;

import GamePack.gfx.Assests;

public class rockTile extends Tile 
{

	public rockTile(int id) 
	{
		super(Assests.rock, id);
	}
	
	public boolean isSolid()
	{
		return true;
	}
}