package GamePack;

import java.io.IOException;

//Launches the game 
public class Launcher 
{
	public static void main(String[] args) throws IOException
	{	
		Game game = new Game("Test", 1280, 720);
		game.start();
	}
}
