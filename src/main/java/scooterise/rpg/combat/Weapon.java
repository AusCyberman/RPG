package scooterise.rpg.combat;

public class Weapon extends Item{
    public String damagedie = "1d4+3";
    public Integer weapontype;
    public Integer getAttackDamage(){
        Creature.Dice dice = new Creature.Dice();
        Integer attackdamage = dice.attackRoll(damagedie);
return attackdamage;
    }
}
