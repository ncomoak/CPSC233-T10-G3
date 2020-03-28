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
	

	private Comparator<GameObject> renderSorter = new Comparator<GameObject>() 
	{
		/*Compares to objects based on when they will be rendered.
		 * @return int
		 */
		public int compare(GameObject a, GameObject b)
		{
			if((a.getY() + a.getHeight())  < (b.getY() + b.getHeight()))
			{
				return -1;
			}
			return 1;
		}
	};
	
	/*Constructor for GameObjectManager. 
	 * @param Handler handler
	 * @param Player player. 
	 */
	public GameObjectManger(Handler handler, Player player)
	{
		this.handler = handler;
		this.player = player;
		
		gameObjects = new ArrayList<GameObject>();
		
		addGameObject(player);
		
	}
	
	/*Tick method for GameObjectManager Class. 
	 * 
	 */
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
	
	/*Render method
	 * @param Graphics g, graphics context. 
	 */
	public  void render(Graphics g) 
	{
		for(int i = 0; i < gameObjects.size(); i++)
		{
			GameObject placeHolderGameobject = gameObjects.get(i);
			placeHolderGameobject.render(g);	
		}
	}
	
	/*Adds Game Object to gameObjects
	 * @param GameObject newGameObject. 
	 */
	public void addGameObject(GameObject newGameObject)
	{
		gameObjects.add(newGameObject);
	}

	
	//GETTERS AND SETTERS
	
	/*Gets handler
	 * @return handler
	 */
	public Handler getHandler()
	{
		return handler;
	}

	/*sets handler
	 * @param handler
	 */
	public void setHandler(Handler handler)
	{
		this.handler = handler;
	}

	/*Gets player
	 * @return player
	 */
	public Player getPlayer() 
	{
		return player;
	}

	/*Sets player
	 * @param player
	 */
	public void setPlayer(Player player)
	{
		this.player = player;
	}

	/*Returns ArrayList of GameObjects
	 * @return gameObjects
	 */
	public ArrayList<GameObject> getGameObjects() 
	{
		return gameObjects;
	}

	/*Sets gameObjects array
	 * @param ArrayList<GameObject> gameObjects
	 */
	public void setGameObjects(ArrayList<GameObject> gameObjects)
	{
		this.gameObjects = gameObjects;
	}
}
