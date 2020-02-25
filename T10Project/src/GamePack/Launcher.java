package GamePack;

import java.io.IOException;

//Launches the game 
public class Launcher 
{
	public static void main(String[] args) throws IOException
	{	
		Game game = new Game("T10 Project Test", 360, 720);
		game.start();
	}
}
