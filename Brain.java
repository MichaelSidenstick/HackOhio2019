package Hack;

public class Brain {

	//Initializing stuff
	PVector[] directions;
	int step = 0;
	
	//Creating the constructor
	public Brain(int size){
		
		directions = new PVector[size]; //Creates a new set of directions (tons of pairs of x and y coordinates that the dot will travel)
		randomize(); //Calls randomize function
		
	}

	public void randomize() {
	    for (int i = 0; i< directions.length; i++) {
	      double randomAngle = 2*3.141592654*Math.random(); //Sets angle
	      directions[i] = PVector.fromAngle(randomAngle); //Calls fromAngle method which breaks angle into components
	    }
	  }
	
	public Brain copy() {
		
		Brain copy = new Brain(directions.length); // Creates new Brain (dot) 
		for (int i = 0; i<directions.length; i++) { //Loops thru all directions
			
			copy.directions[i] = directions[i].clone(); //Clones directions into a new dot (survivor?)
			
		}
		
		return copy;
		
	}
	
	public void mutate() {
		
		double mutationRate = 0.01; //Sets mutation rate
		for (int i = 0; i<directions.length; i++){ //Loops through entire direction vector 
		
			double rand = Math.random(); //Generates double from 0 to 1
			if(rand < mutationRate) { //Checks for whether current dot should mutate
				
				double randomAngle = 2*3.14159265; //Sets new angle 
				directions[i] = PVector.fromAngle(randomAngle); //Sets new direction vector to 
				
			}
			
		}
	}

}
