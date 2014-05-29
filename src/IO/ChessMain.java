package IO;

import java.io.*;
import java.util.ArrayList;

import view.Viewer;
import model.*;
import model.Piece.TeamColor;

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
		//game.isKingInCheck(TeamColor.WHITE);
		
	}
	

}
