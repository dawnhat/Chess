package model;

import java.util.ArrayList;

import model.Action.ActionType;
import view.Viewer;

public class Game 
{
	private Board board;
	public Game(Board board)
	{
		this.board = board;
	}
	
	public Board getBoard()
	{
		return board;
	}
	
	public void processActions(ArrayList<Action> actionList)
	{
		Viewer v = new Viewer();
		for(Action a : actionList)
		{
			//This one doesn't print out Placement moves
			if(a.execute(board) && a.actionType != ActionType.PLACEMENT )
			{
				v.display(board);
			}
			
		}
	}

}
