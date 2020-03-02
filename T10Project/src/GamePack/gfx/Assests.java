//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 9
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
		dirt =  ImageLoader.loadImage("/textures/Dirt.png");
		rock =  ImageLoader.loadImage("/textures/rock.jpg");
	}
}
