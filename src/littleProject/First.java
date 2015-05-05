package littleProject;

import tools.Grid;
import tools.World;
import Avatars.Avatar;
import Avatars.IConstantsAvatars;
import Avatars.horizontal.BasicAnimal;
import Avatars.horizontal.Human;

public class First extends Initilizer {

	private static int NB_HULMANS = 100;
	private static int NB_THINGS = 8;
	
	public void run() throws InterruptedException{
		
		initWorld();

		for(int i=0 ; i < NB_HULMANS ; i++){
			int random = (int) (Math.random() *100);
			int size = (int) (Math.random() * 20 ) + 1;
			Avatar human = new Human(size, 1, random, 55, HEIGHWORLD, WIDTHWORLD, 1, WORLD);
			human.setColor(human.getColor());
			human.setMatricule(WORLD.addAvatar(human));
		}
		
		for(int i=0 ; i < NB_THINGS ; i++){
			int size = (int) (Math.random() * 20 ) + 30;
			Avatar thing = new BasicAnimal(size, 1, 1, 55, HEIGHWORLD, WIDTHWORLD, WORLD);
			thing.setColor(thing.getColor());
			thing.setMatricule(WORLD.addAvatar(thing));
		}
		
		runWorld();
	}

	protected Integer[][] initData() {
		Integer[][] data = new Integer[ HEIGHWORLD ][ WIDTHWORLD  ];	    
	    for(int i=0 ; i < HEIGHWORLD ; i++){
			for(int j=55; j < 57 ; j++){
				data[i][j] = 0;
			}
	    }
		return data;
	}
	
	protected void runWorld() throws InterruptedException{
		while(WORLD.getMapAvatarsTri().get(IConstantsAvatars.HUMAN).size() > 0){
			MAP_WORLD = new Grid(HEIGHWORLD, WIDTHWORLD, WORLD.getData());
			WORLD.add(MAP_WORLD);
			WORLD.setVisible(true);
			Thread.sleep(30);
			WORLD.event(initData());
		}
	}
}
