package model;

import model.Piece.TeamColor;

public class PlaceAction extends Action
{	
	//this takes in a board and a string command
	private Piece placedPiece;
	private Square square;
	
	public PlaceAction(Piece piece, Square square)
	{
		placedPiece = piece;
		this.square = square;
		this.actionType = ActionType.PLACEMENT;
	}

	@Override
	public boolean execute(Board board) 
	{
		square.setPiece(placedPiece);
		return true;
		
	}

	@Override
	public boolean setActionColor() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
