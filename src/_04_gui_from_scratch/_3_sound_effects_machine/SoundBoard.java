package _04_gui_from_scratch._3_sound_effects_machine;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SoundBoard implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	JButton button5 = new JButton();
	JButton button6 = new JButton();
	
	Dimension large = new Dimension(100,40);
	
	public void setup() {
		frame.setTitle("Sound Board");
		frame.setVisible(true);
		frame.add(panel);
		
		panel.add(button1);
		button1.setText("Spaceship");
		button1.setPreferredSize(large);
		button1.addActionListener(this);
		
		panel.add(button2);
		button2.setText("Seagulls");
		button2.setPreferredSize(large);
		button2.addActionListener(this);
		
		panel.add(button3);
		button3.setText("Big bark");
		button3.setPreferredSize(large);
		button3.addActionListener(this);
		
		panel.add(button4);
		button4.setText("Bell");
		button4.setPreferredSize(large);
		button4.addActionListener(this);
		
		panel.add(button5);
		button5.setText("Small bark");
		button5.setPreferredSize(large);
		button5.addActionListener(this);
		
		panel.add(button6);
		button6.setText("SOS");
		button6.setPreferredSize(large);
		button6.addActionListener(this);
		
		frame.pack();
		
		
	}

	private void playSound(String soundFile) {
		String path = "src/_04_gui_from_scratch/_3_sound_effects_machine/";
			File sound = new File(path+soundFile);
			if (sound.exists()) {
				new Thread(() -> {
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
					Thread.sleep(clip.getMicrosecondLength()/1000);
				}
				catch (Exception e) {
					System.out.println("Could not play this sound");
				}}).start();
	 		}
			else {
				System.out.println("File does not exist");
			}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if (button1 == buttonPressed) {
			playSound("alien-spaceship_daniel_simion.wav");
		} else if (button2 == buttonPressed) {
			playSound("flock-of-seagulls_daniel-simion.wav");
		} else if (button3 == buttonPressed) {
			playSound("labrador-barking-daniel_simon.wav");
		}else if (button4 == buttonPressed) {
			playSound("service-bell_daniel_simion.wav");
		}else if (button5 == buttonPressed) {
			playSound("small-dog-barking_daniel-simion.wav");
		} else {
			playSound("sos-morse-code_daniel-simion.wav");
		}
	}
}
