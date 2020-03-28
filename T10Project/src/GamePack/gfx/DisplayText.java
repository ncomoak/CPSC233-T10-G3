package GamePack.gfx;

public class DisplayText {
	/*Render method
	 * @param int[][] worldTiles. 
	 * @param int playerX
	 * @param int playerY
	 */
	public static void render(int[][] worldTiles,int playerX,int playerY) {
		for(int width = 0; width < worldTiles.length; width++) {
			for(int height = 0; height < worldTiles.length; height++) {
					if(playerX == width && playerY == height) {
						System.out.print("P");
					}
					else if(worldTiles[width][height] == 1) {
						System.out.print(" ");
					}
					else if(worldTiles[width][height] == 2) {
						System.out.print("+");
					}
					else {
						System.out.print("e");
					}
				}
			System.out.println("");
			}
	}
		
}

