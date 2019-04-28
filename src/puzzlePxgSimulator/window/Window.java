package puzzlePxgSimulator.window;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import puzzlePxgSimulator.puzzle.Puzzle;
import puzzlePxgSimulator.puzzle.PuzzleLoader;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel labels[][];
	private LayoutManager layout;
	private Border selectedBorder;
	private int selectedI;
	private int selectedJ;
	private Puzzle puzzle;
	
	public Window() {
		setTitle("Pxg Puzzle Simulator");
		setSize(PuzzleLoader.IMAGE_WIDTH + 50, PuzzleLoader.IMAGE_HEIGHT + 50);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		onInit();
	}

	private final void onInit() {
		try {
			this.layout = new GridLayout(8, 13, 0, 0);
			setLayout(this.layout);
			this.selectedBorder = BorderFactory.createLineBorder(Color.RED, 1);
			this.puzzle = PuzzleLoader.getInstance().getPuzzle();
			this.puzzle.shuffle();
			this.selectedI = -1;
			this.selectedJ = -1;
			this.labels = new JLabel[PuzzleLoader.LINES][PuzzleLoader.COLUMNS];
			this.setupIcons();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível carregar a imagem");
		}

	}

	private void swapIcons(int i, int j, int k , int l) {
		Icon temp = this.labels[i][j].getIcon();
		this.labels[i][j].setIcon(this.labels[k][l].getIcon());
		this.labels[k][l].setIcon(temp);
	}
	
	private void setupIcons() {
		for (int i = 0; i < PuzzleLoader.LINES; i++) {
			for (int j = 0; j < PuzzleLoader.COLUMNS; j++) {	
				if(this.labels[i][j] == null) {
					this.labels[i][j] = new JLabel();
					this.labels[i][j].addMouseListener(new LabelMouseListener(this, i, j));
					this.add(this.labels[i][j]);
				}
				this.labels[i][j].setIcon(this.puzzle.getPiece(i, j).getIcon());
			}
		}
	}
	
	public void onClick(int i , int j) {
		if(this.selectedI == -1) {
			this.selectedI = i;
			this.selectedJ = j;
			this.labels[this.selectedI][this.selectedJ].setBorder(selectedBorder);
		}else {
			swapIcons(this.selectedI, this.selectedJ, i, j);
			this.puzzle.move(this.selectedI, this.selectedJ, i, j);
			this.labels[this.selectedI][this.selectedJ].setBorder(null);
			if(puzzle.isCorrect()) {
				int answer = JOptionPane.showConfirmDialog(null, "Quebra cabeça finalizado, deseja fazer outro?", "",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(answer == JOptionPane.YES_OPTION) {
					this.puzzle.shuffle();
					this.setupIcons();
				}else {
					dispose();
				}
			}
			this.selectedI = -1;
			this.selectedJ = -1;
		}
		
	}
	
	public static void main(String[] args) {
		new Window().setVisible(true);
	}
}
