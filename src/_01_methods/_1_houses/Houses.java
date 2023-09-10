package _01_methods._1_houses;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */
public class Houses {

	Robot rob = new Robot();
	Random ran = new Random();
	

	public String small = "60";
	public String medium = "120";
	public String large = "250";

	public void run() {
		// Check the recipe to find out what code to put here
		
		rob.setX(20);
		rob.setY(300);
		rob.penDown();
		rob.setSpeed(40);
		for (int i = 0; i < 9; i++) {

			int heightCompare = ran.nextInt(3);

			int r = ran.nextInt(255);
			int g = ran.nextInt(255);
			int b = ran.nextInt(255);

			if (heightCompare == 2) {
				building(large, r, g, b);
			} else if (heightCompare == 1) {
				house(medium, r, g, b);
			} else {
				house(small, r, g, b);
			}
			
			rob.setPenColor(0, 240, 35);
			rob.move(40);
			rob.turn(-90);
		}
	}

	public void building(String heightStr, int red, int green, int blue) {
		int height = Integer.parseInt(heightStr);
		rob.setPenColor(red, green, blue);
		
		rob.move(height);
		rob.turn(90);
		rob.move(20);
		rob.turn(90);
		rob.move(height);
		rob.turn(-90);
		
	}	

	public void house(String heightStr, int red, int green, int blue) {
		int height = Integer.parseInt(heightStr);
		rob.setPenColor(red, green, blue);
		
		rob.move(height);
		rob.turn(45);
		rob.move(20);
		rob.turn(90);
		rob.move(20);
		rob.turn(45);
		rob.move(height);
		rob.turn(-90);
	}

}
