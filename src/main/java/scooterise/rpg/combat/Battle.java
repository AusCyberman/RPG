package scooterise.rpg.combat;

import java.util.HashMap;
import java.util.Random;

import scooterise.rpg.combat.weapons.Weapon;
import scooterise.rpg.combat.weapons.WeaponType;
import scooterise.rpg.story.StoryItem;
import scooterise.rpg.story.Player;

public class Battle extends StoryItem implements StoryItem.Story {
	private Creature[] participants = {};
	private HashMap<Integer,Creature> playerz = new HashMap<Integer,Creature>();
	Integer combatdistance;
	Integer currentcreature;






	public String combat(Integer playerID, Integer weaponID, Integer creatureID, Integer distanceAway){
		if(currentcreature==playerID) {
			WeaponType expectedweapontype;
			Weapon playerweapon = participants[playerID].getWeapon(weaponID);

			Creature player = players.get(playerID).character;
			Creature creature = participants[creatureID];
			if (distanceAway > 2) {
				expectedweapontype = WeaponType.RANGED;
			} else {
				expectedweapontype = WeaponType.MELEE;
			}
			Integer modifier;
			if (playerweapon.weaponType == WeaponType.MELEE) {
				modifier = creature.getAbilityModifier(creature.getStrength());
			} else {
				modifier = creature.getAbilityModifier(creature.getDexterity());
			}
			if (new Creature.Dice().attackRoll("1d20") >= creature.armorclass + modifier && playerweapon.weaponType == expectedweapontype) {
				Integer attackdamage = playerweapon.getAttackDamage();
				creature.currenthp = creature.currenthp - attackdamage;

				if (creature.currenthp == 0) {
					participants[playerID] = player;
					participants[creatureID] = creature;
					participants[findCreature(creature)] = null;
					return player.CreatureName + " has used " + playerweapon.getWeaponName() + " on " + creature.CreatureType + "and done " + attackdamage + " damage";


				} else {
					participants[playerID] = player;
					participants[creatureID] = creature;

					return player.CreatureName + " has used " + playerweapon.getWeaponName() + " on " + creature.CreatureType + "and done " + attackdamage + " damage. " + creature.CreatureType + " is on " + creature.currenthp;
				}


			}
			return "Missed";
		}
		return "It is not "+players.get(playerID).character.CreatureName+"'s turn";

	}







	public String combat(Integer playerID, Integer creatureID,Integer distanceAway){
		if(creatureID==currentcreature) {
			combatdistance = distanceAway;
			WeaponType expectedweapontype;
			if (distanceAway > 2) {
				expectedweapontype = WeaponType.RANGED;
			} else {
				expectedweapontype = WeaponType.MELEE;
			}

			Creature player = participants[playerID];
			Creature creature = participants[creatureID];
			Weapon weapon = creature.getWeapon(0);
			for (int i = 0; i < creature.weapons.length; i++) {
				if (creature.weapons[i].weaponType == expectedweapontype) {
					i = creature.weapons.length;
					weapon = creature.weapons[i];
				}
			}

			Integer modifier;
			if (weapon.weaponType == WeaponType.MELEE) {
				modifier = player.getAbilityModifier(player.getStrength());
			} else {
				modifier = player.getAbilityModifier(player.getDexterity());
			}
			if (new Creature.Dice().attackRoll("1d20") >= player.armorclass + modifier) {
				Integer attackdamage = weapon.getAttackDamage();
				player.currenthp = player.currenthp - attackdamage;
				participants[playerID] = player;
				participants[creatureID] = creature;

				if (player.currenthp == 0) {
					participants[findCreature(creature)] = null;
					participants[playerID] = null;
					participants[creatureID] = creature;
					playerz.remove(playerID);

					return creature.CreatureType + " has used " + weapon.getWeaponName() + " on " + player.CreatureName + "and killed" + player.CreatureName;
				} else {
					participants[playerID] = player;
					participants[creatureID] = creature;
					return creature.CreatureType + " has used " + weapon.getWeaponName() + " on " + player.CreatureName + "and done " + attackdamage + " damage";
				}

			}
			return "Missed";
		}
		return "Incorrect Sequence";
	}
    Integer[] partici = {};

public void dexcheck(int dex,Creature creature ) {
	if(participants[dex] != null){
		participants[dex]= creature;
		if(creature.isPlayer==true){
		    playerz.put(dex,creature);
        }
	}else {
		dexcheck(dex,creature);
	}
}

public void addEnemy(Creature creature) {
	dexcheck(creature.abilitycheck("Dexterity"),creature);


}
public class IncorrectBattle extends Exception{
	public IncorrectBattle(String error){
		super("error");
	}
}
public Integer findCreature(Creature creature){
		for(int i=0;i>participants.length;i--){
			if(participants[i]!=null){
				partici[i]=i;
			}
		}
	Integer[] partici = {};
	Integer highest = partici[partici.length-1];
	for(int i =highest;i<highest;i--){
		if(participants[i]!=null){
			if(participants[i] == creature) {
			return i;
			}
		}

	}
	return null;
}

public Battle(Player[] Creature,Integer combatDistance,Creature... creatures){


for(int i=0;creatures.length>i;i++){
	int dexcheck = creatures[i].abilitycheck("Dexterity");
	dexcheck(dexcheck,creatures[i]);

}
for(int i=0;players.size()>i;i++){
   Player[] playes;
    playes = (Player[]) players.keySet().toArray();
    dexcheck(players.get(playes[i]).character.abilitycheck("Dexterity"),players.get(playes[i]).character);

}

Integer keyset =0;
	for(int i=0;i<participants.length;i++){
		if(participants[i]!=null){

			partici[keyset]=i;
			keyset++;
		}
	}

    Integer highest = partici[partici.length-1];

attackSequence();
}
public boolean checkIfAllPlayers(){
	boolean answer = false;
	boolean validplayers =false;
	for(int i =0;i<participants.length;i++){
		if(participants[i] !=null){
			validplayers=true;
			if(!participants[i].isPlayer){
				answer=true;
			}
		}
	}

		return answer;

}

    @Override
    public void start() {
        Integer highest = partici[partici.length-1];
        attackSequence();

    }
public Integer getNextCreature
    public void attackSequence(){
		for (int i=0;i>participants.length;i--){

			if(participants !=null){
				if (!participants[i].isPlayer){


					Random rand = new Random();

					int  n = rand.nextInt(50) + 1;

					combat(rand.nextInt(playerz.size()) + 1,i,combatdistance);
				}else{
					while(currentcreature==i){

					}



				}
			}}
			if(!checkIfAllPlayers()) {
				attackSequence();
			}
	}



	public void setweapon(Integer playerID, Weapon weapon){
	Creature player = players.get(playerID).character;
}

    public class Dead extends Exception{
		public Dead(String pretxt,Creature creature){
			super(pretxt);

			if(!creature.isPlayer){
			participants[findCreature(creature)]=null;

			}

		}


	}


}
