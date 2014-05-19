package model;
import java.util.HashMap;



public class Board 
{
	private final int BOARD_LENGTH = 8;
	private Square[][] board = new Square[BOARD_LENGTH][BOARD_LENGTH];
	private String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};
	private HashMap<String, Square> hashBoard;
	
	public Board()
	{	
		
		hashBoard = new HashMap<String, Square>();
		int l = BOARD_LENGTH;
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			
			for(int u = 0; u < BOARD_LENGTH; u++)
			{
				String squareID = letters[u] + "" + l;
				Square newSquare = new Square(squareID);
				board[i][u] = newSquare;
				hashBoard.put(squareID, newSquare);
				
				//System.out.println(letters[u] + "" + l);
				
			}
			l--;
		}
		
	}
	
	public int getBoardLength()
	{
		return this.BOARD_LENGTH;
	}
	
	/*
	public void display()
	{
		
		//for each square in board, display the displaysymbol
		int u = BOARD_LENGTH;
		System.out.println("  A  B  C  D  E  F  G  H");
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			System.out.print(u--);
			for(Square s : board[i])
			{
				System.out.print(s.getDisplaySymbol());
			}
			System.out.println("");
		}
	}
	*/
	
	public Square returnSquare(String squareID)
	{
		
		Square square = null;
		
		square = hashBoard.get(squareID);
		/*
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			for(Square s : board[i])
			{
				if(s.getSquareID().equals(squareID))
				{
					square = s;
				}
			}
		}*/
		
		
		return square;
		
		/*
		int letter = squareID.charAt(0) - 'A';
		int num = '8'-squareID.charAt(1);
		return board[num][letter];	
		*/
		
	}
	
	public Square returnSquareAt(int rowNum, int columnNum)
	{
		//System.out.println(board[columnNum][rowNum].getSquareID());
		return board[rowNum][columnNum];
	}
}
