package frontend;

import javax.swing.JFrame;

public class MainFrame {

	public MainFrame() {
		JFrame mainFrame = new JFrame("Dashboard");
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); //default maximum frame
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);

	}
}
