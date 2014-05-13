package model;

import model.Piece.TeamColor;

public class Queen extends Piece 
{
private String displaySymbol = "Q";
	public static String name = "Queen";
	
	public Queen(TeamColor color)
	{
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "q" : "Q";
	}
	

}
