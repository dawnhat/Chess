package IO;

import java.io.*;

public class ChessMain 
{
	public static void main(String[] args)
	{
		MoveReader moveReader = new MoveReader();
		//moveReader.convertFileToList("src/moves.txt");
		moveReader.convertFileToList(args[0]);

		
	}

}
