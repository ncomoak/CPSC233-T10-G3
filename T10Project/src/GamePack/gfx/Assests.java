package GamePack.gfx;

import java.awt.image.BufferedImage;
// Loads and initializes all the assets for the game 
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
<<<<<<< Updated upstream
		dirt =  ImageLoader.loadImage("/textures/Dirt.png");
=======
		dirt =  ImageLoader.loadImage("/textures/dirt.png");
>>>>>>> Stashed changes
		rock =  ImageLoader.loadImage("/textures/rock.jpg");
	}
}
