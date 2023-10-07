package _04_gui_from_scratch._1_fortune_cookie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FortuneCookies implements ActionListener {

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();

	public void showButton() {
		System.out.println("ButtonClicked");
		frame.setVisible(true);
		frame.add(panel);
		panel.add(button);
		button.setText("FORTUNE COOKIE!, CLICK HERE");
		frame.pack();
		button.addActionListener(this);
	}

	@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "WOOHOO!");
			int ran = random.nextInt(5);
			if (ran == 0) {
				JOptionPane.showMessageDialog(null, "You will get hit by a train at 37");
			} else if (ran == 1) {
				JOptionPane.showMessageDialog(null, "You will win the lottery and then lose everything");
			} else if (ran == 2) {
				JOptionPane.showMessageDialog(null, "You are going to eat a chocolate bar today");
			} else if (ran == 3) {
				JOptionPane.showMessageDialog(null, "You are going to find the love of your life tonight");
			} else {
				JOptionPane.showMessageDialog(null, "You are going to succeed");
			}
			
		}

}
