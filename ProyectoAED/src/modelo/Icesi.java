package modelo;

import java.util.ArrayList;
import java.util.HashMap;

import collections.Graph;
import collections.NodeGraph;

public class Icesi {

	private Graph<Building, Route> graph;
	private String [] route;

	public Icesi() {
		graph = new Graph<Building, Route>();
		route=new String[22];
		addBuildings();
		addRoutes();
	}

	public Graph<Building, Route> getGraph() {
		return graph;
	}

	public void setGraph(Graph<Building, Route> graph) {
		this.graph = graph;
	}

	public ArrayList<Building> wayTo(String origin, String end) {

		graph.print(graph.dijkstraNodes(origin), graph.foundPos(end));
//revisar();
		return graph.getNodes();

	}
	public void revisar() {
		HashMap<String, NodeGraph<Building>>  lista=graph.getVertices();
		
		System.out.println(lista.get("B").getPos()+ "pos de B");
		System.out.println(lista.get("C").getPos()+ "pos de C");
		System.out.println(lista.get("A").getPos()+ "pos de A");
		System.out.println(lista.get("D").getPos()+ "pos de D");
		System.out.println(lista.get("E").getPos()+ "pos de E");
		System.out.println(lista.get("G").getPos()+ "pos de G");
	}
	public String[] primMTS() {
		int [] info= graph.primMTS();
		String [] way=new String[info.length];
		for (int i = 0; i < info.length; i++) {
			way[i]=route[info[i]];
		}
		return way;
	}
	
	public void cleanRoute() {
		graph.getNodes().clear();
	}

	public void addBuildings() {
		//0
		graph.addVertex("A", new Building("A"));
		route[0]="A";
		//1
		graph.addVertex("Auditorios", new Building("Auditorios"));
		route[1]="Auditorios";
		//2
		graph.addVertex("B", new Building("B"));
		route[2]="B";
		//3
		graph.addVertex("Biblioteca", new Building("Biblioteca"));
		route[3]="Biblioteca";
		//4
		graph.addVertex("I", new Building("I"));
		route[4]="I";
		//5
		graph.addVertex("C", new Building("C"));
		route[5]="C";
		//6
		graph.addVertex("CF", new Building("CF"));
		route[6]="CF";
		//7
		graph.addVertex("Wonka", new Building("Wonka"));
		route[7]="Wonka";
		//8
		graph.addVertex("Central", new Building("Central"));
		route[8]="Central";
		//9
		graph.addVertex("Coliseo1", new Building("Coliseo1"));
		route[9]="Coliseo1";
		//10
		graph.addVertex("Coliseo2", new Building("Coliseo2"));
		route[10]="Coliseo2";
		//11
		graph.addVertex("D", new Building("D"));
		route[11]="D";
		//12
		graph.addVertex("E", new Building("E"));
		route[12]="E";
		//13
		graph.addVertex("G", new Building("G"));
		route[13]="G";
		//14
		graph.addVertex("F", new Building("F"));
		route[14]="F";
		//15
		graph.addVertex("H", new Building("H"));
		route[15]="H";
		//16
		graph.addVertex("L", new Building("L"));
		route[16]="L";
		//17
		graph.addVertex("J", new Building("J"));
		route[17]="J";
		//18
		graph.addVertex("K", new Building("K"));
		route[18]="K";
		//19
		graph.addVertex("M", new Building("M"));
		route[19]="M";
		//20
		graph.addVertex("N", new Building("N"));
		route[20]="N";
		//21
		graph.addVertex("Saman", new Building("Saman"));
		route[21]="Saman";

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
		graph.print(graph.dijkstraNodes("M"), graph.foundPos("Central"));
		for (int i = 0; i < graph.getNodes().size(); i++) {
			System.out.println(graph.getNodes().get(i).getName());
		}
	}

	public void dij() {
		for (int i = 0; i < graph.dijkstra("M").length; i++) {
			System.out.println(graph.dijkstra("M")[i]);
		}
	}

	public static void main(String[] args) {
		Icesi n = new Icesi();
//		System.out.println(n.getGraph().getEdges().get(0).getOrigin().getValue().getName());
//		System.out.println(n.getGraph().getEdges().get(0).getEnd().getValue().getName());
//		System.out.println(n.getGraph().getVertices().get("M").getPos());
//	    n.dij();
	}

}
