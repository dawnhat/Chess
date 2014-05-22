package model;

import java.util.ArrayList;

import model.Action.ActionType;
import model.Piece.TeamColor;
import view.Viewer;

public class Game 
{
	//white moves first
	private Board board;
	private Viewer v;
	private TeamColor currentTurnColor;
	
	public Game(Board board)
	{
		this.board = board;
		this.v = new Viewer();
		this.currentTurnColor = TeamColor.WHITE;
	}
	
	public void setupBoard(ArrayList<Action> placeList)
	{
		for(Action a : placeList)
		{
			a.execute(board);
		}
	}
	
	public Board getBoard()
	{
		return board;
	}
	
	public void displayBoard()
	{
		v.display(board);
	}
	
	public void processActions(ArrayList<Action> actionList)
	{	
		for(Action a : actionList)
		{
			a.setActionColor();
			if(a.actionType != ActionType.PLACEMENT)
			{
				//acting out of turn
				if(a.actionColor != currentTurnColor)
				{
					System.out.println("Invalid move; it is " + currentTurnColor + "'s turn");
					
				}
				else
				{
					if(a.execute(board))
					{
						displayBoard();
						currentTurnColor = currentTurnColor == TeamColor.WHITE ? TeamColor.BLACK : TeamColor.WHITE;
					}
				}
			}
			else
			{
				a.execute(board);
			}
			/*
			if(a.execute(board) && a.actionType != ActionType.PLACEMENT)
			{
				displayBoard();
			}
			
			*/
			
		}
	}

}
