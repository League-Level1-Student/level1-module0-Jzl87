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
    
    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        
    }

    @Override
    public void draw() {
    	background(0,70, 150);
    	fill(255,0,0);
    	
    	velocity += gravity;
    	birdY += velocity;
    	
        ellipse(birdX, birdY, 40,40);
        
        if (mousePressed) {
        	velocity = -12;
        }
        
        if (birdY >= 600 || birdY <= 0) {
        	textSize(100);
        	text("Game Over", 40, 300);
        }
        
        obsX -= 2;
        rect(obsX, 0, 20, random(275));
        
    }

    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
