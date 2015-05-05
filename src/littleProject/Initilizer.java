package littleProject;

import tools.Grid;
import tools.World;

public class Initilizer {
	protected static int HEIGHWORLD 	 	=   120; 
	protected static int WIDTHWORLD 	 	=    58; 
	protected static int WINDOWHEIGHT 		=   600;
	protected static int WINDOWSWDITH 		=  1206;
	protected static int FRAME_SPEED 		=    30; 

	protected static int MAP[] = {HEIGHWORLD, WIDTHWORLD};
	protected static World WORLD = null;  
	protected static Grid MAP_WORLD = null;  
	
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
