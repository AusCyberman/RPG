package scooterise.rpg.combat;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Creature {
	public class Dice{
		public Integer attackRoll(String diceString,Integer abilityscore){
			char[] string = diceString.toCharArray();
			Integer DiceCount = 1;
			Boolean multiplierfin = false;
			Integer dice = 4;
			Integer Multiplierfinnumber = 1;
			Integer doingmodifier = 0;
			Integer modifiers = 0;
			Integer modifer = 0;
			for(int i=0;i<=string.length;i++) {
				switch(i) {
				case 0:
					DiceCount = (int) string[i];
					break;
				case 1:
				if(string[i] == ('d')) {
					multiplierfin = true;
					
					
				}else {
					DiceCount = (DiceCount *10)+((int)string[i]);
				}
				break;
				case 2:
					if(string[i] == ('d')) {
						multiplierfin = true;
					}else if(multiplierfin==true){										
						dice = (int) string[i];
					}else {
						DiceCount = (DiceCount *10)+((int)string[i]);
					}
				break;
				case 3:
					if(string[i] == ('d')) {
						multiplierfin = true;
					}else {
						DiceCount = (DiceCount *10)+((int)string[i]);
					}if(1==1){
						
					}else if(multiplierfin==true){
						if((i-Multiplierfinnumber)==1) {
						dice = ((int) string[i]);
						}else if((i-Multiplierfinnumber)>1&&string[i]!='+'&&string[i]!='-') {
							dice = (dice *10)+string[i];
						}else if(string[i]=='+') {
							doingmodifier = i;
							modifiers = 1;
						}else if(string[i]=='-') {
						doingmodifier = i;
						modifiers = -1;
					}
					}
					break;
				case 4:
					if(string[i] == ('d')) {
						multiplierfin = true;
					}else {
						DiceCount = (DiceCount *10)+((int)string[i]);
					}if(1==1){
						
					}else if(multiplierfin==true){
						if((i-Multiplierfinnumber)==1) {
						dice = ((int) string[i]);
						}else if((i-Multiplierfinnumber)>1&&string[i]!='+'&&string[i]!='-') {
							dice = (dice *10)+string[i];
						}else if(string[i]=='+') {
							doingmodifier = i;
							modifiers = 1;
						}else if(string[i]=='-') {
						doingmodifier = i;
						modifiers = -1;
					}else if(i-doingmodifier!=0) {
						if(i-doingmodifier>1) {
							modifer=(int) string[i];
							
							if(i==string.length) {
								Integer diceanswer=0;
								for(int c=0;c<=DiceCount;c++) {
								diceanswer = diceanswer+ThreadLocalRandom.current().nextInt(1, dice + 1);
								}
								int fin =0;
								switch(modifiers) {
								case -1:
									fin = diceanswer-modifer;
				break;
								case 1:
									fin = diceanswer+modifer;
									break;
								}
								
							}
						}else {
							modifer=modifer*10+(int) string[i];
						}
					}
					}
					break;
					default:
						if(string[i] == ('d')) {
							multiplierfin = true;
						}else {
							DiceCount = (DiceCount *10)+((int)string[i]);
						}if(1==1){
							
						}else if(multiplierfin==true){
							if((i-Multiplierfinnumber)==1) {
							dice = ((int) string[i]);
							}else if((i-Multiplierfinnumber)>1&&string[i]!='+'&&string[i]!='-') {
								dice = (dice *10)+string[i];
							}else if(string[i]=='+') {
								doingmodifier = i;
								modifiers = 1;
							}else if(string[i]=='-') {
							doingmodifier = i;
							modifiers = -1;
						}else if(i-doingmodifier!=0) {
							if(i-doingmodifier>1) {
								modifer=(int) string[i];
								
								if(i==string.length) {
									Integer diceanswer=0;
									for(int c=0;c<=DiceCount;c++) {
									diceanswer = diceanswer+ThreadLocalRandom.current().nextInt(1, dice + 1);
									}
									int fin =0;
									switch(modifiers) {
									case -1:
										fin = diceanswer-modifer;
					break;
									case 1:
										fin = diceanswer+modifer;
										break;
									}
									
								}
							}else {
								modifer=modifer*10+(int) string[i];
							}
						}
						}	
					
					
				}
				
			}
			switch(abilityscore) {
			case 1:
			}
			return 0;
		}
	}
   public int maxhp = 15;
   public String CreatureName ="undefined";
   public boolean isPlayer = false;
   public boolean canBePlayer = false;
   
   HashMap<String,Integer> abilities = new HashMap<String,Integer>();
   public Creature(){
	   abilities.put("Dexterity", 12);
   }
   public void notPlayer() {
	   try {
		throw new InvalidCharacter("Player Creature cannot be player, Please choose another creature");
	} catch (InvalidCharacter e) {
		e.printStackTrace();
	}
   }
   public class InvalidAbility extends Exception{
	   public InvalidAbility(String message) {
		   super("InvalidAbility: "+message);
	   }
   }
   public class InvalidCharacter extends Exception{
       public InvalidCharacter(String Error){
           super(Error);
       
       }}
   public int getAbilityModifier(int Ability) {
	   switch(Ability) {
	   case 1:
		   return -5;
		   
	   case 2: case 3:
		   return -4;
		   
	   case 4: case 5:
		   return -3;
	   case 6: case 7:
		   return -2;
	   case 8: case 9:
		   return -1;
	   case 10: case 11:
		   return 0;
	   case 12: case 13:
		   return 1;
	   case 14: case 15:
		   return 2;
	   case 16: case 17:
		   return 3;
	   case 18: case 19:
		   return 4;
	   case 20: case 21:
		   return 5;
	   case 22: case 23:
		   return 6;
	   case 24: case 25:
		   return 7;
	   case 26: case 27:
		   return 8;
	   case 28: case 29:
		   return 9;
	   case 30:
		   return 10;
		   
		   
		   
	   }
	return (Integer) null;
	   
   }
       public boolean abilitycheck(String ability){
    	  if(abilities.get(ability)==null) {
    		  try {
				throw new InvalidAbility("Not proper ability");
			} catch (InvalidAbility e) {
				e.printStackTrace();
			}
    	  }else {
    		  Random rand = null;

    		    // nextInt is normally exclusive of the top value,
    		    // so add 1 to make it inclusive
    		    int randomNum = (rand.nextInt((20 -0) + 1) + 0)+getAbilityModifier(abilities.get(ability));
    		    
    	  }
    	  
		return canBePlayer;
    	   
       }
       
   }
   

