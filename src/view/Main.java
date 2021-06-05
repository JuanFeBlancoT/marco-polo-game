package view;

import controller.MainController;
import processing.core.PApplet;

public class Main extends PApplet{
	
	private MainController mainController;
	
	
	public static void main (String[] args) {
		PApplet.main("view.Main");
	}
	
	public void settings() {
	size(800,800);
	}
	
	public void setup() {
		mainController = new MainController(this);
	}

	public void draw() {
		background(40);
		mainController.drawScene();
		
		
	}
} 
