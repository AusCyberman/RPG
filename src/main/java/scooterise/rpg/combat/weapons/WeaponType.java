package scooterise.rpg.combat.weapons;

public class WeaponType{
    private Double typed;
    public String type;
    static public WeaponType  MELEE =new WeaponType("Melee");
    static public WeaponType  RANGED=new WeaponType("Ranged");
    private WeaponType(String type){
        typed=Math.random();


    }
}
