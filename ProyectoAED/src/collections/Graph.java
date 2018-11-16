package collections;

import java.util.*;

public class Graph<V, E> {
	

	public static final int SIZE = 10001; // maximo numero de vértices
	public static final double INFINITY = 1 << 30;
	public static final int AMOUNT=40;
	private int[][] adjacentsMatrix;
	private Double[][] weightMatrix;
	private HashMap<String, NodeGraph<V>> vertices;
	private HashMap<String,Edge<V, E>> edges;

	public Graph() {
		vertices = new HashMap<String, NodeGraph<V>>();
		edges = new HashMap<String,Edge<V, E>>();
		adjacentsMatrix = new int[AMOUNT][AMOUNT];
		weightMatrix=new Double[AMOUNT][AMOUNT];
		
		inicializeMatrix();
	}

	public int[][] getAdjacentsMatrix() {
		return adjacentsMatrix;
	}

	public void setAdjacentsMatrix(int[][] adjacentsMatrix) {
		this.adjacentsMatrix = adjacentsMatrix;
	}

	public HashMap<String, NodeGraph<V>> getVertices() {
		return vertices;
	}

	public void setVertices(HashMap<String, NodeGraph<V>> vertices) {
		this.vertices = vertices;
	}

	public HashMap<String,Edge<V, E>> getEdges() {
		return edges;
	}

	public void setEdges(HashMap<String,Edge<V, E>> edges) {
		this.edges = edges;
	}

	public NodeGraph<V> searchVertex(String key) {
		return vertices.get(key);
	}

	public void addVertex(String key, V newVertex) {
		if (vertices.isEmpty()) { // Si la tabla esta vacia que la posicion en la matriz sea (0,0)
			NodeGraph<V> vertex = new NodeGraph<V>(newVertex, 0, 0);
			vertices.put(key, vertex);
		} else {
			NodeGraph<V> vertex = new NodeGraph<V>(newVertex, vertices.size(), vertices.size()); // si esta con al menos
																									// 1 que sea el
																									// (size,size)
			vertices.put(key, vertex);
		}

	}

	public void removeVertex(String key) {
		vertices.remove(key);

	}

	public void insertEdge(E edge, String key, String vertex1, String vertex2, double weight) {
		NodeGraph<V> origin = searchVertex(vertex1);
		NodeGraph<V> end = searchVertex(vertex2);
		Edge<V, E> edge1 = new Edge<V, E>(edge, weight, origin, end);

		edges.put(key, edge1);
		addToMatrix(origin.getPosY(), end.getPosX());
		
		int x = edge1.getOrigin().getPosX();
		int y = edge1.getEnd().getPosX();

		weightMatrix[x][y] = edge1.getWeight();
		weightMatrix[y][x] = edge1.getWeight();

	}

	public Edge<V, E> searchEdge(String key) {
		return edges.get(key);
	}

	public Edge<V, E> removeEdge(String key) {

		return edges.remove(key);

	}

	public void inicializeMatrix() {
		for (int i = 0; i < adjacentsMatrix.length; i++) {
			for (int j = 0; j < adjacentsMatrix[i].length; j++) {
				adjacentsMatrix[i][j] = 0;
			}
		}

	}

	public boolean areAdjacents(String vertex1, String vertex2) {
		NodeGraph<V> origin = searchVertex(vertex1);
		NodeGraph<V> end = searchVertex(vertex2);
		if (adjacentsMatrix[origin.getPosY()][end.getPosX()] > 0) {
			return true;
		} else
			return false;
	}

	public void addToMatrix(int i, int j) {
		adjacentsMatrix[i][j] += 1;
	}

	public void removeFromMatrix(int i, int j) {
		if (adjacentsMatrix[i][j] > 0)
			adjacentsMatrix[i][j] -= 1;
	}

	public void dijkstra(V node) {
		PriorityQueue<NodeGraph<V>> queue = new PriorityQueue<NodeGraph<V>>();
		Double[] distancia = new Double[SIZE];
		int[] anterior = new int[SIZE];
		boolean[] visitado = new boolean[SIZE];

		for (int i = 0; i <= vertices.size(); i++) {

			distancia[i] = INFINITY;
			anterior[i] = -1;
			visitado[i] = false;

		}

		queue.add(new NodeGraph<V>(node));

	}

	public void fillWeightMatrix() {

		for (int i = 0; i < adjacentsMatrix.length; i++) {
			for (int j = 0; j < adjacentsMatrix.length; j++) {

				if (i == j)
					weightMatrix[i][j] = 0.0;

				else if (adjacentsMatrix[i][j] == 0) {
					weightMatrix[i][j] = INFINITY;

				}
			}
		}

	}

	public Double[][] floydWarshall() {

		Double[][] matrix = weightMatrix;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				for (int k = 0; k < matrix.length; k++) {

					if (matrix[i][k] + matrix[j][i] < matrix[j][k]) {
						matrix[j][k] = matrix[i][k] + matrix[j][i];
					}
				}
			}
		}
		return matrix;

	}

}
