package model; 

import junit.framework.TestCase;

public class ButtonTest extends TestCase {
	  @org.junit.Test
	    public void testSetLinkedDoor() {
	        Button button=new Button(0,0);
	        Door door=new Door(10,10,button,false);
	        button.setLinkedDoor(door);
	        assertEquals(door,button.getLinkedDoor());
	        button.setLinkedDoor(null);
	        assertEquals(null,button.getLinkedDoor());
	    }
	  
	  @org.junit.Test
	  public void testButton() {
		  Door door=new Door(10,12,null,false);
		  Button button=new Button(20,22);
		  assertEquals(20,button.getX());
		  assertEquals(22,button.getY());
		  assertEquals(null,button.getLinkedDoor());
		  button.setX(0);
		  button.setY(1);
		  assertEquals(0,button.getX());
		  assertEquals(1,button.getY());
	  }

}
