package model;

import processing.core.PApplet;

public class Agent implements Runnable{

	public final static int SIZE = 40;	
	
	private PApplet app;
	private int posX;
	private int posY;
	private int colorAgent;
	private int moveH;
	private int moveV;
	
	public Agent(PApplet app, int x, int y, int ca) {
		posX = x;
		posY = y;
		colorAgent = ca;
		this.app = app;
		//assign random starting directions
		moveH = (int) app.random(2)+1;
		if(moveH == 2) {
			moveH = -1;
		}
		moveV = (int) app.random(2)+1;
		if(moveV == 2) {
			moveV = -1;
		}
	}
	
	public void drawAgent() {
		app.fill(colorAgent);
		app.circle(posX, posY, SIZE);
	}
	
	public void moveAgent() {
		posX+=moveH;
		posY+=moveV;
		changeDir();
	}

	private void changeDir() {
		if(posX > 800-SIZE/2 || posX < SIZE/2) {
			moveH *= -1;
		}		
		if(posY > 800-SIZE/2 || posY < SIZE/2) {
			moveV *= -1;
		}
	}

	@Override
	public void run() {
			moveAgent();
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
}
