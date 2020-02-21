package GamePack;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import GamePack.Input.KeyManger;
import GamePack.States.GameState;
import GamePack.States.State;
import GamePack.gfx.Assests;
import GamePack.gfx.GameCamera;
import GamePack.gfx.ImageLoader;

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
	
	
	
	private void init() 
	{		
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManger);
		
		Assests.init();

		handler = new Handler(this);
		
		gameCamera = new GameCamera(handler,0, 0);
		
		
		
		//initialize States 
		gameState = new GameState(handler);
		State.setState(gameState);
	}
	
	
	private void tick()
	{
		keyManger.tick();

		if(State.getState() != null)
		{
			State.getState().tick();
		}
	}	
	
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		//Clear Screen
		g.clearRect(0, 0, width, height);
		
		//draw here
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
		
		init();
		
		long timer = 0;
		int ticks = 0;
		
		while (running) 
		{
			now = System.nanoTime();
			delta += (now - lastTime)/timepertick;
			timer +=now - lastTime;
			lastTime = now;
			
			if(delta >= 1) 
			{
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
		stop();
	}
	
	
	//Starting and Stop A new Thread
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
