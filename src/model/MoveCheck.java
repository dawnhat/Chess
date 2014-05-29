package model;

import model.Piece.TeamColor;

public class MoveCheck extends Action
{
	private Square square;
	private Game game;
	
	public MoveCheck(Square s, Game game)
	{
		this.actionType = ActionType.MOVECHECK;
		this.square = s;
		this.game = game;
	}
	@Override
	public boolean execute() 
	{	
		if(!square.isEmpty())
		{
			square.getPiece().getPossibleMoves(square, game.getBoard());
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
