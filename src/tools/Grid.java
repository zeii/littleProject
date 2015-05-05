package tools;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;

import javax.swing.JPanel;
 
public class Grid extends JPanel {
	
	static final int CHECKER_SIZE = 20;
	static Integer[][] grid;
	private int width;
	private int height;
	
	public Grid(int width, int height, Integer[][] grid){
		this.grid = grid;
		this.width = width;
		this.height = height;		
	}
	  
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.darkGray);
			
		int stripeX = 0;
		int a = getWidth();
		grid[0][0] = 0;
		grid[this.width-1][0] = 0;
		int stripeY = this.height/ getHeight();
		for(int i=0 ; i < this.width ; i++){
			stripeY = 0;
			for(int j=0; j < this.height ; j++){
				if(grid[i][j] != null){
					defineColor(g, i, j);
					g.fillRect(stripeX, stripeY, CHECKER_SIZE/2, CHECKER_SIZE/2);
				}				
				stripeY += CHECKER_SIZE/2;
			}
			stripeX += CHECKER_SIZE/2;
		}
	}

	/**
	 * Défini la couleur de la cellule
	 * @param g
	 * @param i
	 * @param j
	 */
	private void defineColor(Graphics g, int i, int j) {
		switch (grid[i][j]) {
		case 0:
			g.setColor(Color.darkGray);
			break;
		case 1:
			g.setColor(Color.black);
			break;
		case 2:
			g.setColor(Color.cyan);
			break;
		case 3:
			g.setColor(Color.ORANGE);
			break;
		case 4:
			g.setColor(Color.green);
			break;
		case 5:
			g.setColor(Color.yellow);
			break;
		case 6:
			g.setColor(Color.lightGray);
			break;
		case 7:
			g.setColor(Color.PINK);
			break;
		case 8:
			g.setColor(Color.orange);
			break;
		case 9:
			g.setColor(Color.MAGENTA);
			break;
		case 100:
			g.setColor(Color.RED);
			break;
		default:
			break;
		}
	}          
}