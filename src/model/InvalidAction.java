package model;

import model.Piece.TeamColor;

public class InvalidAction extends Action
{

	public InvalidAction()
	{
		this.actionType = ActionType.INVALID;
	}
	@Override
	public boolean execute() {
		System.out.println("Invalid action; did not execute.");
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
