package model;

import java.util.HashSet;
import java.util.Set;

import model.Piece.TeamColor;

public class Knight extends Piece
{

	public Knight(TeamColor color)
	{
		this.name = "Knight";
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "n" : "N";
		possibleMoves = new HashSet<Square>();
	}

	@Override
	public Set<Square> getPossibleMoves(Square currentSquare, Board board) 
	{
		possibleMoves.clear();


		if(currentSquare.convertRowIndex()+2 <= board.getBoardLength()-1)
		{
			if(currentSquare.convertColumnIndex()+2 <= board.getBoardLength()-1)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()+2, currentSquare.convertColumnIndex()+1).isEmpty())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+2, currentSquare.convertColumnIndex()+1));
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()+2, currentSquare.convertColumnIndex()+1).getPiece().getColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+2, currentSquare.convertColumnIndex()+1));
					}
				}
			}
			if(currentSquare.convertColumnIndex()-1 > 0)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()+2, currentSquare.convertColumnIndex()-1).isEmpty())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+2, currentSquare.convertColumnIndex()-1));
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()+2, currentSquare.convertColumnIndex()-1).getPiece().getColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+2, currentSquare.convertColumnIndex()-1));
					}
				}

			}
		}

		if(currentSquare.convertRowIndex()+1 <= board.getBoardLength()-1)
		{
			if(currentSquare.convertColumnIndex()-2 > 0)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()-2).isEmpty())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()-2));
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()-2).getPiece().getColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()-2));
					}
				}
			}
			if(currentSquare.convertColumnIndex()+2 <= board.getBoardLength()-1)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()+2).isEmpty())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()+2));
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()+2).getPiece().getColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()+2));
					}
				}

			}
		}

		if(currentSquare.convertRowIndex()-2 > 0)
		{
			if(currentSquare.convertColumnIndex()+1 <= board.getBoardLength()-1)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()-2, currentSquare.convertColumnIndex()+1).isEmpty())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-2, currentSquare.convertColumnIndex()+1));
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()-2, currentSquare.convertColumnIndex()+1).getPiece().getColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-2, currentSquare.convertColumnIndex()+1));
					}
				}

			}
			if(currentSquare.convertColumnIndex()-1 > 0)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()-2, currentSquare.convertColumnIndex()-1).isEmpty())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-2, currentSquare.convertColumnIndex()-1));
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()-2, currentSquare.convertColumnIndex()-1).getPiece().getColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-2, currentSquare.convertColumnIndex()-1));
					}
				}
			}
		}

		if(currentSquare.convertRowIndex()-1 > 0)
		{
			if(currentSquare.convertColumnIndex()+2 <= board.getBoardLength()-1)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()+2).isEmpty())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()+2));
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()+2).getPiece().getColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()+2));
					}
				}

			}
			if(currentSquare.convertColumnIndex()-2 > 0)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()-2).isEmpty())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()-2));
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()-2).getPiece().getColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()-2));
					}
				}

			}
		}

		return this.possibleMoves;
	}

}
