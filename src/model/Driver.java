package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

public class Driver {
	static ArrayList<Transformer> myArray = new ArrayList<>();
//	static ArrayList<Transformer> decepticonArray = new ArrayList<>();
//	static ArrayList<Transformer> autobotsArray = new ArrayList<>();
	public static void main(String args[]){
		Battle myBattle = new Battle();
		Scanner scanner=new Scanner(System.in);
	    while (true) {
	        System.out.println("Enter the transformer in format: Transformer,a,S,I,S,E,R,C,F,S");
	        System.out.println("Enter 'start' to start the game");
	        String output = scanner.nextLine();
	        if(output.equals("start")){
	            break;
	        } else {
	        
	        	if(myBattle.isValidOutput(output)!=null){
	        		myArray.add(myBattle.isValidOutput(output));
	        	} else {
	        		System.out.println("Invalid Input ");
	        	}
	        }
	        if(output.equals("start")){
	            break;
	        }
	    } 
	      myBattle.startGame(myArray);
	}
	
}
