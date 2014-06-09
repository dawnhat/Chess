package model;

import java.awt.Image;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;

public class King extends Piece
{
	//private String displaySymbol = "K";
	//public static String name = "King";
	
	public King(TeamColor color)
	{
		this.name = "King";
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "k" : "K";
		possibleMoves = new HashSet<Square>();
		ImageIcon ic = new ImageIcon("src/images/" + teamColor.toString().toLowerCase() + "king.png");
		Image i = ic.getImage();
		Image newImage = i.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
		this.image = new ImageIcon(newImage);
	}

	@Override
	public Set getPossibleMoves(Square currentSquare, Board board)
	{
		possibleMoves.clear();

		if(currentSquare.convertRowIndex()+1 <= board.getBoardLength()-1)
		{
			if(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()).getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()));
			}
			else if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()).getPiece().getColor())
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()));
			}

			if(currentSquare.convertColumnIndex() + 1 <= board.getBoardLength()-1)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()+1).getPiece() == null)
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()+1));
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()+1).getPiece().getColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()+1));
					}
				}
			}
			if(currentSquare.convertColumnIndex() - 1 >= 0)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()-1).getPiece() == null)
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()-1));
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()-1).getPiece().getColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()-1));
					}
				}
			}
		}

		if(currentSquare.convertRowIndex()-1 >= 0)
		{
			if(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()).getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()));
			}
			else
			{
				if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()).getPiece().getColor())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()));
				}
			}

			if(currentSquare.convertColumnIndex()+1 <= board.getBoardLength()-1)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()+1).getPiece() == null)
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()+1));
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()+1).getPiece().getColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()+1));
					}
				}
			}
		}


		if(currentSquare.convertColumnIndex() + 1 <= board.getBoardLength()-1)
		{
			if(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()+1).getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()+1));
			}
			else
			{
				if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()+1).getPiece().getColor())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()+1));
				}
			}

		}

		if(currentSquare.convertColumnIndex() - 1 >= 0)
		{
			if(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()-1).getPiece() == null)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()-1));
			}
			else
			{
				if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()-1).getPiece().getColor())
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()-1));
				}
			}

			if(currentSquare.convertRowIndex() -1 >= 0)
			{
				if(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()-1).getPiece() == null)
				{
					possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()-1));
				}
				else
				{
					if(this.teamColor != board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()-1).getPiece().getColor())
					{
						possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()-1));
					}
				}
			}

		}

		return possibleMoves;
	}
	
	

}
