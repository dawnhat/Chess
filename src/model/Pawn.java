package model;

import java.awt.Image;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;

import model.Piece.TeamColor;

public class Pawn extends Piece
{
	public boolean hasMoved;
	public Pawn(TeamColor color)
	{
		this.name = "Pawn";
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "p" : "P";
		possibleMoves = new HashSet<Square>();
		hasMoved = false;

		ImageIcon ic = new ImageIcon("src/images/" + teamColor.toString().toLowerCase() + "pawn.png");
		Image i = ic.getImage();
		Image newImage = i.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
		this.image = new ImageIcon(newImage);
	}

	@Override
	public Set getPossibleMoves(Square currentSquare, Board board) {
		
		possibleMoves.clear();
		//multiply by positive or negative 1 depending on the color
		//minus 1 for white, plus 1 for black
		
		int sign = this.teamColor.equals(TeamColor.WHITE) ? -1 : 1;
		
		if(currentSquare.convertRowIndex() + sign <= board.getBoardLength()-1 && currentSquare.convertRowIndex() + sign >= 0)
		{
			Square tempSquare = board.returnSquareAt(currentSquare.convertRowIndex() + sign, currentSquare.convertColumnIndex());
			if(tempSquare.isEmpty())
			{
				possibleMoves.add(tempSquare);
				
				if(currentSquare.convertRowIndex() + (sign*2) <= board.getBoardLength()-2 && currentSquare.convertRowIndex() + (sign*2) >= 0)
				{
					Square tempSquare2 = board.returnSquareAt(currentSquare.convertRowIndex() + (sign*2), currentSquare.convertColumnIndex());
					if(!this.hasMoved && tempSquare2.isEmpty())
					{
						possibleMoves.add(tempSquare2);
					}
				}
				
			}
		}

		/*
		if(currentSquare.convertRowIndex() + (sign*2) <= board.getBoardLength()-2 && currentSquare.convertRowIndex() + (sign*2) >= 0)
		{
			Square tempSquare = board.returnSquareAt(currentSquare.convertRowIndex() + (sign*2), currentSquare.convertColumnIndex());
			if(!this.hasMoved && tempSquare.isEmpty())
			{
				possibleMoves.add(tempSquare);
			}
		}
		*/
		
		//handles captures
		//left, up/down
		if(currentSquare.convertColumnIndex()-1 >= 0 && currentSquare.convertRowIndex() + sign <= board.getBoardLength()-1 && currentSquare.convertRowIndex() + sign >= 0)
		{
			
			Square tempSquare = board.returnSquareAt(currentSquare.convertRowIndex() + sign ,currentSquare.convertColumnIndex()-1);
			//if the space is occupied by a piece of the opposite color
			
			if(!tempSquare.isEmpty() && tempSquare.getPiece().getColor() != this.teamColor)
			{
				possibleMoves.add(tempSquare);
			}
		}
		
		if(currentSquare.convertColumnIndex()+1 <= board.getBoardLength()-1 && currentSquare.convertRowIndex() + sign <= board.getBoardLength()-1 && currentSquare.convertRowIndex() + sign >= 0)
		{
			Square tempSquare = board.returnSquareAt(currentSquare.convertRowIndex() + sign, currentSquare.convertColumnIndex()+1);
			//if the space is occupied by a piece of the opposite color
			
			if(!tempSquare.isEmpty() && tempSquare.getPiece().getColor() != this.teamColor)
			{
				
				possibleMoves.add(tempSquare);
			}
		}
		/*
		for(Square s : possibleMoves)
		{
			System.out.println(s);
		}*/
		
		return possibleMoves;
	}

}
