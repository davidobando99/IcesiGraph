package collections;

import java.util.HashMap;

public class NodeGraph<V> {
	
	private V value;
	private int posX;
	private int posY;
	private HashMap<String, NodeGraph<V>> adjList;
	
	
	public NodeGraph(V value) {
		this.value =value;
		adjList= new HashMap<String, NodeGraph<V>>();
	}
	
	//Constructor para matriz de adyacencia
	public NodeGraph(V value, int posX, int posY) {
		this.value =value;
		this.posX=posX;
		this.posY=posY;
		adjList= new HashMap<String, NodeGraph<V>>();
	}
	
	public NodeGraph(V value, HashMap<String, NodeGraph<V>> adjList) {
		this.value =value;
		this.adjList= adjList;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public  HashMap<String, NodeGraph<V>> getAdjList() {
		return adjList;
	}

	public void setAdjList( HashMap<String, NodeGraph<V>> adjList) {
		this.adjList = adjList;
	}
	
	
	
	public void addAdjacent(String key,NodeGraph<V> adjacent) {
		adjList.put(key, adjacent);
	}
	
	public void removeAdjacent(String key) {
		adjList.remove(key);
	}
	
	public  NodeGraph<V> searchBoolean(String key){
		return adjList.get(key);
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	
	
	
	

}
