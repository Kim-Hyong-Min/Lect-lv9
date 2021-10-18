package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

public class File {
	
	private Unit ut = Unit.instance;
	private Guild gd = Guild.instance;
	private Shop sp = Shop.instance;
	
	File playerFile = new File("PlayerData.txt");
	
	private FileWriter fw = null;
	private FileReader fr = null;
	private BufferedReader br = null;
	
  //save
	
	// Player
	public void playerSave(){
		fw = new FileWriter(playerFile);
  	}
	
  	private String saveSet(){
	    String data = "";
	    for(int i=0; i<ut.player.size(); i++) {
	    	data += ut.player.get(i).getPlayerName()+"/";
	    	data += ut.player.get(i).getPlayerLevel()+"/";
	    	data += ut.player.get(i).getPlayerHp()+"/";
	    	data += ut.player.get(i).getPlayerMaxHp()+"/";
	    	data += ut.player.get(i).getPlayerAtk()+"/";
	    	data += ut.player.get(i).getPlayerDef()+"/";
	    	data += ut.player.get(i).getPlayerExp()+"/";
	    	data += ut.player.get(i).getPlayerParty()+"/";
	    	data += ut.player.get(i).getPlayerCode()+"/";
	    	for(int j=0; j<3; j++) {
	    		data += ut.player.get(i).getPlayerItem(j)+"/";
	    	}
	    	data += "\n";
	    }
	    
	    return data;
  	}
	// Item
	public void itemSave(){
	    
  	}
	// Guild
	public void guildSave(){
	    
  	}
	// Inventory
	public void inventorySave(){
	    
  	}
	public void save(){
    
  	}
  

  	
  	
  	
  //load
    public void load(){
    
    }
    
    
    private String loadSet(){
	    String data = "";
	    
	    return data;
    }
}
