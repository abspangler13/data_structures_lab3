package lab3;

public class LinkedList {
	Vertex root;
	Vertex nextLinkedList;
	Edge tail = null;
	int size = 0;
	
	/**
     *  Creates a linked list to hold all the Edges associated with a vertex. 
     *  This linked list is linked to its corresponding Vertex.  
     */ 
		
		public LinkedList(Vertex vert){
			this.root = vert;
		}
		
		public void setNextList(Vertex vert){
			this.nextLinkedList = vert;
		}
		
		public void addEdge (Edge newEdge){
			if (tail == null){
				root.setNextEdge(newEdge);
				tail = newEdge;
			}
			else{
				tail.setNextEdge(newEdge);
				tail = newEdge;
			}
			size++;

		}
		public Edge getNextEdgeList(Edge curEdge){
			return curEdge.getNextEdge();
		}
		
}
