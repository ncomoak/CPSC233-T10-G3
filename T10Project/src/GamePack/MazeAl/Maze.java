package GamePack.MazeAl;

import java.util.Random;
<<<<<<< Updated upstream
import java.io.BufferedWriter;
=======
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
>>>>>>> Stashed changes
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Maze
{
    int height;
    int width;
    ArrayList<ArrayList<MazeBlock>> mazeList;
    ArrayList<MazeBlock> usedMazeBlocks = new ArrayList<>();
    

    public Maze(final int height, final int width, String path) throws IOException{
    	
        //Create 2D List. 
        ArrayList <ArrayList<MazeBlock>> mazeList = new ArrayList<>();
        for(int i = 0; i < height; i++){
            mazeList.add(new ArrayList<MazeBlock>());
            for(int j = 0; j < width; j++){
               mazeList.get(i).add(new MazeBlock(j,i));
            }
        }
        //Create a border around the edge of the maze. 
        this.height = height;
        this.width = width;
        this.mazeList = mazeList;
        
        //The Generation and Drawing of the maze 
        recursiveMaze(0, 0, usedMazeBlocks);
        
        //Your algorithm Seems to multiply By a factor of 5;
        drawMaze(width * 5, height * 5, path);
    }
    
    public void recursiveMaze(int currentHeight, int currentWidth, ArrayList<MazeBlock> usedMazeBlocks){
        Random random = new Random();
        ArrayList<String> possibleDirections = new ArrayList<>();
        boolean allBrokenPaths = false;
        while(!allBrokenPaths){
            possibleDirections = new ArrayList<String>();
            if(currentHeight != 0 && !usedMazeBlocks.contains(mazeList.get(currentHeight - 1).get(currentWidth))){
                possibleDirections.add("North");
            }
            if(currentHeight < mazeList.size() - 1&& !usedMazeBlocks.contains(mazeList.get(currentHeight + 1).get(currentWidth))){
                possibleDirections.add("South");
            }
            if(currentWidth != 0 && !usedMazeBlocks.contains(mazeList.get(currentHeight).get(currentWidth - 1))){
                possibleDirections.add("West");
            }
            if(currentWidth < mazeList.get(0).size() - 1 && !usedMazeBlocks.contains(mazeList.get(currentHeight).get(currentWidth + 1))) {
                possibleDirections.add("East");
            }
            if(possibleDirections.size() == 0){
                if(usedMazeBlocks.size() > width*height) {
                    allBrokenPaths = true;
                }
                else{
                    MazeBlock lastMazeBlock = usedMazeBlocks.get(usedMazeBlocks.size() - 1);
                    usedMazeBlocks.remove(usedMazeBlocks.size() - 1);
                    usedMazeBlocks.add(0, lastMazeBlock);
                    usedMazeBlocks.add(0, mazeList.get(currentHeight).get(currentWidth));
                    currentHeight = lastMazeBlock.yCoord;
                    currentWidth = lastMazeBlock.xCoord;
                }
            }
            else{
                usedMazeBlocks.add(mazeList.get(currentHeight).get(currentWidth));
                int direction = random.nextInt(possibleDirections.size());
                if(possibleDirections.get(direction).equals("North")){
                    mazeList.get(currentHeight).get(currentWidth).north = false;
                    mazeList.get(currentHeight - 1).get(currentWidth).south = false;
                    currentHeight -=1;
            //return recursiveMaze(currentHeight - 1, currentWidth, usedMazeBlocks);
                }
                if(possibleDirections.get(direction).equals("South")){
                    mazeList.get(currentHeight).get(currentWidth).south = false;
                    mazeList.get(currentHeight + 1).get(currentWidth).north = false;
                    currentHeight+=1;
                    //return recursiveMaze(currentHeight + 1, currentWidth, usedMazeBlocks);
                }
                if(possibleDirections.get(direction).equals("East")){
                    mazeList.get(currentHeight).get(currentWidth).east = false;
                    mazeList.get(currentHeight).get(currentWidth + 1).west = false;
                    currentWidth+=1;
                    //return recursiveMaze(currentHeight, currentWidth + 1, usedMazeBlocks);
                }
                if(possibleDirections.get(direction).equals("West")){
                    mazeList.get(currentHeight).get(currentWidth).west = false;
                    mazeList.get(currentHeight).get(currentWidth - 1).east = false;
                    currentWidth-=1;
                    //return recursiveMaze(currentHeight, currentWidth - 1, usedMazeBlocks);
                }
            }
        }
    }
    
    public void drawMaze(int width, int height, String path) throws IOException{
    	
    	String firstLine = width + " " + height;
    	String secondLine = "\n" + 100 + " " + 100;
    	
    	BufferedWriter writer = new BufferedWriter(new FileWriter(path));
    	
    	// The width and height of the maze 
    	writer.write(firstLine);
    	writer.write(secondLine);
    	
    	
        //Draws maze (Text based.) -> Goes to res/World(Folder)
        for(int i = 0; i < mazeList.get(0).size();i++){
        	writer.write("\n");
            for(int j = 0; j < mazeList.size(); j++){
                if(mazeList.get(i).get(j).north){
                	writer.write("2 2 2 2 2 ");
                }
                else
                {
                	writer.write("2 1 1 1 2 ");
                }
            }
            for(int k = 0; k < 3; k++){
            	writer.write("\n");
                for(int j = 0; j < mazeList.size();j++){
                    if(mazeList.get(i).get(j).west && mazeList.get(i).get(j).east){
                    	writer.write("2 1 1 1 2 ");
                    }
                    else if(mazeList.get(i).get(j).west){
                    	writer.write("2 1 1 1 1 ");
                    }
                    else if(mazeList.get(i).get(j).east){
                    	writer.write("1 1 1 1 2 ");
                    }
                    else{
                    	writer.write("1 1 1 1 1 ");
                    }
                    
                }
            }
            writer.write("\n");
            for(int j = 0; j < mazeList.size(); j++){
                if(mazeList.get(i).get(j).south){
                	writer.write("2 2 2 2 2 ");
                }
                else{
                	writer.write("2 1 1 1 2 ");
                }
            }
        }
        writer.write("\n");
        writer.close();
    }
}
