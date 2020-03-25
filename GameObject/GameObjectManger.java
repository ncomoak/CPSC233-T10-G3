//https://www.youtube.com/watch?v=W-j9Xjrteq4&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=26
//Video: 26 	
package GamePack.GameObject;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import GamePack.Handler;
import GamePack.GameObject.Characters.Player;
import GamePack.GameObject.Characters.Monsters.Monster;

public class GameObjectManger 
{
	private Handler handler;
	private Player player;
	
	private ArrayList<GameObject> gameObjects;
	
	// TODO Java docs 
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
	
	// TODO Java docs 
	public GameObjectManger(Handler handler, Player player)
	{
		this.handler = handler;
		this.player = player;
		
		gameObjects = new ArrayList<GameObject>();
		
		addGameObject(player);
		
	}
	
	// TODO Java docs 
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
	
	// TODO Java docs 
	public  void render(Graphics g) 
	{
		for(int i = 0; i < gameObjects.size(); i++)
		{
			GameObject placeHolderGameobject = gameObjects.get(i);
			placeHolderGameobject.render(g);	
		}
	}
	
	// TODO Java docs 
	public void addGameObject(GameObject newGameObject)
	{
		gameObjects.add(newGameObject);
	}

	
	//GETTERS AND SETTERS

	// TODO Java docs 
	public Handler getHandler()
	{
		return handler;
	}

	// TODO Java docs 
	public void setHandler(Handler handler)
	{
		this.handler = handler;
	}

	// TODO Java docs 
	public Player getPlayer() 
	{
		return player;
	}

	// TODO Java docs 
	public void setPlayer(Player player)
	{
		this.player = player;
	}

	// TODO Java docs 
	public ArrayList<GameObject> getGameObjects() 
	{
		return gameObjects;
	}

	// TODO Java docs 
	public void setGameObjects(ArrayList<GameObject> gameObjects)
	{
		this.gameObjects = gameObjects;
	}
}
