package model;

import model.Piece.TeamColor;

public class MoveAction extends Action
{
	private Square square1;
	private Square square2;
	private Piece piece;
	
	public MoveAction(TeamColor actionColor, Square s1, Square s2)
	{
		this.square1 = s1;
		this.square2 = s2;
		this.piece = s1.getPiece();
		this.actionType = ActionType.MOVEMENT;
		this.actionColor = actionColor;
	}
	
	
	
	public MoveAction(Square s1, Square s2)
	{
		
		this.square1 = s1;
		this.square2 = s2;
		this.actionType = ActionType.MOVEMENT;
		
	}
	
	public Piece getPiece()
	{   
		piece = square2.getPiece();
		
		return piece;
	}
	
	public Square getFinalSquare()
	{
		return this.square2;
	}
	

	
	public boolean setActionColor()
	{
		boolean setColor = false;
		if(!square1.isEmpty())
		{
			setColor = true;
			actionColor = square1.getPiece().getColor();
		}
		
		return setColor;
	}
	
	@Override
	public TeamColor getActionColor() {
		setActionColor();
		return this.actionColor;
	}
	
	
	@Override
	public boolean execute(Board board) 
	{
		boolean executed = false;
		
		if(square1.isEmpty())
		{
			System.err.println("No piece to move on " + square1);
		}
		else
		{
			Piece movedPiece = square1.getPiece();
			if(movedPiece.getPossibleMoves(square1, board).contains(square2))
			{
				//if the square is occupied
				
				if(!square2.isEmpty())
				{
					Piece capturedPiece = square2.getPiece();
					System.out.println("Moved " + movedPiece.getName() + " from " + square1 + " to capture "
							+ capturedPiece.getName() + " on " + square2);
				}
				else
				{
					System.out.println("Moved " + movedPiece.getName() + " from " + square1 + " to " + square2);
				}
				square2.setPiece(movedPiece);
				square1.clearPiece();
				
				//clear
				
				if(movedPiece.name.equals("Pawn"))
				{
					Pawn p = (Pawn)movedPiece;
					p.hasMoved = true;
				}
				
				executed = true;
				
			}
			else
			{
				System.err.println("Not a valid move for " + movedPiece.getName());
			}
			
			/*
			for(Square s : movedPiece.possibleMoves)
			{
				System.out.println(s);
			}*/
			
		}
		
		return executed;
		
	}



	

}
