package model;

import java.util.Scanner;

import model.Piece.TeamColor;

public class MoveAction extends Action
{
	private Square square1;
	private Square square2;
	private Piece piece;
	private Game game;
	private Scanner scan;	
	
	public MoveAction(Square s1, Square s2, Game game)
	{
		this.square1 = s1;
		this.square2 = s2;
		this.piece = s1.getPiece();
		this.actionType = ActionType.MOVEMENT;
		this.game = game;
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
	public boolean execute() 
	{
		boolean executed = false;
		
		if(square1.isEmpty())
		{
			System.err.println("No piece to move on " + square1);
		}
		else
		{
			Piece movedPiece = square1.getPiece();
			if(movedPiece.getPossibleMoves(square1, game.getBoard()).contains(square2))
			{
				//if the square is occupied
				
				if(!square2.isEmpty())
				{
					Piece capturedPiece = square2.getPiece();
					System.out.println("Moved " + movedPiece.getName() + " from " + square1 + " to capture "
							+ capturedPiece.getName() + " on " + square2);
					
					//remove the captured piece from its team for it is a failure
					game.getTeams().get(capturedPiece.getColor()).deletePiece(capturedPiece);
					
				}
				else
				{
					System.out.println("Moved " + movedPiece.getName() + " from " + square1 + " to " + square2);
				}
				square2.setPiece(movedPiece);
				//game.getTeams().get(movedPiece.getColor()).updatePiecePosition(movedPiece, square2);
				square1.clearPiece();
				
				//clear
				
				game.getTeams().get(movedPiece.getColor()).updatePiecePosition(movedPiece, square2);
				
				if(movedPiece.name.equals("Pawn"))
				{
					Pawn p = (Pawn)movedPiece;
					p.hasMoved = true;
					
					//if pawn moves onto these magic squares
					if(game.getBoard().returnPromoteSquares().contains(square2))
					{
						promotePawn(p);
					}
					
				}
				
				//finally, update the piece's final position with its team
				
				
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
	
	public void promotePawn(Pawn pawn)
	{
		scan = new Scanner(System.in);
		TeamColor color = pawn.getColor();
		Square position = game.getTeams().get(color).getPiecePosition(pawn);
		//replace it with a piece of the same color
		
		Piece newPiece = null;
		
		boolean piecePromoted = false;
		
		while(!piecePromoted)
		{
			System.out.println("Promote pawn to: ");
			System.out.println("Q - Queen \nN - Knight\nB - Bishop \nR - Rook");
			
			String input = scan.nextLine().toUpperCase();
			if(input.equals("Q") || input.equals("B") || input.equals("N") || input.equals("R"))
			{
				newPiece = Placer.returnPiece(input, color);
				piecePromoted = true;
			}
			else
			{
				System.out.println("Not a valid piece to promote to!");
			}
		}
		
		position.setPiece(newPiece);
		game.getTeams().get(color).addPiece(newPiece, position);
		//remove pawn
		game.getTeams().get(color).deletePiece(pawn);
		
		game.getTeams().get(color).updatePiecePosition(newPiece, position);
	}



	

}
