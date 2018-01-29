import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		String[][] board = {{"","",""},{"","",""},{"","",""}};
		System.out.println("Welcome to tic tac toe!");
		boolean xTurn = true;
		Scanner sc = new Scanner(System.in);
		int row = 0;
		int columb = 0;
		
		while(true)
		{
			draw(board);
			System.out.println("It is " + ((xTurn)?"X's":"O's") + " turn!");
			System.out.println("Please input a row number!(Top to bottom)");
			while(true)
			{
				boolean isInt = false;
				while(!isInt)
				{
					try{
						row = sc.nextInt()-1;
						isInt = true;
					}
					catch(NumberFormatException e)
					{
						System.out.println("Not a string!");
					}
					catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.println("Too small or big!");
					}
				}
				System.out.println("Please input a columb number!(Left to right!)");
				isInt = false;
				while(!isInt)
				{
					try{
						columb = sc.nextInt()-1;
						isInt = true;
					}
					catch(NumberFormatException e)
					{
						System.out.println("Not a string!");
					}
					catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.println("Too small or big!");
					}
				}
				try
				{
					if(!board[row][columb].equals(""))
					{
							System.out.println("That space is taken!");
					}
					else
					{
							break;
					}
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("Out of bounds!");
				}
			}
			
			board[row][columb] = (xTurn)?"X":"O";
			
			String winner = testWin(board, xTurn);
			if(!winner.equals("")&&!winner.equals("C"))
			{
				draw(board);
				System.out.println(((xTurn)?"X":"O") + " wins!");
				break;
			}
			if(winner.equals("C"))
			{
				draw(board);
				System.out.println("Cat! No winners!");
				break;
			}
			xTurn = (xTurn)?false:true;
		}
		sc.close();
	}
	
	public static void draw(String[][] board)
	{
		for(int i = 0; i < board.length; i++)
		{
			String[] lines = {"","",""};
			
			for(int j = 0; j < board[i].length; j++)
			{
				if(board[i][j].equals(""))
				{
					lines[0] += "   ";
					lines[1] += "   ";
					lines[2] += "   ";
				}
				else if(board[i][j].equals("X"))
				{
					lines[0] += "\\ /";
					lines[1] += " | ";
					lines[2] += "/ \\";
				}
				else if(board[i][j].equals("O"))
				{
					lines[0] += "/-\\";
					lines[1] += "| |";
					lines[2] += "\\_/";
				}
				
				if(j+1 != board[i].length)
				{
					lines[0] += "|";
					lines[1] += "|";
					lines[2] += "|";
				}
			}
			
			System.out.print(lines[0] + "\n" + lines[1] + "\n" + lines[2] + "\n");
			if(i+1 != board.length)
			{
				System.out.println("---+---+---");
			}
		}
	}
	
	public static String testWin(String[][] board, boolean turn)
	{
		for(int i = 0; i < board.length; i++)
		{
			if(board[i][0].equals(board[i][1])&&board[i][1].equals(board[i][2])&&board[i][0]!="")
			{
				if(turn == true)
				{
					return "X";
				}
				else
				{
					return "O";
				}
			}
			else if(board[0][i].equals(board[1][i])&&board[1][i].equals(board[2][i])&&board[0][i]!="")
			{
				if(turn == true)
				{
					return "X";
				}
				else
				{
					return "O";
				}
			}
			else if(board[0][0].equals(board[1][1])&&board[1][1].equals(board[2][2])&&board[0][0]!="")
			{
				if(turn == true)
				{
					return "X";
				}
				else
				{
					return "O";
				}
			}
			else if(board[2][0].equals(board[1][1])&&board[1][1].equals(board[0][2])&&board[2][0]!="")
			{
				if(turn == true)
				{
					return "X";
				}
				else
				{
					return "O";
				}
			}
		}
		boolean isCat = true;
		for(int j = 0; j < board.length; j++)
		{
			for(int k = 0; k < board[j].length;k++)
			{
				if(board[j][k].equals(""))
				{
					isCat = false;
				}
			}
		}
		if(isCat)
		{
			return "C";
		}
		
		return "";
	}

}
