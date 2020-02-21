package GamePack.gfx;

import java.awt.image.BufferedImage;

public class Assests 
{
	public static BufferedImage player;
	public static BufferedImage grass;
	public static BufferedImage dirt;
	public static BufferedImage rock;
	
	public static void init() 
	{
		player = ImageLoader.loadImage("/textures/LC2.png");
		grass =  ImageLoader.loadImage("/textures/grass.jpg");
		dirt =  ImageLoader.loadImage("/textures/dirt.png");
		rock =  ImageLoader.loadImage("/textures/rock.jpg");
	}
}
