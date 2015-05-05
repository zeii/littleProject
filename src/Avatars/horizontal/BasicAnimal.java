package Avatars.horizontal;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import Avatars.Avatar;
import Avatars.IConstantsAvatars;
import tools.World;

public class BasicAnimal extends Avatar {

	protected int speed = 1; 
	
	public BasicAnimal(int size, int width, int positionX, int positionY, int worldSize, int worldHeight, World world) {
		super(size, width,  positionX, positionY, worldSize, worldHeight, world);
		
		type = IConstantsAvatars.THING ;
		this.color = 1;
	}

	public void action(){
		Double random = Math.random();
		if(random % 2 < 0.50){
			moveLeft();
		} else {
			moveRight();
		}
		
		Map<String, Avatar> humanDead = new HashMap<String, Avatar>();
		for(Entry<String, Avatar> avatars : this.world.getMapAvatarsTri().get(IConstantsAvatars.HUMAN).entrySet()){
			Avatar avatar = avatars.getValue();
			if(this.positionX == avatar.getPositionX()){
				humanDead.put(avatar.getMatricule(), avatar);
			}
		}
		
		for(Entry<String, Avatar> av : humanDead.entrySet()){
			this.world.removeAvatar(av.getValue());
		}
	}
	
	public void moveLeft(){
		this.positionX--;
		if(this.positionX < 0  ){
			this.positionX = this.worldSize - 1 ;
		}		
	}
	
	public void moveRight(){
		this.positionX++;
		if(this.positionX == worldSize ){
			this.positionX = 0;
		}
	}
}
