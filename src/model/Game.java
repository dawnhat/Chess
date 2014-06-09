package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

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
	private boolean isRunning;
	private Scanner scan;	

	public Game(Board board)
	{
		this.board = board;
		this.v = new Viewer(this);
		this.currentTurnColor = TeamColor.WHITE;
		
		teams = new HashMap<TeamColor, Team>();
		
		teamBlack = new Team(TeamColor.BLACK);
		teamWhite = new Team(TeamColor.WHITE);
		
		teams.put(TeamColor.BLACK, teamBlack);
		teams.put(TeamColor.WHITE, teamWhite);
		isRunning = true;
		scan = new Scanner(System.in);
	}
	
	public boolean isRunning()
	{
		return isRunning;
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
		v.setupGui(this.board);
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
		//System.out.println(kingSquare);
		HashSet<Square> enemyMoves = (HashSet<Square>) board.getTeamMoves(enemyColor);
		
		isInCheck = enemyMoves.contains(kingSquare);

		
		return isInCheck;
	}
	
	
	public boolean isKingInCheckmate()
	{
		//true until you find a move that takes the king out of check
		boolean checkMated = true;
		
		//HashSet<Square> allyMoves = (HashSet<Square>)board.getTeamMoves(currentTurnColor);
		Team kingTeam = teams.get(currentTurnColor);
		Team enemyTeam = teams.get((currentTurnColor == TeamColor.WHITE) ? TeamColor.BLACK : TeamColor.WHITE);
		
		HashSet<Piece> pieces = new HashSet<Piece>(kingTeam.getPieces());
		
		//while(checkMated)
		//{
			for(Piece p : pieces)
			{
				Square initialPosition = kingTeam.getPiecePosition(p);
				HashSet<Square> possibleMoves = (HashSet<Square>) p.getPossibleMoves(initialPosition, this.board);
				
				for(Square s : possibleMoves)
				{
					//make changes
					initialPosition.clearPiece();
					kingTeam.updatePiecePosition(p, s);
					
					Piece possiblePiece = s.getPiece();
					
					s.setPiece(p);
					
					//if the king is no longer in check, there is no checkmate
					if(!isKingInCheck())
					{
						//System.out.println(p.getName() + ", " + s);
						checkMated = false;
					}					
					//else, undo the changes and continue checking moves
					
					//undo changes
					initialPosition.setPiece(p);
					kingTeam.updatePiecePosition(p, initialPosition);
					
					if(possiblePiece != null)
					{
						s.setPiece(possiblePiece);
						enemyTeam.addPiece(possiblePiece, s);
					}
					else
					{
						s.clearPiece();
					}
				}
				
				
			}
		//}
		 
		
		return checkMated;
	}
	
	//TODO pawn promotion
	public void promotePawn(Pawn pawn)
	{
		TeamColor color = pawn.getColor();
		Square position = teams.get(color).getPiecePosition(pawn);
		//replace it with a piece of the same color
		
		Piece newPiece = null;
		
		System.out.println("Promote pawn to: ");
		System.out.println("Q - Queen \nN - Knight\nB-Bishop \nR-Rook");
		
		newPiece = Placer.returnPiece(scan.nextLine().toUpperCase(), color);
		
		teams.get(color).addPiece(newPiece, position);
		//remove pawn
		teams.get(color).deletePiece(pawn);
	}
	
	//TODO process single line actions
	public void processAction(Action a)
	{
		
		if(a.actionType != ActionType.MOVECHECK)
		{
			//acting out of turn
			if(a.actionType == ActionType.INVALID)
			{
				a.execute();
			}
			else if(a.getActionColor() != currentTurnColor)
			{
				System.out.println("Invalid move; it is " + currentTurnColor + "'s turn");
			}
			else if(a.actionType == ActionType.MOVEMENT)
			{
				boolean inCheck = isKingInCheck();
				MoveAction ma = (MoveAction)a;
				
				//if the king was in check to begin with
				if(ma.execute())
				{
					if(isKingInCheck())
					{
						//undo move
						System.out.println("Invalid move; " + currentTurnColor + "'s king must be taken out of check.");
						ma.undo();
					}
					else
					{
						currentTurnColor = (currentTurnColor == TeamColor.WHITE) ? TeamColor.BLACK : TeamColor.WHITE;
						notifyTurn();
					}

				}
				
				displayBoard();
			}
		}
		else
		{
			a.execute();
		}
	}
	

	public void processActions(ArrayList<Action> actionList)
	{	
		notifyTurn();
		for(Action a : actionList)
		{
			processAction(a);
		}
	}
	
	public void notifyTurn()
	{
		System.out.println("It is now " + currentTurnColor + "'s turn.");
		
		
		System.out.println("Movable pieces are on:" + teams.get(currentTurnColor).getMovablePieces(board));
		
		if(isKingInCheck())
		{
			//every time there is a check, check for checkmate
			if(isKingInCheckmate())
			{
				System.out.println(currentTurnColor + "'s King has been checkmated; game over.");
				isRunning = false;
				//v.closeGui();
			
			}
			else
			{
				System.out.println(currentTurnColor + "'s King is in check.");
				//i need to make sure king gets out of check on this turn
				
			}
		}
	}

}
