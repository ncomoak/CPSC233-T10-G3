package GamePack;

import java.io.IOException;
import java.util.ArrayList;

import GamePack.MazeAl.Maze;
import GamePack.MazeAl.MazeBlock;

public class Launcher 
{
	public static void main(String[] args) throws IOException
	{	
		Game game = new Game("Test", 1280, 720);
		game.start();
		
		
	}
}
