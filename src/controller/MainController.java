package controller;

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
		for (int i = 0; i < world.getAgents().size(); i++) {
			world.getAgents().get(i).run();
		}
	}

}
