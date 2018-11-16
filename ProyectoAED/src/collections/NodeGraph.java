package collections;

import java.util.ArrayList;
import java.util.HashMap;

public class NodeGraph<V> {
	
	private V value;
	private int posX;
	private ArrayList<NodeGraph<V>> adjList;
	
	
	public NodeGraph(V value) {
		this.value =value;
		adjList= new ArrayList<NodeGraph<V>>();
	}
	
	//Constructor para matriz de adyacencia
	public NodeGraph(V value, int posX) {
		this.value =value;
		this.posX=posX;
		adjList= new ArrayList<NodeGraph<V>>();
	}
	
	public NodeGraph(V value, ArrayList<NodeGraph<V>> adjList) {
		this.value =value;
		this.adjList= adjList;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public  ArrayList<NodeGraph<V>> getAdjList() {
		return adjList;
	}

	public void setAdjList( ArrayList<NodeGraph<V>> adjList) {
		this.adjList = adjList;
	}
	
	
	
	public void addAdjacent(NodeGraph<V> adjacent) {
		adjList.add(adjacent);
	}
	
	public void removeAdjacent(NodeGraph<V> adjacent) {
		adjList.remove(adjacent);
	}
	
//	public  NodeGraph<V> searchBoolean(String key){
//		return adjList.get(key);
//	}

	public int getPos() {
		return posX;
	}

	public void setPos(int posX) {
		this.posX = posX;
	}

	
	
	
	
	

}
