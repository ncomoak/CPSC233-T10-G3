//https://www.youtube.com/watch?v=Vmpe6mht3qE&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=8

package GamePack.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet)
	{
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int height)
	{
		return sheet.getSubimage(x, y, width, height);
	}

}
