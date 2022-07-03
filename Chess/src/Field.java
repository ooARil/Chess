import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Field extends JFrame {
	private Panel panel;
	
	
	public class ActiveMouse implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			Panel.selectedPiece = Panel.getPiece(e.getX(), e.getY());
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			Panel.selectedPiece.move(e.getX()/64, e.getY()/64);
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public class MoveMouse implements MouseMotionListener {
		@Override
		public void mouseDragged(MouseEvent e) {
			if (Panel.selectedPiece != null) {
				Panel.selectedPiece.x = e.getX() - 32;
				Panel.selectedPiece.y = e.getY() - 32;
				repaint();
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public Field() {
		addMouseListener(new ActiveMouse());
		addMouseMotionListener(new MoveMouse());
		setFocusable(true);
		setBounds(10, 10, 512, 512);
		setUndecorated(true);
		panel = new Panel();
		add(panel);
		setVisible(true);
	}
}
