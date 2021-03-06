package littleProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import tools.Grid;
import Avatars.Avatar;
import Avatars.IConstantsAvatars;
import Avatars.multi.Pion;

public class Second extends Initilizer{

	private static int NB_PIONS = 500;
	
	public void run() throws InterruptedException{
		initWorld();
		
		for(int i=0 ; i < NB_PIONS ; i++){
			Avatar pion = new Pion(1, 1, 20, 6, HEIGHWORLD, WIDTHWORLD, WORLD);
			pion.setColor(pion.getColor());
			pion.setMatricule(WORLD.addAvatar(pion));
		}
		
		runWorld();
	}
	
	protected void runWorld() throws InterruptedException{
		int nbWin = 0;
		while(nbWin < NB_PIONS){
			MAP_WORLD = new Grid(HEIGHWORLD, WIDTHWORLD, WORLD.getData());
			WORLD.add(MAP_WORLD);
			WORLD.setVisible(true);
			nbWin = getNumberAvatarWin();
			System.out.println(nbWin);
			Thread.sleep(FRAME_SPEED);
			WORLD.event(initData());
		}
	}
	
	private int getNumberAvatarWin(){
		int nbWin = 0;
		for(Entry<String, Avatar> entryAvatar : WORLD.getMapAvatarsTri().get(IConstantsAvatars.PION).entrySet()){
			Pion av = (Pion) entryAvatar.getValue();
			if(av.isWin()){
				nbWin++;
			}
		}
		return nbWin;
	}
	
	protected Integer[][] initData() {
		Integer[][] labyrinthe = new Integer[HEIGHWORLD][WIDTHWORLD];
		
		//laby1(labyrinthe);
		laby2(labyrinthe);
		
		return labyrinthe;
	}

	private void laby1(Integer[][] labyrinthe) {
		List<Integer> listX = new ArrayList<Integer>();
		listX.add(0);
		listX.add(3);
		listX.add(8);
		listX.add(14);
		listX.add(16);
		listX.add(23);
		listX.add(89);
		listX.add(88);
		listX.add(87);
		listX.add(110);
		listX.add(100);
		
		for(int i = 60; i < 80 ; i++){
			listX.add(i);
		}
		
		List<Integer> listY = new ArrayList<Integer>();
		listY.add(25);
		listY.add(2);
		listY.add(42);
		listY.add(15);
		listY.add(35);
		listY.add(27);
		
		for(int i = 25; i < 35 ; i++){
			listY.add(i);
		}
		
		for(int i = 0 ; i < HEIGHWORLD ; i++){
			for(int j = 0; j < WIDTHWORLD ; j++){
				if(!listX.contains(i) && !listY.contains(j)  ){
					labyrinthe[i][j] = 0;
				}
			}
		}
		
		labyrinthe[110][15] = 100;
	}

	private void laby2(Integer[][] labyrinthe) {
		List<Integer> listX = new ArrayList<Integer>();
		listX.add(20);
		listX.add(60);
		
	
		List<Integer> listY = new ArrayList<Integer>();
		for(int i = 5; i < 50 ; i++){
			listY.add(i);
		}
	
		
		for(int i = 0 ; i < HEIGHWORLD ; i++){
			for(int j = 0; j < WIDTHWORLD ; j++){
				if(!listX.contains(i) || !listY.contains(j)){
					labyrinthe[i][j] = 0;
				}
			}
		}
		
		for(int i = 20 ; i < 61 ; i++){
			labyrinthe[i][50] = null;
			labyrinthe[i][35] = null;
			labyrinthe[i][40] = null;
			labyrinthe[i][20] = null;
		}	
		
		for(int i = 60 ; i < 97 ; i++){
			labyrinthe[i][37] = null;
			labyrinthe[i][56] = null;
		}	
		
		for(int i = 5 ; i < 40 ; i++){
			labyrinthe[i][20] = null;
		}	
		
		for(int i = 40 ; i < 96 ; i++){
			labyrinthe[i][20] = null;
		}
		
		for(int i = 20 ; i < 30 ; i++){
			labyrinthe[70][i] = null;
		}
		
		for(int i = 23 ; i < 28; i++){
			labyrinthe[72][i] = null;
		}
		
		for(int i = 25 ; i < 28; i++){
			labyrinthe[78][i] = null;
		}
		
		for(int i = 23 ; i < 30 ; i++){
			labyrinthe[80][i] = null;
		}
		
		for(int i = 70 ; i < 81 ; i++){
			labyrinthe[i][30] = null;
		}
		
		for(int i = 72 ; i < 81 ; i++){
			labyrinthe[i][23] = null;
		}
		
		for(int i = 72 ; i < 79 ; i++){
			labyrinthe[i][28] = null;
		}
		
		for(int i = 20 ; i < 56 ; i++){
			labyrinthe[96][i] = null;
		}	
		
		for(int i = 60 ; i < 115 ; i++){
			labyrinthe[i][40] = null;
		}	
		
		for(int i = 30 ; i < 41 ; i++){
			labyrinthe[115][i] = null;
		}	
		
		labyrinthe[115][30] = 100;
	}
}
