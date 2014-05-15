package model;

import model.Piece.TeamColor;

public class Rook extends Piece 
{
	
	public Rook(TeamColor color)
	{
		this.name = "Rook";
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "r" : "R";
	}

}
