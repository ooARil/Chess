import java.util.LinkedList;

public class Rook extends Piece {
	public Rook(int xp, int yp, boolean isWhite, String name, LinkedList<Piece> pieces) {
		super(xp, yp, isWhite, name, pieces);
	}

	@Override
	boolean checkmove(int xp, int yp) {
		if (this.xp == xp) {
			return true;
		} else if (this.yp == yp) {
			return true;
		} else {
			return false;
		}
	}
}
