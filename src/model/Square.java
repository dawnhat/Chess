package model;


public class Square 
{
	private Piece piece = null;
	private String displaySymbol = " - "; //default empty
	private String squareID;
	Color color = null;
	public Square(String squareID)
	{
		this.squareID = squareID;
	}
	
	public Piece getPiece()
	{
		return this.piece;
	}
	
	public String getDisplaySymbol()
	{
		return displaySymbol;
	}
	
	public void setDisplaySymbol(String newSymbol)
	{
		displaySymbol = " " + newSymbol + " ";
	}
	
	public void clearSymbol()
	{
		this.displaySymbol = " - ";
	}
	
	public void clearPiece()
	{
		this.piece = null;
		clearSymbol();
	}
	
	public boolean isEmpty()
	{
		if(displaySymbol.equals(" - "))
		{
			return true;
		}
		else
			return false;
	}
	
	public String takeSymbol()
	{
		String temp = this.displaySymbol;
		clearSymbol();
		return temp;
	}
	
	public int convertColumnIndex()
	{
		return squareID.charAt(0) - 'A';
	}
	
	public int convertRowIndex()
	{
		return 8 - Integer.parseInt(squareID.charAt(1)+"");
	}
	
	public String getSquareID()
	{
		return this.squareID;
	}
	
	public void setPiece(Piece piece)
	{
		this.piece = piece;
		setDisplaySymbol(piece.displaySymbol);
	}
	
	

}
