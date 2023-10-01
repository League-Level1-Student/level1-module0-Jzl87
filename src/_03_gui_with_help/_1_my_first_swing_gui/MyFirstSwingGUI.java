package _03_gui_with_help._1_my_first_swing_gui;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import processing.core.PImage;

public class MyFirstSwingGUI {
	public void run() {

		// 1. Create and initialize an object of the JFrame class
		JFrame mike = new JFrame();
		// 2. Set your JFrame object to be visible
		mike.setVisible(true);
		// 3. Run your program. Do you see your window? It's probably very
		// small.

		// 4. Set the default close operation to JFrame.EXIT_ON_CLOSE
		mike.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 5. Create and initialize an object of the JPanel class
		JPanel mike2 = new JPanel();
		// 6. Create and initialize an object of the JLabel class
		JLabel mike3 = new JLabel();
		// 7. Set the text of the JLabel to a lovely greeting.
		mike3.setText("HALLO");
		// 8. Add the JPanel object to the JFrame
		mike.add(mike2);
		// 9. Add the JLabel object to the JPanel
		mike2.add(mike3);
		// 10. Pack your JFrame.
		mike.pack();
		// 11. Run your program again. Do you see your message.
		
		// 12. Use the loadImage method to set the icon of the JLabel object.
		mike3.setIcon(loadImage());
		// 13. Re-pack the JFrame object.
		mike.pack();
		// 14. Run the program one more time. Do you see the image?

	}

	public ImageIcon loadImage() {
		try {
			return new ImageIcon(ImageIO.read(new MyFirstSwingGUI().getClass().getResourceAsStream("java.png")));
		} catch (IOException e) {

			return null;
		}
	}
}
