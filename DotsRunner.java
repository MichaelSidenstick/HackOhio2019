package Hack2;

import javax.swing.JFrame;

	public class DotsRunner {
	static boolean drawStop = false;
	static Population test;
	static PVector goal = new PVector(320, 10);
	
	public static void main(String[] args)
	{
//---------------------------------------------------------------------
		
		JFrame window = new JFrame();  
	    window.setSize(640,640);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setVisible(true);
		
//---------------------------------------------------------------------
		
		test = new Population(1000, window, goal);
		draw(drawStop);
	}
	
	public static void draw(boolean drawStop)
	{
		while(!drawStop)
		{
			if (test.allDotsDead()) {
				test.calculateFitness();
				test.naturalSelection();
				test.mutateBabies();
			} else {
				try {
					Thread.sleep(8);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				test.update();
				test.show();
			}
		}
	}
}
