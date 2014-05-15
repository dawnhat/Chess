package model;

public abstract class Piece {
	protected String displaySymbol;
	protected String name;
	protected TeamColor teamColor;
	
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
		return this.name;
	}
	
	public TeamColor getColor()
	{
		return this.teamColor;
	}
	
	public enum TeamColor
	{
		WHITE,
		BLACK
	}

}
