import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class Panel extends JPanel{
	public Timer timer;
	final int ONE_SECOND = 1000;
	public Panel() {
		timer = new Timer(ONE_SECOND, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		System.out.println("Enter");
		boolean white = true;
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                if (white) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(i * 64, j * 64, 64, 64);
                white = !white;
            }
            white = !white;
        }
	}
}
