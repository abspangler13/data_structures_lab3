package lab3;

public class edgeStack {
	Edge [] edgeStack;
	int vertices;
	int   top = -1;

    /**
     *  Creates a new stack to hold paths that have been found.
     *  Implemented as an array thats 1 larger than the number
     *  of vertices in the adjacency matrix. 
     */ 
	
	public edgeStack(int vertices) {
	    	this.vertices = vertices;
			edgeStack = new Edge [vertices+1];
	    }
	
	public boolean isEmpty() {
	        
	        if (top == -1)
	            return true;
	        else
	            return false;
	     }
	
	public boolean isFull() {
        
        if (top == vertices)
            return true;
        else
            return false;
    }
	
	public Edge pop() {
	    
        Edge edgeToReturn;
        
        edgeToReturn = edgeStack[top];
        edgeStack[top] = null;
        top--;
        
        return edgeToReturn;
    }
	
	public void push(Edge edge) {
        
	 	top++;
        edgeStack[top] = edge;
        return;
    }
	
    /**
     *  Searches the pathStack for a specific vertex
     */ 

	
    /**
     *  Prints out the pathStack
     */
	
	
    /**
     *  Gets value on top without popping. Like a peek
     *  method. 
     */ 
	public Edge getEdgeOnTop(){
		return edgeStack[top];
	}
	
	public Edge getEdgeOnBottom(){
		return edgeStack[0];
	}
	

	
	public int getTop(){
		return top;
	}


}
