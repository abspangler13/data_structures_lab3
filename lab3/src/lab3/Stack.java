package lab3;


public class Stack {
	int [] pathStack;
	int vertices;
	int   top = -1;
	//FileWriter outputStream;

    /**
     *  Creates a new stack to hold paths that have been found.
     *  Implemented as an array thats 1 larger than the number
     *  of vertices in the adjacency matrix. 
     */ 
	
	public Stack(int vertices) {
	    	this.vertices = vertices;
			pathStack = new int [vertices+1];
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
	
	public int pop() {
	    
        int vertToReturn;
        
        vertToReturn = pathStack[top];
        pathStack[top] = 0;
        top--;
        
        return vertToReturn;
    }
	
	public void push(int vertex) {
        
	 	top++;
        pathStack[top] = vertex;
        return;
    }
	
    /**
     *  Searches the pathStack for a specific vertex
     */ 
	public boolean contains(int vertex){
		for (int i = 0; i <= top; i++){
			if (pathStack[i] == vertex){
				return true;
			}
		}
		return false;
	}
	
    /**
     *  Prints out the pathStack
     */
	public void printStack(){
		for (int i = 0; i<=top; i++){
			System.out.print(pathStack[i]);
			//outputStream.write(pathStack[i]);
		}
	}
	
//	public void outputStack(FileWriter outputStream){
//		for (int i = 0; i<=top; i++){
//			//System.out.print(pathStack[i]);
//			this.outputStream = outputStream;
//			outputStream.write(pathStack[i]);
//		}
//	}
    /**
     *  Gets value on top without popping. Like a peek
     *  method. 
     */ 
	public int getValueOnTop(){
		return pathStack[top];
	}
	
	public int getValueOnBottom(){
		return pathStack[0];
	}
	
	public boolean isValidPath(){
		int x;
		boolean duplicates = false;
		if(top <= 0){
			return false;
		}
		for(int i=0; i<=top; i++){
			//boolean [] seent = new boolean[top+1];
			x = pathStack[i];
					for(int j=0; j<top; j++){
						if(i == j){
							continue;
						}
						if(x == pathStack[j]){
							duplicates = true;
						}
						
					}
		}
		if (duplicates == true && pathStack[0]!=pathStack[top]){
			return false;
		}
		
		else
			return true;
	}
	
	public int getTop(){
		return top;
	}

}
