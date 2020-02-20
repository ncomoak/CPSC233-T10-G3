package GamePack;

import java.util.ArrayList;

import GamePack.MazeAl.Maze;
import GamePack.MazeAl.MazeBlock;

public class Launcher 
{
	public static void main(String[] args)
	{
		Game game = new Game("Test", 1280, 720);
		game.start();
		
		ArrayList<MazeBlock> mb = new ArrayList<MazeBlock>();
		
		
		
		Maze maze = new Maze(10,10);
		maze.recursiveMaze(0, 0, mb);
		maze.drawMaze();
		
	}
}
