package IO;

import java.io.*;
import java.util.ArrayList;

import view.Viewer;
import model.*;

public class ChessMain 
{
	public static void main(String[] args)
	{
		Game game = new Game(new Board());
		MoveReader moveReader = new MoveReader(game);
		moveReader.interpretFile(args[0]);
		
		moveReader.interpretFile(args[1]);
		
		//processActions(game, moveReader.actionList);
		game.setupBoard(moveReader.placeList);
		game.displayBoard();
		//moveReader.updateGame(game);
		game.processActions(moveReader.actionList);
		
	}
	
	public static void processActions(Game game, ArrayList<Action> actionList)
	{
		Viewer v = new Viewer();
		for(Action a : actionList)
		{
			if(a.execute(game.getBoard()))
			{
				v.display(game.getBoard());
			}
			
		}
	}

}
