package collections;

public class Edge<V,E> {
	
	private E value;
	private NodeGraph<V,E> origin;
	private NodeGraph<V,E> end;
	private Double weight;
	
	public Edge(E value, Double weight, NodeGraph<V,E> origin, NodeGraph<V,E> end){
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

	public NodeGraph<V, E> getOrigin() {
		return origin;
	}

	public void setOrigin(NodeGraph<V, E> origin) {
		this.origin = origin;
	}

	public NodeGraph<V, E> getEnd() {
		return end;
	}

	public void setEnd(NodeGraph<V, E> end) {
		this.end = end;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	
	

}
