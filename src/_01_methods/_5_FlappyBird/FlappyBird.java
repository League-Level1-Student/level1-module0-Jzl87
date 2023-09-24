package _01_methods._5_FlappyBird;

import processing.core.PApplet;

public class FlappyBird extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;

	int birdX = 50;
	int birdY = 300;
	int obsX = 800;
	int obsY;
	int velocity = -24;
	int gravity = 1;
	float pipe1H = random(75, 275);
	float pipe2H = random(75, 275);
	boolean gameOver = false;
	int score = 0;

	@Override
	public void settings() {
		size(WIDTH, HEIGHT);
	}

	@Override
	public void setup() {

	}

	@Override
	public void draw() {
		background(0, 70, 150);
		fill(255, 0, 0);
		textSize(20);
		text(score, 20, 20);

		if (gameOver == false) {
			// physics
			velocity += gravity;
			birdY += velocity;
			// bird
			ellipse(birdX, birdY, 40, 40);

			if (mousePressed) {
				velocity = -12;
			}

			// pipes
			obsX -= 4;
			rect(obsX, 0, 20, pipe1H);
			rect(obsX, 600 - pipe2H, 20, pipe2H);

			if (obsX < -5) {
				obsX = 800;
				pipe1H = random(75, 265);
				pipe2H = random(75, 265);
			}

			// death
			boolean isXColliding = birdX+20 >= obsX && birdX <= obsX + 20;
			boolean isYTopsColliding = birdY+20 <= pipe1H;
			boolean isYBottomColliding = birdY-20 >= 600-pipe2H;
			
			if (birdY >= 600 || birdY <= 0 || isXColliding && isYTopsColliding || isXColliding && isYBottomColliding) {
				gameOver = true;
			}
			// score
			if (birdX >= obsX && birdX <= obsX + 4) {
				score++;
			}

		} else {
			background(0, 0, 255);
			textSize(100);
			text("Game Over", 40, 300);

		}
	}

	static public void main(String[] args) {
		PApplet.main(FlappyBird.class.getName());
	}
}
