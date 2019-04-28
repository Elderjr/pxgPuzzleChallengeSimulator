package puzzlePxgSimulator.puzzle;

import javax.swing.Icon;

public class Piece {

	private Icon icon;
	private int index;
	
	public Piece(Icon icon, int index) {
		this.icon = icon;
		this.index = index;
	}
	
	public Icon getIcon() {
		return this.icon;
	}
	
	public int getIndex() {
		return this.index;
		
	}
}
