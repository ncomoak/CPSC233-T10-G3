package GamePack.MazeAi;

public class MazeBlock{
    boolean north;
    boolean east;
    boolean west;
    boolean south;
    boolean fourWalls;
    int xCoord;
    int yCoord;

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