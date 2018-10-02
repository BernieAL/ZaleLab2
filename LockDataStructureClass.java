package lab2ADT;

public class LockDataStructureClass {
	
	private int x;
	private int y;
	private int z;
	private boolean closed;
	
	
	public LockDataStructureClass() {
		x = 0;
		y = 0;
		z = 0;
	}

//overloaded	
	public LockDataStructureClass(int xIn, int yIn,int zIn) {
		x = xIn;
		y = yIn;
		z = zIn;
	}

//copy constructor to perform deep copy of object
	
public LockDataStructureClass(LockDataStructureClass lockIn) {
		
	}
//========================================================


public void turn() {
	
	boolean xFound = false;
	boolean yFound = false;
	boolean zFound = false;
	
	boolean comboMatch = false;
	int passZeroCounter = 0; //this is to make sure we pass 0 atleast 2 
	
/*while combomatch is false, iterate using for loops until x,y,z are found
 * 	if these are found, change comboMatch to true which means the lock combo has been entered */
	while(comboMatch == false) {
		int xVal = 0; //these 2 vars will be passed into the next for loop
		int yVal = 0;
		for(int i = 0; i < 24;i++) {
			System.out.print(i + " ");
			if(i == x) {
				xVal = i;
				xFound = true;
				System.out.println("\nX found, now we go in reverse to find Y");
				break;
			} 
		}
		
		
		//reverse direction to find y
		int counter = 0;
		if (passZeroCounter == 1) {
			for(int p = 0; p < 24;p++) {
				System.out.println( p + " ");
				if(p == y);
				break;
			}
		}
		for(int j = xVal + 24; j > 0; j--){
			System.out.print(j + " ");
//			
			if( j == y) {
			yFound = true;
			
			System.out.println("\nY found, now we go forward to find Z");
			break;
			} 
		}
		
		
		//forward to find z
		for(int k = 0; k < 24;k++) {
			System.out.print(k + " ");
			if(k == z) {
				zFound = true;
				//write method to check if comboMatch is unlocked
				/* it will check to see if x,y,and z are true*/
				System.out.println("\nZ found.");
				break;
			} 
			
			if(xFound == true && (yFound == true) && (zFound == true)) {
				comboMatch = true;
			}
		}
		
			if(comboMatch == true) {
				System.out.println("Lock opened");
			} else {
				System.out.println("Incorrect combo entered");
			}

	}
		
	}
//=============================================================
}
//===============================================================


/*
 * 
 * zale wants the locks to be able to spin past max number and back to 0.
 * how would I have it keep spinnng and not stop at x if x is found?
 */

/*
constructor, copy constructor, setX, setY, setZ, 
alter (change the lock’s combination to the numbers passed) //call setters from this method
turn (use for loops to show the dial turning), 
close (locks the lock),
 attempt (tries to unlock the lock – calls turn( ), 
inquire (locked or unlocked),
 current (returns the number the dial is pointing to),
  toString

*/