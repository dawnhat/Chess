package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

import IO.MoveReader;
import model.Board;
import model.Game;
import model.MoveAction;
import model.MoveCheck;
import model.Piece;
import model.Square;

public class Viewer implements Runnable, MouseListener
{
	private JFrame frame;
	private Board board;
	private Square currentFocus;
	private MoveReader reader;
	private Game game;
	
	public Viewer(Game game)
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLayout(new GridLayout(8,8));
		this.game = game;
		reader = new MoveReader(game);
		
		//setupGui(game.getBoard());
	}
	
	public void display(Board b)
	{
		this.board = b;
		//for each square in board, display the displaysymbol
		int u = b.getBoardLength();
		System.out.println("  A  B  C  D  E  F  G  H");
		for(int i = 0; i < b.getBoardLength(); i++)
		{
			System.out.print(u--);
			for(int z = 0; z < b.getBoardLength(); z++)
			{
				System.out.print(b.returnSquareAt(i, z).getDisplaySymbol());
			}
			System.out.println("");
		}
		/*
		if(!game.isRunning())
		{
			closeGui();
		}*/
	}
	
	public void closeGui()
	{
		//display(game.getBoard());

		frame.dispose();
		System.exit(0);
		
	}
	
	/*
	public void updateGui()
	{
		//after every move i need the gui to reflect the current state of the board?
		HashSet<Square> squares = new HashSet<Square>();
		for(int i = 0; i < frame.getComponentCount(); i++)
		{
			if(frame.getComponent(i) instanceof Square)
			{
				squares.add((Square)frame.getComponent(i));
			}
		}

		for(Square s : squares)
		{
			if(!s.isEmpty())
			{
				s.setImage(s.getPiece().getImage());
			}
			s.revalidate();
			s.repaint();
			
		}
		frame.repaint();
		frame.revalidate();
		
		
	}
	*/
	
	public void wipeBoardFocus()
	{
		for(int i = 0; i < board.getBoardLength(); i++)
		{
			for(int u = 0; u < board.getBoardLength(); u++)
			{
				Square s = board.returnSquareAt(i, u);
				s.setBackground(s.getColor());
			}
		}
	}
	
	public void setupGui(Board b)
	{
		
		Color c = Color.WHITE;
		for(int i = 0; i < b.getBoardLength(); i++)
		{
			for(int u = 0; u < b.getBoardLength(); u++)
			{
				
				Square s = b.returnSquareAt(i,u);
				s.setSize(75,75);
				s.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				s.setOpaque(true);
				
				s.setBackground(c);
				s.setColor(c);
				
				
				s.setIcon(s.getImage());
				
				s.addMouseListener(new MouseListener()
				{
					//now i have to put in some logic for movement...

					@Override
					public void mouseClicked(MouseEvent arg0) 
					{
						Square s = (Square)arg0.getSource();
						
						if(!game.isRunning())
						{
							closeGui();
						}
						
						if(s.getBackground() == Color.cyan)
						{
							s.setBackground(s.getColor());
						}
						else
						{
							s.setBackground(Color.cyan);
						}
						
						//if I click somewhere other than the current focused square AND if there IS a currentfocus
						if(currentFocus != null)
						{
							
							if(!s.equals(currentFocus))
							{
								//set conditions for when i click a square in the moveset?
								//create a movement action with these two squares
								Square square1 = currentFocus;
								Square square2 = s;
								
								//if the first selected square had a piece on it
								if(!square1.isEmpty())
								{
									//create a MoveAction; game will handle all invalid actions
									MoveAction ma = (MoveAction)reader.returnAction(square1 + " " + square2);
									game.processAction(ma);	
								}
								
								
							}

							//afterwards, clear the highlights and set focus to null
							currentFocus = null;
							//s.setFocus(false);
							wipeBoardFocus();
						}
						//if there is no previously clicked square AND if there is a piece on the clicked square, then
						//that means we need to highlight that piece's possible moves.
						else
						{
							if(!s.isEmpty())
							{
								
								//highlight moves
								System.out.println(s.getPiece().getName());
								HashSet<Square> moves = (HashSet<Square>) s.getPiece().getPossibleMoves(s, board);
								
								MoveCheck mc = (MoveCheck)reader.returnAction(s.getSquareID());
								game.processAction(mc);
								
								s.repaint();

								for(Square ps : moves)
								{
									if(ps.isEmpty())
									{
										ps.setBackground(Color.GREEN);
									}
									else
									{
										ps.setBackground(Color.RED);
									}
									ps.repaint();
								}
								currentFocus = s;
								//s.setFocus(true);

							}
							//if the square is empty
							else
							{
								System.out.println("Empty!");
								currentFocus = null;
								//s.setFocus(false);
								//wipeBoardFocus();
							}
						}			
						
						

					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
				frame.add(s);
				
				c = (c == Color.WHITE) ? Color.DARK_GRAY : Color.WHITE;
			}
			c = (c == Color.WHITE) ? Color.DARK_GRAY : Color.WHITE;
		}
		frame.setVisible(true);
	}

	//take in the board and create alternating colored squares??
	//JLabels for each square
	
	//setuperino
	@Override
	public void run() 
	{
		setupGui(board);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// should get the JLabel that has been clicked on, no? arg0.getComponent()
		arg0.getComponent().setBackground(Color.RED);
		arg0.getComponent().setForeground(Color.RED);
		System.out.println(arg0.getComponent());
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
