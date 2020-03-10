import java.util.ArrayList;
import java.util.Random;

class Maze{
    int height;
    int width;
    ArrayList<ArrayList<MazeBlock>> mazeList;

    public Maze(final int height, final int width){
        //Create 2D List. 
        ArrayList <ArrayList<MazeBlock>> mazeList = new ArrayList<>();
        for(int i = 0; i < height; i++){
            mazeList.add(new ArrayList<MazeBlock>());
            for(int j = 0; j < width; j++){
               mazeList.get(i).add(new MazeBlock(j,i));
            }
        }
        
        //set instance variables or fields. 
        this.height = height;
        this.width = width;
        this.mazeList = mazeList;
        

    }
    public void recursiveMaze(){
        //Sets all veriables. 
        int currentHeight = 0;
        int currentWidth = 0;
        ArrayList<MazeBlock> usedMazeBlocks = new ArrayList<>();
        Random random = new Random();//Creates an instance of the Random Class so that we can use it to generate random numbers below. 
        ArrayList<String> possibleDirections = new ArrayList<>();
        boolean allBrokenPaths = false;
        while(!allBrokenPaths){//Loops until each tile has an entry/exit point. 
            for(int j = 0; j < usedMazeBlocks.size(); j++){//makes sure there isn't duplicate maze blocks in usedMazeBlocks. 
                for(int k = 0; k < usedMazeBlocks.size();k++){
                    if(k != j && usedMazeBlocks.get(j) == usedMazeBlocks.get(k)){
                        usedMazeBlocks.remove(k);
                        break;
                    }
                }
                
            }
            possibleDirections = new ArrayList<String>();//Figures out which way we can go from any given mazeblock. 
            if(currentHeight != 0 && !checkForMazeBlock(currentWidth, currentHeight - 1, usedMazeBlocks)){
                possibleDirections.add("North");
            }
            if(currentHeight < mazeList.size() - 1&& !checkForMazeBlock(currentWidth, currentHeight+ 1, usedMazeBlocks)){
                possibleDirections.add("South");
            }
            if(currentWidth != 0 && !checkForMazeBlock(currentWidth - 1, currentHeight, usedMazeBlocks)){
                possibleDirections.add("West");
            }
            if(currentWidth < mazeList.get(0).size() - 1 && !checkForMazeBlock(currentWidth + 1, currentHeight, usedMazeBlocks)){
                possibleDirections.add("East");
            }
            if(possibleDirections.size() == 0){//If there are no possible directions, and all tiles have a passage going in or out, the loop ends. 
                if(usedMazeBlocks.size() == width*height){
                    allBrokenPaths = true;
                }
                else{
                    MazeBlock lastMazeBlock = usedMazeBlocks.get(usedMazeBlocks.size() - 1);//If there are still tiles left, we go to the last mazeBlock and see if there are any driections to go there
                    usedMazeBlocks.remove(usedMazeBlocks.size() - 1);
                    usedMazeBlocks.add(0, lastMazeBlock);
                    usedMazeBlocks.add(0, mazeList.get(currentHeight).get(currentWidth));
                    currentHeight = lastMazeBlock.yCoord;
                    currentWidth = lastMazeBlock.xCoord;
                }
            }
            else{
                usedMazeBlocks.add(mazeList.get(currentHeight).get(currentWidth));//If there are ways we can go, we pick a random number for each direction and go in that direction
                int direction = random.nextInt(possibleDirections.size());
                if(possibleDirections.get(direction).equals("North")){
                    mazeList.get(currentHeight).get(currentWidth).north = false;
                    mazeList.get(currentHeight - 1).get(currentWidth).south = false;
                    currentHeight -=1;
                }
                if(possibleDirections.get(direction).equals("South")){
                    mazeList.get(currentHeight).get(currentWidth).south = false;
                    mazeList.get(currentHeight + 1).get(currentWidth).north = false;
                    currentHeight+=1;
                }
                if(possibleDirections.get(direction).equals("East")){
                    mazeList.get(currentHeight).get(currentWidth).east = false;
                    mazeList.get(currentHeight).get(currentWidth + 1).west = false;
                    currentWidth+=1;
                }
                if(possibleDirections.get(direction).equals("West")){
                    mazeList.get(currentHeight).get(currentWidth).west = false;
                    mazeList.get(currentHeight).get(currentWidth - 1).east = false;
                    currentWidth-=1;
                }
            }
        }
    }
    
    public void drawMaze(){//Draws text based version of maze for testing purposes only. 
        System.out.println("");
        for(int i = 0; i < mazeList.get(0).size();i++){
            System.out.println("");
            for(int j = 0; j < mazeList.size(); j++){
                if(mazeList.get(i).get(j).north){
                    System.out.print("+++++");
                }
                else{
                    System.out.print("+   +");
                }
            }
            for(int k = 0; k < 3; k++){
                System.out.println("");
                for(int j = 0; j < mazeList.size();j++){
                    if(mazeList.get(i).get(j).west && mazeList.get(i).get(j).east){
                        System.out.print("+   +");
                    }
                    else if(mazeList.get(i).get(j).west){
                        System.out.print("+    ");
                    }
                    else if(mazeList.get(i).get(j).east){
                        System.out.print("    +");
                    }
                    else{
                        System.out.print("     ");
                    }
                    
                }
            }
            System.out.println("");
            for(int j = 0; j < mazeList.size(); j++){
                if(mazeList.get(i).get(j).south){
                    System.out.print("+++++");
                }
                else{
                    System.out.print("+   +");
                }
            }
        }
        System.out.println("");
    }
    private static boolean checkForMazeBlock(int xCoord, int yCoord, ArrayList<MazeBlock> mazeBlockList){//Checks to see if a mazeBlock with the right xCoor and yCoord are in a list of mazeBlocks. 
        for(int i = 0; i < mazeBlockList.size(); i++){
            if(mazeBlockList.get(i).xCoord == xCoord && mazeBlockList.get(i).yCoord == yCoord){
                return true;
            }
        }
        return false;
    }
}
