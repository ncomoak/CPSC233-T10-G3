//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 16
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