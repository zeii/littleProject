package Avatars.multi;

import tools.World;
import Avatars.Avatar;
import Avatars.IConstantsAvatars;

public class Pion extends Avatar{

	private String lastDirection = "";
	private boolean win = false;
	
	public Pion(int size, int width, int positionX, int positionY,
			int worldSize, int worldHeight, World world) {
		super(size, width, positionX, positionY, worldSize, worldHeight, world);


		type = IConstantsAvatars.PION ;
		
		int colorRandom = (int) (Math.random() * 10);
		this.color = colorRandom;
	}
	
	public void action(){
		Integer[][] mapWorld = this.world.getData();
		int realY = (this.positionY - 1 < 0) ? this.worldHeight - 2 : this.positionY - 1;
		if(mapWorld[this.positionX][realY] != null &&  mapWorld[this.positionX][realY]  == 100){
			win = true;
		}
		
		if(!win){
			move(mapWorld);
		}
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	private void move(Integer[][] mapWorld) {
		Boolean canTakeUp = canTakeUp(mapWorld); 
		Boolean canTakeLeft = canTakeLeft(mapWorld);
		Boolean canTakeRight = canTakeRight(mapWorld);
		Boolean canTakeDown = canTakeDown(mapWorld);

		Boolean directionSelect = false ;
		directionSelect = lastLeft(canTakeUp, canTakeLeft, canTakeDown, directionSelect);
		directionSelect = lastRight(canTakeUp, canTakeRight, canTakeDown, directionSelect);
		directionSelect = lastUp(canTakeUp, canTakeLeft, canTakeRight, directionSelect);
		directionSelect = lastDown(canTakeLeft, canTakeRight, canTakeDown, directionSelect);
		directionSelect = anywhere(canTakeUp, canTakeLeft, canTakeRight, canTakeDown, directionSelect);
		directionSelect = leftUpRight(canTakeUp, canTakeLeft, canTakeRight, directionSelect);
		directionSelect = LeftUpDown(canTakeUp, canTakeLeft, canTakeDown, directionSelect);
		directionSelect = UpRightDown(canTakeUp, canTakeRight, canTakeDown, directionSelect);
		directionSelect = LeftUp(canTakeUp, canTakeLeft, directionSelect);
		directionSelect = LeftRight(canTakeLeft, canTakeRight, directionSelect);
		directionSelect = LeftDown(canTakeLeft, canTakeDown, directionSelect);
		directionSelect = UpRight(canTakeUp, canTakeRight, directionSelect);
		directionSelect = UpDown(canTakeUp, canTakeDown, directionSelect);
		directionSelect = RightDown(canTakeRight, canTakeDown, directionSelect);
		uniqueDirection(canTakeUp, canTakeLeft, canTakeRight, canTakeDown, directionSelect);
		
	}
	
	private Boolean RightDown(Boolean canTakeRight, Boolean canTakeDown, Boolean directionSelect) {
		if(!directionSelect && canTakeRight && canTakeDown){	
			int random = (int) (Math.random() * 2);
			if(random == 0 ){
				moveRight();
			} else {
				moveDown();
			}
			return true;
		}
		return directionSelect;
	}
	
	private Boolean UpDown(Boolean canTakeUp, Boolean canTakeDown, Boolean directionSelect) {
		if(!directionSelect && canTakeUp && canTakeDown){	
			int random = (int) (Math.random() * 2);
			if(random == 0 ){
				moveUp();
			} else {
				moveDown();
			}
			return true;
		}
		return directionSelect;
	}
	
	private Boolean UpRight(Boolean canTakeUp, Boolean canTakeRight, Boolean directionSelect) {
		if(!directionSelect && canTakeUp && canTakeRight){	
			int random = (int) (Math.random() * 2);
			if(random == 0 ){
				moveUp();
			} else {
				moveRight();
			}
			return true;
		}
		return directionSelect;
	}
	
	
	private Boolean LeftDown(Boolean canTakeDown, Boolean canTakeLeft, Boolean directionSelect) {
		if(!directionSelect && canTakeLeft && canTakeDown){	
			int random = (int) (Math.random() * 2);
			if(random == 0 ){
				moveLeft();
			} else {
				moveDown();
			}
			return true;
		}
		return directionSelect;
	}
	
	private Boolean LeftRight(Boolean canTakeRight, Boolean canTakeLeft, Boolean directionSelect) {
		if(!directionSelect && canTakeLeft && canTakeRight){	
			int random = (int) (Math.random() * 2);
			if(random == 0 ){
				moveLeft();
			} else {
				moveRight();
			}
			return true;
		}
		return directionSelect;
	}
	
	private Boolean LeftUp(Boolean canTakeUp, Boolean canTakeLeft, Boolean directionSelect) {
		if(!directionSelect && canTakeLeft && canTakeUp){	
			int random = (int) (Math.random() * 2);
			if(random == 0 ){
				moveLeft();
			} else {
				moveUp();
			}
			return true;
		}
		return directionSelect;
	}
	
	private Boolean UpRightDown(Boolean canTakeUp, Boolean canTakeRight,Boolean canTakeDown, Boolean directionSelect) {
		if(!directionSelect && canTakeRight && canTakeDown && canTakeUp){	
			int random = (int) (Math.random() * 3);
			if(random == 0 ){
				moveRight();
			} else if (random == 1) {
				moveUp();
			} else {
				moveDown();
			}
			return true;
		}
		return directionSelect;
	}
	
	private Boolean LeftUpDown(Boolean canTakeUp, Boolean canTakeLeft,Boolean canTakeDown, Boolean directionSelect) {
		if(!directionSelect && canTakeLeft && canTakeDown && canTakeUp){	
			int random = (int) (Math.random() * 3);
			if(random == 0 ){
				moveLeft();
			} else if (random == 1) {
				moveUp();
			} else {
				moveDown();
			}
			return true;
		}
		return directionSelect;
	}
	
	private Boolean leftUpRight(Boolean canTakeUp, Boolean canTakeLeft,Boolean canTakeRight, Boolean directionSelect) {
		if(!directionSelect && canTakeLeft && canTakeRight && canTakeUp){	
			int random = (int) (Math.random() * 3);
			if(random == 0 ){
				moveLeft();
			} else if (random == 1) {
				moveUp();
			} else {
				moveRight();
			}
			return true;
		}
		return directionSelect;
	}

	private void uniqueDirection(Boolean canTakeUp, Boolean canTakeLeft,
			Boolean canTakeRight, Boolean canTakeDown, Boolean directionSelect) {
		if(!directionSelect && canTakeLeft){
			moveLeft();
		}
		
		if(!directionSelect && canTakeRight){
			moveRight();
		}
			
		if(!directionSelect && canTakeUp){
			moveUp();
		}
		
		if(!directionSelect && canTakeDown){
			moveDown();
		}
	}

	private Boolean anywhere(Boolean canTakeUp, Boolean canTakeLeft,
			Boolean canTakeRight, Boolean canTakeDown, Boolean directionSelect) {
		if(!directionSelect && canTakeLeft && canTakeRight && canTakeUp && canTakeDown){	
			int random = (int) (Math.random() * 4);
			if(random == 0 ){
				moveLeft();
			} else if (random == 1) {
				moveDown();
			} else if (random == 2) {
				moveRight();
			} else {
				moveUp();
			}
			return true;
		}
		return directionSelect;
	}

	private Boolean lastDown(Boolean canTakeLeft, Boolean canTakeRight,
			Boolean canTakeDown, Boolean directionSelect) {
		if(!directionSelect && this.lastDirection.equals("down") && canTakeDown){
			if(canTakeDown && canTakeRight && canTakeLeft){
				int random = (int) (Math.random() * 3);
				if(random == 0){
					moveLeft();
				} else if (random == 1) {
					moveDown();
				} else {
					moveRight();
				}
			}else if(canTakeDown && canTakeLeft){
				Double random = Math.random();
				if(random % 2 < 0.50){
					moveLeft();
				} else {
					moveDown();
				}
			}else if(canTakeDown && canTakeRight){
				Double random = Math.random();
				if(random % 2 < 0.50){
					moveRight();
				} else {
					moveDown();
				}
			}else{
				moveDown();
			}
			return true;
		}
		return directionSelect;
	}

	private Boolean lastUp(Boolean canTakeUp, Boolean canTakeLeft,
			Boolean canTakeRight, Boolean directionSelect) {
		if(!directionSelect && this.lastDirection.equals("up") && canTakeUp){
			if(canTakeUp && canTakeRight && canTakeLeft){
				int random = (int) (Math.random() * 3);
				if(random == 0){
					moveLeft();
				} else if (random == 1) {
					moveUp();
				} else {
					moveRight();
				}
			}else if(canTakeUp && canTakeLeft){
				Double random = Math.random();
				if(random % 2 < 0.50){
					moveLeft();
				} else {
					moveUp();
				}
			}else if(canTakeUp && canTakeRight){
				Double random = Math.random();
				if(random % 2 < 0.50){
					moveRight();
				} else {
					moveUp();
				}
			}else{
				moveUp();
			}
			return true;
		}
		return directionSelect;
	}

	private Boolean lastRight(Boolean canTakeUp, Boolean canTakeRight,
			Boolean canTakeDown, Boolean directionSelect) {
		if(!directionSelect && this.lastDirection.equals("right") && canTakeRight){
			if(canTakeDown && canTakeRight && canTakeUp){
				int random = (int) (Math.random() * 3);
				if(random == 0){
					moveUp();
				} else if (random == 1) {
					moveDown();
				} else {
					moveRight();
				}
			}else if(canTakeUp && canTakeRight){
				Double random = Math.random();
				if(random % 2 < 0.50){
					moveUp();
				} else {
					moveRight();
				}
			}else if(canTakeDown && canTakeRight){
				Double random = Math.random();
				if(random % 2 < 0.50){
					moveRight();
				} else {
					moveDown();
				}
			}else{
				moveRight();
			}
			return true;
		}
		return directionSelect;
	}

	private Boolean lastLeft(Boolean canTakeUp, Boolean canTakeLeft,
			Boolean canTakeDown, Boolean directionSelect) {
		if(!directionSelect && this.lastDirection.equals("left") && canTakeLeft){
			if(canTakeDown && canTakeLeft && canTakeUp){
				int random = (int) (Math.random() * 3);
				if(random == 0){
					moveUp();
				} else if (random == 1) {
					moveDown();
				} else {
					moveLeft();
				}
			}else if(canTakeUp && canTakeLeft){
				Double random = Math.random();
				if(random % 2 < 0.50){
					moveUp();
				} else {
					moveLeft();
				}
			}else if(canTakeDown && canTakeLeft){
				Double random = Math.random();
				if(random % 2 < 0.50){
					moveLeft();
				} else {
					moveDown();
				}
			}else{
				moveLeft();
			}
			return true;
		}
		return directionSelect;
	}
	
	/********************************************************/
	/*********			  Check Mouvement		   **********/
	/********************************************************/
	
	private boolean checkCell(Integer cell){
		if(cell == null){
			return true;
		}
		if(cell != null && cell != 0){
			return true; 
		}
		return false;
	}
	
	public boolean canTakeUp(Integer[][] mapWorld){		
		return this.positionY - 1 > 0 && checkCell(mapWorld[this.positionX][this.positionY - 2]) 
				|| this.positionY - 1 <= 0 && checkCell(mapWorld[this.positionX][this.worldHeight - 2]);
	}
	
	public boolean canTakeDown(Integer[][] mapWorld){		
		return this.positionY > this.worldHeight - 1 && checkCell(mapWorld[this.positionX][0])
				|| this.positionY <= this.worldHeight - 1 && checkCell(mapWorld[this.positionX][this.positionY]);
	}
	
	public boolean canTakeLeft(Integer[][] mapWorld){
		int nextX = (this.positionX - 1 < 0) ? this.worldSize - 1  : this.positionX - 1;
		int nextY = (this.positionY - 1 < 0) ? this.worldHeight - 2 : this.positionY - 1;
		return checkCell(mapWorld[nextX][nextY]);	
	}
	
	public boolean canTakeRight(Integer[][] mapWorld){
		int nextX = (this.positionX + 1 == this.worldSize) ? 0  : this.positionX + 1;
		int nextY = (this.positionY - 1 < 0) ? this.worldHeight - 2 : this.positionY - 1;
		return checkCell(mapWorld[nextX][nextY]);	
	}

	public void moveLeft(){
		this.positionX--;
		if(this.positionX < 0  ){
			this.positionX = this.worldSize - 1 ;
		}
		this.lastDirection = "left";
	}
	
	public void moveRight(){
		this.positionX++;
		if(this.positionX == worldSize ){
			this.positionX = 0;
		}
		this.lastDirection = "right";
	}
	
	public void moveUp(){
		this.positionY--;
		if(this.positionY < 0  ){
			this.positionY = this.worldHeight - 1 ;
		}
		this.lastDirection = "up";
	}
	
	public void moveDown(){
		this.positionY++;
		if(this.positionY > this.worldHeight -1  ){
			this.positionY = 0 ;
		}
		this.lastDirection = "down";
	}
}
