//https://www.youtube.com/watch?v=W-j9Xjrteq4&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=26
//Video: 26 	
package GamePack.GameObject;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import GamePack.Handler;
import GamePack.GameObject.Characters.Player;

public class GameObjectManger 
{
	private Handler handler;
	private Player player;
	
	private ArrayList<GameObject> gameObjects;
	
	//Render Sorter 
	private Comparator<GameObject> renderSorter = new Comparator<GameObject>() 
	{
		public int compare(GameObject a, GameObject b)
		{
			if((a.getY() + a.getHeight())  < (b.getY() + b.getHeight()))
			{
				return -1;
			}
			return 1;
		}
	};
	
	public GameObjectManger(Handler handler, Player player)
	{
		this.handler = handler;
		this.player = player;
		
		gameObjects = new ArrayList<GameObject>();
		
		addGameObject(player);
		
	}
	
	public  void tick() 
	{
		//Runs through and checks every gameObject 
		for(int i = 0; i < gameObjects.size(); i++)
		{
			GameObject placeHolderGameobject = gameObjects.get(i);
			placeHolderGameobject.tick();
			
			// if a GameObject is dead Remove it 
			if(!placeHolderGameobject.isActive)
			{
				gameObjects.remove(placeHolderGameobject);
			}
		}
		gameObjects.sort(renderSorter);
	} 
	
	public  void render(Graphics g) 
	{
		for(int i = 0; i < gameObjects.size(); i++)
		{
			GameObject placeHolderGameobject = gameObjects.get(i);
			placeHolderGameobject.render(g);	
		}
	}
	
	public void addGameObject(GameObject newGameObject)
	{
		gameObjects.add(newGameObject);
	}

	
	//GETTERS AND SETTERS

	public Handler getHandler()
	{
		return handler;
	}

	public void setHandler(Handler handler)
	{
		this.handler = handler;
	}

	public Player getPlayer() 
	{
		return player;
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}

	public ArrayList<GameObject> getGameObjects() 
	{
		return gameObjects;
	}

	public void setGameObjects(ArrayList<GameObject> gameObjects)
	{
		this.gameObjects = gameObjects;
	}
}
