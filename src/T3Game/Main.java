package T3Game;

import java.util.Scanner;


public class Main {
	
	char Board[][]=new char[3][3];
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		
		PvP obj=new PvP();
		PvC obj1=new PvC();
		
		System.out.println("-----TIC TAC TOE-----");
		
		System.out.println("\n1)Player vs Player\n2)Player vs Computer\nChoose game mode :- ");
		int ch=sc.nextInt();
		
		switch(ch)
		{
			case 1:
					obj.main();
					break;
			case 2:
					obj1.main();
					break;
					
			default:
					System.out.println("Invalid Option. Please Choose again !");
								
		}
		
		

	}

}




