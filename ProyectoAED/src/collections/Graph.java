package collections;

import java.util.HashMap;

public class Graph<V,E> {
	
	private int[][] adjacentsMatrix;
	private HashMap<String, NodeGraph<V,E>> vertices;
	private HashMap<String, Edge<V,E>> edges;
	
	
	public Graph() {
		adjacentsMatrix = new int[vertices.size()][edges.size()];
		vertices= new HashMap<String, NodeGraph<V,E>>();
		edges=new HashMap<String, Edge<V,E>>();
		
	}


	public int[][] getAdjacentsMatrix() {
		return adjacentsMatrix;
	}


	public void setAdjacentsMatrix(int[][] adjacentsMatrix) {
		this.adjacentsMatrix = adjacentsMatrix;
	}
	
	public HashMap<String, NodeGraph<V, E>> getVertices() {
		return vertices;
	}


	public void setVertices(HashMap<String, NodeGraph<V, E>> vertices) {
		this.vertices = vertices;
	}


	public HashMap<String, Edge<V, E>> getEdges() {
		return edges;
	}


	public void setEdges(HashMap<String, Edge<V, E>> edges) {
		this.edges = edges;
	}


	public NodeGraph<V,E> searchVertex(String key) {
		return vertices.get(key);
	}
	
	public void addVertex(String key, V newVertex) {
		NodeGraph<V,E> vertex = new NodeGraph<V,E>(newVertex);
		vertices.put(key, vertex);
	}
	
	public void removeVertex(String key) {
		vertices.remove(key);
		
	}
	
	public void insertEdge( E edge,String key,V vertex1, V vertex2, double weight) {
		NodeGraph<V,E> origin = new NodeGraph<V,E>(vertex1);
		NodeGraph<V,E> end = new NodeGraph<V,E>(vertex2);
		Edge<V,E> edge1 = new Edge<V,E>(edge, weight, origin, end);
		edges.put(key, edge1);
		
	}
	
	public Edge<V,E> searchEdge(String key){
		return edges.get(key);
	}
	
	public Edge<V,E> removeEdge(String key){
		return edges.remove(key);
	}
	




}
