//https://www.youtube.com/watch?v=dEKs-3GhVKQ&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=1
//Video: 2,3,5,14

package GamePack;

import java.awt.*;
import javax.swing.JFrame;

// This Class creates the window
public class Display 
{
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width,height;
	
	/*Constructor, sets up a new Display 
	* @param String, title. the title of the window.
	* @param int, width. the width of the display.
	* @return void,
	*/
	public Display(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}

	/*Creates a new window
	* @return void,
	*/
	private void createDisplay() 
	{
		frame = new JFrame(title);
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
	
	//Getters and Setters
	
	/*gets the Canvas
	* @return canvas, the canvas of the Jframe.
	*/
	public Canvas getCanvas()
	{
		return canvas;	
	}
	
	/*gets the JFrame
	* @return JFrame, the Jframe.
	*/
	public JFrame getFrame()
	{
		return frame;
	}
}

