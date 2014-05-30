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
			PlaceAction pa = (PlaceAction)a;
			pa.execute();
			
			TeamColor color = pa.getPiece().getColor();
			teams.get(color).addPiece(pa.getPiece(), pa.getSquare());
			//System.out.println(pa.getPiece().getColor());
		}
	}
	
	public Board getBoard()
	{
		return board;
	}
	
	public HashMap<TeamColor, Team> getTeams()
	{
		return this.teams;
	}
	
	public void displayBoard()
	{
		v.display(board);
	}
	
	public boolean isKingInCheck()
	{
		boolean isInCheck = false;
		
		TeamColor enemyColor = (currentTurnColor == TeamColor.WHITE) ? TeamColor.BLACK : TeamColor.WHITE;
		Team kingTeam = teams.get(currentTurnColor);

		King k = kingTeam.getKing();
		Square kingSquare = kingTeam.getPiecePosition(k);
		
		HashSet<Square> enemyMoves = (HashSet<Square>) board.getTeamMoves(enemyColor);
		
		isInCheck = enemyMoves.contains(kingSquare);

		
		return isInCheck;
	}
	
	
	public boolean isKingInCheckmate(King king)
	{
		
		//true until you find a move that takes the king out of check
		boolean checkMated = true;
		//Potential methods:
		
		/*
		 * 1. Carry out ALL the moves from the king's team (including the king himself)
		 * 		a. After a move is executed, check if the king is still in check
		 * 		b. If after every move the king is still in check, the king and his team has no moves to take him out of check; this is checkmate
		 * 2.  
		 *
		 *
		 */
		
		
		return checkMated;
	}
	
	
	public void processActions(ArrayList<Action> actionList)
	{	
		notifyTurn();
		for(Action a : actionList)
		{
			//a.setActionColor();
			
			if(a.actionType != ActionType.MOVECHECK)
			{
				//acting out of turn
				if(a.getActionColor() != currentTurnColor)
				{
					System.out.println("Invalid move; it is " + currentTurnColor + "'s turn");
				}
				else if(a.actionType == ActionType.MOVEMENT)
				{
					//MoveAction ma = (MoveAction)a;
					if(a.execute())
					{
						displayBoard();
						currentTurnColor = (currentTurnColor == TeamColor.WHITE) ? TeamColor.BLACK : TeamColor.WHITE;
						notifyTurn();
					}
				}
			}
			else
			{
				a.execute();
			}
			
		}
	}
	
	public void notifyTurn()
	{
		System.out.println("It is now " + currentTurnColor + "'s turn.");
		if(isKingInCheck())
		{
			System.out.println(currentTurnColor + "'s King is in check.");
		}
	}

}
