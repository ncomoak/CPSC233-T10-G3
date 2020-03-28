package GamePack.GameObject.Characters.Monsters;

import java.util.ArrayList;
import java.util.Random;

public class MonsterAI{
	
	private Monster monster; //During implementation, pass in a world object IDENTICAL TO THE ONE FOR THE GAME. 
	private String lastDirection;//The last direction that the monster moved in. In order to initialize the monster AI, this is set to 'n'
	/*Monster AI constructor
	 * @param Monster monster
	 */
	public MonsterAI(Monster monster) {
		this.monster = monster;
		setLastDirection("n");
	}
	/*MonsterAI constructor
	 * @param Monster monster
	 * @param String lastDirection, lastDirection the monster went. 
	 */
	public MonsterAI(Monster monster, String lastDirection) {
		this.monster = monster;
		setLastDirection(lastDirection);
	}
	/*Sets lastDirection
	 * @return lastDirection
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
	
	/*Moves the monster
	 * @return String representation of the direction the mosnter moved. 
	 */
	public String move() {
		ArrayList<String> possibleDirections = new ArrayList<>();
		int intMonsterXCoor = (int)(monster.getX()/64 - ((monster.getX())/64) % 1 + 1);
		int intMonsterYCoor = (int)(monster.getY()/64 + 1);
		//Gets all possible directions for monster to go. 
		if(!monster.collionWithTile(intMonsterXCoor, intMonsterYCoor - 2)) {
			possibleDirections.add("North");
		}
		if(!monster.collionWithTile(intMonsterXCoor, intMonsterYCoor + 1)) {
			possibleDirections.add("South");
		}
		
		if(!monster.collionWithTile(intMonsterXCoor - 2, intMonsterYCoor)) {
			possibleDirections.add("West");
		}
		if(!monster.collionWithTile(intMonsterXCoor + 1, intMonsterYCoor)) {
			possibleDirections.add("East");
		}
		Random random = new Random();
		int direction = 0;
		//Determines if the monster can go in the same directions its going. 
		//If so, it goes that way. 
		if(possibleDirections.contains(lastDirection)) {
			direction = possibleDirections.indexOf(lastDirection);
			monster.move();
			return lastDirection;
		}
		//Otherwise, it goes in another, random direction. 
		else if (possibleDirections.size() != 0) {
			direction = random.nextInt(possibleDirections.size());
			if(possibleDirections.get(direction).equals("North")) {
				monster.setyMove(-monster.getSpeed());
				monster.setxMove(0);
				monster.move();
				return "North";
			}
			else if(possibleDirections.get(direction).equals("South")) {
				monster.setyMove(monster.getSpeed());
				monster.setxMove(0);
				monster.move();
				return "South";
			}
			else if(possibleDirections.get(direction).equals("West")) {
				monster.setxMove(-monster.getSpeed());
				monster.setyMove(0);
				monster.move();
				return "West";
			}
			else if(possibleDirections.get(direction).equals("East")){
				monster.setxMove(monster.getSpeed());
				monster.setyMove(0);
				monster.move();
				return "East";
			}

		}
		return "n";
	}
	
	
}






		
