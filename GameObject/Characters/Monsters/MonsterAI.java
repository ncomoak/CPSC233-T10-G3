package GamePack.GameObject.Characters.Monsters;

import java.util.ArrayList;
import java.util.Random;

public class MonsterAI{
	
	private Monster monster; //During implementation, pass in a world object IDENTICAL TO THE ONE FOR THE GAME. 
	private String lastDirection;//The last direction that the monster moved in. In order to initialize the monster AI, this is set to 'n'
	
	public MonsterAI(Monster monster) {
		this.monster = monster;
		setLastDirection("n");
	}
	
	public MonsterAI(Monster monster, String lastDirection) {
		this.monster = monster;
		setLastDirection(lastDirection);
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
	
	
	public String move() {
		ArrayList<String> possibleDirections = new ArrayList<>();
		if(!monster.collisionWithTile(0,-1)) {
			possibleDirections.add("North");
		}
		if(!monster.collisionWithTile(0, 1)) {
			possibleDirections.add("South");
		}
		
		if(!monster.collisionWithTile(-1, 0)) {
			possibleDirections.add("West");
		}
		if(!monster.collisionWithTile(0, 1)) {
			possibleDirections.add("East");
		}
		
		Random random = new Random();
		int direction = 0;
		if(possibleDirections.contains(lastDirection)) {
			direction = possibleDirections.indexOf(lastDirection);
		}
		else {
			direction = random.nextInt(possibleDirections.size());
		}
		if(possibleDirections.get(direction).equals("North")) {
			monster.setxMove(-monster.getSpeed());
			return "North";
		}
		else if(possibleDirections.get(direction).equals("South")) {
			monster.setyMove(monster.getSpeed());
			return "South";
		}
		else if(possibleDirections.get(direction).equals("West")) {
			monster.setxMove(-monster.getSpeed());
			return "West";
		}
		else {
			monster.setxMove(monster.getSpeed());
			return "East";
		}

	}
	
}





