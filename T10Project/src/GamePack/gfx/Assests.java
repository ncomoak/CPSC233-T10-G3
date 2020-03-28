//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 9
package GamePack.gfx;

import java.awt.image.BufferedImage;
// Loads and initializes all the assets for the game 
public class Assests 
{
	//Player
	//public static BufferedImage player;
	public static BufferedImage[] player_move;
	
	//Enemy
	//public static BufferedImage enemy;
	public static BufferedImage[] enemy_move;
	
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
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet/spritesheet.png"));
		
		//Player
		//player = sheet.crop(92, 0, 25, 48);
		player_move = new BufferedImage[2];
		
		player_move[0] = sheet.crop(118, 0, 27, 48);
		player_move[1] = sheet.crop(145, 0, 26, 47);
		
		//Enemy
		//enemy = sheet.crop(176, 0, 65, 73);
		enemy_move = new BufferedImage[2];
		
		enemy_move[0] = sheet.crop(244, 0, 50, 74);
		enemy_move[1] = sheet.crop(297, 0, 44, 73);
		
		// portal texture 
		portal0 =  sheet.crop(0, 73, 44, 44);
		portal1 =  sheet.crop(45, 73, 44, 44);
		portal2 =  sheet.crop(90, 73, 44, 44);
		portal3 =  sheet.crop(0, 118, 44, 44);
		portal4 =  sheet.crop(45, 118, 44, 44);
		portal5 =  sheet.crop(90, 118, 44, 44);
		portal6 =  sheet.crop(0, 163, 44, 44);
		portal7 =  sheet.crop(45, 163, 44, 44);
		portal8 =  sheet.crop(90, 163, 44, 44);


		dirt =  sheet.crop(0, 0, 44, 44);
		rock =  sheet.crop(44, 0, 48, 48);
	}
}
