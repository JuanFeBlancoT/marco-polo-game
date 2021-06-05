package model;

import processing.core.PApplet;

public class Marco implements Runnable{

	private PApplet app;
	private int posX;
	private int posY;
	private int objectiveX;
	private int objectiveY;
	private boolean dir;
	private int countDown;
	private World world;

	
	public Marco(PApplet app, World world) {
		posX = 400;
		posY = 400;
		countDown = 120;
		
		this.app = app;
		this.world = world;
	}
	
	public void drawMarco() {
		app.fill(255);
		app.circle(posX, posY, 40);
		
		count();
		verifyCollide();
	}
	
	private void verifyCollide() {
		for (int i = 0; i < world.getAgents().size(); i++) {
			if(app.dist(posX, posY, world.getAgents().get(i).getPosX(), world.getAgents().get(i).getPosY()) <= 25) {
				world.getAgents().remove(i);
			}
		}
	}

	private void count() {
		countDown--;
		if(countDown <= 0) {
			countDown = 120;
			askPolo();
			app.text("Marco", posX-20, posY-20);
		}
	}

	private void askPolo() {
		int minDist = 10000;
		int indexMin = -1;
		for (int i = 0; i < world.getAgents().size(); i++) {
			@SuppressWarnings("static-access")
			int actualDist = (int) app.dist(world.getAgents().get(i).getPosX(), world.getAgents().get(i).getPosY(), posX, posY);
			if(actualDist < minDist) {
				minDist = actualDist;
				indexMin = i;
		
			}
		}
	if(world.getAgents().size()>0) {
		objectiveX = world.getAgents().get(indexMin).getPosX();
		objectiveY = world.getAgents().get(indexMin).getPosY();
	}
		
		
		world.sendMessage();
	}

	public void moveMarco() {
		if(dir && objectiveX > posX) {
			posX+=7;
			dir = !dir;
		}else if(dir && objectiveX < posX) {
			posX -=7;
			dir = !dir;
		}
		
		if(!dir && objectiveY > posY) {
			posY+=7;
			dir = !dir;
		}else if(!dir && objectiveY < posY) {
			posY -=7;
			dir = !dir;
		}
		
	}
	
	public void run() {
		moveMarco();
	}

	public void setObjectiveX(int objectiveX) {
		this.objectiveX = objectiveX;
	}

	public void setObjectiveY(int objectiveY) {
		this.objectiveY = objectiveY;
	}


}
