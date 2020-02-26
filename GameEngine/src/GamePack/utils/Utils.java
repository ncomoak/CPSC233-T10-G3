package GamePack.utils;

import java.io.*;

//a Class with useful methods 
public class Utils 
{
	//Loads a file into a single String
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
	
	//parses and int form a string 
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
