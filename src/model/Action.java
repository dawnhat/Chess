package model;

public abstract class Action 
{
	//An object that kind of represents a move in chess, whether it is a placement, capture, movement, etc.
	//Takes in the current state of the  board?
	protected ActionType actionType;
	protected String commandString;
	
	public abstract boolean execute(Board b);
	
	
	public enum ActionType
	{
		PLACEMENT,
		MOVEMENT,
		CAPTURE,
		CASTLING
	}

}
