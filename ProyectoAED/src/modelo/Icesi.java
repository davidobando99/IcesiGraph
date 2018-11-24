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
		graph.addVertex("Coliseo2", new Building("Coliseo2"));
		graph.addVertex("C", new Building("C"));
		graph.addVertex("G", new Building("G"));
		graph.addVertex("D", new Building("D"));
		graph.addVertex("E", new Building("E"));
		graph.addVertex("N", new Building("N"));
		graph.addVertex("A", new Building("A"));
		graph.addVertex("B", new Building("B"));
		graph.addVertex("Bienestar", new Building("Bienestar"));
		graph.addVertex("Saman", new Building("Saman"));
		graph.addVertex("Central", new Building("Central"));
		graph.addVertex("Biblioteca", new Building("Biblioteca"));
		graph.addVertex("Auditorios", new Building("Auditorios"));
	}
	
	
	
	
	

}
