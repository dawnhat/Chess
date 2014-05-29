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
	
	public void displayBoard()
	{
		v.display(board);
	}
	
	public boolean isKingInCheck(TeamColor color)
	{
		boolean isInCheck = false;
		
		TeamColor enemyColor = (color == TeamColor.WHITE) ? TeamColor.BLACK : TeamColor.WHITE;
		Team kingTeam = teams.get(color);
		//Team enemyTeam = teams.get(enemyColor);
		//check every single enemy piece's moves and see if the king's current location is contained in the list
		//get King's current location?
		King k = kingTeam.getKing();

		//System.out.println("King" + k);

		Square kingSquare = kingTeam.getPiecePosition(k);
		
		HashSet<Square> enemyMoves = (HashSet) board.getTeamMoves(enemyColor);
		//System.out.println(enemyMoves);
		//System.out.println(kingSquare);
		
		if(enemyMoves.contains(kingSquare))
		{
			isInCheck = true;
		}
		
		
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
			

			if(a.actionType != ActionType.MOVECHECK)
			{
				//acting out of turn
				if(a.actionColor != currentTurnColor)
				{
					System.out.println("Invalid move; it is " + currentTurnColor + "'s turn");
				}
				else if(a.actionType == ActionType.MOVEMENT)
				{
					MoveAction ma = (MoveAction)a;
					
					if(ma.execute())
					{
						
						teams.get(ma.actionColor).addPiece(ma.getPiece(), ma.getFinalSquare());
						
						//here i should be handling updating the teams
						
						
						displayBoard();
						currentTurnColor = (currentTurnColor == TeamColor.WHITE) ? TeamColor.BLACK : TeamColor.WHITE;
						System.out.println("It is now " + currentTurnColor + "'s turn.");
						if(isKingInCheck(currentTurnColor))
						{
							System.out.println(currentTurnColor + "'s King is in check.");
						}
					}
				}
			}
			else
			{
				a.execute();
				
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
