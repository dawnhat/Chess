package model;

import model.Piece.TeamColor;

public class CaptureAction extends Action
{
	private Square square1;
	private Square square2;
	
	
	public CaptureAction(Square s1, Square s2, Game game)
	{
		this.square1 = s1;
		this.square2 = s2;
		this.actionType = ActionType.CAPTURE;
		this.game = game;
	}
	
	
	//FUTURE NOTE, have to update this if i ever need it
	//deprecated for now
	@Override
	public boolean execute()
	{
		// TODO Auto-generated method stub
		boolean executed = false;
		if(square1.isEmpty())
		{
			System.err.println("No piece to move on " + square1);
		}
		else if(square2.isEmpty())
		{
			System.err.println("No piece to capture on " + square2);
		}
		else
		{
			//if there IS a piece to move on square1 and if there IS a piece to capture on square 2, then
			Piece capturingPiece = square1.getPiece();
			Piece capturedPiece = square2.getPiece();
			if(capturingPiece.getPossibleMoves(square1, game.getBoard()).contains(square2))
			{
				square2.setPiece(capturingPiece);
				//clear
				square1.clearPiece();
				
				System.out.println("Moved " + capturingPiece.getName() + " from " + square1 + " to capture " + capturedPiece.getName() + " on " + square2);
				executed = true;
			}
			else
			{
				System.err.println("Not a valid move for " + capturingPiece.getName());
			}
		}
		
		return executed;
		
	}
	@Override
	public boolean setActionColor() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public TeamColor getActionColor() {
		// TODO Auto-generated method stub
		return null;
	}

}
