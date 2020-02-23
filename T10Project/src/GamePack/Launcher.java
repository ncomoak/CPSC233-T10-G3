package GamePack;

import java.io.IOException;
import java.util.ArrayList;

import GamePack.MazeAi.Maze;
import GamePack.MazeAi.MazeBlock;

//Launches the game 
public class Launcher 
{
	public static void main(String[] args) throws IOException
	{	
		Game game = new Game("T10 Project Test", 1280, 720);
		game.start();
	}
}
