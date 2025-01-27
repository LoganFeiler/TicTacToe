package Default;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display {
	private JFrame frame = new JFrame("Tic Tac Toe");
	private JPanel mainPanel = new JPanel();
	private JPanel northPanel = new JPanel();
	private JLabel whichPlayer = new JLabel("Player 1 (X)");
	private JPanel gameScreen = new GameScreen();
	
	public Display() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new FlowLayout());
		northPanel.add(whichPlayer);
		mainPanel.add(gameScreen, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
	
}
