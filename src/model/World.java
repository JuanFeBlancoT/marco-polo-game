package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class World {

	public final static int NUM_AGENTS = 20;
	
	private PApplet app;
	private ArrayList<Agent> agents;
	private Marco marco;
	
	public World(PApplet app) {
		agents = new ArrayList<>();
		this.app = app;
		int x;
		int y;
		int color;
		
		for (int i = 0; i < NUM_AGENTS; i++) {
			x = (int) app.random(780)+20;
			y = (int) app.random(780)+20;
			color = app.color(app.random(255),app.random(255),app.random(255));
			Agent agent = new Agent(app, x, y, color);
			agents.add(agent);
			
		}
		
		marco = new Marco(app, this);
	}

	public ArrayList<Agent> getAgents() {
		return agents;
	}

	public void setAgents(ArrayList<Agent> agents) {
		this.agents = agents;
	}

	public Marco getMarco() {
		return marco;
	}

	public void setMarco(Marco marco) {
		this.marco = marco;
	}

	public void sendMessage() {
		app.textSize(16);
		for (Agent agent : agents) {
			app.text(agent.getPosX()+","+agent.getPosY(), agent.getPosX()-20, agent.getPosY()-20);
		}
	}


	
	
	
}
