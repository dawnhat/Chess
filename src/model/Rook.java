package model;

import model.Piece.TeamColor;

public class Rook extends Piece 
{
	private String displaySymbol = "R";
	public static String name = "Rook";
	
	public Rook(TeamColor color)
	{
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "r" : "R";
	}

}
