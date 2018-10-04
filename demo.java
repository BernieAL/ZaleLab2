package lab2ADT;

import java.util.Scanner;

public class demo {

		public static void main(String[] args) {
			
			Scanner kbdIn = new Scanner(System.in);
			
			LockDataStructureClass temp = new LockDataStructureClass(19,4,6);
			
			menu(kbdIn);
			
		}
//----------------------------
//ROSE USE JOPTION AND IF ELSE	
		
		public static void menu (Scanner kbd) {
			
			
			LockDataStructureClass lock = new LockDataStructureClass();
			int x;
			int y;
			int z;
			
			System.out.println("Welcome to lock program. \n "
					+ "\nWhat would you like to do? Choose a number: ");
			
			System.out.println("  1: Set Lock Combination \n"
							  +"  2: close lock \n"
							  +"  3: Check Status \n"
							  +"  4: Attempt to open lock \n"
							  +"  5: Check dial is currently pointing at \n"
							  +"  6: Exit the program \n"
							  + "-------------------------");
			
			int userNum = kbd.nextInt();
			switch(userNum) {
			case 1: 
				System.out.println("Enter the new combination");
				System.out.println("First number: ");
				x = kbd.nextInt();
				System.out.println("Second number: ");
				y = kbd.nextInt();
				System.out.println("Third number: ");
				z = kbd.nextInt();
				
				lock.alter(x, y, z);
				System.out.println(lock.inquire());
				System.out.println("-------------------------");
				menu(kbd);  //route back to menu so user can choose another option
				
			case 2:
				System.out.println("Closing lock.");
				lock.close();
				System.out.println("Lock closed");
				System.out.println("-------------------------");
				menu(kbd);
			case 3:
				System.out.println(lock.inquire());
				System.out.println("-------------------------");
				menu(kbd);
			case 4:
				System.out.println("Enter 3 numbers to try and open the lock");
				System.out.println("First Number: ");
				x = kbd.nextInt();
				System.out.println("Second Number: ");
				y = kbd.nextInt();
				System.out.println("Third Number: " );
				z = kbd.nextInt();
				System.out.println("----");
				
				System.out.println("Attempting to open lock");
				lock.attempt(x, y, z);
				System.out.println("-------------------------");
				menu(kbd);
			case 5:
				System.out.println("Dial is currently pointing to " + lock.top());
				System.out.println("-------------------------");
				menu(kbd);
			case 6:
					System.out.println("Exiting.");
					System.out.println("-------------------------");
				}
			}
			
		
		
		/*
		 * 
		 * 
		 * 1: set lock combination  
2: close lock   
3: check status  
4: attempt to open lock
5: check what the dial is currently pointing at 
6: exit the program

		 */
}
