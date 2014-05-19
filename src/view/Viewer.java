package view;

import model.Board;
import model.Square;

public class Viewer 
{
	public Viewer()
	{
		
	}
	
	public void display(Board b)
	{
		
		//for each square in board, display the displaysymbol
		int u = b.getBoardLength();
		System.out.println("  A  B  C  D  E  F  G  H");
		for(int i = 0; i < b.getBoardLength(); i++)
		{
			System.out.print(u--);
			for(int z = 0; z < b.getBoardLength(); z++)
			{
				System.out.print(b.returnSquareAt(i, z).getDisplaySymbol());
			}
			System.out.println("");
		}
	}

}
