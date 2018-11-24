package modelo;

import collections.Graph;

public class Icesi {
	
	private Graph<Building,Route> graph;
	public Icesi() {
		graph= new Graph<Building,Route>();
		addBuildings();
		addRoutes();
	}
	public Graph<Building, Route> getGraph() {
		return graph;
	}
	public void setGraph(Graph<Building, Route> graph) {
		this.graph = graph;
	}
	
	public void addBuildings() {
		graph.addVertex("A", new Building("A"));
		graph.addVertex("Auditorios", new Building("Auditorios"));
		graph.addVertex("B", new Building("B"));
		graph.addVertex("Biblioteca", new Building("Biblioteca"));
		graph.addVertex("Bienestar", new Building("Bienestar"));
		graph.addVertex("C", new Building("C"));
		graph.addVertex("Central", new Building("Central"));
		graph.addVertex("Coliseo1", new Building("Coliseo1"));
		graph.addVertex("Coliseo2", new Building("Coliseo2"));
		graph.addVertex("D", new Building("D"));
		graph.addVertex("E", new Building("E"));
		graph.addVertex("G", new Building("G"));
		graph.addVertex("L", new Building("L"));
		graph.addVertex("M", new Building("M"));
		graph.addVertex("N", new Building("N"));
		graph.addVertex("Saman", new Building("Saman"));
		
		
		
		
		
		
		

	}
	
	public void addRoutes() {
		graph.insertEdge(new Route(53), "M", "Central", 53);
		graph.insertEdge(new Route(27), "Auditorios", "Central", 27);
		graph.insertEdge(new Route(8), "Auditorios", "M", 8);
		
		
		
		
		
	}
	
	public void dijkstra() {
		graph.print(graph.dijkstraNodes("M"),graph.foundPos("Central"));
		 for(int i=0;i<graph.getNodes().size();i++) {
			 System.out.println(graph.getNodes().get(i).getName());
		 }
	}
	
	public void dij() {
		for(int i=0;i<graph.dijkstra("M").length;i++) {
			System.out.println(graph.dijkstra("M")[i]);
		}
	}
	
	public static void main(String[] args) {
		Icesi n= new Icesi();
		System.out.println(n.getGraph().getEdges().get(0).getOrigin().getValue().getName());
		System.out.println(n.getGraph().getEdges().get(0).getEnd().getValue().getName());
		System.out.println(n.getGraph().getVertices().get("M").getPos());
	    n.dij();
	}
	
	
	
	
	

}
