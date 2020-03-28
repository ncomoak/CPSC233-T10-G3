package GamePack.MazeAi;

//creates a brand new maze 
import java.io.IOException;

public class MazeGenerationText 
{
	/*Constructor the MazeGenerationText class
	 * @String path, path for maze data file
	 * @int mazeWidth
	 * @int mazeHeight
	 */
	public MazeGenerationText(String path, int mazeWidth, int mazeHeight)
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
