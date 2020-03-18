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

public class Monster extends Characters
{

	private int lootTable;
	private int experience;
	private int coinValue;
	private int xCoor;
	private int yCoor;
	

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
	/*gets XCoordinate
	 * @return xCoor;
	 */
	public int getxCoor() {
		return xCoor;
	}
	/*sets xCoordinate
	 * @param xCoor
	 */
	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}
	/*gets yCoordinate
	 * @return yCoor
	 */
	public int getyCoor() {
		return yCoor;
	}
	/*sets yCoordinate
	 * @param yCoor
	 */
	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}
	
	
	
	public Monster(Handler handler, float x, float y)
	{
		super(handler, x, y, Characters.DEFAULT_CHARACTER_WIDTH, Characters.DEFAULT_CHARACTER_HEIGHT);
		
		bounds.x =  0;
		bounds.y =  0;
		bounds.width = Characters.DEFAULT_CHARACTER_WIDTH;
		bounds.height = Characters.DEFAULT_CHARACTER_HEIGHT;
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
	}

//gets movement of the monster and moves the monster 
	public void tick() 
	{
		move();
	}


//puts graphic on the screen
	public void render(Graphics g) 
	{
		g.drawImage(Assests.enemy,(int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width, height, null);
	}
	
	
	public void die() 
	{
		
	}
}