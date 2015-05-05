package Avatars;

import java.awt.Color;

import tools.World;

public class Avatar {

	private Boolean[][] body;
	private int size;
	private int width;
	private String matricule;
	
	protected String type;
	protected int worldHeight;	
	protected int worldSize;
	protected World world;
	protected int positionX;

	protected int positionY;
	protected int[] map;
	protected Integer color;
	
	/**
	 * Creation du personnage
	 * @param size
	 * @param width
	 */
	public Avatar(int size, int width, int positionX, int positionY, int worldSize, int worldHeight, World world){
		this.size = size;
		this.width = width;
		this.positionX = positionX;
		this.positionY = positionY;
		this.worldHeight = worldHeight;
		this.worldSize = worldSize;
		int[]  map = { worldHeight, worldSize };
		this.map = map;
		this.world = world;
		this.body = new Boolean[this.size][this.width];		
		for(int i=0;i<this.size;i++) {
			for(int j=0;j<this.width;j++) {
				this.body[i][j] = false;
			}
		}
	}
	
	
	/**
	 * .Getters Setters
	 */
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Boolean[][] getBody(){
		return body;
	}
	
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public Integer getColor() {
		return color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	/**
	 * Retourn l'emplacement geaographique sur la map;
	 * @return
	 */
	public int[] getPosition(){
		int position[] = new int[2];
		
		position[0] = this.positionX;
		position[1] = this.positionY;
		
		return position;
	}

	public void action(){}
	
}
