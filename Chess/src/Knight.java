import java.util.LinkedList;

public class Knight extends Piece {
	public Knight(int xp, int yp, boolean isWhite, String name, LinkedList<Piece> pieces) {
		super(xp, yp, isWhite, name, pieces);
	}

	@Override
	boolean checkmove(int xp, int yp) {
		if (Math.abs(this.xp - xp) == 1) {
			if (Math.abs(this.yp - yp) == 2) {
				return true;
			} else {
				return false;
			}
		} else if (Math.abs(this.yp - yp) == 1) {
			if (Math.abs(this.xp - xp) == 2) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
