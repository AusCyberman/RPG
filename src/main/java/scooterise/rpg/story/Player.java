package scooterise.rpg.story;
import scooterise.rpg.combat.Creature;
import scooterise.rpg.combat.Creature.InvalidCharacter;
import java.util.concurrent.ThreadLocalRandom;
public class Player {
	public class Dice{
		public Integer rolldice(String diceString){
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
								return fin;
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
									return fin;
								}
							}else {
								modifer=modifer*10+(int) string[i];
							}
						}
						}	
					
					
				}
				
			}
			return 0;
		}
	}
    public Creature character;
    public void setCharacter(Creature charc) {
    	if(charc.canBePlayer==true) {
    		character.isPlayer = true;
    	}else {
    		character.notPlayer(); 
    	}
    }
}
