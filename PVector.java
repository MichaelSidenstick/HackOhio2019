package Hack;

public class PVector {

	private double x, y;
	private static double length;

	public PVector(double x, double y)
	{

		x = this.x;
		y = this.y;
		length = (float) java.lang.Math.sqrt(this.x * this.x + this.y * this.y); //Calculates magnitude of angle

	}

	public static PVector fromAngle(double rad) //Finds the components of a given angle
	{
		double newX = length * (double) java.lang.Math.cos(rad); //X component of angle
		double newY = length * (double) java.lang.Math.sin(rad); //Y component of angle
		PVector angle = new PVector(newX, newY); //New direction based off components
		return angle; //Returns vector generated
	}

	public double x()
	{
		return x;
	}

	public double y()
	{
		return y;	
	}

	public PVector clone()
	{
		
		return new PVector(x, y); //Returns a copy of current vector of directions
		
	}
	
}

	

	