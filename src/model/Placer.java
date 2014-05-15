package model;

import model.Piece.TeamColor;



public final class Placer 
{
	
	public static Piece returnPiece(String symbolString, TeamColor color)
	{
		Piece newPiece = null;
		switch(symbolString)
		{
			case "K":
				newPiece = new King(color);
				break;
			case "Q":
				newPiece = new Queen(color);
				break;
			case "B":
				newPiece = new Bishop(color);
				break;
			case "N":
				newPiece = new Knight(color);
				break;
			case "P":
				newPiece = new Pawn(color);
				break;
			case "R":
				newPiece = new Rook(color);
				break;
		}

		return newPiece;
	}

}
