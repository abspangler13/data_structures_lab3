package lab3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *  This project imports an adjacency matrix as a linked
 *  structure and finds all possible paths through the 
 *  graph by DFS. 
 *  @author     Abby Spangler
 */
public class Main {
	/**
     *  Main entry point for the program.
     *  @param args[]   Holds two command line arguments:  the input filename
     *                  and the output filename.
     */

	static int dim; //global variable representing dimension of current adjacency matrix
	static int pathTracker[][]; //global array to keep track of paths that exist
	static Stack pathStack; //global stack use in DFS
	static FileWriter outputStream = null;
	
	/**
     *  Main method reads in the adjacency matrices from an input file one at a time and
     *  processes them into a linked structure. Then it performs a depth first search (DFS) 
     *  on each linked structure while outputting each path found. 
     */

	public static void main(String[] args) throws IOException{
		FileReader inputStream = null;
        

        try {
            inputStream = new FileReader(args[0]); // input file
            outputStream = new FileWriter(args[1]); // output file
           
            int c; //File reader reads in one character at a time and stores it in the variable c. 
            
            /**
    	     *  Iterate through file and create linked structure for current matrix.
    	     */
            
            while ((c = inputStream.read()) != -1) { // while the file isn't empty,read and process one character
            	dim = c-48; //Characters are read as ascii integers so they must be converted
            	System.out.println("Reading in matrix of dimensions " + dim);
            	outputStream.write("Reading in matrix of dimensions " + dim);
            	pathTracker = new int [dim][dim]; //to keep track of found paths
            	int colCount = -1; 
        		int rowCount = -1;
        		LinkedList curList = null;
        		Vertex [] vertices = new Vertex [dim];
        		for (int i = 0; i < dim; i++){
        			vertices[i] = new Vertex(i);
        		}
        		while (rowCount <dim){ 
            		c = inputStream.read();
        			if(c-48 == 0){
    					colCount++;
    				}
        			
        			else if (c-48 == 1){
        				Edge curEdge = new Edge (vertices[colCount],colCount);
        				curList.addEdge(curEdge);
        				colCount++;
        			}
        			
    				else if (c == 10){ //10 in ascii represents new line
    					colCount = 0;
    					rowCount++;
    					if(rowCount<dim){
    						curList = new LinkedList(vertices[rowCount]);
    						vertices[rowCount].setLinkedList(curList); //doubly link vertex to it's list
    					}
    					
    				}

    				else if (c == 32){ //32 represents space
    					continue;
    				}
        			
    				else if (c == 13){  //represents carriage return
    					continue;
    				}
    				
        			//else error saying there's something wrong with the input. kill loop
        			
        		}

        		/**
        	     *  After linked structure is made, iterate through each vertex and pass it as the starting 
        	     *  vertex to the recursive DFS method in order to find all paths starting from that vertex.
        	     */

        		for (int i = 0; i < dim; i++){
        			pathStack = new Stack(dim+1);//for performing DFS
        			pathStack.push(vertices[i].getVName());//push the starting vertex onto the stack
        			System.out.println("\nrunning DFS starting at vertex " + i );
        			outputStream.write("\nrunning DFS starting at vertex " + i);
        			Main.DFS(vertices[i]);
        		}

        		for (int i=0; i < dim; i++){
        			for (int j=0; j<dim; j++){
        				if(pathTracker[i][j]==0){
        					System.out.println("No path found between: " + i + "," + j);
        					outputStream.write("No path found between: " + i + "," + j);
        				}
        			}
        		}
        		System.out.println();
        		outputStream.write("\n");
        		
        	}
        }
        
        /**
	     *  Close stream and write to output file
	     */
            finally {
            if (inputStream != null) inputStream.close();
            if (outputStream != null) outputStream.close();
        }
		

	}
	
	/**
     *  Methods to do DFS traversal. Recursive DFS call anytime we reach an unexplored vertex. 
     */
	
    static void DFS(Vertex v) //v indicates starting vertex
    {  
        
        Edge e = v.getNextEdge();//get the first edge associated with the vertex
        
        while(e!=null){ //while we're not at the end of the linked structure
        	if(!pathStack.contains(e.getEdgeName())){
        		pathStack.push(e.getEdgeName());
        		v = e.getNextVertex();
        		DFS(v);//recursive call to DFS
        	}
        	if(pathStack.contains(e.getEdgeName()) && pathStack.getValueOnBottom()==e.getEdgeName()){
        		pathStack.push(e.getEdgeName()); 
        		System.out.print("Found path ");
        		pathStack.printStack();
        		System.out.print("\n");
        		int x = pathStack.getValueOnBottom();
        		int y = pathStack.getValueOnTop();
        		pathTracker[x][y] = 1; //records that a path exists between these two vertices
        		pathStack.pop();
        		
        	}
        	e = e.getNextEdge(); //get next edge
        }

        if(pathStack.getTop() > 0){
        	System.out.print("Found path ");
        	pathStack.printStack();
        	System.out.print("\n");
    		int x = pathStack.getValueOnBottom();
    		int y = pathStack.getValueOnTop();
    		pathTracker[x][y] = 1;  //records that a path exists between these two vertices
        }
    	pathStack.pop();

    } 
    
}
