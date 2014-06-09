package model;

import java.awt.Image;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;

import model.Piece.TeamColor;

public class Queen extends Piece 
{
	public Queen(TeamColor color)
	{
		this.name = "Queen";
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "q" : "Q";
		possibleMoves = new HashSet<Square>();
		ImageIcon ic = new ImageIcon("src/images/" + teamColor.toString().toLowerCase() + "queen.png");
		Image i = ic.getImage();
		Image newImage = i.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
		this.image = new ImageIcon(newImage);
	}

	@Override
	public Set getPossibleMoves(Square currentSquare, Board board) {
		possibleMoves.clear();
		Square tempSquare;
		//rook moves
		boolean pieceFound = false;
		for(int i = 1; currentSquare.convertRowIndex()+i <= board.getBoardLength()-1 && !pieceFound; i++)
		{	
			tempSquare = board.returnSquareAt(currentSquare.convertRowIndex()+i, currentSquare.convertColumnIndex());
			//pieceFound = this.addPossibleMoves(tempSquare, board);
			if(tempSquare.isEmpty())
			{
				possibleMoves.add(tempSquare);		
			}
			else
			{
				if(this.teamColor != tempSquare.getPiece().getColor())
				{
					possibleMoves.add(tempSquare);	
				}
				pieceFound = true;
			}
		}

		pieceFound = false;
		for(int i = 1; currentSquare.convertColumnIndex()+i <= board.getBoardLength()-1 && !pieceFound; i++)
		{
			
			tempSquare = board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()+i);
			if(tempSquare.isEmpty())
			{
				possibleMoves.add(tempSquare);	

			}
			else
			{
				if(this.teamColor != tempSquare.getPiece().getColor())
				{
					possibleMoves.add(tempSquare);	
				}
				pieceFound = true;
			}
		}

		pieceFound = false;
		for(int i = 1; currentSquare.convertColumnIndex()-i >= 0 && !pieceFound; i++)
		{
			tempSquare = board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()-i);
			if(tempSquare.isEmpty())
			{
				possibleMoves.add(tempSquare);	

			}
			else
			{
				if(this.teamColor != tempSquare.getPiece().getColor())
				{
					possibleMoves.add(tempSquare);	
				}
				pieceFound = true;
			}
		}

		pieceFound = false;
		for(int i = 1; currentSquare.convertRowIndex()-i >= 0 && !pieceFound; i++)
		{
			tempSquare = board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex());
			if(tempSquare.isEmpty())
			{
				possibleMoves.add(tempSquare);	

			}
			else
			{
				if(this.teamColor != tempSquare.getPiece().getColor())
				{
					possibleMoves.add(tempSquare);	
				}
				pieceFound = true;
			}
		}
		//bishop moves

		pieceFound = false;

		for(int i = 1; currentSquare.convertRowIndex()+i <= board.getBoardLength()-1 && currentSquare.convertColumnIndex()+i <= board.getBoardLength()-1 && !pieceFound; i++)
		{
			tempSquare = board.returnSquareAt(currentSquare.convertRowIndex()+i, currentSquare.convertColumnIndex()+i);
			if(tempSquare.isEmpty())
			{
				possibleMoves.add(tempSquare);	
			}
			else
			{
				if(this.teamColor != tempSquare.getPiece().getColor())
				{
					possibleMoves.add(tempSquare);	
				}
				pieceFound = true;
			}
		}

		pieceFound = false;
		for(int i = 1; currentSquare.convertRowIndex()-i >= 0 && currentSquare.convertColumnIndex()+i <= board.getBoardLength()-1 && !pieceFound; i++)
		{
			tempSquare = board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex()+i);
			if(tempSquare.isEmpty())
			{
				possibleMoves.add(tempSquare);	
			}
			else
			{
				if(this.teamColor != tempSquare.getPiece().getColor())
				{
					possibleMoves.add(tempSquare);	
				}
				pieceFound = true;
			}
		}

		pieceFound = false;
		for(int i = 1; currentSquare.convertRowIndex()-i >= 0 && currentSquare.convertColumnIndex()-i >= 0 && !pieceFound; i++)
		{
			tempSquare = board.returnSquareAt(currentSquare.convertRowIndex()-i, currentSquare.convertColumnIndex()-i);
			if(tempSquare.isEmpty())
			{
				possibleMoves.add(tempSquare);	
			}
			else
			{
				if(this.teamColor != tempSquare.getPiece().getColor())
				{
					possibleMoves.add(tempSquare);	
				}
				pieceFound = true;
			}
		}

		pieceFound = false;
		for(int i = 1; currentSquare.convertRowIndex()+i <= board.getBoardLength()-1 && currentSquare.convertColumnIndex()-i >= 0 && !pieceFound; i++)
		{
			tempSquare = board.returnSquareAt(currentSquare.convertRowIndex()+i, currentSquare.convertColumnIndex()-i);
			if(tempSquare.isEmpty())
			{
				possibleMoves.add(tempSquare);	
			}
			else
			{
				if(this.teamColor != tempSquare.getPiece().getColor())
				{
					possibleMoves.add(tempSquare);	
				}
				pieceFound = true;
			}
		}
		return this.possibleMoves;
	}
	

}
