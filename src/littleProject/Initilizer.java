package littleProject;

import tools.Grid;
import tools.World;

public class Initilizer {
	protected static int HEIGHWORLD 	 	=   120; 
	protected static int WIDTHWORLD 	 	=    58; 
	protected static int WINDOWHEIGHT 	=   600;
	protected static int WINDOWSWDITH 	=   1216;
	protected static int BODYSIZE	 		=     2;
	protected static int BODYWIDTH	 	=     1;
	protected static int POSITIONX	 	=    20;
	protected static int POSITIONY	 	=    53;
	protected static int MAP[] = {HEIGHWORLD, WIDTHWORLD};
	protected static World WORLD = null;  
	protected static Grid MAP_WORLD = null;  
	protected int FRAME_SPEED = 30; 
	
	protected void initWorld(){
		// Initialisize Worl		
		WORLD = new World(WIDTHWORLD, HEIGHWORLD, WINDOWHEIGHT, WINDOWSWDITH, initData());
		MAP_WORLD = new Grid(HEIGHWORLD, WIDTHWORLD, WORLD.getData());
		WORLD.add(MAP_WORLD);
		WORLD.setVisible(true);
	}
	
	protected Integer[][] initData() {
		return new Integer[ HEIGHWORLD ][ WIDTHWORLD  ];
	}
	
	protected void runWorld() throws InterruptedException{
		while(true){
			MAP_WORLD = new Grid(HEIGHWORLD, WIDTHWORLD, WORLD.getData());
			WORLD.add(MAP_WORLD);
			WORLD.setVisible(true);
			Thread.sleep(FRAME_SPEED);
			WORLD.event(initData());
		}
	}
}
