//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 3,4,5,6,7,9,10,12,14,15,19,21,24
package GamePack;

import java.awt.*;
import java.awt.image.BufferStrategy;
import GamePack.Input.KeyMangerGUI;
import GamePack.States.GameStateGUI;
import GamePack.States.GameStateText;
import GamePack.States.State;
import GamePack.gfx.Assests;
import GamePack.gfx.DisplayGUI;
import GamePack.gfx.GameCamera;

// The main Game Class
public class Game implements Runnable 
{
	//Set Up
	private DisplayGUI displayGUI;
	private int width,height;
	public String title;
	
	//Graphics and rendering 
	private Thread thread;
	private boolean gameIsRunning = false;
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	
	//Input
	private KeyMangerGUI keyMangerGUI;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	
	//TextBased Version
	public boolean isTextBased = false;
	private String MazeDataPathText =  "res/Worlds/MazeData.txt";
	private GameStateText gameStateText;

	
	
	/*Constructor, sets up a new Game 
	* @param String, title. the title of the window.
	* @param int, width. the width of the display.
	* @return void,
	*/
	public Game(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		
		keyMangerGUI = new KeyMangerGUI();
	}
	
	
	
	/* This Method initializes all of the variables needed.
	* @return void,
	*/
	private void init() 
	{	
		if(!isTextBased)
		{
			//Creating a display and adding a keyLister
			displayGUI = new DisplayGUI(title, width, height);
			displayGUI.getFrame().addKeyListener(keyMangerGUI);
			
			//initializing all the assets
			Assests.init();

			//initializing all the Game Handler 
			handler = new Handler(this);
			
			//initializing a new camera
			gameCamera = new GameCamera(handler,0, 0);
			
			
			//initializing the States 
			gameState = new GameStateGUI(handler);
			State.setState(gameState);
		}
		else
		{
			//Text Based 
			gameStateText = new GameStateText(MazeDataPathText);
		}
	}
	
	
	/* This Method is called every frame and is used for all the logic 
	* @return void,
	*/
	private void tick()
	{
		if(!isTextBased)
		{
			//Input Check
			keyMangerGUI.tick();
			
			//Running the States
			if(State.getState() != null)
			{
				State.getState().tick();
			}
		}
		else
		{
			//text based
			gameStateText.tick();	
		}
	}	

	
	/* This Method is called every frame and it show the  renders all the graphics.
	* @return void,
	*/
	private void render()
	{
		if(!isTextBased)
		{
			//The bs(Buffer Strategy is getting the canvas to draw on )
			bs = displayGUI.getCanvas().getBufferStrategy();
			if(bs == null)
			{
				displayGUI.getCanvas().createBufferStrategy(3);
				return;
			}
			g = bs.getDrawGraphics();
			
			//Clears Screen
			g.clearRect(0, 0, width, height);
			
			//draws the graphics  here
			if(State.getState() != null)
			{
				State.getState().render(g);
			}
			
			//End Drawing
			bs.show();
			g.dispose();
		}
		else
		{
			//text based
			gameStateText.render();
		}
	}
	
	
	
	/* This Method is  the main game loop that runs every 60 frame and it renders all the graphics and calculates all the logic.
	* @return void,
	*/
	public void run() 
	{
		int NANO_SECONDS = 1000000000;
		int FramesPerSecond = 60;
		double maxTimePerTick = NANO_SECONDS/FramesPerSecond; 
		double changeInTime = 0; 
		long currentTime;
		long lastTime = System.nanoTime();
		
		//initializing the all variables 
		init();
		
		long timer = 0;
		int ticks = 0;
			
			
		//The main Game Loop for GUI
		while (gameIsRunning) 
		{
			//Checks if a frame has passed 
			currentTime = System.nanoTime();
			changeInTime += (currentTime - lastTime)/maxTimePerTick;	
			timer +=currentTime - lastTime;
			lastTime = currentTime;
			
			if(changeInTime >= 1) 
			{
				//Calls the tick and render method each frame 
				tick();
				render();
				
				ticks++;
				changeInTime--;
			}
			
			// For printing the frames per second 
			if(timer >= NANO_SECONDS) 
			{
				//System.out.println("FPS: " + ticks);
				ticks = 0;
				timer = 0;
			}
			
			// Stops the Thread when done running 
		}
		stop();

	}
	
	public void runText()
	{
		init();
		while (gameIsRunning) 
		{ 
			tick();
			render();	
		}
		System.out.println("game over");
	}
	
	
	//Starting and Stopping of a new Thread
	
	/* This Method is starts a new Thread
	* @return void,
	*/
	public synchronized void start()
	{
		System.out.println("Game Opened");

		if(!isTextBased)
		{
			if(gameIsRunning) 
			{
				return;
			}
			
			gameIsRunning = true;
			thread = new Thread(this);
			thread.start();
		}
		else
		{
			//text based 
			gameIsRunning = true;
			runText();
		}
	}
	
	/* This Method is stops the Thread
	* @return void,
	*/
	public synchronized void stop()
	{
		if(!gameIsRunning) 
		{
			return;
		}
		
		gameIsRunning = false;
		try 
		{
			thread.join();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Game Closed");
	}
	
	//Getters and Setters 
	
	/*gets the KeyManger
	* @return canvas,the KeyManger.
	*/
	public KeyMangerGUI getKeyManger()
	{
		return keyMangerGUI;
	}
	
	/*gets the GameCamera
	* @return GameCamera,the GameCamera.
	*/
	public GameCamera getGameCamera()
	{
		return gameCamera;
	}

	/*gets the width of the game
	* @return int,the width.
	*/
	public int getWidth() 
	{
		return width;
	}

	/*gets the height of the game
	* @return int,the height.
	*/
	public int getHeight() 
	{
		return height;
	}
}
