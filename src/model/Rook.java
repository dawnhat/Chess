package model;

import java.util.Set;

import model.Piece.TeamColor;

public class Rook extends Piece 
{
	
	public Rook(TeamColor color)
	{
		this.name = "Rook";
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "r" : "R";
	}

	@Override
	public Set getPossibleMoves(Square square, Board board) {
		// TODO Auto-generated method stub
		return null;
	}

}
