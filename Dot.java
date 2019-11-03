package Hack2;

import javax.swing.JFrame;

public class Dot {
	PVector pos;
	PVector vel;
	PVector acc;
	PVector goal;
	Brain brain;
	boolean dead = false;
	boolean reachedGoal = false;
	boolean isBest = false;
	int dotIndex;
	float fitness = 0;
	JFrame window;
	
	Dot(PVector goal) {
		this.goal = goal;
		
		brain = new Brain(400);
		
		pos = new PVector(320, 572);
		vel = new PVector(0,0);
		acc = new PVector(0,0);
	}

//---------------------------------------------------------------------
	
	void move()
	{
		if (brain.directions.length > brain.step) {
			acc = brain.directions[brain.step];
			brain.step++;
		} else {
			dead = true;
		}
		vel = vel.add(acc);
		vel = vel.limit(5);
		pos = pos.add(vel);
	}
	
//---------------------------------------------------------------------
	
	void update() {
		if (!dead && !reachedGoal) {
			move();
			if (pos.x < 2 || pos.y < 2 || pos.x > 618 || pos.y > 592) { 
				dead = true;
			} else if (pos.dist(goal) < 5) {
				reachedGoal = true;
			}
		}
	}
	
	
//---------------------------------------------------------------------
	
	void calculateFitness() {
		if (reachedGoal) {
			fitness = 1/16 + 10000/(float)(brain.step*brain.step);
		} else { 
			float distanceToGoal = pos.dist(goal);
			//if (distanceToGoal != 0) {
				fitness = 1 / (distanceToGoal * distanceToGoal);
			//} else {
			//	fitness = 2;
			//}
		}
	}
	
//---------------------------------------------------------------------
		
	Dot getBaby() {
		Dot baby = new Dot(goal);
		baby.brain = brain.copy();
		return baby;
	}
	
}
































