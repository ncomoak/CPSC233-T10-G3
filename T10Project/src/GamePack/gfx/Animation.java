//https://www.youtube.com/watch?v=uitt3vk-Xkk&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=25&ab_channel=CodeNMore

package GamePack.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	
	private int speed;
	private int index;
	private long lastTime;
	private long timer;
	private BufferedImage[] frames;
	
	/*Constructor, sets up a new Animation
	* @param int, speed. the animation speed.
	* @param BufferedImage, frames. the frames the animation will use.
	* @return void,
	*/
	public Animation(int speed, BufferedImage[] frames)
	{
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public void tick() 
	{
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if (timer > speed) 
		{
			index++;
			timer = 0;
			if (index >= frames.length)
				index = 0;
			
		}
	}
	
	/*gets CurrentFrame
	 * @return BufferedImage frame[index]
	 */
	public BufferedImage getCurrentFrame()
	{
		return frames[index];
	}
	
	

}
