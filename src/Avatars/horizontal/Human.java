package Avatars.horizontal;

import java.util.Map;
import java.util.Map.Entry;

import Avatars.Avatar;
import Avatars.IConstantsAvatars;
import tools.World;

public class Human extends BasicAnimal {

	private int life;
	private int brain;
	private int strengh;
	private String directionFlee;
	private int timeFlee;
	
	public Human(int size, int width, int positionX, int positionY, int worldSize, int worldHeight, int speed, World world) {
		super(size, width, positionX, positionY, worldSize, worldHeight, world);
		
		type =  IConstantsAvatars.HUMAN;
		
		int colorRandom = (int) (Math.random() * 10);
		this.color = colorRandom;
		
		this.speed = speed;
		this.life = 100;
		this.brain = 100;
		this.strengh = 100;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	/**
	 * @return
	 */
	public int getBrain() {
		return brain;
	}

	public void setBrain(int brain) {
		this.brain = brain;
	}

	public int getStrengh() {
		return strengh;
	}

	public void setStrengh(int strengh) {
		this.strengh = strengh;
	}

	public String getDirectionFlee() {
		return directionFlee;
	}

	public void setDirectionFlee(String directionFlee) {
		this.directionFlee = directionFlee;
	}

	public int getTimeFlee() {
		return timeFlee;
	}

	public void setTimeFlee(int timeFlee) {
		this.timeFlee = timeFlee;
	}

	public void action(){
		if(isOnFlee()){
			run();
		}else{
			
			Boolean moveLeft = false;
			Boolean moveRight = false;
			int distance = 4;
			int ecart = 0;
			for(int i = this.positionX ; i < this.positionX  + distance && !moveLeft; i++){
				if(this.world.getMapAvatarsTri().get(IConstantsAvatars.THING) != null){
					for(Entry<String, Avatar> monsterEntry : this.world.getMapAvatarsTri().get(IConstantsAvatars.THING).entrySet()){
						Avatar monster = monsterEntry.getValue();
						if(this.positionX < monster.getPositionX() 
								&&  monster.getPositionX() < this.positionX + distance){
							moveLeft = true;
							ecart = monster.getPositionX() - this.positionX;
						}
					}
				}
			}
			
			for(int i = this.positionX  ; i > this.positionX - distance && !moveRight; i--){
				if(this.world.getMapAvatarsTri().get(IConstantsAvatars.THING) != null){
					for(Entry<String, Avatar> monsterEntry : this.world.getMapAvatarsTri().get(IConstantsAvatars.THING).entrySet()){
						Avatar monster = monsterEntry.getValue();
						if(this.positionX > monster.getPositionX() 
								&&  monster.getPositionX() > this.positionX - distance){
							
							moveRight = true;
							if(!moveLeft || this.positionX - monster.getPositionX() < ecart){
								moveLeft = false;
								ecart = this.positionX - i;
							}
						}
					}
				}
			}
			
			if(moveLeft && moveRight){
				randomMove();
			} else if (moveLeft){
				moveLeft();
				executeFlee("LEFT", ecart);
			}else if(moveRight){
				moveRight();
				executeFlee("RIGHT", ecart);
			}else{
				randomMove();
			}
		}
	}
	
	private void randomMove(){
		Double random = Math.random();
		if(random % 2 < 0.50){
			moveLeft();
		} else {
			moveRight();
		}
	}
	
	private void executeFlee(String direction, int timeFlee){
		this.directionFlee = direction ;
		if(timeFlee == 0){
			timeFlee = 10;
		}
		this.timeFlee = timeFlee * 2;
	}
	
	private void run(){
		this.timeFlee--;
		if(this.directionFlee.equals("RIGHT")){
			moveRight();
		}else{
			
			moveLeft();
		}
	}
	
	private Boolean isOnFlee(){
		if(this.timeFlee > 0){
			return true;
		}
		return false;
	}
}
