import java.util.LinkedList;

public class Queen extends Piece {
	public Queen(int xp, int yp, boolean isWhite, String name, LinkedList<Piece> pieces) {
		super(xp, yp, isWhite, name, pieces);
	}

	@Override
	boolean checkmove(int xp, int yp) {
		if (this.xp == xp || this.yp == yp) {
			return true;
		} else if (this.xp != xp && this.yp != yp) {
			if (Math.abs(this.xp - xp) == Math.abs(this.yp - yp)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
