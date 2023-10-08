package _04_gui_from_scratch._4_cuteness_tv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CuteVideoPlayer implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Pink Unicorns");
	JButton button2 = new JButton("Duck Song");
	JButton button3 = new JButton("Funny Frog");
	
	public void setup() {
		
		frame.setTitle("Video Player");
		frame.setVisible(true);
		frame.add(panel);
		
		panel.add(button1);
		button1.addActionListener(this);
		
		panel.add(button2);
		button2.addActionListener(this);
		
		panel.add(button3);
		button3.addActionListener(this);
		
		frame.pack();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		
		if (buttonPressed == button1) {
			showFluffyUnicorns();
		} else if (buttonPressed == button2) {
			showDucks();
		} else {
			showFrog();
		}
	}
	
	void showDucks() {
	     playVideo("https://www.youtube.com/watch?v=MtN1YnoL46Q");
	}

	void showFrog() {
	     playVideo("https://www.youtube.com/watch?v=cBkWhkAZ9ds");
	}

	void showFluffyUnicorns() {
	     playVideo("https://www.youtube.com/watch?v=qRC4Vk6kisY");
	}

	void playVideo(String videoID) {
	     
	     // Workaround for Linux because "Desktop.getDesktop().browse()" doesn't
	     //work on some Linux implementations
	     try {
	     if (System.getProperty("os.name").toLowerCase().contains("linux")) {
	     if (Runtime.getRuntime().exec(new String[] {
	      "which", "xdg- open" }).getInputStream().read() != -1) {
	     Runtime.getRuntime().exec(new String[] { "xdg-open", videoID });
	     }
	     } else {
	          URI uri = new URI(videoID);
	          java.awt.Desktop.getDesktop().browse(uri);
	     }      } catch (Exception e) {
	          e.printStackTrace();
	     }
	}
}
