package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collections.Graph;

class GraphTest {

	private Graph<String, Integer> graph;

	private void setUpOne() {
		graph = new Graph<String, Integer>();
	}

	private void setUpTwo() {

		setUpOne();
		String vertex1 = "Vertice1";
		String key = "0";
		graph.addVertex(key, vertex1);

		String vertex2 = "Vertice2";
		String key2 = "1";
		graph.addVertex(key2, vertex2);
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

		Integer edge = 6;
		String keyEdge = "0";
		graph.insertEdge(edge, keyEdge, key1, key2, 6);

//		System.out.println(graph.floydWarshall()[0][1]);
		assertTrue(edge.equals(graph.searchEdge(keyEdge).getValue()));

	}

	public void removeVertexTest() {
		setUpTwo();

		graph.removeVertex("0");
		assertTrue(graph.searchVertex("0") == null);

	}

	public void removeEdgeTest() {

		setUpOne();
		String vertex1 = "Vertice1";
		String key = "0";
		graph.addVertex(key, vertex1);

		String vertex2 = "Vertice2";
		String key2 = "1";
		graph.addVertex(key2, vertex2);

		Integer edge = 6;
		String keyEdge = "0";
		graph.insertEdge(edge, keyEdge, key, key2, 6);

		graph.removeEdge(keyEdge);

		assertTrue(graph.searchEdge(keyEdge) == null);

	}
	
	public void areAdjacentsTest() {
		
		setUpTwo();
		String key = "0";
		String key2 = "1";
		
		Integer edge = 6;
		String keyEdge = "0";
		graph.insertEdge(edge, keyEdge, key, key2, 6);
		
		boolean result=graph.areAdjacents(key, key2);
		boolean result2=graph.areAdjacents(key2, key);
		
		assertTrue(result);
		assertTrue(result2);
		
		
		
	}

}
