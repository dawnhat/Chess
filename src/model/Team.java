package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Piece.TeamColor;

public class Team 
{
	private TeamColor color;
	private HashMap<Piece, Square> teamPositions;
	
	public Team(TeamColor color)
	{
		this.color = color;
		teamPositions = new HashMap<Piece, Square>();
	}
	
	public void addPiece(Piece piece, Square square)
	{
		this.teamPositions.put(piece, square);
	}
	
	public Set<Square> getMovablePieces(Board board)
	{
		HashSet<Square> moves = new HashSet<Square>();
		for(Piece p : teamPositions.keySet())
		{
			if(!p.getPossibleMoves(teamPositions.get(p), board).isEmpty())
			{
				moves.add(teamPositions.get(p));
			}
		}
		
		return moves;
	}
	
	public Set<Piece> getPieces()
	{
		/*
		Set<Piece> pieces = new HashSet<Piece>();
		pieces = teamPositions.keySet();
		
		return pieces;*/
		
		return teamPositions.keySet();
	}
	
	public Map<Piece, Square> getTeamPositions()
	{
		return this.teamPositions;
	}
	
	public void updatePiecePosition(Piece piece, Square square)
	{
		this.teamPositions.remove(piece);
		this.teamPositions.put(piece, square);
	}
	
	public void deletePiece(Piece piece)
	{
		this.teamPositions.remove(piece);
	}
	
	public Square getPiecePosition(Piece piece)
	{
		Square position = null;
		position = teamPositions.get(piece);
		
		return position;
	}

	
	public King getKing()
	{
		King k = null;
		
		for(Piece p : teamPositions.keySet())
		{
			if(p instanceof model.King)
			{
				k = (King)p;
			}
		}
		
		return k;
		
	}
	


}
