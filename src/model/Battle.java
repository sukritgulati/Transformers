package model;

import java.util.ArrayList;
import java.util.Collections;

import org.w3c.dom.css.Counter;

public class Battle {

	ArrayList<Transformer> decepticonArray = new ArrayList<>();
	ArrayList<Transformer> autobotsArray = new ArrayList<>();
	
	public Battle(){
		
	}
	
	//check validity of the input
	public  Transformer  isValidOutput(String input) {
		
		String[] outputArray = input.split(",");
		if(outputArray.length != 10){
			return null;
		}
		String name = outputArray[0];
		String type;
		if(outputArray[1].equalsIgnoreCase("d")){
			type = "Decepticon";
		} else if(outputArray[1].equalsIgnoreCase("a")) {
			type = "Autobot";
		} else {
			return null;
		}
		
		int strength, intelligence, speed, endurance, rank, courage, firepower, skill ;
		try{
		
			strength = Integer.parseInt(outputArray[2]);
			intelligence = Integer.parseInt(outputArray[3]);
			speed = Integer.parseInt(outputArray[4]);
			endurance = Integer.parseInt(outputArray[5]);
			rank = Integer.parseInt(outputArray[6]);
			courage = Integer.parseInt(outputArray[7]);
			firepower = Integer.parseInt(outputArray[8]);
			skill = Integer.parseInt(outputArray[9]);
				
		} catch(Exception e){
			return null;
		}
		
		if( (strength < 0 || strength > 10) ||(intelligence < 0 || intelligence > 10) ||
				(speed < 0 || speed > 10)||(endurance < 0 || endurance > 10)||
				(rank < 0 || rank > 10)||(courage < 0 || courage > 10)||
				(firepower < 0 || firepower > 10)||(skill < 0 || skill > 10)){
			return null;		
		}	
		Transformer myTransformer = new Transformer(name,type,strength,intelligence, speed, endurance, rank, courage, firepower, skill);
		return myTransformer;	
	}
	
	// sorting the input into teams
	public void startGame(ArrayList<Transformer> startList){
		Collections.sort(startList);
		for(Transformer myTrans : startList){
			if (myTrans.getType() == "Decepticon") {
				decepticonArray.add(myTrans);
			} else {
				autobotsArray.add(myTrans);
			}
		}
		
		battle(decepticonArray,autobotsArray);
	}
	
	//battle between transformers
	public void battle(ArrayList<Transformer> decepticons, ArrayList<Transformer> autobots){
		ArrayList<Result> resultArray = new ArrayList<>();
		ArrayList<Transformer> didnotBattle = new ArrayList<>();
		if(decepticons.size() == autobots.size()){
			// no survivors
			for (int i = 0; i < decepticons.size();i++){
				resultArray.add(fight(decepticons.get(i), autobots.get(i)));
			}
		}
		else if(decepticons.size() > autobots.size()){
			//decepticons
			int i = 0;
			for (; i < autobots.size();i++){
				resultArray.add(fight(decepticons.get(i), autobots.get(i)));
			}
			for(;i<decepticons.size();i++){
				didnotBattle.add(decepticons.get(i));
			}
		} else {
			int i = 0;
			for (; i < decepticons.size();i++){
				resultArray.add(fight(decepticons.get(i), autobots.get(i)));
			}
			for(;i<autobots.size();i++){
				didnotBattle.add(autobots.get(i));
			}
		}
		
		int nBattles = 0;
		int countWinner = 0;
		ArrayList<String> decept = new ArrayList();
		ArrayList<String> autobo = new ArrayList();
		for(Result result: resultArray){
			if(result.getBattle() == -1){
				countWinner = 0;
				nBattles = 1;
				break;
			}
			nBattles = nBattles + result.getBattle();
			if(result.getWinner().getType()=="Decepticon"){
				countWinner = countWinner + 1;
				decept.add(result.getWinner().getName());
			} else if(result.getWinner().getType() == "Autobot") {
				countWinner = countWinner - 1;
				autobo.add(result.getWinner().getName());
			}
		}
		
		if(countWinner > 0){
			//decepticons won
			System.out.println(nBattles + " battle(s)");
			
			System.out.print("Winning team (Decepticons): "+decept);
			for(String dec: decept){	
					System.out.print(dec+ " ");	
			}
			System.out.print("Survivors from (Autobots): ");
			for(Transformer survivor: didnotBattle){
				if(survivor.getType()=="Autobot"){
					System.out.print(survivor.getName()+ " ");
				}
			}

			
		} else if(countWinner < 0){
			//autobots won
			System.out.println(nBattles + " battle(s)");
			System.out.print("Winning team (Autobots):"+autobo);
			for(String aut: autobo){	
				System.out.print(aut+ " ");	
			}
			System.out.print("Survivors from (Decepticons): ");
			for(Transformer survivor: didnotBattle){
				if(survivor.getType()=="Decepticon"){
					System.out.print(survivor.getName()+ " ");
				}
			}
		} else {
			//all competitors destroyed
			System.out.println(nBattles + " battle(s)");
			System.out.println("All Competitors Destroyed");

		}
		
	}
	
	//rules for the fight
public Result fight(Transformer decepticon, Transformer autobot){
		
		if(autobot.getName().equalsIgnoreCase("optimus prime")
				&&(decepticon.getName().equalsIgnoreCase("predaking"))){
			return new Result(null, null, -1);
		} else if(autobot.getName().equalsIgnoreCase("optimus prime")){
			return new Result(decepticon,autobot,1);
		} else if(decepticon.getName().equalsIgnoreCase("predaking")){
			return new Result(autobot,decepticon,1);
		}
		else if ((decepticon.getCourage() - autobot.getCourage() >= 4)&&
				(decepticon.getStrength() - autobot.getStrength() >=3)){
			return new Result(decepticon, autobot, 1);
		} else if ((autobot.getCourage() - decepticon.getCourage() >= 4)&&
				(autobot.getStrength() - decepticon.getStrength() >=3)){
			return new Result(autobot, decepticon, 1);
		} else if(decepticon.getSkill() - autobot.getSkill() >= 3) {
			return new Result(decepticon, autobot, 1);
		} else if (autobot.getSkill() - decepticon.getSkill() >= 3) {
			return new Result(autobot, decepticon, 1);
		} else if (decepticon.getRating() == autobot.getRating()){
			return new Result(null,null,1);
		} else if (decepticon.getRating() > autobot.getRating()){
			return new Result(decepticon, autobot, 1);
		} else if (decepticon.getRating() < autobot.getRating()){
			return new Result(autobot, decepticon, 1);
		} else {
			return new Result(null,null,1);
		}
	}
	
}
