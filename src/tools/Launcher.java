package tools;

import littleProject.First;
import littleProject.Second;


public class Launcher {


	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Start");
	
		First e = new First();
		Second e2 =new Second();
	//	e.run();
		e2.run();
		
		System.out.println("End");
	}	
}
