import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class Contest_ready {
	static int r; // initialise r;
	static int c; // initialise c;
	static int[][] l; // initialise the l;
	public static boolean[][] visited; // initialise the visited array;
	static ArrayList<Point> neighbours = new ArrayList<Point>(); // create an array list of neighbours;
	
public static void main(String[] args) {
	int m; // method number;
	Scanner sc = new Scanner(System.in);
	System.out.print("row count: ");
	r = sc.nextInt();
	System.out.print("column count: ");
	c = sc.nextInt();
	l = new int[r][c]; // reinitialise the l;
	visited = new boolean[r][c]; // reinitialise the visited array;
	
	for (int i=0; i<r; i++) // fill the array
	  for (int j=0; j<c; j++)
	    l[i][j] = sc.nextInt();
	l[r-1][c-1] = 3; // the last element is equal to 3

	System.out.print("method number (1-3):");
	    m = sc.nextInt();
		sc.close();
		
	switch(m) {
	case 1:
		for (int i=0;i<r;i++)
		     for (int j=0;j<c;j++)
		         visited[i][j] = false; // nothing is visited
		           
	    visited[0][0] = true; // the first one is visited
	    Point starting_point = new Point();
	    starting_point.x = 0; // starting point is 0,0
	    starting_point.y = 0;
	    dfs(l, starting_point); // call the dfs function
	break;
	}
}

public static boolean dfs(int[][] l, Point p){
    neighbours = getNeighbours(l,p); // find neighbours
    if (l[p.x][p.y] == l[r-1][c-1]){ // the last element
        System.out.println("(" + p.x + "," + p.y + ")");
        return true;
    }
    if (neighbours.isEmpty()){ // no neighbours
        return false;
    }
    for (int i=0;i<neighbours.size();i++){
        System.out.print("(" + p.x + "," + p.y + ")" + " ");
        visited[neighbours.get(i).x][neighbours.get(i).y] = true; //current point is visited
        dfs(l, neighbours.get(i)); // call the function dfs from the neighbour
    }
    return false;
}

public static ArrayList<Point> getNeighbours(int[][] l, Point p){
    ArrayList<Point> neighbours = new ArrayList<Point>();
    Point left = new Point();
    Point right = new Point();
    Point down = new Point();
    Point up = new Point();
    down.x = p.x - 1;
    down.y = p.y;
    if (valid(l,down)) neighbours.add(down);
    up.x = p.x + 1;
    up.y = p.y;
    if (valid(l,up)) neighbours.add(up);
    left.x = p.x;
    left.y = p.y - 1;
    if (valid(l,left)) neighbours.add(left);
    right.x = p.x;
    right.y = p.y + 1;
    if (valid(l,right)) neighbours.add(right);
    return neighbours;
}

public static boolean valid(int[][] l, Point p){
    if (inl(l,p) && canGo(l,p) && visited[p.x][p.y] == false) return true;
    else return false;
}

public static boolean inl(int[][] l, Point p){
	if (p.x < r && p.x > -1 && p.y < c && p.y > -1){
        return true;
    } else return false;
}

public static boolean canGo(int[][] l, Point p){
    if (l[p.x][p.y] != 1) return true;
    else return false;  
}

}
