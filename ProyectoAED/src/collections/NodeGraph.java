package collections;

public class NodeGraph<V,E> {
	
	private V value;
	private ILinkedList<NodeGraph<V,E>> adjList;
	
	public NodeGraph(V value) {
		this.value =value;
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
	
	
	

}
