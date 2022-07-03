import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel extends JPanel {
	private static LinkedList<Piece> pieces = new LinkedList<>();
	public static Piece selectedPiece;
	private BufferedImage images; // Разделить изображение
	private Map<String, Image> whiteImage, blackImage; // Словарь хранения наименования и изображения фигуры
	private String[] namesPieces = new String[] { // Массив наименования фигуры
		"king", "queen", "bishop", 
		"knight", "rook", "pawn"
	};
	final Color WHITE_TILE = new Color(249, 205, 160);
	final Color BLACK_TILE = new Color(209, 139, 70);
	
	public Panel() {
		{ // Разрезка изображения на белые и черные фигуры
			try {
				images = ImageIO.read(getClass().getResource("/pieces.png"));
			} catch (Exception e) {
				System.out.println("Image not founded");
			}
			
			whiteImage = new HashMap<String, Image>();
			for (int x=0, i=0; x<1200; x+=200, i++) {
				whiteImage.put(namesPieces[i],
						images.getSubimage(x, 0, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH));
			}
			
			blackImage = new HashMap<String, Image>();
			for (int x=0, i=0; x<1200; x+=200, i++) {
				blackImage.put(namesPieces[i],
						images.getSubimage(x, 200, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH));
			}
		}
		
		{	
			for (Entry<String, Image> entry : whiteImage.entrySet()) {
				switchSetPiece(entry.getKey(), true);
			}
			
			for (Entry<String, Image> entry : blackImage.entrySet()) {
				switchSetPiece(entry.getKey(), false);
			}
		}
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		{ // Отрисовка плитки
			boolean white = true;
	        for (int i=0; i<8; i++) {
	            for (int j=0; j<8; j++) {
	                if (white) {
	                    g.setColor(WHITE_TILE);
	                } else {
	                    g.setColor(BLACK_TILE);
	                }
	                g.fillRect(i * 64, j * 64, 64, 64);
	                white = !white;
	            }
	            white = !white;
	        }
		}
		
		{ // Отрисовка фигур
			for (Piece ps : pieces) {
				switch (String.valueOf(ps.isWhite)) { 
					case "true": {
						g.drawImage(whiteImage.get(ps.name), ps.x, ps.y, this);
						break;
					}
					case "false": {
						g.drawImage(blackImage.get(ps.name), ps.x, ps.y, this);
						break;
					}
				}
			}
		}
	}
	
	void switchSetPiece(String namePiece, boolean isWhite) {
		int yp = isWhite ? 0 : 7;
		switch (namePiece) {
			case "king": {
				Piece piece = new King(3, yp, isWhite, namePiece, pieces);
				break;
			}
			case "queen": {
				Piece piece = new Queen(4, yp, isWhite, namePiece, pieces);
				break;
			}
			case "bishop": {
				Piece piece1 = new Bishop(2, yp, isWhite, namePiece, pieces);
				Piece piece2 = new Bishop(5, yp, isWhite, namePiece, pieces);
				break;
			}
			case "knight": {
				Piece piece1 = new Knight(1, yp, isWhite, namePiece, pieces);
				Piece piece2 = new Knight(6, yp, isWhite, namePiece, pieces);
				break;
			}
			case "rook": {
				Piece piece1 = new Rook(0, yp, isWhite, namePiece, pieces);
				Piece piece2 = new Rook(7, yp, isWhite, namePiece, pieces);
				break;
			}
			case "pawn": {
				int bias = isWhite ? 1 : -1;
				for (int i=0; i<8; i++) {
					Piece piece = new Pawn(i, yp+bias, isWhite, namePiece, pieces);
				}
				break;
			}
		}
	}
	
	public static Piece getPiece(int x, int y) {
		int xp = x/64;
		int yp = y/64;
		
		for (Piece p: pieces) {
			if (p.xp == xp && p.yp == yp) {
				return p;
			}
		}
		
		return null;
	}
}

