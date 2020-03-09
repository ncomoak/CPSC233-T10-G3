//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 3,4,5,6,7,9,10,12,14,15,19,21,24
package GamePack;

import java.awt.*;
import java.awt.image.BufferStrategy;
import GamePack.Input.KeyManger;
import GamePack.States.GameState;
import GamePack.States.State;
import GamePack.gfx.Assests;
import GamePack.gfx.GameCamera;

// The main Game Class
public class Game implements Runnable 
{
	//Set Up
	private Display display;
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
	private KeyManger keyManger;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
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
		
		keyManger = new KeyManger();
	}
	
	
	
	/* This Method initializes all of the variables needed.
	* @return void,
	*/
	private void init() 
	{	
		//Creating a display and adding a keyLister
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManger);
		
		//initializing all the assets
		Assests.init();

		//initializing all the Game Handler 
		handler = new Handler(this);
		
		//initializing a new camera
		gameCamera = new GameCamera(handler,0, 0);
		
		
		//initializing the States 
		gameState = new GameState(handler);
		State.setState(gameState);
	}
	
	
	/* This Method is called every frame and is used for all the logic 
	* @return void,
	*/
	private void tick()
	{
		//Input Check
		keyManger.tick();
		
		//Running the States
		if(State.getState() != null)
		{
			State.getState().tick();
		}
	}	

	
	/* This Method is called every frame and it show the  renders all the graphics.
	* @return void,
	*/
	private void render()
	{
		//The bs(Buffer Strategy is getting the canvas to draw on )
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
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
		
		
		//The main Game Loop
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
		}
		// Stops the Thread when done running 
		stop();
	}
	
	
	//Starting and Stopping of a new Thread
	
	/* This Method is starts a new Thread
	* @return void,
	*/
	public synchronized void start()
	{
		if(gameIsRunning) 
		{
			return;
		}
		
		gameIsRunning = true;
		thread = new Thread(this);
		thread.start();
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
	}
	
	//Getters and Setters 
	
	/*gets the KeyManger
	* @return canvas,the KeyManger.
	*/
	public KeyManger getKeyManger()
	{
		return keyManger;
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
