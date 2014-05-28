package model;

import model.Piece.TeamColor;

public class MoveCheck extends Action
{
	private Square square;
	public MoveCheck(Square s)
	{
		this.actionType = ActionType.MOVECHECK;
		this.square = s;
	}
	@Override
	public boolean execute(Board board) 
	{	
		if(!square.isEmpty())
		{
			square.getPiece().getPossibleMoves(square, board);
			System.out.println(square + "'s moves: " + square.getPiece().possibleMoves);
		}
		else //if empty square
		{
			System.out.println(this.square + " is empty");
		}
		return true;
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
