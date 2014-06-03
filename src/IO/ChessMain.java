package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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

		game.setupBoard(moveReader.placeList);
		game.displayBoard();
		//moveReader.updateGame(game);
		
		//game.processActions(moveReader.actionList);
		
		Scanner scan = new Scanner(System.in);
		game.notifyTurn();
		while(game.isRunning())
		{
			game.processAction(moveReader.returnAction(scan.nextLine().toUpperCase()));
		}
		scan.close();
		/*
		while(game.isRunning())
		{
			try(Scanner scan = new Scanner(System.in))
			{
				game.processAction(moveReader.returnAction(scan.nextLine().toUpperCase()));
			}
		}*/
		
		
		
		

		
	}
	

}
