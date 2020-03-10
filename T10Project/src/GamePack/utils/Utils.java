//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 18
package GamePack.utils;

import java.io.*;

//a Class with useful methods 
public class Utils 
{
	/*Loads a file into a single string. 
	 *@param String path, path for a given file.
	 *@return String
	 */
	public static String loadFileAsString(String path)
	{
		StringBuilder builder = new StringBuilder();
		
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null)
			{
				builder.append(line + "\n");
			}
			br.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return builder. toString(); 
	}
	
	/*Parses an int into a string. 
	 * @param String number, string to parse into a number
	 * @return int represention of string
	 * @throws NumberFormatException
	 */
	public static int parseInt(String number)
	{
		try 
		{
			return Integer.parseInt(number);
		} catch (NumberFormatException e) 
		{
			e.printStackTrace();
			return 0;
		}
	}
}
