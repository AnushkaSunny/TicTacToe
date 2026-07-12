package T3Game;


class PvP extends Main
{
	char p1;
	char p2;
	char winner=' ';
	int row,col;
	String player1,player2;
	
	void main()
	{
		System.out.println("Enter Player 1 name: ");
		player1=sc.next();
		System.out.println("Enter Player 2 name: ");
		player2=sc.next();
		System.out.println(player1+ " Choose between X or O : "+p1);
		p1=sc.next().charAt(0);
		
		if(p1=='X' || p1=='x')
		{	
			p2='O';
			System.out.println(player1+" is "+p1);
			System.out.println(player2+" is "+p2);
		}
		else
		{
			p2='X';
			System.out.println(player1+" is "+p1);
			System.out.println(player2+" is "+p2);
			
		}
		
		resetBoard();
		
		while(winner == ' ' && isSpotFree() != 0)
		{
		
			printBoard();
	
			P1Move(player1);
			winner = checkWinner();
			if(winner != ' ' || isSpotFree() == 0)
			{
				break;
			}
			
			printBoard();
			
			P2Move(player2);
			winner = checkWinner();
			if(winner != ' ' || isSpotFree() == 0)
			{
				break;
			}
		}
		
		printBoard();
		printWinner(winner,player1,player2);
			
	}
	
	void resetBoard()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				Board[i][j]=' ';
			}
		}
	}
	
	void printBoard()
	{
		for(int t=0;t<3;t++)
		{
			System.out.println(" "+Board[t][0]+" | "+Board[t][1]+" | "+Board[t][2]);
			if(t!=2) 
			{
				System.out.println("---|---|---");
			}
		}
	}
	
	int isSpotFree()
	{
		int freespot=9;
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(Board[i][j]!=' ')
				{
					freespot--;
				}
			}
		}
		return freespot;
		
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
				System.out.println("Invalid Option . Please choose within the Range 1-3");
				P1Move(player1);
			}
		}
		while(Board[row][col] != ' ');
		
	}
	
	void P2Move(String player2)
	{
		do
		{
			try
			{
				System.out.println("\n"+player2+"'s Turn  ");
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
					Board[row][col]=p2;
					break;
				}
			}
			catch(Exception e)
			{
				System.out.println("Invalid Option. Please Choose within the range 1-3");
				P2Move(player2);
			}
		}
		while(Board[row][col] != ' ');
	}
	char checkWinner()
	{
		//rows
		for(int i=0;i<3;i++)
		{
			if(Board[i][0]!=' ' && (Board[i][0]==Board[i][1]) && (Board[i][1]==Board[i][2]))
			{
				return Board[i][0];
			}
		}
		
		//column
		for(int i=0;i<3;i++)
		{
			if(Board[0][i]!=' ' && (Board[0][i]==Board[1][i]) && (Board[1][i]==Board[2][i]))
			{
				return Board[0][i];
			}
		}
		
		//diagonal
		for(int i=0;i<3;i++)
		{
			if(Board[0][0]!=' ' && (Board[0][0]==Board[1][1]) && (Board[1][1]==Board[2][2]))
			{
				return Board[0][0];
			}
			if(Board[0][2]!=' ' && (Board[0][2]==Board[1][1]) && (Board[1][1]==Board[2][0]))
			{
				return Board[0][2];
			}
		}
		
		return ' ';
	}
	
	void printWinner(char winner,String player1,String player2)
	{
		if(winner == p1)
		{
			System.out.println(player1+" WINS !!");
		}
		
		else if(winner == p2)
		{
			System.out.println(player2+" WINS !!");
		}
		else
		{
			System.out.println("IT'S A DRAW ");
		}
	}
}
