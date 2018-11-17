package lab3;

public class Vertex {
	int vName;
	boolean visited = false;
	Edge nextEdge = null;
	Vertex nextVertex;
	LinkedList myList;
	
	/**
     *  Creates a vertex class to keeps track of each vertex and it's associated 
     *  edges.
     */ 
	
	public Vertex(int vName){
		this.vName = vName;
	}
	
	public void setNextEdge(Edge nextEdge){
		this.nextEdge = nextEdge;
	}
	
	public void setNextVertex (Vertex nextVertex){
		this.nextVertex = nextVertex;
	}
	
	public Vertex getNextVertex(){
		return this.nextVertex;
	}
	
	public Edge getNextEdge(){
		return this.nextEdge;
	}
	
	public int getVName(){
		return this.vName;
	}
	public void setLinkedList(LinkedList myList){
		this.myList = myList;
	}
	public void makeVisited(){
		this.visited = true;
	}
	public LinkedList getLinkedList(){
		return this.myList;
	}

}
