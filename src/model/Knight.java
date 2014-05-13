package model;

import model.Piece.TeamColor;

public class Knight extends Piece
{
	private String displaySymbol = "N";
	public static String name = "Knight";
	
	public Knight(TeamColor color)
	{
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "n" : "N";
	}

}
