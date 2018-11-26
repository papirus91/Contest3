import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class Contest_ready {
	static int rows; // initialise rows;
	static int columns; // initialise columns;
	static int[][] maze; // initialise the maze;
	public static boolean[][] visited; // initialise the visited array;
	static ArrayList<Point> neighbours = new ArrayList<Point>(); // create an array list of neighbours;
	
public static void main(String[] args) {
	int m; // method number;
	Scanner sc = new Scanner(System.in);
	System.out.print("row count: ");
	rows = sc.nextInt();
	System.out.print("column count: ");
	columns = sc.nextInt();
	maze = new int[rows][columns]; // reinitialise the maze;
	visited = new boolean[rows][columns]; // reinitialise the visited array;
	
	for (int i=0; i<rows; i++) // fill the array
	  for (int j=0; j<columns; j++)
	    maze[i][j] = sc.nextInt();
	maze[rows-1][columns-1] = 3; // the last element is equal to 3

	System.out.print("method number (1-3):");
	    m = sc.nextInt();
		sc.close();
		
	switch(m) {
	case 1:
		for (int i=0;i<rows;i++)
		     for (int j=0;j<columns;j++)
		         visited[i][j] = false; // nothing is visited
		           
	    visited[0][0] = true; // the first one is visited
	    Point starting_point = new Point();
	    starting_point.x = 0; // starting point is 0,0
	    starting_point.y = 0;
	    dfs(maze, starting_point); // call the dfs function
	break;
	}
}

public static boolean dfs(int[][] maze, Point p){
    neighbours = getNeighbours(maze,p); // find neighbours
    if (maze[p.x][p.y] == maze[rows-1][columns-1]){ // the last element
        System.out.println("(" + p.x + "," + p.y + ")");
        return true;
    }
    if (neighbours.isEmpty()){ // no neighbours
        return false;
    }
    for (int i=0;i<neighbours.size();i++){
        System.out.print("(" + p.x + "," + p.y + ")" + " ");
        visited[neighbours.get(i).x][neighbours.get(i).y] = true; //current point is visited
        dfs(maze, neighbours.get(i)); // call the function dfs from the neighbour
    }
    return false;
}

public static ArrayList<Point> getNeighbours(int[][] maze, Point p){
    ArrayList<Point> neighbours = new ArrayList<Point>();
    Point left = new Point();
    Point right = new Point();
    Point down = new Point();
    Point up = new Point();
    down.x = p.x - 1;
    down.y = p.y;
    if (valid(maze,down)) neighbours.add(down);
    up.x = p.x + 1;
    up.y = p.y;
    if (valid(maze,up)) neighbours.add(up);
    left.x = p.x;
    left.y = p.y - 1;
    if (valid(maze,left)) neighbours.add(left);
    right.x = p.x;
    right.y = p.y + 1;
    if (valid(maze,right)) neighbours.add(right);
    return neighbours;
}

public static boolean valid(int[][] maze, Point p){
    if (inMaze(maze,p) && canGo(maze,p) && visited[p.x][p.y] == false) return true;
    else return false;
}

public static boolean inMaze(int[][] maze, Point p){
	if (p.x < rows && p.x > -1 && p.y < columns && p.y > -1){
        return true;
    } else return false;
}

public static boolean canGo(int[][] maze, Point p){
    if (maze[p.x][p.y] != 1) return true;
    else return false;  
}

}
