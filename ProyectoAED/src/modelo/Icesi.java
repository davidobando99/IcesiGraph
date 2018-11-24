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
		graph.addVertex("I", new Building("I"));
		graph.addVertex("C", new Building("C"));
		graph.addVertex("CF", new Building("CF"));
		graph.addVertex("Wonka", new Building("Wonka"));
		graph.addVertex("Central", new Building("Central"));
		graph.addVertex("Coliseo1", new Building("Coliseo1"));
		graph.addVertex("Coliseo2", new Building("Coliseo2"));
		graph.addVertex("D", new Building("D"));
		graph.addVertex("E", new Building("E"));
		graph.addVertex("G", new Building("G"));
		graph.addVertex("F", new Building("F"));
		graph.addVertex("H", new Building("H"));
		graph.addVertex("L", new Building("L"));
		graph.addVertex("J", new Building("J"));
		graph.addVertex("K", new Building("K"));
		graph.addVertex("M", new Building("M"));
		graph.addVertex("N", new Building("N"));
		graph.addVertex("Saman", new Building("Saman"));	
		

	}
	
	public void addRoutes() {
		graph.insertEdge(new Route(26), "A", "Biblioteca", 26);
		graph.insertEdge(new Route(13.4), "A", "Saman", 13.4);
		graph.insertEdge(new Route(48.5), "B", "C", 48.5);
		graph.insertEdge(new Route(26), "B", "Biblioteca", 26);
		graph.insertEdge(new Route(54.2), "B", "Wonka", 54.2);
		graph.insertEdge(new Route(13.4), "B", "Saman", 13.4);	
		graph.insertEdge(new Route(8.2), "C", "D", 8.2);
		graph.insertEdge(new Route(19.6), "D", "E", 19.6);
		graph.insertEdge(new Route(22.8), "D", "I", 22.8);
		graph.insertEdge(new Route(143.7), "D", "Central", 143.7);
		graph.insertEdge(new Route(72.1), "F", "G", 72.1);
		graph.insertEdge(new Route(115.0), "F", "Coliseo1", 115.0);
		graph.insertEdge(new Route(66.5), "G", "Coliseo1", 66.5);
		graph.insertEdge(new Route(30.1), "H", "I", 30.1);
		graph.insertEdge(new Route(19.6), "H", "CF", 19.6);
		graph.insertEdge(new Route(151.4), "I", "Central", 151.4);
		graph.insertEdge(new Route(24.6), "J", "H", 24.6);
		graph.insertEdge(new Route(48), "J", "L", 48);
		graph.insertEdge(new Route(50.3), "J", "N", 50.3);
		graph.insertEdge(new Route(34.7), "J", "Coliseo2", 34.7);
		graph.insertEdge(new Route(3.9), "J", "CF", 3.9);
		graph.insertEdge(new Route(75.3), "K", "B", 75.3);
		graph.insertEdge(new Route(49.5), "K", "L", 49.5);
		graph.insertEdge(new Route(43.5), "K", "Coliseo1", 43.5);
		graph.insertEdge(new Route(21.9), "L", "H", 21.9);
		graph.insertEdge(new Route(48.5), "L", "J", 48.5);
		graph.insertEdge(new Route(55.4), "L", "Wonka", 55.4);
		graph.insertEdge(new Route(136.7), "L", "N", 136.7);
		graph.insertEdge(new Route(8), "M", "Auditorios", 8);
		graph.insertEdge(new Route(53), "M", "Central", 53);
		graph.insertEdge(new Route(36.5), "N", "Coliseo2", 36.5);
		graph.insertEdge(new Route(40.2), "Biblioteca", "Central", 40.2);
		graph.insertEdge(new Route(40.9), "Biblioteca", "Saman", 40.9);
		graph.insertEdge(new Route(160.4), "Auditorios", "G", 160.4);
		graph.insertEdge(new Route(27.8), "Auditorios", "Central", 27.8);
		graph.insertEdge(new Route(37.1), "Central", "A", 37.1);
		graph.insertEdge(new Route(52.7), "Coliseo1", "L", 52.7);
		graph.insertEdge(new Route(40), "CF", "I", 40);

		
		
		
		
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
//		System.out.println(n.getGraph().getEdges().get(0).getOrigin().getValue().getName());
//		System.out.println(n.getGraph().getEdges().get(0).getEnd().getValue().getName());
//		System.out.println(n.getGraph().getVertices().get("M").getPos());
//	    n.dij();
	}
	
	
	
	
	

}
