package GamePack;

import java.awt.*;
import java.awt.image.BufferStrategy;
<<<<<<< Updated upstream
=======
import java.awt.image.BufferedImage;

>>>>>>> Stashed changes
import GamePack.Input.KeyManger;
import GamePack.States.GameState;
import GamePack.States.State;
import GamePack.gfx.Assests;
import GamePack.gfx.GameCamera;
<<<<<<< Updated upstream
=======
import GamePack.gfx.ImageLoader;
>>>>>>> Stashed changes

// The main Game Class
public class Game implements Runnable 
{
	//Set Up
	private Display display;
	private int width,height;
	public String title;
	
	//Graphics and rendering 
	private Thread thread;
	private boolean running = false;
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
	
	public Game(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		
		keyManger = new KeyManger();
	}
	
	
	//This Method initializes all of the variables needed.
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
	
	// This Method is called Every frame and is used for all the logic 
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

	// This Method is called every frame and it show the  renders all the graphics. 
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
	
	
	//GameLoop
	public void run() 
	{
		int fps = 60;
		double timepertick = 1000000000/fps; 
		double delta = 0; 
		long now;
		long lastTime = System.nanoTime();
		
		//initializing the all variables 
		init();
		
		long timer = 0;
		int ticks = 0;
		
		//The main Game Loop
		while (running) 
		{
			//Checks if a frame has passed 
			now = System.nanoTime();
			delta += (now - lastTime)/timepertick;
			timer +=now - lastTime;
			lastTime = now;
			
			if(delta >= 1) 
			{
				//Calls the tick and render method each frame 
				tick();
				render();
				
				ticks++;
				delta--;
			}
			if(timer >= 1000000000) 
			{
				//System.out.println("fps: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		// Stops the Thread when done running 
		stop();
	}
	
	
	//Starting and Stopping of  a new Thread
	public synchronized void start()
	{
		if(running) 
		{
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop()
	{
		if(!running) 
		{
			return;
		}
		
		running = false;
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
	public KeyManger getKeyManger()
	{
		return keyManger;
	}
	
	public GameCamera getGameCamera()
	{
		return gameCamera;
	}

	public int getWidth() 
	{
		return width;
	}

	public int getHeight() 
	{
		return height;
	}
}
