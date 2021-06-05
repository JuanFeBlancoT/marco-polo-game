package controller;

import model.Agent;
import model.World;
import processing.core.PApplet;

public class MainController {

	private PApplet app;
	private World world;
	
	public MainController(PApplet app) {
		this.app = app;
		world = new World(app);
		
	}
	
	public void drawScene() {
		/*for (int i = 0; i < world.getAgents().size(); i++) {
			new Thread(world.getAgents().get(i)).start();
		}*/
		
		for (Agent agent : world.getAgents()) {
			agent.drawAgent();
			new Thread(agent).start();
		}
		
		//new Thread(world.getAgents().get(0)).start();
		world.getMarco().drawMarco();
		new Thread(world.getMarco()).start();

		
	}

}
