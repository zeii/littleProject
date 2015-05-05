package tools;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;

import Avatars.Avatar;

public class World extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static int height;
	private static int width;
	
	private Map<String, Map<String, Avatar>> mapAvatarsTri;
	
	private Integer posAvatar;
	
	private Integer[][] data;

	public World(int height, int width, int windowHeight, int windowsWdith, Integer[][] initData){
	
		this.height = height;
		this.width = width;
	    this.setTitle("Strange world");
	    this.setSize(windowsWdith, windowHeight);
	    this.setResizable(false);
	    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );        
        
	    this.posAvatar = 0;
	    this.mapAvatarsTri = new HashMap<String, Map<String, Avatar>>();
	    this.data = initData;
	    
	}
	
	public String addAvatar(Avatar avatar){
		String pos = (this.posAvatar++).toString();
		if(mapAvatarsTri.get(avatar.getType()) == null){
			mapAvatarsTri.put(avatar.getType(), new HashMap<String, Avatar>());
		}
		mapAvatarsTri.get(avatar.getType()).put(pos, avatar);
		int[] geolocalisation = avatar.getPosition();
		
		for(int i=geolocalisation[0] ; i < ( geolocalisation[0] + avatar.getWidth() ) ; i++){
			for(int j=geolocalisation[1] - avatar.getSize() ; j < ( geolocalisation[1] )  ; j++){
				data[i][j] = 0;
			}
		}
		
		return pos;
	}
	
	public void removeAvatar(Avatar avatar){
		System.out.println(avatar.getMatricule() + " " + mapAvatarsTri.get(avatar.getType()).get(avatar.getMatricule()));
		mapAvatarsTri.get(avatar.getType()).remove(avatar.getMatricule());
		System.out.println("Humain restant : " + mapAvatarsTri.get(avatar.getType()).size());
	}
	
	public void event(Integer[][] initData){
	
		for(Entry<String, Map<String, Avatar>>  entry : mapAvatarsTri.entrySet()){
			Map<String, Avatar> avatars = entry.getValue();
			for(Entry<String, Avatar> avatar : avatars.entrySet()){
				avatar.getValue().action();
			}
		}
		
		this.data = initData;
		for(Entry<String, Map<String, Avatar>>  mapTri : mapAvatarsTri.entrySet()){
			Map<String, Avatar> avatars = mapTri.getValue();
			for(Entry<String, Avatar>  entry : avatars.entrySet()){
				Avatar avatar = entry.getValue();
				int[] geolocalisation = avatar.getPosition();
				
				for(int i=geolocalisation[0] ; i < ( geolocalisation[0] + avatar.getWidth() ) ; i++){
					if(i>-1 && i < width){
						for(int j=geolocalisation[1] - avatar.getSize(); j < ( geolocalisation[1] )  ; j++){
							if(j>-1 && j < height && data[i][j] == null){
								data[i][j] = avatar.getColor();
							}
						}
					}
				}
			}
		}
		
	}
	
	public Map<String, Map<String, Avatar>> getMapAvatarsTri() {
		return mapAvatarsTri;
	}

	public void setMapAvatarsTri(Map<String, Map<String, Avatar>> mapAvatarsTri) {
		this.mapAvatarsTri = mapAvatarsTri;
	}

	public Integer[][] getData() {
		return data;
	}

	public void setData(Integer[][] data) {
		this.data = data;
	}
}