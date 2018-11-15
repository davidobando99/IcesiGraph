package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collections.Graph;

class GraphTest {

	private Graph<String,Integer> graph;

	
	private void setUpOne() {
		graph= new Graph<String,Integer>();
	}
	private void setUpTwo() {

		setUpOne();
		String vertex1= "Vertice1"; 
		String key="0";
		graph.addVertex(key, vertex1);
	}
	
	
	
	@Test
	public void addVertexTest() {
		
		setUpOne();
		String vertex1= "Vertice1"; 
		String key="0";
		graph.addVertex(key, vertex1);
		
		String found= graph.searchVertex(key).getValue();
		assertTrue(vertex1.equals(found));
		
		
		
		
	}
	
	@Test
	public void insertEdge() {
		setUpOne();
		
		String vertex1="Vertice0";
		String key1="0";
		graph.addVertex(key1, vertex1);
		
		String vertex2="Vertice1";
		String key2="1";
		graph.addVertex(key2, vertex2);
		
		Integer edge=6;
		String keyEdge="0";
		graph.insertEdge(edge, keyEdge, key1, key2, 6);
		
		assertTrue(edge.equals(graph.searchEdge(keyEdge).getValue()));
		
		
	}
	
	public void removeVertexTest() {
		setUpTwo();
		
		graph.removeVertex("0");
		assertTrue(graph.searchVertex("0")==null);
		

		
		
		
	}

}
