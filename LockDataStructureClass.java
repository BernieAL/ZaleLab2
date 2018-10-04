package lab2ADT;

public class LockDataStructureClass implements LockADT{
	
	
	private int xVal;
	private int yVal;
	private int zVal;
	private int x;
	private int y;
	private int z;
	private int top;
	private boolean closed = false;
	boolean comboMatch = false;
	boolean xFound = false;
	boolean yFound = false;
	boolean zFound = false;
	
	
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
public void turn2(int userLockNum, int comboNum) {
//public void turn2(int lockNum, char comboLetter)	
	
		if(comboNum == 1) {
			
			//searching first combo which means clockwise
			//NEED TO COMPARE USER ENTERED NUMB TO LOCK NO
			
			if(userLockNum == x) {
				for(int i = 0; i < userLockNum;i++) {
					System.out.print(i + " ");
						xVal = i;
						xFound = true;
						//System.out.println(" ");
						//System.out.println("\nX found, moving to find y");
						//break;
				}
				System.out.println(" ");
				System.out.println("x Found");
				System.out.println("------------------");
				
			} else if(userLockNum != x) {
				for(int i = 0 ; i < 25;i++) {
					System.out.print(i + " ");
					xVal = 25;
				}
				System.out.println(" ");
				System.out.println(" user number doesnt match first lock num");
				System.out.println("------------------");
					
				
			}
		
		System.out.println(" ");
//--------------------------------------------------------		
		//this needs to start where x left off and then pass 0 going counter clockwise to get to the y val
		
		} else if( comboNum == 2) {
			
			if(userLockNum == y) {
				for(int j = xVal; j >= 0; j--){
					System.out.print(j + " ");
						yVal = y;
						yFound = true;
						//System.out.print(" ");
						//System.out.println("\nY found, moving to find z");
						//break;
				}	
				System.out.println(" ");
				System.out.println(" Y Found");
				System.out.println("-------------");
				
			
			} else if(userLockNum != y) {
					//if j reaches 0 and y is still not found, pass 0 in reverse to 24,23,22,21 etc
				for(int i = 24; i >= 0;i--) {
					System.out.print(i + " ");
				}
				System.out.println(" ");
				System.out.println("user number doesnt match second lock num");
				System.out.println("------------------");
			}
			
			//System.out.println(" ");
//------------------------------------------------
		
		//pick up where y left off, go right to the number
		} else if(comboNum == 3) {
			
				if(userLockNum == z) {
					//System.out.println("test");
					for(int k = yVal; k >= 0;k--) {
						System.out.print(k + " ");
						zFound = true;
						//System.out.println(" ");
						//break;
					}
				} else {
					System.out.println("test");
					for(int i = 24; i >= 0;i--) {
						System.out.print(i + " ");
					}
					System.out.println("wrong 3rd value entered");
				}
		}
}
	
//--------------------------------------------------
public void turn(int lockNum, int comboNum) {
	
	
	if(comboNum == 1) {
		
		if(lockNum == x || lockNum == z) {
			for(int i = 0; i <= lockNum;i++) {
				System.out.print(i + " ");
				if(i == x){
					xVal = i;
					xFound = true;
					top = i;
					System.out.println("\nLock top: " + top);
					System.out.println("X Found");
					break;
				}
			}	
			System.out.println(" ");
		}
//-----------------------------------------		
	} else if (comboNum == 2) {
		
		int i = 0;
		if(lockNum == y) {
			//pick up where x stopped go past 0 once then to the number
			for( i = xVal ; i >= 0;i--) {
				System.out.print(i + " ");
				yVal = i;
				if(yVal == 0) {
					break;
				}
			}
			for(int j = 0; j < 24;j++) {
					System.out.print(j + " ");
					if(j == lockNum) {
						yFound = true;
						top = j;
						System.out.println("\nLock top: " + top);
						System.out.println("Y Found");
						yVal = j;
						break;
					}
				}
			System.out.println(" ");
			}
//------------------------------------------			
		} else if(comboNum == 3) {
			//pick up where y left off and go right to the num
			for( int i = yVal;i >= 0;i--) {
				System.out.print(i + " ");
				zVal = i;
				if(zVal == 0) {
					break;
				}
			}
			for(int j = 24; j >= 0;j--) {
				System.out.print(j + " ");
				if(j == lockNum) {
					zFound = true;
					top = j;
					System.out.println("\nLock top: " + top);
					System.out.println("Z Found");
					zVal = j;
					break;
				}
			}
			
			System.out.println(" ");
		}
//---------------------------------------------------------
}// END METHOD
		
	
	
	
	



//========================================


@Override
public void attempt(int x,int y, int z) {
	turn(x,1);
	turn(y,2);
	turn(z,3);
	
	
	if(xFound == true && (yFound == true) && (zFound == true)) {
		comboMatch = true;
		System.out.println("Attempt successful: lock opened");
	} else {
		System.out.println("Lock closed, wrong combination");
	}
	
}

@Override
public void alter(int xIn, int yIn,int zIn) {
	x = xIn;
	y = yIn;
	z = zIn;
	close();
	
}

@Override
public boolean close() {
	closed = true;
	return closed;
	
}



@Override
public String inquire() {
	if(closed == true) {
		return "Status: Locked";
	} else {
		return "Status: Not locked";
	}
	
}

@Override
public int top() {
	return top;
/*
 * Returns the number the dial is currently pointing too
 */
	
}

public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}

public int getZ() {
	return z;
}

public void setZ(int z) {
	this.z = z;
}


@Override
public String toString() {
	return "LockDataStructureClass [x=" + x + ", xVal=" + xVal + ", yVal=" + yVal + ", zVal=" + zVal + ", y=" + y
			+ ", z=" + z + ", top=" + top + ", closed=" + closed + ", comboMatch=" + comboMatch + ", xFound=" + xFound
			+ ", yFound=" + yFound + ", zFound=" + zFound + "]";
}






}
//=============================================================

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