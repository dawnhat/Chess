package IO;

public enum CommandType 
{
	PLACEMENT,
	MOVEMENT,
	CAPTURE,
	CASTLING, //google tells me castling is the ONLY move in chess where two pieces move in one turn, so there
	INVALID, 
	MOVECHECK

}
