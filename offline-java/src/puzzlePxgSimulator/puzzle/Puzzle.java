package puzzlePxgSimulator.puzzle;

import java.util.Random;

public class Puzzle {

	private Piece[][] pieces;
	
	public Puzzle(Piece[][] peaces) {
		this.pieces = peaces;
	}
	
	public Piece getPiece(int i, int j) {
		return pieces[i][j];
	}
	
	public boolean isCorrect() {
		int index = 0;
		for(int i = 0; i < pieces.length; i++) {
			for(int j = 0; j < pieces[0].length; j++) {
				if(pieces[i][j].getIndex() != index) {
					return false;
				}
				index++;
			}
		}
		return true;
	}
	
	public void move(int i, int j, int k, int l) {
		Piece temp = pieces[i][j];
		pieces[i][j] = pieces[k][l];
		pieces[k][l] = temp;
	}
	
	public void shuffle() {
		Random random = new Random();
	    for (int i = pieces.length - 1; i > 0; i--) {
	        for (int j = pieces[i].length - 1; j > 0; j--) {
	            int m = random.nextInt(i + 1);
	            int n = random.nextInt(j + 1);
	            Piece temp = pieces[i][j];
	            pieces[i][j] = pieces[m][n];
	            pieces[m][n] = temp;
	        }
	    }
	}
}
