package model;

import model.Piece.TeamColor;

public class Knight extends Piece
{

	public Knight(TeamColor color)
	{
		this.name = "Knight";
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "n" : "N";
	}

}
