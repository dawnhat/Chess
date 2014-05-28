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
		//System.out.println(placedPiece + " placed on " + getSquare());
		square.setPiece(placedPiece);
		
		return true;
		
	}
	
	public Piece getPiece()
	{
		return this.placedPiece;
	}
	
	public Square getSquare()
	{
		return this.square;
	}

	@Override
	public boolean setActionColor() {
		this.actionColor = placedPiece.teamColor;
		return true;
	}
	
	public TeamColor getActionColor()
	{
		setActionColor();
		return this.actionColor;
	}
	

}
