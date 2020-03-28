package GamePack.World;

//creates a brand new maze 
import java.io.IOException;

import GamePack.MazeAi.Maze;

public class MazeGeneration 
{
	public MazeGeneration(String path, int mazeWidth, int mazeHeight)
	{
		String MazeDataPath =  "res/Worlds/MazeData.txt";
		try
		{
			Maze maze = new Maze(mazeWidth, mazeHeight, MazeDataPath);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
}
