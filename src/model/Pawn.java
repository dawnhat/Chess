package model;

import model.Piece.TeamColor;

public class Pawn extends Piece
{
	
	public Pawn(TeamColor color)
	{
		this.name = "Pawn";
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "p" : "P";
	}

}
