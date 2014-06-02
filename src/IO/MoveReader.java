package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Action;
import model.Board;
import model.CaptureAction;
import model.Game;
import model.King;
import model.MoveAction;
import model.MoveCheck;
import model.Piece;
import model.Piece.TeamColor;
import model.PlaceAction;
import model.Placer;
import model.Square;

public final class MoveReader 
{
	
	static FileReader input = null;
	
	private final static String PLACEMENT_STRING = "(?<piece>[KQBRNPkqbrnp])(?<color>[DLdl])(?<column>[A-Ha-h])(?<row>[1-8])";
	private final static String MOVEMENT_STRING = "(?<column1>[A-Ha-h])(?<row1>[1-8])[ ](?<column2>[A-Ha-h])(?<row2>[1-8])";
	private final static String CAPTURE_STRING = "(?<column1>[A-Ha-h])(?<row1>[1-8])[ ](?<column2>[A-Ha-h])(?<row2>[1-8])[*]";
	private final static String CASTLE_STRING = "(?<p1column1>[A-Ha-h])(?<p1row1>[1-8])[ ](?<p1column2>[A-Ha-h])(?<p1row2>[1-8])[ ](?<p2column1>[A-Ha-h])(?<p2row1>[1-8])[ ](?<p2column2>[A-Ha-h])(?<p2row2>[1-8])";
	private final static String CHECK_STRING = "(?<column1>[A-Ha-h])(?<row1>[1-8])";
	
	private static StringPattern placementPattern = new StringPattern(PLACEMENT_STRING, CommandType.PLACEMENT);
	private static StringPattern movementPattern = new StringPattern(MOVEMENT_STRING, CommandType.MOVEMENT);
	private static StringPattern capturePattern = new StringPattern(CAPTURE_STRING, CommandType.CAPTURE);
	private static StringPattern castlePattern = new StringPattern(CASTLE_STRING, CommandType.CASTLING);
	private static StringPattern checkPattern = new StringPattern(CHECK_STRING, CommandType.MOVECHECK);
	
	static StringPattern[] stringPatterns = {placementPattern, movementPattern, capturePattern, castlePattern, checkPattern};
	
	private static HashMap<String, String> pieceTable = new HashMap<String, String>();
	private static HashMap<String, TeamColor> colorTable = new HashMap<String, TeamColor>();
	
	static
	{
		pieceTable.put("K", "King");
		pieceTable.put("Q", "Queen");
		pieceTable.put("B", "Bishop");
		pieceTable.put("R", "Rook");
		pieceTable.put("N", "Knight");
		pieceTable.put("P", "Pawn");
		
		colorTable.put("L", TeamColor.WHITE);
		colorTable.put("D", TeamColor.BLACK);
	}
	
	
	Game game;
	
	ArrayList<Action> placeList = new ArrayList<Action>();
	ArrayList<Action> actionList = new ArrayList<Action>();
	
	public MoveReader(Game game)
	{
		this.game = game;
	}
	
	public void updateGame(Game game)
	{
		this.game = game;
	}
	
	public void interpretFile(String fileName)
	{
		File file = new File(fileName);
		
		try {
			input = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader buffer = new BufferedReader(input);
		
		String temp;
		try {
			while((temp = buffer.readLine()) != null)
			{
				interpretCommand(temp.toUpperCase());
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static CommandType returnCommandType(String commandString)
	{
		CommandType type = CommandType.INVALID;
		for(int i = 0; i < stringPatterns.length && type == CommandType.INVALID; i++)
		{
			if(Pattern.matches(stringPatterns[i].getString(), commandString))
			{
				type = stringPatterns[i].getCommandType();
			}
		}
		return type;
	}
	
	public void interpretCommand(String commandString)
	{
		Board board = game.getBoard();
		Matcher m = null;
		//String symbol1 = null;
		//String symbol2 = null;
		for(StringPattern sp : stringPatterns)
		{
			if(sp.getCommandType() == returnCommandType(commandString))
			{
				m = sp.getMatcher(commandString);
				m.find();
			}
		}
		
		//TODO: change error messages; make sure they throw an exception instead
		//Take these out; the IO shouldn't be making game changes
		
		switch(returnCommandType(commandString))
		{
		case PLACEMENT:

			//old
			
			TeamColor color = colorTable.get(m.group("color"));
			
			Piece p = Placer.returnPiece(m.group("piece"), color);
			Square s = board.returnSquare(m.group("column") + m.group("row"));
			
			/*
			board.returnSquare(squareName).setPiece(Placer.returnPiece(m.group("piece"), color));
			*/
			
			//new
			placeList.add(new PlaceAction(p, s));
			//new PlaceAction(p, s).execute(board);
			
			
			break;
		case MOVEMENT:
			//game.displayBoard();
			Square moveSquare1 = board.returnSquare(m.group("column1") + m.group("row1"));
			Square moveSquare2 = board.returnSquare(m.group("column2") + m.group("row2"));
		
			//TeamColor actionColor = moveSquare1.getPiece().getColor();
			MoveAction ma = new  MoveAction(moveSquare1, moveSquare2, game);
			
			actionList.add(ma);
			//ma.execute(board);
			break;
		case MOVECHECK:
			Square checkSquare = board.returnSquare(m.group("column1") + m.group("row1"));
			MoveCheck mc = new MoveCheck(checkSquare, game);
			
			actionList.add(mc);
			//mc.execute(board);
		
			break;
		case CAPTURE:
			
			Square captureSquare1 = board.returnSquare(m.group("column1") + m.group("row1"));
			Square captureSquare2 = board.returnSquare(m.group("column2") + m.group("row2"));

			actionList.add(new CaptureAction(captureSquare1, captureSquare2, game));
			
			break;
		case CASTLING:
			Square castleSquare1 = board.returnSquare(m.group("p1column1") + m.group("p1row1"));
			Square castleSquare2 = board.returnSquare(m.group("p1column2") + m.group("p1row2"));
			Square castleSquare3 = board.returnSquare(m.group("p2column1") + m.group("p2row1"));
			Square castleSquare4 = board.returnSquare(m.group("p2column2") + m.group("p2row2"));
			
			if(castleSquare1.isEmpty() || castleSquare3.isEmpty())
			{
				System.out.println("No piece to move!");
			}
			else if(!castleSquare2.isEmpty() || !castleSquare4.isEmpty())
			{
				System.out.println("One or both squares are already occupied.");
			}
			else
			{
				Piece k = castleSquare1.getPiece();
				Piece r = castleSquare3.getPiece();
				
				castleSquare2.setPiece(k);
				castleSquare4.setPiece(r);
				
				castleSquare1.clearPiece();
				castleSquare3.clearPiece();
				
				System.out.println("Moved piece from " + castleSquare1 + " to " + castleSquare2 
						+ ", and moved piece from " + castleSquare3 + " to " + castleSquare4);
			}
			
			break;
		case INVALID:
			System.err.println(commandString + " is an invalid move");
			
			break;
		}
	}

}
