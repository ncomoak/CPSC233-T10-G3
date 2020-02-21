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
