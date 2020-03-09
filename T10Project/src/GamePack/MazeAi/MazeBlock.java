package GamePack.MazeAi;

public class MazeBlock{
    boolean north;
    boolean east;
    boolean west;
    boolean south;
    boolean fourWalls;
    int xCoord;
    int yCoord;
    /*Constructor to build a mazeBlock object. 
    *int xCoord location of mazeBlock in a 2D array.
    *int yCoord location of mazeBlock in a 2D array.
    */
    public MazeBlock(int xCoord, int yCoord)
    {
        this.north = true;
        this.east = true;
        this.west = true;
        this.south = true;
        this.fourWalls = true;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
}