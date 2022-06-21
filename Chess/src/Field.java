import javax.swing.JFrame;

public class Field extends JFrame {
	private Panel panel;
	public Field() {
		setFocusable(true);
		setBounds(10, 10, 512, 512);
		setUndecorated(true);
		panel = new Panel();
		add(panel);
		setVisible(true);
	}
}
