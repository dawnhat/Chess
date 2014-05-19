package model;

import java.util.Set;

public class King extends Piece
{
	//private String displaySymbol = "K";
	//public static String name = "King";
	
	public King(TeamColor color)
	{
		this.name = "King";
		this.teamColor = color;
		displaySymbol = this.teamColor.equals(TeamColor.WHITE) ? "k" : "K";
	}

	@Override
	public Set getPossibleMoves(Square currentSquare, Board board)
	{
		possibleMoves.clear();
		//one to the right
		if(currentSquare.convertRowIndex()+1 <= board.getBoardLength()-1)
		{
			possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()).getSquareID());
			if(currentSquare.convertColumnIndex() + 1 <= board.getBoardLength()-1)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()+1).getSquareID());
			}
			if(currentSquare.convertColumnIndex() - 1 >= 0)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()+1, currentSquare.convertColumnIndex()-1).getSquareID());
			}
		}
		
		if(currentSquare.convertRowIndex()-1 >= 0)
		{
			possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()).getSquareID());
			if(currentSquare.convertColumnIndex()+1 <= board.getBoardLength()-1)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()+1).getSquareID());
			}
		}
		
		
		if(currentSquare.convertColumnIndex() + 1 <= board.getBoardLength()-1)
		{
			possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()+1).getSquareID());
		}
		
		if(currentSquare.convertColumnIndex() - 1 >= 0)
		{
			possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex(), currentSquare.convertColumnIndex()-1).getSquareID());
			if(currentSquare.convertRowIndex() -1 >= 0)
			{
				possibleMoves.add(board.returnSquareAt(currentSquare.convertRowIndex()-1, currentSquare.convertColumnIndex()-1).getSquareID());
			}
		}
		
		return possibleMoves;
	}
	
	

}
