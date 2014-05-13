package model;

import model.Piece.TeamColor;

public class Pawn extends Piece
{
	private String displaySymbol = "P";
	public static String name = "Pawn";
	
	public Pawn(TeamColor color)
	{
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "p" : "P";
	}

}
