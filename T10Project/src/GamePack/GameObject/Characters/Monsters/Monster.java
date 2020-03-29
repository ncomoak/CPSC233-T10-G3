package GamePack.GameObject.Characters.Monsters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import GamePack.Game;
import GamePack.Handler;
import GamePack.GameObject.GameObject;
import GamePack.GameObject.Characters.Characters;
import GamePack.gfx.Assests;

// how  attack 
//when the player is in range the monster moves and attacks and the players health goes down 
//there will be printing saying the player is being attacked 

//what the monster looks  like 

//how to follow the player AI 

public class Monster extends Characters 
{
	private int lootTable;
	private int experience;
	private int coinValue;
	private String lastDirection = "n";

	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	private int attackRange = 20;

	
	/*Constructor for Monster Class. 
	 * @param int lootTable
	 * @param int experience
	 */
	
	//This is the real constructor! 
	
	public Monster(Handler handler, int xCoor, int yCoor, int lootTable, int experinece, int coinValue) {
		super(handler, xCoor, yCoor, Characters.DEFAULT_CHARACTER_WIDTH, Characters.DEFAULT_CHARACTER_HEIGHT);
		setLootTable(lootTable);
		setExperience(experience);
		setCoinValue(coinValue);
		setLastDirection("n");
		setSpeed((float)1.5);
		
		name = "Monster";
	}

//gets movement of the monster and moves the monster 
	public void tick() 
	{
		getInput();
		move();
		checkAttacks();
	}
	
	/*checks attacks
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
		Rectangle monsterCollisonBounds = getCollisionBound(0, 0);
		Rectangle attackBounds = new Rectangle();
		
		
		attackBounds.width = attackRange;
		attackBounds.height = attackRange;
		
	
		//up
		attackBounds.x = monsterCollisonBounds.x + monsterCollisonBounds.width / 2 - attackRange/2; 
		attackBounds.y = monsterCollisonBounds.y - attackRange; 

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

		
		//down
		attackBounds.x = monsterCollisonBounds.x + monsterCollisonBounds.width / 2 - attackRange/2; 
		attackBounds.y = monsterCollisonBounds.y + attackRange + monsterCollisonBounds.height;
		
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
				//deal 2 damage
				e.hurt(2);
				return;
			}
		}

		//left
		attackBounds.x = monsterCollisonBounds.x - attackRange; 
		attackBounds.y = monsterCollisonBounds.y + monsterCollisonBounds.height / 2 - attackRange/2;
		
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
				//deal 2 damage
				e.hurt(2);
				return;
			}
		}

		//right
		attackBounds.x = monsterCollisonBounds.x + monsterCollisonBounds.width; 
		attackBounds.y = monsterCollisonBounds.y + monsterCollisonBounds.height / 2 - attackRange/2;

		
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
				//deal 2 damage
				e.hurt(2);
				return;
			}
		}
	}
	
	


	/*Overwritten die method. 
	 * 
	 */
	public void die() {
		
	}


//gets the KeyBoard input and decides if the play should move.
//I need to rewrite this, because for the MonsterAI to work, we need to get input from the class instead of the keyboard. 
//-Rachel.
	
	/*getsInput from MonsterAI class. 
	 * 
	 */
	private void getInput()
	{
		MonsterAI monsterAI = new MonsterAI(this, lastDirection);
		setLastDirection(monsterAI.move());
		
	}
	

	@Override
	
	/*Render Method
	 * @param Graphics g, graphics context. 
	 */
	public void render(Graphics g) {
		g.drawImage(Assests.enemy,(int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width, height, null);
		
		if(Game.devTestMode)
		{
			g.setColor(Color.RED);
			g.drawRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width,bounds.height);
		}


		
	}
	
	//Getters and Setters

	/*gets lootTable
	 * @return lootTable
	 */
	public int getLootTable() 
	{
		return lootTable;
	}
	/*sets lootTable
	 * @param int lootTable
	 */
	public void setLootTable(int lootTable) 
	{
		this.lootTable = lootTable;
	}
	/*get's experience
	 * @return experience
	 */
	public int getExperience() 
	{
		return experience;
	}
	/*sets Experience
	 * @param experience
	 */
	public void setExperience(int experience) 
	{
		this.experience = experience;
	}
	/*gets CoinValue
	 * @return coinValue
	 */
	public int getCoinValue() 
	{
		return coinValue;
	}
	/*sets coinvValue
	 * @param coinValue
	 */
	public void setCoinValue(int coinValue) 
	{
		this.coinValue = coinValue;
	}
	/*gets the last direction the monster has moved.
	 * @return String lastDirection
	 */
	public String getLastDirection() {
		return lastDirection;
	}
	/*sets the last direction monster went
	 * @param String lastDirection
	 */
	private void setLastDirection(String lastDirection) {
		if(lastDirection.equals("North") || lastDirection.equals("South")){
			this.lastDirection = lastDirection;
		}
		else if(lastDirection.equals("East") || lastDirection.equals("West")) {
			this.lastDirection = lastDirection;
		}
		else {
			lastDirection = "n";
		}
	}	
}
