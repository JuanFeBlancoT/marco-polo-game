package model;

import processing.core.PApplet;

public class Marco implements Runnable{

	private PApplet app;
	private int posX;
	private int posY;
	private int objectiveX;
	private int objectiveY;
	private boolean dir;
	
	public Marco(PApplet app) {
		posX = 400;
		posY = 400;
		
		this.app = app;
	}
	
	public void drawMarco() {
		app.fill(255);
		app.circle(posX, posY, 40);
	}
	
	public void moveMarco() {
		if(dir && objectiveX > posX) {
			posX+=5;
			dir = !dir;
		}else if(dir && objectiveX < posX) {
			posX -=5;
			dir = !dir;
		}
		
		if(!dir && objectiveY > posY) {
			posY+=5;
			dir = !dir;
		}else if(!dir && objectiveY < posY) {
			posY -=5;
			dir = !dir;
		}
		
	}
	
	public void run() {
		drawMarco();
		moveMarco();
	}

	public void setObjectiveX(int objectiveX) {
		this.objectiveX = objectiveX;
	}

	public void setObjectiveY(int objectiveY) {
		this.objectiveY = objectiveY;
	}
	
	
}
