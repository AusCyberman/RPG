package scooterise.rpg.story;
import scooterise.rpg.combat.Creature;
import scooterise.rpg.combat.Creature.InvalidCharacter;

public class Player {
	public String name;
    public Creature character;
    public void setCharacter(Creature charc) {
    	if(charc.canBePlayer==true) {
    		character=charc;
    	}else {
    		character.notPlayer(); 
    	}
    }
    public Player(Creature charc,String name) {
    	if(charc.canBePlayer==true) {
    		character= charc;
    	}else {
    		character.notPlayer(); 
    	}
    	this.name=name;
    }
}
