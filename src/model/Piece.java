package model;

public class Piece {
	protected String displaySymbol;
	protected String name;
	protected TeamColor teamColor;
	
	public String getDisplaySymbol()
	{
		return displaySymbol;
		
	}
	
	public enum TeamColor
	{
		WHITE,
		BLACK
	}

}
