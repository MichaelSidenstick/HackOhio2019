package Hack2;

public class Brain {
	PVector[] directions;
	int step = 0;
	
	Brain(int size) {
		directions = new PVector[size];
		randomize();
	}
	
	
//---------------------------------------------------------------------
	
	void randomize() {
		for(int i = 0; i < directions.length; i++) {
			float randomAngle = (float) (2 * 3.141592653589 * Math.random());
			directions[i] = PVector.fromAngle(randomAngle);
		}
	}
	
//---------------------------------------------------------------------
	
	Brain copy() {
		Brain copy = new Brain(directions.length);
		for(int i = 0; i < directions.length; i++) {
			copy.directions[i] = directions[i].clone();
		}
		return copy;
	}
	
//---------------------------------------------------------------------
	
	void mutate() {
		float mutationRate = (float) 0.01;
		for(int i = 0; i < directions.length; i++) {
			float rand = (float) Math.random();
			if (rand < mutationRate) {
				float randomAngle = (float) (2 * 3.141592653589 * Math.random());
				directions[i] = PVector.fromAngle(randomAngle);
			}
		}	
	}
	
}
