package puzzlePxgSimulator.puzzle;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class PuzzleLoader {

	public static final int IMAGE_WIDTH = 624;
	public static final int IMAGE_HEIGHT = 384;
	public static final int COLUMNS = 13;
	public static final int LINES = 8;
	private static final String IMAGE_NAME = "puzzle.jpg";
	private static final PuzzleLoader INSTANCE = new PuzzleLoader();

	public static PuzzleLoader getInstance() {
		return INSTANCE;
	}

	public Puzzle getPuzzle() throws IOException {
		BufferedImage mainImage = ImageIO.read(PuzzleLoader.class.getResource(IMAGE_NAME));
		Piece pieces[][] = new Piece[LINES][COLUMNS];
		int widthSubimage = IMAGE_WIDTH / COLUMNS;
		int heigthSubimage = IMAGE_HEIGHT / LINES;
		int x = 0, y = 0;
		Icon icon = null;
		int index = 0;
		for(int i = 0; i < LINES; i++) {
			for(int j = 0; j < COLUMNS; j++) {
				icon = new ImageIcon(mainImage.getSubimage(x, y, widthSubimage, heigthSubimage));
				pieces[i][j] = new Piece(icon, index);
				index++;
				x += widthSubimage;
			}
			x = 0;
			y += heigthSubimage;
		}
		return new Puzzle(pieces);
	}
}
