package collections;


import java.util.*;

public class Graph<V,E> {
	
	public static final int SIZE = 10001;  //maximo numero de vértices
	public static final int INF =1<<30;
	private int[][] adjacentsMatrix; 
	private HashMap<String, NodeGraph<V>> vertices;
	private HashMap<String, Edge<V,E>> edges;
	
	
	private List< List< NodeGraph<V> > > ady = new ArrayList< List< NodeGraph<V> > >();
	
	
	public Graph() {
		adjacentsMatrix = new int[vertices.size()][vertices.size()];
		vertices= new HashMap<String, NodeGraph<V>>();
		edges=new HashMap<String, Edge<V,E>>();
		inicializeMatrix();
	}


	public int[][] getAdjacentsMatrix() {
		return adjacentsMatrix;
	}


	public void setAdjacentsMatrix(int[][] adjacentsMatrix) {
		this.adjacentsMatrix = adjacentsMatrix;
	}
	
	public HashMap<String, NodeGraph<V>> getVertices() {
		return vertices;
	}


	public void setVertices(HashMap<String, NodeGraph<V>> vertices) {
		this.vertices = vertices;
	}


	public HashMap<String, Edge<V, E>> getEdges() {
		return edges;
	}


	public void setEdges(HashMap<String, Edge<V, E>> edges) {
		this.edges = edges;
	}


	public NodeGraph<V> searchVertex(String key) {
		return vertices.get(key);
	}
	
	public void addVertex(String key, V newVertex) {
		if(vertices.isEmpty()) { //Si la tabla esta vacia que la posicion en la matriz sea (0,0)
			NodeGraph<V> vertex = new NodeGraph<V>(newVertex,0,0);
			vertices.put(key, vertex);
		}
		else {
			NodeGraph<V> vertex = new NodeGraph<V>(newVertex,vertices.size(),vertices.size() ); //si esta con al menos 1 que sea el (size,size)
			vertices.put(key, vertex);
		}
		
	}
	
	public void removeVertex(String key) {
		vertices.remove(key);
		
	}
	
	public void insertEdge( E edge,String key,V vertex1, V vertex2, double weight) {
		NodeGraph<V> origin = new NodeGraph<V>(vertex1);
		NodeGraph<V> end = new NodeGraph<V>(vertex2);
		Edge<V,E> edge1 = new Edge<V,E>(edge, weight, origin, end);
		edges.put(key, edge1);
		addToMatrix(origin.getPosY(),end.getPosX());
		
		
		
	}
	
	public Edge<V,E> searchEdge(String key){
		return edges.get(key);
	}
	
	public Edge<V,E> removeEdge(String key){
		
		return edges.remove(key);
		
	}
	
	public void inicializeMatrix() {
		 for(int i=0; i< adjacentsMatrix.length; i++){
	            for(int j=0; j< adjacentsMatrix[i].length; j++){
	                adjacentsMatrix[i][j] = 0;
	            }
		 }
		
	}
	public boolean areAdjacents(String vertex1, String vertex2) {
		NodeGraph<V> origin = searchVertex(vertex1);
		NodeGraph<V> end = searchVertex(vertex2);
		if(adjacentsMatrix[origin.getPosY()][end.getPosX()]>0) {
			return true;
		}else return false;
	}
	
	public void addToMatrix(int i, int j){
		adjacentsMatrix[i][j] += 1;
    }
    
    public void removeFromMatrix(int i, int j){
        if(adjacentsMatrix[i][j]>0)
        	adjacentsMatrix[i][j] -= 1;
    }
    
    public void dijkstra(V node) {
    	 PriorityQueue<NodeGraph<V>> queue=new  PriorityQueue<NodeGraph<V>> ();
    	 int[] distancia = new int[SIZE];
    	 int[] anterior = new int[SIZE];  
    	 boolean[] visitado = new boolean[ SIZE ]; 
    	          
    	 for( int i = 0 ; i <= vertices.size() ; i++ ){
    		 
    	    
               distancia[i] = INF;  
               anterior[i] = -1;
               visitado[i] = false;
              
          
    	 }
    	 
    	 queue.add(new NodeGraph<V>(node));
    	 
    	 
    	 
    	 
    }
	




}
