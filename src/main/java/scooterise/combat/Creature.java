package scooterise.combat;

public class Creature {
   public int maxhp = 15;
   public String CreatureName ="undefined";
   public boolean isPlayer = false;
   public boolean canBePlayer = false;
   public class playerclass{
       
   }
   public class InvalidChracter extends Exception{
       public InvalidChracter(int error){
           switch(error){
               case 1:
               
           }
       }
   }
   
}
