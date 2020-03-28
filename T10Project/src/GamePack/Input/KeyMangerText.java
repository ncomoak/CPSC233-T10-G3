//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 14
package GamePack.Input;

import java.util.Scanner;

//checks if a certain key has been pressed
public class KeyMangerText 
{
	String playerInput = "";
	
	public boolean up,down,left,right;
	
	private String UP_KEY = "w";
	private String DOWN_KEY = "s";
	private String LEFT_KEY = "a";
	private String RIGHT_KEY = "d";
	
	/*Tick method for key manager. 
	 * 
	 */
	public String tick() 
	{
		Scanner playerInputReader = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter a key");
		
		playerInput = playerInputReader.nextLine();
		return checkInput();
	}

	/*checks if a certain input is given 
	*@return String checkInput
	*/
	private String checkInput() 
	{
		if(playerInput.equals(UP_KEY))
		{
			return "w";
		}
		
		if(playerInput.equals(DOWN_KEY))
		{
			return "s";
		}
		
		if(playerInput.equals(LEFT_KEY))
		{
			return "a";
		}
		
		if(playerInput.equals(RIGHT_KEY))
		{
			return "d";
		}
		return "n";
	}
	 
	
}
