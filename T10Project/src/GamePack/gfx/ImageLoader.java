//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 7
package GamePack.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//Loads Images when given the path
public class ImageLoader 
{
	public static BufferedImage loadImage(String path)
	{
		try 
		{
			return ImageIO.read(ImageLoader.class.getResource(path));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.exit(1);
		}
		
		return null;
	}
}
