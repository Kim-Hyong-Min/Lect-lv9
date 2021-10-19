package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class file {
	public static file instance = new file();
	private Unit ut = Unit.instance;
	private Guild gd = Guild.instance;
	private Shop sp = Shop.instance;
	
	File PlayerFile = new File("Player.txt");
	File ItemFile = new File("Item.txt");
	File GuildFile = new File("Guild.txt");
	File InventoryFile = new File("Inventory.txt");
	
	private FileWriter fw = null;
	private FileReader fr = null;
	private BufferedReader br = null;
	
  //save
	
	// Player
	public void playerSave(){
		try {
			fw = new FileWriter(PlayerFile);
			fw.write(saveSet());
			fw.close();
		}catch (Exception e) {
		}
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
	    data.substring(0, data.length()-1);
	    return data;
  	}
	// Item
	public void itemSave(){
		try {
			fw = new FileWriter(ItemFile);
			fw.write(itemSet());
			fw.close();
		} catch (Exception e) {
		}
  	}
	
  	private String itemSet(){
	    String data = "";
	    for(int i=0; i<sp.item.size(); i++) {
	    	data += sp.item.get(i).getName()+"/";
	    	data += sp.item.get(i).getAtk()+"/";
	    	data += sp.item.get(i).getDef()+"/";
	    	data += sp.item.get(i).getPrice()+"/";
	    	data += sp.item.get(i).getItemCode()+"\n";
	    }
	    data.substring(0, data.length()-1);
	    return data;
  	}
	// Guild
	public void guildSave(){
		try {
			fw = new FileWriter(GuildFile);
			fw.write(guildSet());
			fw.close();
		} catch (Exception e) {
		}
  	}
	
  	private String guildSet(){
	    String data = "";
	    data += gd.getGulidName()+"/";
	    data += gd.getGuildMoney();
	    return data;
	    
  	}
	// Inventory
	public void inventorySave(){
		try {
			fw = new FileWriter(InventoryFile);
			fw.write(inventorySet());
			fw.close();
		} catch (Exception e) {
		}
  	}
	
	private String inventorySet(){
	    String data = "";
	    for(int i=0; i<gd.inven.size(); i++) {
	    	data += gd.inven.get(i).getItemName()+"/";
	    	data += gd.inven.get(i).getAtk()+"/";
	    	data += gd.inven.get(i).getDef()+"/";
	    	data += gd.inven.get(i).getItemCode()+"/";
	    	data += gd.inven.get(i).getItemCnt()+"\n";
	    }
	    data.substring(0, data.length()-1);
	    return data;
  	}
  

  	
  	
  	
  //load
    public void playerLoad(){
    	ut.playerReset();
    	
		try {
			fr = new FileReader(PlayerFile);
			br = new BufferedReader(fr);
			String data = br.readLine();
			while(data != null) {
				String temp[] = data.split("/");
				Player pr = new Player(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), Integer.parseInt(temp[6]), temp[7], Integer.parseInt(temp[8]), Integer.parseInt(temp[9]), Integer.parseInt(temp[10]), Integer.parseInt(temp[11]));
				ut.player.add(pr);
				data = br.readLine();
			}
			fr.close();
			br.close();
			
		}catch (Exception e) {
		}
    }
    
    public void itemLoad(){
        sp.shopReset();
        
		try {
			fr = new FileReader(ItemFile);
			br = new BufferedReader(fr);
			String data = br.readLine();
			while(data != null) {
				String temp[] = data.split("/");
				Item it = new Item(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
				sp.item.add(it);
				data = br.readLine();
			}
			fr.close();
			br.close();
			
		}catch (Exception e) {
		}
        
    }
    
    public void guildLoad(){
		try {
			fr = new FileReader(GuildFile);
			br = new BufferedReader(fr);
			String data = br.readLine();
			String temp[] = data.split("/");
			gd.guildSet(temp[0], Integer.parseInt(temp[1]));
			
		}catch (Exception e) {
		}
    }
    
    public void inventoryLoad(){
        gd.inventoryReset();
        
		try {
			fr = new FileReader(InventoryFile);
			br = new BufferedReader(fr);
			String data = br.readLine();
			while(data != null) {
				String temp[] = data.split("/");
				Inventory iy = new Inventory(temp[0], Integer.parseInt(temp[1]), 0, 0, 0);
				gd.inven.add(iy);
				data = br.readLine();
			}
			fr.close();
			br.close();
			
		}catch (Exception e) {
		}
        
    }

}
