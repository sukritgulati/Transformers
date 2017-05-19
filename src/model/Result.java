package model;

public class Result {
	
	private Transformer winner;
	private Transformer loser;
	private int battle;
	

	public Result(Transformer winner, Transformer loser, int battle) {
		super();
		this.winner = winner;
		this.loser = loser;
		this.battle = battle;
	}
	
	public Transformer getWinner() {
		return winner;
	}


	public Transformer getLoser() {
		return loser;
	}

	public int getBattle() {
		return battle;
	}

	
}
