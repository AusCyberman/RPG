package scooterise.rpg.story;
import scooterise.rpg.combat.Creature;
import scooterise.rpg.combat.Creature.InvalidCharacter;
import java.util.concurrent.ThreadLocalRandom;
public class Player {
	
    public Creature character;
    public void setCharacter(Creature charc) {
    	if(charc.canBePlayer==true) {
    		character.isPlayer = true;
    	}else {
    		character.notPlayer(); 
    	}
    }
}
