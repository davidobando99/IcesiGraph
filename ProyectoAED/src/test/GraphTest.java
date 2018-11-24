package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import collections.Graph;

class GraphTest {

	private Graph<String, Double> graph;

	private void setUpOne() {
		graph = new Graph<String, Double>();
	}

	private void setUpTwo() {

		setUpOne();
		String vertex1 = "Vertice1";
		String key = "0";
		graph.addVertex(key, vertex1);

		String vertex2 = "Vertice2";
		String key2 = "1";
		graph.addVertex(key2, vertex2);

		String vertex3 = "Vertice3";
		String key3 = "2";
		graph.addVertex(key3, vertex3);

		String vertex4 = "Vertice4";
		String key4 = "3";
		graph.addVertex(key4, vertex4);

		String vertex5 = "Vertice5";
		String key5 = "4";
		graph.addVertex(key5, vertex5);

		Double edge1 = 12.0;
		Double edge2 = 9.0;
		Double edge3 = 13.0;
		Double edge4 = 14.0;
		Double edge5 = 7.0;
		Double edge6 = 10.0;
		Double edge7 = 8.0;
		Double edge8 = 20.0;

		graph.insertEdge(edge1, "0", "1", edge1);
		graph.insertEdge(edge2, "0", "2", edge2);
		graph.insertEdge(edge3, "2", "1", edge3);
		graph.insertEdge(edge4, "2", "3", edge4);
		graph.insertEdge(edge5, "3", "4", edge7);
		graph.insertEdge(edge6, "1", "3", edge5);
		graph.insertEdge(edge7, "1", "4", edge6);
		graph.insertEdge(edge8, "0", "4", edge8);

	}

	@Test
	public void addVertexTest() {

		setUpOne();
		String vertex1 = "Vertice1";
		String key = "0";
		graph.addVertex(key, vertex1);

		String found = graph.searchVertex(key).getValue();
		assertTrue(vertex1.equals(found));

	}

	@Test
	public void insertEdge() {
		setUpOne();

		String vertex1 = "Vertice0";
		String key1 = "0";
		graph.addVertex(key1, vertex1);

		String vertex2 = "Vertice1";
		String key2 = "1";
		graph.addVertex(key2, vertex2);

		Double edge = 6.0;
		graph.insertEdge(edge, key1, key2, 6.0);

		Double found = graph.getEdges().get(0).getValue();
//		System.out.println(graph.floydWarshall()[0][1]);
		assertTrue(edge.equals(found));

	}

	@Test
	public void removeVertexTest() {
		setUpTwo();

		graph.removeVertex("0");
		assertTrue(graph.searchVertex("0") == null);

	}

	@Test
	public void removeEdgeTest() {

		setUpOne();
		String vertex1 = "Vertice1";
		String key = "0";
		graph.addVertex(key, vertex1);

		String vertex2 = "Vertice2";
		String key2 = "1";
		graph.addVertex(key2, vertex2);

		Double edge = 6.0;
		graph.insertEdge(edge, key, key2, 6);

		graph.getEdges().remove(0);

		assertTrue(graph.getEdges().size() == 0);

	}

	@Test
	public void areAdjacentsTest() {

		setUpTwo();
		String key = "0";
		String key2 = "1";

		Double edge = 6.0;
		graph.insertEdge(edge, key, key2, 6);

		boolean result = graph.areAdjacents(key, key2);
		boolean result2 = graph.areAdjacents(key2, key);

		assertTrue(result);
		assertTrue(result2);

	}

	@Test
	public void dijkstraTest() {
		setUpTwo();

		double[] dijkstra = graph.dijkstra("3");

		/**
		 * way1, way2, way3 son caminos desde el vertice 3 hasta el vertice 1 verificar
		 * si dijkstra encontró el camino mimnimo entre las todas las aristas
		 * 
		 */
		double way1 = graph.getEdges().get(6).getWeight() + graph.getEdges().get(5).getWeight();

		double way2 = graph.getEdges().get(3).getWeight() + graph.getEdges().get(2).getWeight();
		double way3 = graph.getEdges().get(3).getWeight() + graph.getEdges().get(1).getWeight()
				+ graph.getEdges().get(0).getWeight();
		double way4 = graph.getEdges().get(6).getWeight() + graph.getEdges().get(7).getWeight()
				+ graph.getEdges().get(0).getWeight();
		assertTrue(dijkstra[1] < way1);
		assertTrue(dijkstra[1] < way2);
		assertTrue(dijkstra[1] < way3);
		assertTrue(dijkstra[1] < way4);

	}

	@Test
	public void floydWarshallTest() {
		setUpTwo();

		/**
		 * Camino minimo desde el vertice 0 hasta el vertice 3
		 * 
		 */
		double[] array = graph.dijkstra("0");
		double minWay = array[3];
		double[][] matrix = graph.floydWarshall();
		assertEquals(minWay, matrix[0][3]);

		/**
		 * camino minimo desde el vertice 4 al vertice 0
		 */
		double minWay1 = array[4];
		assertEquals(minWay1, matrix[0][4]);

		/**
		 * Camino minimo desde el vertice 2 al vertice 4
		 */
		double[] array2 = graph.dijkstra("2");
		double minWay2 = array2[4];
		assertEquals(minWay2, matrix[2][4]);

	}

	@Test
	public void primMTSTest() {

		setUpTwo();

//		String posVertex = "1";
		int[] prim = graph.primMTS();

		assertTrue(prim[0] == 1);

	}

}
