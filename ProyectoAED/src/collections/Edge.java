package collections;

public class Edge<V,E> {
	
	private E value;
	private NodeGraph<V> origin;
	private NodeGraph<V> end;
	private Double weight;
	
	public Edge(E value, Double weight, NodeGraph<V> origin, NodeGraph<V> end){
		this.value=value;
		this.weight=weight;
		this.origin=origin;
		this.end=end;
		
		
		
	}
	
	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public NodeGraph<V> getOrigin() {
		return origin;
	}

	public void setOrigin(NodeGraph<V> origin) {
		this.origin = origin;
	}

	public NodeGraph<V> getEnd() {
		return end;
	}

	public void setEnd(NodeGraph<V> end) {
		this.end = end;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	
	

}
