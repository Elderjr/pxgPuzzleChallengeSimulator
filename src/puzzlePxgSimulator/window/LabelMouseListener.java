package puzzlePxgSimulator.window;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LabelMouseListener implements MouseListener {

	private Window window;
	private int i;
	private int j;
	
	public LabelMouseListener(Window window, int i, int j) {
		this.window = window;
		this.i = i;
		this.j = j;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {		
		this.window.onClick(this.i, this.j);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}}
