package scooterise.rpg.story;

import java.util.HashMap;

public class StoryItem{
    public HashMap<String,Player> players = new HashMap<String,Player>();
    private String story;
    public static String NAME = "TEXT";
    private StoryItem proceeding;
    public void setInternalName(String varname){
        NAME = varname;
    }
    public StoryItem(String story){
        
        this.story = story;
        
        
    }
    public StoryItem(){
        this.story = "";
    }
    private void setPlayers(HashMap<String,Player> players){
        this.players= players;
    }
    public void setProcedingStoryItem(StoryItem item){
        item.setPlayers(players);
        proceeding = item;

    }
    
    
}
