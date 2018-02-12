package scooterise.rpg.story;

import java.util.HashMap;

import scooterise.rpg.combat.Creature;

public class Battle extends StoryItem{
public void dexcheck(int dexcheck,Creature creature ) {
	if(participants.get(dexcheck) != null){
		participants.put(dexcheck, creature);
	}else {
		dexcheck(dexcheck,creature);
	}
}
	HashMap<Integer,Creature> participants = new HashMap<Integer,Creature>();
public void addEnemy(Creature creature) {
	int dexcheck = creature.abilitycheck("Dexterity");


}
public Battle(Creature... creatures){

}

}
