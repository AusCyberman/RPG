package scooterise.rpg.combat;

public class Creature {
   public int maxhp = 15;
   public String CreatureName ="undefined";
   public boolean isPlayer = false;
   public boolean canBePlayer = false;
   public class playerclass{
       
   }
   public void notPlayer() {
	   try {
		throw new InvalidCharacter("Player Creature cannot be player");
	} catch (InvalidCharacter e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   public class InvalidCharacter extends Exception{
       public InvalidCharacter(String Error){
           super(Error);
       
       }
       
       
   }
   
}
