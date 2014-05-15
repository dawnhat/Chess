package IO;

import java.io.*;

import model.*;

public class ChessMain 
{
	public static void main(String[] args)
	{
		Game game = new Game(new Board());
		MoveReader moveReader = new MoveReader(game);
		//moveReader.convertFileToList("src/moves.txt");
		moveReader.interpretFile(args[0]);
		
		
		game.getBoard().display();
		
	}

}
