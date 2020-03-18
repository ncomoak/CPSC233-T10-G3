//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 9
package GamePack.gfx;

import java.awt.image.BufferedImage;
// Loads and initializes all the assets for the game 
public class Assests 
{
	//Player
		public static BufferedImage player;
	
	//Enemy
	public static BufferedImage enemy;
	
	// portal texture 
	public static BufferedImage portal0;
	public static BufferedImage portal1;
	public static BufferedImage portal2;
	public static BufferedImage portal3;
	public static BufferedImage portal4;
	public static BufferedImage portal5;
	public static BufferedImage portal6;
	public static BufferedImage portal7;
	public static BufferedImage portal8;
	
	public static BufferedImage dirt;
	public static BufferedImage rock;
	/*loads images. No parameters or return types. 
	*
	*/
	public static void init() 
	{
		//Player
		player = ImageLoader.loadImage("/textures/CharacterTexture/playerTextures/Player.png");
		
		//Enemy
		enemy = ImageLoader.loadImage("/textures/CharacterTexture/enemyTextures/Enemy.png");
		
		// portal texture 
		portal0 =  ImageLoader.loadImage("/textures/portalTexture/portal0.jpg");
		portal1 =  ImageLoader.loadImage("/textures/portalTexture/portal1.jpg");
		portal2 =  ImageLoader.loadImage("/textures/portalTexture/portal2.jpg");
		portal3 =  ImageLoader.loadImage("/textures/portalTexture/portal3.jpg");
		portal4 =  ImageLoader.loadImage("/textures/portalTexture/portal4.jpg");
		portal5 =  ImageLoader.loadImage("/textures/portalTexture/portal5.jpg");
		portal6 =  ImageLoader.loadImage("/textures/portalTexture/portal6.jpg");
		portal7 =  ImageLoader.loadImage("/textures/portalTexture/portal7.jpg");
		portal8 =  ImageLoader.loadImage("/textures/portalTexture/portal8.jpg");


		dirt =  ImageLoader.loadImage("/textures/tileTexture/Dirt.png");
		rock =  ImageLoader.loadImage("/textures/tileTexture/Rock.png");
	}
}
