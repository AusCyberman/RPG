package scooterise.rpg.combat.weapons;

import scooterise.rpg.combat.Creature;
import scooterise.rpg.combat.Item;

public class Weapon extends Item {
    public String damagedie = "1d4+3";
    public WeaponType weaponType;
    public String WeaponName = "undefined";

    public String getWeaponName() {
        return WeaponName;
    }
    public void setWeaponName(String WeaponName){
        this.WeaponName = WeaponName;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public String getDamagedie() {
        return damagedie;
    }

    public void setDamagedie(String damagedie) {
        this.damagedie = damagedie;
    }

    public Integer getAttackDamage(){
        Creature.Dice dice = new Creature.Dice();
        Integer attackdamage = dice.attackRoll(damagedie);
return attackdamage;


    }
 public class InvalidWeapon extends Exception{
public InvalidWeapon(String error){
    super(error);
}
    }

}
