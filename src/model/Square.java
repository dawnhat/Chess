package model;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Piece.TeamColor;

public class Square extends JLabel
{
	private Piece piece = null;
	private String displaySymbol = " - "; //default empty
	private String squareID;
	private Color color;
	private boolean isFocused;
	private ImageIcon image;
	private String emptyImageString;
	
	public Square(String squareID)
	{
		this.squareID = squareID;
		emptyImageString = "src/images/empty.gif";
		this.image = new ImageIcon(emptyImageString);
	}
	
	public ImageIcon getImage()
	{
		if(!this.isEmpty())
		{
			this.image = this.getPiece().getImage();
		}
		return this.image;
	}
	
	public void setImage(ImageIcon i)
	{
		this.image = i;
		this.setIcon(this.image);
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
		this.image =  new ImageIcon(emptyImageString);
		this.setIcon(this.image);
	}
	
	public void clearPiece()
	{
		this.piece = null;
		clearSymbol();
		setImage(null);
		this.setIcon(this.image);
	}
	
	public boolean isEmpty()
	{
		/*
		if(displaySymbol.equals(" - "))
		{
			return true;
		}*/
		if(this.piece == null)
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

		setDisplaySymbol(piece.getSymbol());
		setImage(piece.getImage());
	}
	
	@Override
	public String toString()
	{
		return this.squareID;
	}
	
	public void setColor(Color newColor)
	{
		this.color = newColor;
	}
	
	public Color getColor()
	{
		return this.color;
	}
	
	public boolean getIsFocused()
	{
		return this.isFocused;
	}
	
	public void setFocus(boolean focus)
	{
		this.isFocused = focus;
	}
	
	

}
