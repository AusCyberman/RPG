package scooterise.combat;
import scooterise.combat.Weapon;
import java.util.HashMap;
public class Creature {
    final class Attribute{
        
    }
   public int maxhp = 15;
   public int hp = 15;
   public String CreatureName ="undefined";
   public boolean isPlayer = false;
   public boolean canBePlayer = false;
   HashMap<Weapon,Boolean> weapons = new HashMap<Weapon,Boolean>();
   public void attack(Creature enemy,Weapon weapon){
      
   }
   final class playerclass{
       
   }
   public class InvalidChractor extends Exception{
       public InvalidChractor(int error){
           switch(error){
               case 1:
               
           }
       }
   }
   
}
