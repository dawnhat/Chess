package model;

public class CaptureAction extends Action
{
	private Square square1;
	private Square square2;
	
	public CaptureAction(Square s1, Square s2)
	{
		this.square1 = s1;
		this.square2 = s2;
		this.actionType = ActionType.CAPTURE;
	}
	@Override
	public void execute(Board board)
	{
		// TODO Auto-generated method stub
		if(square1.isEmpty())
		{
			System.err.println("No piece to move on " + square1);
		}
		else if(square2.isEmpty())
		{
			System.err.println("No piece to capture on " + square2);
		}
		else
		{
			//if there IS a piece to move on square1 and if there IS a piece to capture on square 2, then
			Piece capturingPiece = square1.getPiece();
			Piece capturedPiece = square2.getPiece();
			if(capturingPiece.getPossibleMoves(square1, board).contains(square2))
			{
				square2.setPiece(capturingPiece);
				//clear
				square1.clearPiece();
				
				System.out.println("Moved " + capturingPiece.getName() + " from " + square1 + " to capture " + capturedPiece.getName() + " on " + square2);
			}
			else
			{
				System.err.println("Not a valid move for " + capturingPiece.getName());
			}
		}
		
		
	}

}
