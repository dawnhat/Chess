package model;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	public Square getPiecePosition(Piece piece)
	{
		Square position = null;
		position = teamPositions.get(piece);
		
		return position;
	}
	
	public void print()
	{
		for(Piece p : teamPositions.keySet())
		{
			System.out.println("Class " + p.getClass());
		}
	}
	
	public King getKing()
	{
		King k = null;
		
		for(Piece p : teamPositions.keySet())
		{
			//System.out.println("Class" + p.getClass());
			if(p instanceof model.King)
			{
				k = (King)p;
			}
		}
		
		return k;
		
	}
	
	
	
	/*
	public void canMove(Square s, Board b)
	{
		for(Piece p : teamPieces)
		{
			p.getPossibleMoves
		}
	}*/
	


}
