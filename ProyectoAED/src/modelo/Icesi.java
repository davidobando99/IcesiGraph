package modelo;

import collections.Graph;

public class Icesi {
	
	private Graph<Building,Route> graph;
	public Icesi() {
		graph= new Graph<Building,Route>();
		addVertex();
	}
	public Graph<Building, Route> getGraph() {
		return graph;
	}
	public void setGraph(Graph<Building, Route> graph) {
		this.graph = graph;
	}
	
	public void addVertex() {
		graph.addVertex("L", new Building("L"));
		graph.addVertex("Coliseo1", new Building("Coliseo1"));
		graph.addVertex("C", new Building("C"));
	}
	
	
	
	
	

}
