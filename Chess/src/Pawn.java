import java.util.LinkedList;

public class Pawn extends Piece {
	public Pawn(int xp, int yp, boolean isWhite, String name, LinkedList<Piece> pieces) {
		super(xp, yp, isWhite, name, pieces);
	}

	@Override
	boolean checkmove(int xp, int yp) {
		if (this.xp == xp) {
			if (this.isWhite == true) {
				if ((this.yp - yp) == -1) {
					return true;
				} else {
					return false;
				}
			} else {
				if ((this.yp - yp) == 1) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}
}
