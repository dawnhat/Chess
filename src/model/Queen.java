package model;

import model.Piece.TeamColor;

public class Queen extends Piece 
{
	public Queen(TeamColor color)
	{
		this.name = "Queen";
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "q" : "Q";
	}
	

}
