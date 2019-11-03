package Hack2;

public class PVector {
	float x, y, length;
	
	//creates vector of given x and y and finds length
	public PVector(float x, float y)
	{
		this.x = x;
		this.y = y;
		length = (float) java.lang.Math.sqrt(this.x * this.x + this.y * this.y);
	}

//---------------------------------------------------------------------
	
	//returns unit vector rotated towards angle rad
	public static PVector fromAngle(float rad)
	{
		float newX = (float) (java.lang.Math.cos(rad));
		float newY = (float) (java.lang.Math.sin(rad));
		PVector angle = new PVector(newX, newY);
		return angle;
	}
	
//---------------------------------------------------------------------
	
	public PVector limit(float max) {
		PVector newVect;
		if (length > max) {
			float newX = x * max / length;
			float newY = y * max / length;
			newVect = new PVector(newX, newY);
		} else {
			newVect = new PVector(x, y);
		}
		return newVect;
	}

//---------------------------------------------------------------------
	
	//returns x component of PVector
	public int x()
	{
		return (int) x;
	}

//---------------------------------------------------------------------
	
	//returns y component of PVector
	public int y()
	{
		return (int) y;
	}

//---------------------------------------------------------------------
	
	//returns the PVector
	public PVector clone()
	{
		return new PVector(x,y);
	}

//---------------------------------------------------------------------
	
	public PVector add(PVector changeVector)
	{
		float newX = x + changeVector.x;
		float newY = y + changeVector.y;
		return new PVector(newX, newY);
	}
	
//---------------------------------------------------------------------
	
	public int dist(PVector otherVector){
		float xDist = x - otherVector.x;
		float yDist = y - otherVector.y;
		int totDist = (int) java.lang.Math.sqrt(xDist*xDist+yDist*yDist);
		return totDist;
	}

}