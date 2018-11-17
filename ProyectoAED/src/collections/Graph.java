package collections;

import java.util.*;

public class Graph<V, E> {

	public static final int SIZE = 10001; // maximo numero de vértices
	public static final double INFINITY = 1 << 30;
	public static final int AMOUNT = 5;
	private int[][] adjacentsMatrix;
	private double[][] weightMatrix;
	private HashMap<String, NodeGraph<V>> vertices;
	private ArrayList<Edge<V, E>> edges;

	public Graph() {
		vertices = new HashMap<String, NodeGraph<V>>();
		edges = new ArrayList<Edge<V, E>>();
		adjacentsMatrix = new int[AMOUNT][AMOUNT];
		weightMatrix = new double[AMOUNT][AMOUNT];

		inicializeMatrix();
	}

	public int[][] getAdjacentsMatrix() {
		return adjacentsMatrix;
	}

	public void setAdjacentsMatrix(int[][] adjacentsMatrix) {
		this.adjacentsMatrix = adjacentsMatrix;
	}

	public double[][] getWeightMatrix() {
		return weightMatrix;
	}

	public void setWeightMatrix(double[][] weightMatrix) {
		this.weightMatrix = weightMatrix;
	}

	public HashMap<String, NodeGraph<V>> getVertices() {
		return vertices;
	}

	public void setVertices(HashMap<String, NodeGraph<V>> vertices) {
		this.vertices = vertices;
	}

	public ArrayList<Edge<V, E>> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge<V, E>> edges) {
		this.edges = edges;
	}

	public NodeGraph<V> searchVertexx(V value) {
		boolean found = false;
		NodeGraph<V> searched = null;
		for (int i = 0; i < vertices.size() && !found; i++) {
			if (vertices.get(i).getValue() == value) {
				searched = vertices.get(i);
				found = true;

			}

		}
		return searched;
	}

	public NodeGraph<V> searchVertex(String key) {
		return vertices.get(key);
	}

	public void addVertex(String key, V newVertex) {
		if (vertices.isEmpty()) { // Si la tabla esta vacia que la posicion en la matriz sea (0,0)
			NodeGraph<V> vertex = new NodeGraph<V>(newVertex, 0);
			vertices.put(key, vertex);
		} else {
			NodeGraph<V> vertex = new NodeGraph<V>(newVertex, vertices.size()); // si esta con al menos
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

		edges.add(edge1);
		addToMatrix(origin.getPos(), end.getPos());

		int x = edge1.getOrigin().getPos();
		int y = edge1.getEnd().getPos();

//		System.out.println(x +" pos x");
//		System.out.println(y +" pos y");
//		System.out.println(edge1.getWeight() +" get Wsigth");
		weightMatrix[x][y] = edge1.getWeight();
		weightMatrix[y][x] = edge1.getWeight();
		origin.addAdjacent(end);
		end.addAdjacent(origin);

	}
//
//	public Edge<V, E> searchEdge(String key) {
//		return edges.get(key);
//	}

//	public Edge<V, E> removeEdge(String key) {
//
//		return edges.remove(key);

//	}

	public void inicializeMatrix() {
		for (int i = 0; i < adjacentsMatrix.length; i++) {
			for (int j = 0; j < adjacentsMatrix[i].length; j++) {
				adjacentsMatrix[i][j] = 0;
			}
		}
		fillWeightMatrix();

	}

	public boolean areAdjacents(String vertex1, String vertex2) {
		NodeGraph<V> origin = searchVertex(vertex1);
		NodeGraph<V> end = searchVertex(vertex2);
		if (adjacentsMatrix[origin.getPos()][end.getPos()] > 0) {
			return true;
		} else
			return false;
	}

	public Double adjacentsWeight(NodeGraph<V> origin, NodeGraph<V> end) {
		if (weightMatrix[origin.getPos()][end.getPos()] > 0) {
			return weightMatrix[origin.getPos()][end.getPos()];
		} else
			return 0.0;
	}

	public void addToMatrix(int i, int j) {
		adjacentsMatrix[i][j] += 1;
		adjacentsMatrix[j][i] += 1;
	}

	public void removeFromMatrix(int i, int j) {
		if (adjacentsMatrix[i][j] > 0)
			adjacentsMatrix[i][j] -= 1;
	}

	public double[] dijkstra(String key) {
		NodeGraph<V> node = searchVertex(key);
		Queue<NodeGraph<V>> queue = new LinkedList<NodeGraph<V>>();
		double[] distance = new double[vertices.size()];
		boolean[] visited = new boolean[vertices.size()];

		int i = 0;
		for (Map.Entry<String, NodeGraph<V>> entry : vertices.entrySet()) {
			if (entry.getKey() == key) {
				distance[i] = 0.0;
				visited[i] = false;
			} else {
				distance[i] = INFINITY;
				visited[i] = false;
			}
			i++;
		}

		queue.offer(node);

		while (!queue.isEmpty()) {
			NodeGraph<V> actual = queue.peek();
			queue.poll();
			int posActual = actual.getPos();
//    		 if(visited[posActual]) {
//    			 continue;
//    			 visited[posActual]=true;
//    		 }

			visited[posActual] = true;
			for (int j = 0; j < actual.getAdjList().size(); j++) {
				NodeGraph<V> adyacent = actual.getAdjList().get(j);
				double peso = adjacentsWeight(actual, adyacent);
				int posAdj = adyacent.getPos();
				// if( !visited[ posAdj] ){
				if (distance[posActual] + peso < distance[posAdj]) {
					distance[posAdj] = distance[posActual] + peso;
					queue.offer(adyacent);

					// }
				}

			}

		}
		return distance;

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

	public double[][] floydWarshall() {

		double[][] matrix = weightMatrix;

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
	
	public Edge<V,E> minEdge(){
		
		Edge<V,E> min=edges.get(0);
		
		for (int i = 0; i < edges.size(); i++) {
			
			if(edges.get(i).getWeight()<min.getWeight()) {
				min=edges.get(i);
			}
		}
		return min;
		
	}

	public int minWeight(Double key[],boolean[] visits) {

		double min = INFINITY;
		int val = -1;

		for (int i = 0; i < key.length; i++) {
			
			if (key[i] < min && !visits[i]) {

				
				min = key[i];
//				System.out.println(min);
				val = i;
			}
		}
		return val;

	}

	public int[] primMTS() {
		
		NodeGraph<V>node=minEdge().getOrigin();
		int key=node.getPos();

       Double dist[]= new Double[AMOUNT];
       int order[]= new int[AMOUNT];
       String parent[]= new String[AMOUNT];
		boolean[] visits = new boolean[AMOUNT];
		for (int i = 0; i < visits.length; i++) {
			dist[i]=INFINITY;
			visits[i] = false;
		}
		
		
		dist[key]=0.0;
		parent[key]= key+"";

		for (int i = 0; i < visits.length; i++) {
			
			int u= minWeight(dist, visits);
			visits[u]=true;
			order[i]=u;
			
			
			for (int j = 0; j < visits.length; j++) {
				
				if(weightMatrix[u][j]!=0 && !visits[j]&& weightMatrix[u][j]<dist[j]) {
					parent[j]=u+ " --> " +j;
//					System.out.println(parent[j]);
					dist[j]=weightMatrix[u][j];
				}
			}
//			System.out.println(u +" orden visitas");
//			System.out.println(visits[3]);
		}
		

		return order;

	} 

	public Double[] prim(Double []ordenar) {
		
		Arrays.sort(ordenar);
		return ordenar;

	}
	public static void main(String[] args) {
		Graph<String, Double> grafo= new Graph<String, Double>();
		String S ="S";
		String C="C";
		String N="N";
		String D="D";
		String A="A";
		
		Double edge1=12.0;
		Double edge2=9.0;
		Double edge3=13.0;
		Double edge4=14.0;
		Double edge5=7.0;
		Double edge6=10.0;
		Double edge7=8.0;
		
		grafo.addVertex("S", S);
		grafo.addVertex("C", C);
		grafo.addVertex("N", N);
		grafo.addVertex("D", D);
		grafo.addVertex("A", A);
		
		grafo.insertEdge(edge1, "0", "S", "C", edge1);
		grafo.insertEdge(edge2, "1", "S", "D", edge2);
		grafo.insertEdge(edge3, "2", "D", "C", edge3);
		grafo.insertEdge(edge4, "3", "D", "A", edge4);
		grafo.insertEdge(edge5, "4", "A", "C", edge5);
		grafo.insertEdge(edge6, "5", "C", "N", edge6);
		grafo.insertEdge(edge7, "6", "N", "A", edge7);
		
		int[] lista=grafo.primMTS();
//		Double[] finish=grafo.prim(lista);
		
		for (int i = 0; i < lista.length; i++) {
			
			System.out.println(i+ " VERTICE SIGUIENTE " + lista[i]);
			
		}
		
//		Graph<Edificio, Double> grafo = new Graph<Edificio, Double>();
//		Edificio A = new Edificio("A");
//		Edificio B = new Edificio("B");
//		Edificio C = new Edificio("C");
//		Edificio D = new Edificio("D");
//		Edificio E = new Edificio("E");
//		Edificio Z = new Edificio("Z");
//
//
//		
//		grafo.addVertex("A",A);
//		grafo.addVertex("B",B);
//		grafo.addVertex("C",C);
//		grafo.addVertex("D",D);
//		grafo.addVertex("E",E);
//		grafo.addVertex("Z",Z);
//		Double edge1 = 4.0;
//		Double edge2 = 2.0;
//		Double edge3 = 1.0;
//		Double edge4 = 5.0;
//		Double edge5 = 8.0;
//		Double edge6 = 10.0;
//		Double edge7 = 2.0;
//		Double edge8 = 6.0;
//		Double edge9 = 3.0;
//		String e1="ed1";
//		String e2="ed2";
//		String e3="ed3";
//		String e4="ed4";
//		String e5="ed5";
//		String e6="ed6";
//		String e7="ed7";
//		String e8="ed8";
//		String e9="ed9";
//		
//		grafo.insertEdge(edge1, e1, "A","B", edge1);
//		grafo.insertEdge(edge2, e2, "A","C", edge2);
//		grafo.insertEdge(edge3, e3, "C","B", edge3);
//		grafo.insertEdge(edge4, e4, "B","D", edge4);
//		grafo.insertEdge(edge5, e5, "C","D", edge5);
//		grafo.insertEdge(edge6, e6, "C","E", edge6);
//		grafo.insertEdge(edge7, e7, "E","D", edge7);
//		grafo.insertEdge(edge8, e8, "D","Z", edge8);
//		grafo.insertEdge(edge9, e9, "E","Z", edge9);
//		
//		System.out.println(grafo.getEdges().get(e1).getOrigin().getPos());
//		System.out.println(grafo.getEdges().get(e1).getEnd().getPos());
////		for(int i=0;i<grafo.getWeightMatrix().length;i++) {
////			for(int j=0;j<grafo.getWeightMatrix().length;j++) {
////				System.out.println(grafo.getWeightMatrix()[i][j]);
////			}
////		}
////		
//
////		for(int i=0;i<grafo.getVertices().get(2).getAdjList().size();i++){
////			
////			System.out.println(grafo.getVertices().get(2).getAdjList().get(i).getValue().getName());
////		}
//		for(int i=0;i<grafo.dijkstra("A").length;i++) {
//			System.out.println(grafo.dijkstra("A")[i]);
//		}
////		
//		
//		
//		
	}
//	

}
