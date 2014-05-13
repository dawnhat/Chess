package model;

import model.Piece.TeamColor;

public class Bishop extends Piece
{
	private String displaySymbol = "B";
	public static String name = "Bishop";
	
	public Bishop(TeamColor color)
	{
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "b" : "B";
	}

}
