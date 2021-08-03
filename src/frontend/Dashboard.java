package frontend;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dashboard {

	Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	int height = size.height;
	int width = size.width;
	
	JFrame dashboardFrame;
	JPanel headerJPanel;
	public Dashboard() {
		dashboardFrame = new JFrame("Dashboard");

		//header
		headerJPanel = new JPanel();
		headerJPanel.setSize(40, 10);
		headerJPanel.setBackground(Color.black);
		dashboardFrame.add(headerJPanel);
	
		
		dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dashboardFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		dashboardFrame.setResizable(false);
		dashboardFrame.setVisible(true);
	}
	
	public static void main(String args[]) {	
	
		Dashboard dashboard = new Dashboard();
	
	}
}