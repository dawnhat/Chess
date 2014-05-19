package model;

import java.util.Set;

import model.Piece.TeamColor;

public class Queen extends Piece 
{
	public Queen(TeamColor color)
	{
		this.name = "Queen";
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "q" : "Q";
	}

	@Override
	public Set getPossibleMoves(Square square, Board board) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
