package model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class Piece {
	protected String displaySymbol;
	protected String name;
	protected TeamColor teamColor;
	protected HashSet<Square> possibleMoves;
	
	
	public String getSymbol()
	{
		return displaySymbol;
		
	}
	
	public void setSymbol(String newSymbol)
	{
		this.displaySymbol = newSymbol;
	}
	
	public String getName()
	{
		return this.teamColor + " " + this.name;
	}
	
	public TeamColor getColor()
	{
		//System.out.println(this.teamColor);
		return this.teamColor;
	}
	
	public abstract Set getPossibleMoves(Square currentSquare, Board board);
	
	public enum TeamColor
	{
		WHITE,
		BLACK
	}


}
