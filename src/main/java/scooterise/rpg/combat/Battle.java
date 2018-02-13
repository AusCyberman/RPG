package scooterise.rpg.combat;

import java.util.HashMap;
import java.util.HashSet;

import scooterise.rpg.combat.Creature;
import scooterise.rpg.story.StoryItem;
import scooterise.rpg.story.Player;

public class Battle extends StoryItem {
public void dexcheck(int dexcheck,Creature creature ) {
	if(participants.get(dexcheck) != null){
		participants.put(dexcheck, creature);
		if(creature.isPlayer==true){
		    playerz.put(dexcheck,creature);
        }
	}else {
		dexcheck(dexcheck,creature);
	}
}
	HashMap<Integer,Creature> participants = new HashMap<Integer,Creature>();
    HashMap<Integer,Creature> playerz = new HashMap<Integer,Creature>();
public void addEnemy(Creature creature) {
	int dexcheck = creature.abilitycheck("Dexterity");


}
public Battle(Player[] Creature,Creature... creatures){

for(int i=0;creatures.length>i;i++){
	int dexcheck = creatures[i].abilitycheck("Dexterity");
	dexcheck(dexcheck,creatures[i]);

}
for(int i=0;players.size()>i;i++){
   Player[] playes;
    playes = (Player[]) players.keySet().toArray();
    dexcheck(players.get(playes[i]).character.abilitycheck("Dexterity"),players.get(playes[i]).character);

}
    Integer[] partici = (Integer[]) participants.keySet().toArray();
    Integer highest = partici[partici.length-1];

for(int i =highest;i<highest;i--){
if(participants.get(i) !=null){
    if(participants.get(i).isPlayer==false){

    }else{

    }
}else{

}

}
}

}
