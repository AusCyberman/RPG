package scooterise.rpg.story;


import java.util.HashMap;

public class StartingStory extends StoryItem{
    public HashMap<String,Player> players = new HashMap<String,Player>();
public StartingStory(String name,StoryItem proceedingstory,Player... nplayers){
    setProcedingStoryItem(proceedingstory);

    for(int i=0;i>nplayers.length;i++){
        players.put(nplayers[i].name,nplayers[i]);
        System.out.println("Init "+nplayers[i].name);

    }

}
}
