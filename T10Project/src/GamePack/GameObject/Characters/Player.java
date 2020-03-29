//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 13,14,15,19,21,22,23
package GamePack.GameObject.Characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import GamePack.Game;
import GamePack.Handler;
import GamePack.GameObject.GameObject;
import GamePack.States.GameStateGUI;
import GamePack.States.State;
import GamePack.Tiles.Tile;
import GamePack.gfx.Assests;

// The Player
public class Player extends Characters 
{
	private int xCoor = -1;
	private int yCoor = -1;
	
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	
	/*Constructor, sets up a new Player
	* @param Handler, handler. the game handler.
	* @param float, x. the x position of the Game Object.
	* @param float, y. the y position of the Game Object.
	* @return void,
	*/
	public Player(Handler handler, float x, float y)
	{
		super(handler, x, y, Characters.DEFAULT_CHARACTER_WIDTH, Characters.DEFAULT_CHARACTER_HEIGHT);
		
		bounds.x = 10;
		bounds.y = 10;
		bounds.width = (int) (Characters.DEFAULT_CHARACTER_WIDTH/1.5);
		bounds.height = Characters.DEFAULT_CHARACTER_HEIGHT - 20;
		
		name = "Player ";
	}
	
	/*Constructor for player class. 
	 * @param int xCoor
	 * @param int yCoor
	 */
	public Player(int xCoor, int yCoor)
	{
		super();
		setxCoor(xCoor);
		setyCoor(yCoor);
	}

	/* This Method is called every frame and is used for all the logic 
	* @return void,
	*/
	public void tick() 
	{
		getInput(); 
		move();
		handler.getGameCamera().centerOnGameObject(this);
		checkAttacks();
		hasTouchedPortal();
	}
	
	

	/* This Method is called every frame and it show the  renders all the graphics.
	* @return void,
	*/
	public void render(Graphics g) 
	{
		g.drawImage(Assests.player,(int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width, height, null);
		
		if(Game.devTestMode)
		{
			g.setColor(Color.BLUE);
			g.drawRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width,bounds.height);
		}
	}
	
	/*TextBased Render Method
	 * 
	 */
	public static void render() 
	{
		System.out.println("P");
	}
	
	// Methods
	/*Determines if the player has touched the portal. 
	 * 
	 */
	public void hasTouchedPortal()
	{
		int ID =  handler.getWorld().getTile((int)(x + bounds.width/2) /Tile.TILEWIDTH, (int) (y + bounds.height/2) /Tile.TILEWIDTH).getID();
		
		if(ID == 0 || ID == 3 || ID == 4 || ID == 5 || ID == 6 || ID == 7 || ID == 8 || ID == 9 || ID == 10)
		{
			
			System.out.println("Level UP");
			handler.getGame().gameState = new GameStateGUI(handler);
			State.setState(handler.getGame().gameState);
		}
	}
	
	/*checks if somethings been attacked. 
	 * 
	 */
	private void checkAttacks() 
	{
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer =  System.currentTimeMillis();
		
		if(attackTimer < attackCooldown)
		{
			return;
		}
		Rectangle playerCollisonBounds = getCollisionBound(0, 0);
		Rectangle attackBounds = new Rectangle();
		int attackRange = 20;
		
		attackBounds.width = attackRange;
		attackBounds.height = attackRange;
		
		if(handler.getKeyManger().attackUp)
		{
			attackBounds.x = playerCollisonBounds.x + playerCollisonBounds.width / 2 - attackRange/2; 
			attackBounds.y = playerCollisonBounds.y - attackRange; 

		}
		else if(handler.getKeyManger().attackDown)
		{
			attackBounds.x = playerCollisonBounds.x + playerCollisonBounds.width / 2 - attackRange/2; 
			attackBounds.y = playerCollisonBounds.y + attackRange + playerCollisonBounds.height;
		}
		else if(handler.getKeyManger().attackLeft)
		{
			attackBounds.x = playerCollisonBounds.x - attackRange; 
			attackBounds.y = playerCollisonBounds.y + playerCollisonBounds.height / 2 - attackRange/2;
		}
		else if(handler.getKeyManger().attackRight)
		{
			attackBounds.x = playerCollisonBounds.x + playerCollisonBounds.width; 
			attackBounds.y = playerCollisonBounds.y + playerCollisonBounds.height / 2 - attackRange/2;
		}
		else
		{
			return;
		}
		
		attackTimer = 0;
		
		for(GameObject e : handler.getWorld().getGameObjectManger().getGameObjects())
		{
			//if the GameObject it is looking at is it's self. move on to the next GameObject 
			if(e.equals(this))
			{
				continue;
			}
			
			//if the GameObject is about to collied any other GameObject returns true
			if(e.getCollisionBound(0, 0).intersects(attackBounds))
			{
				//deal 1 damage
				e.hurt(2);
				return;
			}
		}
	}
	
	/*Overwritten die method.
	 * 
	 */
	@Override
	protected void die() 
	{
		System.out.println("YOU DIED");
		handler.getWorld().respawnPlayer();
	}
	
	/*gets the KeyBoard input and decides if the play should move.  
	* @return void, 
	*/
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		
		//Move up
		if(handler.getKeyManger().up)
		{
			yMove = -speed; 
		}
		
		//Move down
		if(handler.getKeyManger().down)
		{
			yMove = speed; 
		}
		
		//Move Left
		if(handler.getKeyManger().left)
		{
			xMove = -speed; 
		}
		
		//Move Right
		if(handler.getKeyManger().right)
		{
			xMove = speed; 
		}
	}
	
	
	/*gets xCoor
	 * @return int xCoor
	 */
	public int getxCoor() 
	{
		return xCoor;
	}

	/*sets xCoor
	 * @param int xCoor
	 */
	public void setxCoor(int xCoor)
	{
		this.xCoor = xCoor;
	}

	/*gets yCoor
	 * @return int yCoor
	 */
	public int getyCoor()
	{
		return yCoor;
	}

	/*set yCoor
	 * @param int yCoor
	 */
	public void setyCoor(int yCoor) 
	{
		this.yCoor = yCoor;
	}
}
