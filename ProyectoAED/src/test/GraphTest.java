package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collections.Graph;

class GraphTest {

	private Graph<String,Integer> graph;

	
	public void setUpOne() {
		graph= new Graph<String,Integer>();
	}
	
	@Test
	private void addVertexTest() {
		
		setUpOne();
		String vertex1= "Vertice1"; 
		String key="0";
		graph.addVertex(key, vertex1);
		
		String found= graph.searchVertex(key).getValue();
		assertTrue(vertex1.equals(found));
		
		
		
		
	}

}
