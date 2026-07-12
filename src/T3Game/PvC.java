package T3Game;

import java.util.Random;

class PvC extends PvP
{
	
	
	void main()
	{
		System.out.println("Enter Player name : ");
		player1=sc.next();
		System.out.println(player1+" choose between X and O");
		p1=sc.next().charAt(0);
		
		if(p1=='X' || p1=='x')
		{
			System.out.println(player1+" is X");
			p2='O';
		}
		else
		{
			System.out.println(player1+" is O");
			p2='X';
		}
		
		resetBoard();
		
		while(winner == ' ' && isSpotFree() != 0)
		{
			printBoard();
			
			P1Move(player1);
			winner=checkWinner();
			if(winner != ' ' || isSpotFree() == 0)
			{
				break;
			}
			
			
			
			CompMove();
			winner=checkWinner();
			if(winner != ' ' || isSpotFree() == 0)
			{
				break;
			}
			
			
			
		}
		
		printBoard();
		printWinner(winner,player1);
		
	}
	
	void P1Move(String player1)
	{
		do
		{
			try
			{
				System.out.println("\n"+player1+"'s Turn  ");
				System.out.println("Enter Row (1-3): ");
				row=sc.nextInt();
				row--;
				System.out.println("Enter Col (1-3): ");
				col=sc.nextInt();
				col--;
				
				if(Board[row][col] != ' ')
				{
					System.out.println("This Spot is taken. Please Choose again !");
					
				}
				else 
				{
					Board[row][col]=p1;
					break;
				}
			}
			catch(Exception e)
			{
				System.out.println("Invalid Option. Please choose again !!");
				P1Move(player1);
			}
		}
		while(Board[row][col] != ' ');
		
	}
	
	
	void CompMove()
	{
		Random random=new Random();
		
			do
			{
				row=random.nextInt(3);
				col=random.nextInt(3);
				
				if(Board[row][col] == ' ')
				{
					Board[row][col]=p2;
					break;
				}
			}
			while(Board[row][col] != ' ');
		
		
		
		
	}
	
	void printWinner(char winner,String player1)
	{
		if(winner == p1)
		{
			System.out.println(player1+" WINS !!");
		}
		
		else if(winner == p2)
		{
			System.out.println("I WIN STUPID HUMAN !!");
		}
		
		else
		{
			System.out.println("IT'S A DRAW ");
		}
	}
}

