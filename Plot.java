/*
 * Class: CMSC203 
 * Instructor: Prf. Gary Thai
 * Project 4
 * Description: This program is used in a property management company
 * Due: 11/06/21 @11:59PM
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Sepand Jahrominejad
*/




public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;
	
	
	public Plot() {
		x = 0;
		y = 0;
		width = 0;
		depth = 0;	
	}
	
	public Plot(Plot plot) {
		x= plot.x;
		y= plot.y;
		width= plot.width;
		depth= plot.depth;
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public boolean overlaps(Plot plot) {
		
		int L1x = x , L1y = y;
		int R1x = x+width , R1y = y+depth;
		int L2x = plot.x , L2y = plot.y;
		int R2x = plot.x+plot.width , R2y = plot.y+plot.depth;
		
		if (L2x>=R1x || L1x>=R2x)
			return false;
		else if(L2y>=R1y || L1y>=R2y)
			return false;
		else
			return true;
		
	}
	
	public boolean encompasses(Plot plot) {
		
		int L1x = x , L1y = y;
		int R1x = x+width , R1y = y+depth;
		int L2x = plot.x , L2y = plot.y;
		int R2x = plot.x+plot.width , R2y = plot.y+plot.depth;
		
		if(L2x>=L1x && R1x>=R2x && L2y>=L1y && R1y>=R2y)
			return true;
		else return false;
		
	}
	
	public void setX(int X) {
		x = X;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int Y) {
		y = Y;
	}
	
	public int getY() {
		return y;
	}
	
	public void setWidth(int W) {
		width = W;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setDepth(int D) {
		depth = D;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public String toString() {
		return "Upper left: (" + x + "," + y
				+ "); Width: " + width + " Depth: " + depth;
	}
}
