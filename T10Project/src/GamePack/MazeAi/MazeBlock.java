package GamePack.MazeAi;

public class MazeBlock{
    public boolean north;
    public boolean east;
    public boolean west;
    public boolean south;
    public boolean fourWalls;
    public int xCoord;
    public int yCoord;

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