package model;

import model.Piece.TeamColor;

public class Bishop extends Piece
{
	
	public Bishop(TeamColor color)
	{
		this.name = "Bishop";
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "b" : "B";
	}

}
