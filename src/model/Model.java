package model;

import model.Model;

public class Model {
	private static Model instance=new Model();
	Labyrinth labyrinth;
	Score score;
	
	private Model() {
		
	}
	
	public static Model getInstance() {
		return instance;
	}
	
}
