package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import model.Action.ActionType;
import model.Piece.TeamColor;
import view.Viewer;

public class Game 
{
	//white moves first
	private Board board;
	private Viewer v;
	private TeamColor currentTurnColor;
	private Team teamBlack;
	private Team teamWhite;
	private HashMap<TeamColor, Team> teams;
	
	
	public Game(Board board)
	{
		this.board = board;
		this.v = new Viewer();
		this.currentTurnColor = TeamColor.WHITE;
		
		teams = new HashMap<TeamColor, Team>();
		
		teamBlack = new Team(TeamColor.BLACK);
		teamWhite = new Team(TeamColor.WHITE);
		
		teams.put(TeamColor.BLACK, teamBlack);
		teams.put(TeamColor.WHITE, teamWhite);
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
	
	public boolean isKingInCheck(TeamColor color)
	{
		boolean isInCheck = false;
		
		TeamColor enemyColor = (color == TeamColor.WHITE) ? TeamColor.BLACK : TeamColor.WHITE;
		Team kingTeam = teams.get(color);
		Team enemyTeam = teams.get(enemyColor);
		//check every single enemy piece's moves and see if the king's current location is contained in the list
		//get King's current location?
		King k = kingTeam.getKing();

		//THIS is null
		System.out.println(k);
		
		//Problem: This returns null
		//Square kingSquare = board.getPieceSquare(k);
		Square kingSquare = kingTeam.getPiecePosition(k);
		
		HashSet<Square> enemyMoves = (HashSet) board.getTeamMoves(enemyColor);
		//System.out.println(enemyMoves);
		//System.out.println(kingSquare);
		
		if(enemyMoves.contains(kingSquare))
		{
			isInCheck = true;
		}
		
		//Should team know the position of every piece?
		
		return isInCheck;
	}
	
	public void processActions(ArrayList<Action> actionList)
	{	
		System.out.println("It is " + currentTurnColor + "'s turn.");
		if(isKingInCheck(currentTurnColor))
		{
			System.out.println(currentTurnColor + "'s King is in check.");
		}
		for(Action a : actionList)
		{
			a.setActionColor();
			//this is where we check if someone is in check?
			if(isKingInCheck(currentTurnColor))
			{
				System.out.println(currentTurnColor + "'s King is in check.");
			}
			
			if(a.actionType != ActionType.MOVECHECK)
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
						System.out.println("It is now " + currentTurnColor + "'s turn.");
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
