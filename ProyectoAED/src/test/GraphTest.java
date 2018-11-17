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
		
		Double edge1=12.0;
		Double edge2=9.0;
		Double edge3=13.0;
		Double edge4=14.0;
		Double edge5=7.0;
		Double edge6=10.0;
		Double edge7=8.0;
		
		
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
		String keyEdge = "0";
		graph.insertEdge(edge, keyEdge, key1, key2, 6.0);

		Double found=  graph.getEdges().get(0).getValue();
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
		String keyEdge = "0";
		graph.insertEdge(edge, keyEdge, key, key2, 6);

		graph.getEdges().remove(0);

		assertTrue(graph.getEdges().size() == 0);

	}
	
	@Test
	public void areAdjacentsTest() {
		
		setUpTwo();
		String key = "0";
		String key2 = "1";
		
		Double edge = 6.0;
		String keyEdge = "0";
		graph.insertEdge(edge, keyEdge, key, key2, 6);
		
		boolean result=graph.areAdjacents(key, key2);
		boolean result2=graph.areAdjacents(key2, key);
		
		assertTrue(result);
		assertTrue(result2);
		
		
		
	}
	
	public void dijkstra() {
		setUpTwo();
		
		
		
		
	}
	
	

}
