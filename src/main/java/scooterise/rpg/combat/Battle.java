package scooterise.rpg.combat;

import java.util.HashMap;

import scooterise.rpg.combat.weapons.Weapon;
import scooterise.rpg.combat.weapons.WeaponType;
import scooterise.rpg.story.StoryItem;
import scooterise.rpg.story.Player;

public class Battle extends StoryItem {
	private Creature[] participants = {};
	private HashMap<Integer,Creature> playerz = new HashMap<Integer,Creature>();



	public String combat(Integer player, Integer weaponID, Creature creature, Integer distanceAway) throws Dead {
		WeaponType expectedweapontype;
		Weapon playerweapon = participants[player].getWeapon(weaponID);
			if(distanceAway>2){
				expectedweapontype = WeaponType.RANGED;
			}else{
				expectedweapontype =WeaponType.MELEE;
			}
			Integer modifier;
			if ( playerweapon.weaponType == WeaponType.MELEE){
				modifier = creature.getAbilityModifier(creature.getStrength());
			}else{
				modifier = creature.getAbilityModifier(creature.getDexterity());
			}
			if(new Creature.Dice().attackRoll("1d20")>=creature.armorclass+modifier&&playerweapon.weaponType==expectedweapontype){
				creature.currenthp = creature.currenthp - playerweapon.getAttackDamage();
				if(creature.currenthp==0) {
					throw new Dead("The "+creature.CreatureType+" has died",creature);

				}

			}



	}
	public String combat(Integer playerID, Integer creatureID,Integer distanceAway){

        WeaponType expectedweapontype;
        if(distanceAway>2){
            expectedweapontype = WeaponType.RANGED;
        }else{
            expectedweapontype =WeaponType.MELEE;
        }

        Creature player = participants[playerID];
        Creature creature = participants[creatureID];
        Weapon weapon = creature.getWeapon(0);
        for(int i=0;i<creature.weapons.length;i++){
            if(creature.weapons[i].weaponType==expectedweapontype){
                i=creature.weapons.length;
                weapon = creature.weapons[i];
            }
        }

		Integer modifier;
		if ( weapon.weaponType == WeaponType.MELEE){
			modifier = player.getAbilityModifier(player.getStrength());
		}else{
			modifier = player.getAbilityModifier(player.getDexterity());
		}
		if(new Creature.Dice().attackRoll("1d20")>=player.armorclass+modifier){
			player.currenthp = player.currenthp - weapon.getAttackDamage();
			return creature.CreatureType +" has used "+weapon.getWeaponName()+" on "+player.CreatureName;
			if(player.currenthp==0){

			}

		}



	}


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
	int dexcheck = creature.abilitycheck("Dexterity");


}
public Integer findCreature(Creature creature){
		for(int i=0;i<participants.length;i++){
			if(participants[i]!=null){
				partici[i]=participants[i];
			}
		}
	Integer[] partici = {};
	Integer highest = partici[partici.length-1];
	for(int i =highest;i<highest;i--){
		if(participants.get(i) !=null){
			if(participants.get(i) == creature) {
			return i;
			}
		}

	}
	return null;
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
Integer[] partici = {};
Integer keyset =0;
	for(int i=0;i<participants.length;i++){
		if(participants[i]!=null){

			partici[keyset]=i;
			keyset++;
		}
	}

    Integer highest = partici[partici.length-1];

for(int i =highest;i<highest;i--){
if(participants[i] !=null){
    if(participants[i].isPlayer==false){

    }else{

    }
}else{

}

}
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
