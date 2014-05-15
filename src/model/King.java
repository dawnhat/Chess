package model;

public class King extends Piece
{
	//private String displaySymbol = "K";
	//public static String name = "King";
	
	public King(TeamColor color)
	{
		this.name = "King";
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "k" : "K";
	}
	
	

}
