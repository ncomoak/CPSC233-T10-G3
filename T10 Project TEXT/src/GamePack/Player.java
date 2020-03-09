package GamePack;

import java.util.Random;

class Player{
	private int xCoor = -1;
	private int yCoor = -1;
	public static void render() {
		System.out.println("P");
	}
	public Player(int xCoor, int yCoor){
		setxCoor(xCoor);
		setyCoor(yCoor);
	}
	public int getxCoor() {
		return xCoor;
	}

	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}

	public int getyCoor() {
		return yCoor;
	}

	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}

}