import java.util.LinkedList;

abstract class Piece {
	int xp, yp;
	int x, y;
	boolean isWhite;
	LinkedList<Piece> pieces;
	String name;
	public Piece(int xp, int yp, boolean isWhite, String name, LinkedList<Piece> pieces) {
		this.xp = xp;
		this.yp = yp;
		x = xp * 64;
		y = yp * 64;
		this.isWhite = isWhite;
		this.name = name;
		this.pieces = pieces;
		this.pieces.add(this);
	}
	
	abstract boolean checkmove(int xp, int yp);
	
	public void move(int xp, int yp) {
		if (this.checkmove(xp, yp)) {
			if (Panel.getPiece(xp*64, yp*64) != null) {
				if (Panel.getPiece(xp*64, yp*64) != this &&
						Panel.getPiece(xp*64, yp*64).isWhite != isWhite) {
					Panel.getPiece(xp*64, yp*64).kill();
				}
				else {
					x = this.xp * 64;
					y = this.yp * 64;
					return;
				}
			}
			this.xp = xp;
			this.yp = yp;
			x = xp * 64;
			y = yp * 64;
		} else {
			x = this.xp * 64;
			y = this.yp * 64;
		}
	}
	
	private void kill() {
		pieces.remove(this);
	}
} 
