package GamePack.GameObject.Characters.Monsters;
import GamePack.GameObject.Characters.Player;
import GamePack.World.World;
import java.util.Random;
import java.util.ArrayList;



public class MonsterAI{
	
	private  Monster monster;
	private World world; //During implementation, pass in a world object IDENTICAL TO THE ONE FOR THE GAME. 
	private Player player; //pass in same player that's used for the game. DO NOT MAKE A COPY OF THE PLAYER. 
	
	
	public MonsterAI(Monster monster, World world, Player player) {
		this.monster = monster;
		this.world = world;
		this.player = player;
	}
	
	public void move() {
		int monsterX = monster.getxCoor();
		int monsterY = monster.getyCoor();
		int[] monsterList = {monsterX, monsterY};
		ArrayList<int[]> usedCoordinates = new ArrayList<>();
		findPlayer(monsterList , usedCoordinates);
		}
		

	public int[] findPlayer(int[]monsterList, ArrayList<int[]>usedCoordinates) {
		int monsterX = monsterList[0];
		int monsterY = monsterList[1];
		ArrayList<String> possibleDirections = new ArrayList<>();
		int[] monsterCoor = {monsterX, monsterY - 1};
		int[][] worldTiles = world.getWorldTiles();
		if(monsterX == player.getxCoor() && monsterY == player.getyCoor()) {
			return usedCoordinates.get(0);
		}
		if(monsterY > 0 && worldTiles[monsterX][monsterY - 1] != 2 && !checkForCoorPair(usedCoordinates, monsterCoor) ) {
			possibleDirections.add("North");
		}
		monsterCoor[1] = monsterY + 1;
		if(monsterY < worldTiles.length && worldTiles[monsterX][monsterY + 1] != 2 && !checkForCoorPair(usedCoordinates, monsterCoor)) {
			possibleDirections.add("South");
		}
		monsterCoor[0] = monsterX - 1;
		monsterCoor[1] = monsterY;
		if(monsterX > 0 && worldTiles[monsterX - 1][monsterY] != 2 && !checkForCoorPair(usedCoordinates, monsterCoor)) {
			possibleDirections.add("West");
		}
		monsterCoor[0] = monsterX + 1;
		if(monsterX < worldTiles.length && worldTiles[monsterX + 1][monsterY] != 2 && !checkForCoorPair(usedCoordinates, monsterCoor)) {
			possibleDirections.add("East");
		}
		monsterCoor[0] = monsterX;
		
		if(possibleDirections.size() == 0) {
			return findPlayer(usedCoordinates.get(usedCoordinates.size() - 1), usedCoordinates);
		}
		Random random = new Random();
		int direction = random.nextInt(possibleDirections.size());
		if(possibleDirections.get(direction).equals("North")){
			usedCoordinates.add(monsterCoor);
			monsterCoor[1] = monsterX + 1;
			return findPlayer(monsterCoor, usedCoordinates);
		}
		int[] returnVal = {0,0};
		return returnVal;
		
		
	}
	
	private static boolean checkForCoorPair(ArrayList<int[]> coorList, int[] pairOfCoor ) {
		for(int i = 0; i < coorList.size(); i++) {
			if(pairOfCoor.equals(coorList.get(i))) {
				return true;
			}
		}
		return false;
	}
		
}