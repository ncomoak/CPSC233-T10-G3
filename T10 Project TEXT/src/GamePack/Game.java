package GamePack;


import GamePack.Input.KeyManger;
import GamePack.World.GameState;


// The main Game Class
public class Game 
{
	//Set Up
	public String title;
	
	private GameState gameState;

	private boolean gameIsRunning;
	
	private String MazeDataPath =  "Worlds/MazeData.txt";

	
	//This Method initializes all of the variables needed.
	private void init() 
	{	
		gameState = new GameState(MazeDataPath);
	}
	
	// This Method is called Every frame and is used for all the logic 
	private void tick()
	{		
		gameState.tick();
	}	
	
	
	//GameLoop
	public void run() 
	{
		init();
		
		//The main Game Loop
		while (gameIsRunning) 
		{ 
			tick();
			render();	
		}
		
		System.out.println("Game Closed");
	}
	
	
	//renders the graphics of the game 
	private void render() 
	{
		gameState.render();
	}

	public void start() 
	{
		System.out.println("Game Opened");
		gameIsRunning = true;
		run();
	}
}
