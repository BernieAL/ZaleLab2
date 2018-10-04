package lab2ADT;

public interface LockADT {

	
public void alter(int x,int y, int z);

public void turn(int lockNum,int comboNum );

public boolean close();

public void attempt(int x, int y, int z);

public String inquire();

public int top();
	
	
	
}


/*
onstructor, copy constructor, setX, setY, setZ, 
alter (change the lock’s combination to the numbers passed) 
turn (use for loops to show the dial turning), 
close (locks the lock),
 attempt (tries to unlock the lock – calls turn( ), 
inquire (locked or unlocked),
 current (returns the number the dial is pointing to),
  toString

*/