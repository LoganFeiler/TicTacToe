package Default;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
	private final Dimension preferredSize = new Dimension(450, 450);
	
	public GameScreen() {
		setPreferredSize(preferredSize);
		setBackground(Color.WHITE);
	}
	
	public void PaintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(50, 50, 300, 300);
		repaint();
	}
}
