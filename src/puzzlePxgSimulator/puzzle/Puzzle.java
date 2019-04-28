package puzzlePxgSimulator.puzzle;

import java.util.Random;

public class Puzzle {

	private Peace[][] peaces;
	
	public Puzzle(Peace[][] peaces) {
		this.peaces = peaces;
	}
	
	public Peace getPeace(int i, int j) {
		return this.peaces[i][j];
	}
	
	public boolean isCorrect() {
		int index = 0;
		for(int i = 0; i < peaces.length; i++) {
			for(int j = 0; j < peaces[0].length; j++) {
				if(peaces[i][j].getIndex() != index) {
					return false;
				}
				index++;
			}
		}
		return true;
	}
	
	public void move(int i, int j, int k, int l) {
		Peace temp = this.peaces[i][j];
		this.peaces[i][j] = this.peaces[k][l];
		this.peaces[k][l] = temp;
	}
	
	public void shuffle() {
		Random random = new Random();
	    for (int i = this.peaces.length - 1; i > 0; i--) {
	        for (int j = this.peaces[i].length - 1; j > 0; j--) {
	            int m = random.nextInt(i + 1);
	            int n = random.nextInt(j + 1);
	            Peace temp = this.peaces[i][j];
	            this.peaces[i][j] = this.peaces[m][n];
	            this.peaces[m][n] = temp;
	        }
	    }
	}
}
