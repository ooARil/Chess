import java.util.LinkedList;

public class King extends Piece {
	public King(int xp, int yp, boolean isWhite, String name, LinkedList<Piece> pieces) {
		super(xp, yp, isWhite, name, pieces);
	}

	@Override
	boolean checkmove(int xp, int yp) {
		if (Math.abs(this.xp - xp) <= 1 && Math.abs(this.yp - yp) <= 1) {
			return true;
		} else {
			return false;
		}
	}
}
