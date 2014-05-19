package model;

import java.util.Set;

import model.Piece.TeamColor;

public class Knight extends Piece
{

	public Knight(TeamColor color)
	{
		this.name = "Knight";
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "n" : "N";
	}

	@Override
	public Set getPossibleMoves(Square square, Board board) {
		// TODO Auto-generated method stub
		return null;
	}

}
