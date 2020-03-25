package GamePack.GameObject.Characters.Monsters;

import java.awt.Graphics;

import GamePack.Handler;
import GamePack.GameObject.Characters.Characters;
import GamePack.gfx.Assests;

// how  attack 
//when the player is in range the monster moves and attacks and the players health goes down 
//there will be printing saying the player is being attacked 

//what the monster looks  like 

//how to follow the player AI 

public class Monster extends Characters {

	
	private int lootTable;
	private int experience;
	private int coinValue;
	private String lastDirection = "n";
	

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
	
	public String getLastDirection() {
		return lastDirection;
	}
	
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
	
	
	

	//I noticed this class doesn't have a constructor, so I'm going to implement one. 
	//-Rachel. 
	
	/*Constructor for Monster Class. 
	 * @param int lootTable
	 * @param int experience
	 */
	
	public Monster(int lootTable, int experience, int coinValue) 
	{
		setLootTable(lootTable);
		setExperience(experience);
		setCoinValue(coinValue);
		setLastDirection("n");
	}
	
	public Monster(Monster monster) {
		setLootTable(monster.lootTable);
		setExperience(monster.experience);
		setCoinValue(monster.coinValue);
		setLastDirection(monster.getLastDirection());
	}
	
	public Monster(Handler handler, int xCoor, int yCoor, int lootTable, int experinece, int coinValue) {
		super(handler, xCoor, yCoor, Characters.DEFAULT_CHARACTER_WIDTH, Characters.DEFAULT_CHARACTER_HEIGHT);
		setLootTable(lootTable);
		setExperience(experience);
		setCoinValue(coinValue);
		setLastDirection("n");
		
	}

//gets movement of the monster and moves the monster 
	public void tick() 
	{
		getInput();
	}


//puts graphic on the screen and centers object 
	
	public void die() {
		
	}


//gets the KeyBoard input and decides if the play should move.
//I need to rewrite this, because for the MonsterAI to work, we need to get input from the class instead of the keyboard. 
//-Rachel.
	
	
	private void getInput()
	{
		MonsterAI monsterAI = new MonsterAI(this, lastDirection);
		setLastDirection(monsterAI.move());
		
	}
	@Override
	public void render(Graphics g) {
		g.drawImage(Assests.enemy,(int)super.x, (int)super.y, Characters.DEFAULT_CHARACTER_WIDTH, Characters.DEFAULT_CHARACTER_HEIGHT, null);
		
	}
	
	
}
