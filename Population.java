package Hack2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Population extends JPanel {
	Dot[] dots;
	JFrame window;
	float fitnessSum;
	PVector goal;
	int gen = 1;
	int bestDot = 0;
	int minStep = 400;
	
	Population(int size, JFrame window, PVector goal) {
		this.window = window;
		window.add(this);
		this.goal = goal;
		
		dots = new Dot[size];
		for (int i = 0; i < size; i++) {
			dots[i] = new Dot(goal);
		}
	}
	
//---------------------------------------------------------------------
	
	public void show() {
		repaint();
		
	}
	
//---------------------------------------------------------------------
	
	void update() {
		for (int i = 0; i < dots.length; i++) {
			if (dots[i].brain.step > minStep) {
				dots[i].dead = true;
			} else {				
				dots[i].update();
			}
		}
	}
	
//---------------------------------------------------------------------
	
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 640, 640);
		g.setColor(Color.red);
		g.fillOval(315, 5, 10, 10);
		for (int i = 0; i < dots.length; i++) {
			if (dots[i].isBest) {
				g.setColor(Color.green);
				g.fillOval(dots[i].pos.x(), dots[i].pos.y(), 10, 10);
			} else {
				g.setColor(Color.black);
				g.fillOval(dots[i].pos.x(), dots[i].pos.y(), 4, 4);
			}
			
		}
	}
	
	
//---------------------------------------------------------------------
	
	void calculateFitness() {
		for (int i = 0; i < dots.length; i++) {
			dots[i].calculateFitness();
		}
	}
	
//---------------------------------------------------------------------
		
	boolean allDotsDead() {
		for (int i = 0; i < dots.length; i++) {
			if (!dots[i].dead && !dots[i].reachedGoal) {
				return false;
			}
		}
		return true;
	}
	
//---------------------------------------------------------------------
	
	void naturalSelection() {
		Dot[] newDots = new Dot[dots.length];
		setBestDot();
		calculateFitnessSum();
		newDots[0] = dots[bestDot].getBaby();
		newDots[0].isBest = true;
		for (int i = 1; i < newDots.length; i++) {
			Dot parent = selectParent();
			newDots[i] = parent.getBaby();
		}
		dots = newDots.clone(); //CHECK HERE
		gen++;
	}
	
//---------------------------------------------------------------------
	
	void calculateFitnessSum() {
		fitnessSum = 0;
		for (int i = 0; i < dots.length; i++) {
			fitnessSum += dots[i].fitness;
		}
	}
	
//---------------------------------------------------------------------
	
	Dot selectParent() {
		double randy = Math.random();
		float rand = (float) (fitnessSum * randy);
		float runningSum = 0;
		for (int i = 0; i < dots.length; i++) {
			runningSum += dots[i].fitness;
			if (runningSum > rand) {
				return dots[i];
			}
		}
		return null;
	}
	
//---------------------------------------------------------------------
	
	void mutateBabies() {
		for (int i = 1; i < dots.length; i++) {
			dots[i].brain.mutate();
		}
	}
	
//---------------------------------------------------------------------
	
	void setBestDot() {
		float max = 0;
		int maxIndex = 0;
		for (int i = 0; i < dots.length; i++) {
			if (dots[i].fitness > max) {
				max = dots[i].fitness;
				maxIndex = i;
			}
		}
		bestDot = maxIndex;
		if (dots[bestDot].reachedGoal) {
			minStep = dots[bestDot].brain.step;
			System.out.println("Steps: " + minStep);
		}
	}
	
}




























