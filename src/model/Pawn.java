package model;

import java.util.Set;

import model.Piece.TeamColor;

public class Pawn extends Piece
{
	
	public Pawn(TeamColor color)
	{
		this.name = "Pawn";
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "p" : "P";
	}

	@Override
	public Set getPossibleMoves(Square square, Board board) {
		// TODO Auto-generated method stub
		return null;
	}

}
