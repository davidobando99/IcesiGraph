package collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import collections.Graph;

public class GradoSeparacion {
	
	public GradoSeparacion() {
		
	}
	
	
	public void agregarVertice(Graph<Integer, Integer> grafo,String k, int v) {
		grafo.addVertex(k, v);
	}
	
	public void agregarArista(Graph<Integer, Integer> grafo,int i,String v1, String v2) {
		grafo.insertEdge(i, "", v1, v2, 1);
	}
	
	public int[][] gradoMinimo(Graph<Integer, Integer> grafo,int num){
		int[][] matriz= new int[num][num];
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz.length;j++) {
				if(grafo.floydWarshall()[i][j]==Graph.INFINITY) {
					matriz[i][j]=-1;
				}
				else {
					matriz[i][j]=(int) grafo.floydWarshall()[i][j];
				}
				
			}
		}
		return matriz;
	}
	
	public int[] gradoMenor(Graph<Integer, Integer> grafo,int num, int grado) {
		int[] arreglo= new int[num];
		
		for(int i=0;i<gradoMinimo(grafo,num).length;i++) {
			int adj=0;
			for(int j=0;j<gradoMinimo(grafo,num).length;j++) {
				if(gradoMinimo(grafo,num)[i][j]>0&&grafo.getWeightMatrix()[i][j]<=grado) {
					adj++;
				}
		}
			arreglo[i]=adj;
		}
		return arreglo;
				
				
	}
	
	public int[] dijkstraa(Graph<Integer, Integer> grafo,int num,String v) {
		int[] arreglo = new int[num];
		for(int i=0;i<arreglo.length;i++) {
			arreglo[i]=(int) grafo.dijkstra(v)[i];
			
		}
		return arreglo;
	}
	public  void pedirDatos() throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String casos = br.readLine();
		int numeroCasos = Integer.parseInt(casos);
		for(int a=0;a<numeroCasos;a++) {
		Graph<Integer, Integer> grafo= new Graph<Integer,Integer>();
		String personas = br.readLine();
		int numPersonas = Integer.parseInt(personas);
		String grado = br.readLine();
		int k = Integer.parseInt(grado);
		
		String[] matriz= new String[numPersonas];
		for(int j=0;j<numPersonas;j++) {
			String line = br.readLine();
			matriz[j]= line;
			agregarVertice(grafo,j+"",j);
			
			
			
		}
		
		for(int j=0;j<matriz.length;j++) {
			String[] info =matriz[j].split(" ");
			for(int z=0;z<info.length; z++) {
				if(info[z].equals("1")) {
					agregarArista(grafo,z,j+"",z+"");
				}
				
			}
		}
		 
		for(int i=0;i<gradoMinimo(grafo,numPersonas).length;i++) {
			String linea="";
			for(int j=0;j<gradoMinimo(grafo,numPersonas).length;j++) {
				linea += gradoMinimo(grafo,numPersonas)[i][j]+" ";
			}
			System.out.println(linea);
		}
		
		String line="";
		for(int i=0;i<gradoMenor(grafo,numPersonas,k).length;i++) {
			line+=gradoMenor(grafo,numPersonas,k)[i]+" ";
		}
		System.out.println(line);
		
//		String line="";
//        for(int i=0;i<dijkstraa(grafo,numPersonas,"2").length;i++) {
//        	line+=dijkstraa(grafo,numPersonas,"2")[i]+" ";
//		}
//        System.out.println(line);
//        String linee="";
//        for(int i=0;i<grafo.kruskal().length;i++) {
//        	linee+=grafo.kruskal()[i]+" ";
//		}
//        System.out.println(linee);
		
		
		
		
		
		
		}
		
		
		
		
		br.close();	
	
		
	}
	
   
	

	public static void main(String[] args) throws IOException {
		GradoSeparacion grafito = new GradoSeparacion();
		grafito.pedirDatos();
		
//		for(int i=0;i<grafito.getGrafo().getWeightMatrix().length;i++) {
//			for(int j=0;j<grafito.getGrafo().getWeightMatrix().length;j++) {
//			System.out.println(i+" "+j+" "+grafito.getGrafo().getWeightMatrix()[i][j]);
//			}
//		}
		
//		for(int i=0;i<grafito.getGrafo().getEdges().size();i++) {
//			System.out.println("origin "+grafito.getGrafo().getEdges().get(i).getOrigin().getValue());
//			System.out.println("end "+grafito.getGrafo().getEdges().get(i).getEnd().getValue());
//		}
		

	}

}
