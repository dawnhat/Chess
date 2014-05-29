package model;

import model.Piece.TeamColor;

public abstract class Action 
{
	//An object that kind of represents a move in chess, whether it is a placement, capture, movement, etc.
	//Takes in the current state of the  board?
	protected ActionType actionType;
	protected TeamColor actionColor;
	protected Game game;
	//protected String commandString;
	
	public abstract boolean execute();
	
	public abstract boolean setActionColor();
	public abstract TeamColor getActionColor();
	
	public enum ActionType
	{
		PLACEMENT,
		MOVEMENT,
		CAPTURE,
		CASTLING,
		MOVECHECK
	}

}
