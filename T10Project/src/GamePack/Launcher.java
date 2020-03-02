//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 1

package GamePack;

import java.io.IOException;

//Launches the game 
public class Launcher 
{
	public static void main(String[] args) throws IOException
	{	
		Game game = new Game("T10 Project Test", 1080, 720);
		game.start();
	}
}
