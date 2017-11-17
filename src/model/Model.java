package model;

import model.Model;

public class Model {
	private static Model instance=new Model();
	private String data;
	
	private Model() {
		
	}
	
	public static Model getInstance() {
		return instance;
	}
	
}
