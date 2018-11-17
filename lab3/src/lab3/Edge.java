package lab3;

public class Edge {
	Vertex vPointer;
	int edgeValue;
	Edge nextEdge = null;
	boolean visited = false;
	
	/**
     *  Creates edge class which contains a pointer to the vertex it connects to
     *  and a pointer to the next vertex. 
     */ 
	
	public Edge(Vertex vPointer, int val){
		this.vPointer = vPointer;
		this.edgeValue = val;
	}
	
	public void setNextEdge(Edge nextEdge){
		this.nextEdge = nextEdge;
	}
	
	public Edge getNextEdge(){
		return this.nextEdge;
	}
	
	public Vertex getNextVertex(){
		return this.vPointer;
	}
	public int getEdgeName(){
		return this.edgeValue;
	}

}
