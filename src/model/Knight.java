package model;

import java.awt.Image;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;

import model.Piece.TeamColor;

public class Knight extends Piece
{

	public Knight(TeamColor color)
	{
		this.name = "Knight";
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "n" : "N";
		possibleMoves = new HashSet<Square>();
		ImageIcon ic = new ImageIcon("src/images/" + teamColor.toString().toLowerCase() + "knight.png");
		Image i = ic.getImage();
		Image newImage = i.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
		this.image = new ImageIcon(newImage);
	}

	@Override
	public Set<Square> getPossibleMoves(Square currentSquare, Board board) 
	{
		possibleMoves.clear();

		//up2
		if(currentSquare.convertRowIndex()+2 <= board.getBoardLength()-1)
		{
			if(currentSquare.convertColumnIndex()+1 <= board.getBoardLength()-1)
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
			if(currentSquare.convertColumnIndex()-1 >= 0)
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
			if(currentSquare.convertColumnIndex()-2 >= 0)
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

		if(currentSquare.convertRowIndex()-2 >= 0)
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
			if(currentSquare.convertColumnIndex()-1 >= 0)
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

		if(currentSquare.convertRowIndex()-1 >= 0)
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
			if(currentSquare.convertColumnIndex()-2 >= 0)
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
