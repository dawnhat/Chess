package model;

import java.util.Set;

import model.Piece.TeamColor;

public class Bishop extends Piece
{
	
	public Bishop(TeamColor color)
	{
		this.name = "Bishop";
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "b" : "B";
	}

	@Override
	public Set getPossibleMoves(Square square, Board board) {
		// TODO Auto-generated method stub
		return null;
	}

}
