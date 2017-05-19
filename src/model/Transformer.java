package model;

import java.util.Comparator;
import java.util.HashMap;

public class Transformer implements Comparable<Transformer> {
	
	private String name;
	private String type;
	private int strength;
	private int intelligence;
	private int speed;
	private int endurance;
	private int rank;
	private int courage;
	private int firepower;
	private int skill;
	
	private int rating;
	
	public Transformer(){
		
	}
	
	public Transformer(String name, String type,int strength, int intelligence, int speed, int endurance, int rank, int courage, int firepower,
			int skill) {
		super();
		this.name = name;
		this.type = type;
		this.strength = strength;
		this.intelligence = intelligence;
		this.speed = speed;
		this.endurance = endurance;
		this.rank = rank;
		this.courage = courage;
		this.firepower = firepower;
		this.skill = skill;
	}
	
	public String getName(){
		return name;
	}
	
	public String getType(){
		return type;
	}
	
	public int getStrength() {
		return strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getSpeed() {
		return speed;
	}

	public int getEndurance() {
		return endurance;
	}

	public int getRank() {
		return rank;
	}

	public int getCourage() {
		return courage;
	}

	public int getFirepower() {
		return firepower;
	}

	public int getSkill() {
		return skill;
	}

	public int getRating() {
	rating  = strength + intelligence + speed + endurance + rank + courage + firepower + skill;
		return  rating;
	}

	@Override
	public int compareTo(Transformer o) {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public int compare(Transformer o1, Transformer o2) {
//		// TODO Auto-generated method stub
//		return 0;
//	}


	
}
