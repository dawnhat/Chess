package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;

public abstract class Piece {
	protected String displaySymbol;
	protected String name;
	protected TeamColor teamColor;
	protected HashSet<Square> possibleMoves;
	protected ImageIcon image;
	
	public String getSymbol()
	{
		return displaySymbol;
		
	}
	
	public ImageIcon getImage()
	{
		return this.image;
	}
	
	public void setImage(String filePath)
	{
		image = new ImageIcon(filePath);
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
