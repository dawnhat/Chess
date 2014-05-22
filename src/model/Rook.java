package model;

import java.util.HashSet;
import java.util.Set;

import model.Piece.TeamColor;

public class Rook extends Piece 
{
	
	public Rook(TeamColor color)
	{
		this.name = "Rook";
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "r" : "R";
		possibleMoves = new HashSet<Square>();
	}

	@Override
	public Set getPossibleMoves(Square currentSquare, Board board) {
		possibleMoves.clear();

		boolean pieceFound = false;
		for(int i = 1; currentSquare.convertRowIndex()+i <= board.getBoardLength()-1 && !pieceFound; i++)
		{
			//straight down	
			if(board.returnSquareAt(currentSquare.convertRowIndex()+i, currentSquare.convertColumnIndex()).getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+i, currentSquare.convertColumnIndex()));	

			}
			else
			{
				if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()+i, currentSquare.convertColumnIndex()).getPiece().getColor())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+i, currentSquare.convertColumnIndex()));	
				}
				pieceFound = true;
			}
		}

		pieceFound = false;
		for(int i = 1; currentSquare.convertColumnIndex()+i <= board.getBoardLength()-1 && !pieceFound; i++)
		{
			if(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()+i).getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()+i));	

			}
			else
			{
				if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()+i).getPiece().getColor())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()+i));	
				}
				pieceFound = true;
			}
		}

		pieceFound = false;
		for(int i = 1; currentSquare.convertColumnIndex()-i >= 0 && !pieceFound; i++)
		{
			
			if(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()-i).getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()-i));	

			}
			else
			{
				if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()-i).getPiece().getColor())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()-i));	
				}
				pieceFound = true;
			}
		}

		pieceFound = false;
		for(int i = 1; currentSquare.convertRowIndex()-i >= 0 && !pieceFound; i++)
		{
			
			if(board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex()).getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex()));	

			}
			else
			{
				if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex()).getPiece().getColor())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex()));	
				}
				pieceFound = true;
			}
		}

		return this.possibleMoves;
	}

}
