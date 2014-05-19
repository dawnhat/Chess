package IO;

import java.io.*;

import view.Viewer;
import model.*;

public class ChessMain 
{
	public static void main(String[] args)
	{
		Game game = new Game(new Board());
		MoveReader moveReader = new MoveReader(game);
		//moveReader.convertFileToList("src/moves.txt");
		moveReader.interpretFile(args[0]);
		
		Viewer v = new Viewer();
		v.display(game.getBoard());
		
		//game.getBoard().display();
		
	}

}
