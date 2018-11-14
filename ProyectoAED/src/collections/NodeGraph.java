package collections;

public class NodeGraph<V,E> {
	
	private V value;
	private int posX;
	private int posY;
	private ILinkedList<NodeGraph<V,E>> adjList;
	
	public NodeGraph(V value) {
		this.value =value;
		adjList= new DoublyLinkedList<NodeGraph<V,E>>();
	}
	
	//Constructor para matriz de adyacencia
	public NodeGraph(V value, int posX, int posY) {
		this.value =value;
		this.posX=posX;
		this.posY=posY;
		adjList= new DoublyLinkedList<NodeGraph<V,E>>();
	}
	
	public NodeGraph(V value, DoublyLinkedList<NodeGraph<V,E>> adjList) {
		this.value =value;
		this.adjList= adjList;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public ILinkedList<NodeGraph<V, E>> getAdjList() {
		return adjList;
	}

	public void setAdjList(ILinkedList<NodeGraph<V, E>> adjList) {
		this.adjList = adjList;
	}
	
	
	
	public void addAdjacent(NodeGraph<V,E> adjacent) {
		adjList.addItem(adjacent);
	}
	
	public void removeAdjacent(NodeGraph<V,E> adjacent) {
		adjList.deleteItem(adjacent);
	}
	
	public  boolean searchBoolean(NodeGraph<V,E> adjacent){
		return adjList.isThereElement(adjacent);
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
