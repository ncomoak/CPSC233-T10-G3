package GamePack.Input;

import java.util.Scanner;

//checks if a certain key has been pressed
public class KeyManger 
{
	String input = "";
	
	public boolean up,down,left,right;
	
	private String UP_KEY = "w";
	private String DOWN_KEY = "s";
	private String LEFT_KEY = "a";
	private String RIGHT_KEY = "d";
	
	public void tick() 
	{
		Scanner playerInputReader = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter a key");
		
		input = playerInputReader.nextLine();
		checkInput();
	}

	private void checkInput() 
	{
		if(input == UP_KEY)
		{
			up = true;
		}
		
		if(input == DOWN_KEY)
		{
			down = true;
		}
		
		if(input == LEFT_KEY)
		{
			left = true;
		}
		
		if(input == RIGHT_KEY)
		{
			right = true;
		}
	}
	 
	
}
	

