package GamePack.Input;

import java.util.Scanner;

//checks if a certain key has been pressed
public class KeyManger 
{
	String playerInput = "";
	
	public boolean up,down,left,right;
	
	private String UP_KEY = "w";
	private String DOWN_KEY = "s";
	private String LEFT_KEY = "a";
	private String RIGHT_KEY = "d";
	
	//where calculations happen
	public void tick() 
	{
		Scanner playerInputReader = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter a key");
		
		playerInput = playerInputReader.nextLine();
		checkInput();
	}

	//checks if a certain input is given 
	private void checkInput() 
	{
		if(playerInput == UP_KEY)
		{
			up = true;
		}
		
		if(playerInput == DOWN_KEY)
		{
			down = true;
		}
		
		if(playerInput == LEFT_KEY)
		{
			left = true;
		}
		
		if(playerInput == RIGHT_KEY)
		{
			right = true;
		}
	}
	 
	
}
	

