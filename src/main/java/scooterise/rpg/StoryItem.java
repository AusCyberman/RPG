package scooterise.rpg;

public class StoryItem{
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
    public void setProcedingStoryItem(StoryItem item){
        proceeding = item;
    }
    
    
}
