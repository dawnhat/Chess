package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.King;
import model.Piece;

public final class MoveReader 
{
	/*
	 * QLD1
	 */
	static FileReader input = null;
	
	private final static String PLACEMENT_STRING = "(?<piece>[KQBRNPkqbrnp])(?<color>[DLdl])(?<column>[A-Ha-h])(?<row>[1-8])";
	private final static String MOVEMENT_STRING = "(?<column1>[A-Ha-h])(?<row1>[1-8])[ ](?<column2>[A-Ha-h])(?<row2>[1-8])";
	private final static String CAPTURE_STRING = "(?<column1>[A-Ha-h])(?<row1>[1-8])[ ](?<column2>[A-Ha-h])(?<row2>[1-8])[*]";
	private final static String CASTLE_STRING = "(?<p1column1>[A-Ha-h])(?<p1row1>[1-8])[ ](?<p1column2>[A-Ha-h])(?<p1row2>[1-8])[ ](?<p2column1>[A-Ha-h])(?<p2row1>[1-8])[ ](?<p2column2>[A-Ha-h])(?<p2row2>[1-8])";
	
	private static StringPattern placementPattern = new StringPattern(PLACEMENT_STRING, CommandType.PLACEMENT);
	private static StringPattern movementPattern = new StringPattern(MOVEMENT_STRING, CommandType.MOVEMENT);
	private static StringPattern capturePattern = new StringPattern(CAPTURE_STRING, CommandType.CAPTURE);
	private static StringPattern castlePattern = new StringPattern(CASTLE_STRING, CommandType.CASTLING);
	
	HashMap<CommandType, StringPattern> stringPatterns2 = new HashMap<CommandType, StringPattern>();
	static StringPattern[] stringPatterns = {placementPattern, movementPattern, capturePattern, castlePattern};
	
	private HashMap<String, String> pieceTable = new HashMap<String, String>();
	private HashMap<String, String> colorTable = new HashMap<String, String>();
	
	public MoveReader()
	{
		pieceTable.put("K", "King");
		pieceTable.put("Q", "Queen");
		pieceTable.put("B", "Bishop");
		pieceTable.put("R", "Rook");
		pieceTable.put("N", "Knight");
		pieceTable.put("P", "Pawn");
		
		
		colorTable.put("L", "White");
		colorTable.put("D", "Black");
		
	}
	
	public void convertFileToList(String fileName)
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
	
	//<CommandType, StringPattern>
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
		Matcher m = null;
		/*
		String symbol1 = null;
		String symbol2 = null;*/
		for(StringPattern sp : stringPatterns)
		{
			if(sp.getCommandType() == returnCommandType(commandString))
			{
				m = sp.getMatcher(commandString);
				m.find();
			}
		}
		
		//just print line depending on the command
		switch(returnCommandType(commandString))
		{
		case PLACEMENT:
			String pieceName = pieceTable.get(m.group("piece"));
			String color = colorTable.get(m.group("color"));
			String squareName = m.group("column") + m.group("row");
			System.out.println(color + " " + pieceName + " placed on " + squareName);
			break;
		case MOVEMENT:
			String moveSquare1 = m.group("column1") + m.group("row1");
			String moveSquare2 = m.group("column2") + m.group("row2");
			System.out.println("Moved piece from " + moveSquare1 + " to " + moveSquare2);
			break;
		case CAPTURE:
			String captureSquare1 = m.group("column1") + m.group("row1");
			String captureSquare2 = m.group("column2") + m.group("row2");
			System.out.println("Moved piece from " + captureSquare1 + " to capture piece on " + captureSquare2);
			break;
		case CASTLING:
			String castleSquare1 = m.group("p1column1") + m.group("p1row1");
			String castleSquare2 = m.group("p1column2") + m.group("p1row2");
			String castleSquare3 = m.group("p2column1") + m.group("p2row1");
			String castleSquare4 = m.group("p2column2") + m.group("p2row2");
			System.out.println("Moved piece from " + castleSquare1 + " to " + castleSquare2 
					+ ", and moved piece from " + castleSquare3 + " to " + castleSquare4);
			break;
		case INVALID:
			System.out.println("Invalid move");
			break;
		}
	}
	
	/*
	 * Create a hashmap/dictionary indexed by their symbols (K, N, so on) with their values being the full name of the piece (King, Knight).
	 */
	
	
	
	

}
