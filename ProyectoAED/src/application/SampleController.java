package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import modelo.Building;
import modelo.Icesi;

public class SampleController {

	private Icesi icesi;
	@FXML
	private ImageView map;

	@FXML
	private ListView<String> listBuildings;
	@FXML
	private Button butBuildings;
	@FXML
	private Button butRute;

	@FXML
	private TextArea txtRute;

	@FXML
	private Button butTour;

	@FXML
	private ListView<String> ListTour;

	@FXML
	private Rectangle Coliseo1;

	@FXML
	private Circle LCir;

	@FXML
	private Rectangle L;

	@FXML
	private Rectangle C;

	@FXML
	private Line lineCol1_L;

	@FXML
	private Canvas canvas;
	@FXML
	private Canvas canvas2;

	@FXML
	private Rectangle D;

	@FXML
	private Rectangle E;

	@FXML
	private Rectangle Saman;

	@FXML
	private Rectangle Biblioteca;

	@FXML
	private Rectangle B;

	@FXML
	private Rectangle Central;

	@FXML
	private Rectangle Auditorios;

	@FXML
	private Rectangle A;

	@FXML
	private Rectangle N;

	@FXML
	private Rectangle Coliseo2;

	@FXML
	private Rectangle I;

	@FXML
	private Rectangle G;

	@FXML
	private Rectangle CF;

	@FXML
	private Rectangle J;

	@FXML
	private Rectangle H;

	@FXML
	private Rectangle K;

	@FXML
	private Rectangle Wonka;

	@FXML
	private Rectangle M;

	@FXML
	private Rectangle F;

	private GraphicsContext gc;
	
	private GraphicsContext gc2;
	private String origin;

	private String end;

	private String originPoint;

	private String endPoint;
	
	private String originName;
	private String endName;

	private boolean isMouseIn;
	
	/**
	 * True para inicio False para final
	 */
	private boolean path;

	private ArrayList<Rectangle> rectangles;

	public void initialize() throws Exception {

		isMouseIn = true;
		path = true;
		origin = "";
		end = "";
		icesi = new Icesi();
		verificateMap();
		rectangles = new ArrayList<Rectangle>();
		addRectangles();
		gc = canvas.getGraphicsContext2D();
		gc2 = canvas2.getGraphicsContext2D();
		for (int i = 0; i < rectangles.size(); i++) {
			
			showText(rectangles.get(i), rectangles.get(i).getId());
		
			clickBuildings(rectangles.get(i), rectangles.get(i).getId());
			
			
		}

		
	}

	@FXML
	public void butTour(ActionEvent event) {

		tourUniversity();
	}

	@FXML
	void butBuildings(ActionEvent event) {
		fillListBuildings();

	}

	public void addRectangles() {
		rectangles.add(Coliseo1);
		rectangles.add(Coliseo2);
		rectangles.add(Saman);
		rectangles.add(Biblioteca);
		rectangles.add(Auditorios);
		rectangles.add(Central);
		rectangles.add(Wonka);
		rectangles.add(CF);
		rectangles.add(A);
		rectangles.add(B);
		rectangles.add(C);
		rectangles.add(D);
		rectangles.add(E);
		rectangles.add(F);
		rectangles.add(G);
		rectangles.add(H);
		rectangles.add(I);
		rectangles.add(J);
		rectangles.add(K);
		rectangles.add(L);
		rectangles.add(M);
		rectangles.add(N);

	}

	public void way(String origin, String end) {

		String rute = "";
		String [] info1= icesi.dij(origin);
		String[] distances= icesi.distancesDijkstra(origin,end);
		ArrayList<Building> lista = icesi.wayTo(origin, end);
		Building anterior = null;
		for (int i = 0; i < lista.size(); i++) {
			if (i > 0) {
				anterior = lista.get(i - 1);
				//drawRectangle(lista.get(i).getName());
				drawRoute(getRectangle(anterior.getName()).getLayoutX(), getRectangle(anterior.getName()).getLayoutY(),
						getRectangle(lista.get(i).getName()).getLayoutX(),
						getRectangle(lista.get(i).getName()).getLayoutY());
//				gc.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.ITALIC, 5.0));
//				gc.setStroke(Color.WHITE);
				
			}
			gc2.strokeText(distances[i], getRectangle(lista.get(i).getName()).getLayoutX()+30,
					getRectangle(lista.get(i).getName()).getLayoutY()+30);

			rute += lista.get(i).getName() +" , "+ info1[i]+ " \n";

		}

		txtRute.setText(rute);
	}

	public void canvas() {
		// Image image = new
		// Image(getClass().getResourceAsStream("./imagenes/mapa.png"));

		gc = canvas.getGraphicsContext2D();
		gc.fillRect(canvas.getLayoutX(), canvas.getLayoutY(), 60, 60);
		gc.fillRect(canvas.getLayoutX() + 60, canvas.getLayoutY() + 60, 60, 60);

		// gc.appendSVGPath("M "+L.getLayoutX()+" "+L.getLayoutY()+" L
		// "+A.getLayoutX()+" "+A.getLayoutY());

	}

//	public void drawLines(double X1, double Y1, double X2, double Y2) {
//		 gc.setStroke(Color.BLUE);
//		 gc.setLineWidth(5.0);
//		 gc.beginPath();
//		 gc.appendSVGPath("M "+X1+" "+Y1+" L "+X2+" "+Y2);
//		 gc.closePath();
//		 gc.stroke();
//	}
	public void drawLines(String origin, String end) {
		gc.setStroke(Color.WHITE);
		gc.setLineWidth(4.0);
		gc.beginPath();
		gc.appendSVGPath("M " + origin + " L " + end);
		gc.closePath();
		gc.stroke();
		
	}

	public void verificateMap() {

		canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
//				System.out.println(event.getX());
//				System.out.println(event.getY());

			}

		});
	}

	public void origen(String building, double X, double Y) {
		if (path) {
			origin = building;
			originPoint = X + " " + Y;
			path = false;
		} else {
			end = building;
			endPoint = X + " " + Y;
			;
		}

		if (origin != "" && end != "") {
//			if (originPoint != "" && endPoint != "") {
//				if (isLine) {
//					drawLines(originPoint, endPoint);
//				}
//
//			}
			way(origin, end);
			System.out.println("INICIO " + origin + " FIN " + end);
		}

	}
	
	public void route(String building) {
		if (isMouseIn) {
			originName = building;
			isMouseIn = false;
		} else {
			originName = building;
		}

	

	}

	public Building getBuilding(Rectangle build, String name) {
		Building building = null;
		if (build.getOpacity() == 1) {
			building = icesi.getGraph().searchVertex(name).getValue();
//			System.out.println(building.getName());
		}
		return building;
	}

	public void drawRectangle(String name) {
		for (int i = 0; i < rectangles.size(); i++) {
			if (name.equals(rectangles.get(i).getId())) {
				rectangles.get(i).setOpacity(1);
			}
		}

	}

	public Rectangle getRectangle(String name) {
		Rectangle rec = null;
		for (int i = 0; i < rectangles.size(); i++) {
			if (name.equals(rectangles.get(i).getId())) {
				rec = rectangles.get(i);
			}
		}
		return rec;

	}

	public void drawRoute(double X1, double Y1, double X2, double Y2) {
		String origin = X1 + " " + Y1;
		String end = X2 + " " + Y2;
		drawLines(origin, end);
		

	}

	
	private void showText(Rectangle rec,String name) {
		 
    rec.setOnMouseMoved(new EventHandler<MouseEvent>() {
			
          
			@Override
			public void handle(MouseEvent event) {
				
			
				if ((originName != "")) {
					refreshText();
				}
				
				gc2.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.ITALIC, 15.0));
				gc2.setStroke(Color.WHITE);
				gc2.strokeText(name, rec.getLayoutX(), rec.getLayoutY());
				route(name);
				}
			
			
		});
		 
			 
		 
	}
	private void clickBuildings(Rectangle rec, String name) {
		//rec.setOnMouseMoved(arg0);
		rec.setOnMouseClicked(new EventHandler<MouseEvent>() {
			

			@Override
			public void handle(MouseEvent event) {
				if (origin != "" && end != "") {
					refresh();
				}
				rec.setVisible(true);
				rec.setOpacity(1);

				getBuilding(rec, name);
				origen(name, rec.getLayoutX(), rec.getLayoutY());
			}

		});
	}

	private void coliseo1Click() {
		Coliseo1.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (origin != "" && end != "") {
					refresh();
				}
				Coliseo1.setVisible(true);
				Coliseo1.setOpacity(1);

				getBuilding(Coliseo1, "Coliseo1");
				origen("Coliseo1", Coliseo1.getLayoutX(), Coliseo1.getLayoutY());
			}

		});
	}

	public void refresh() {
		txtRute.setText(" ");
		icesi.cleanRoute();
		lineCol1_L.setOpacity(0);
		for (int i = 0; i < rectangles.size(); i++) {
			rectangles.get(i).setOpacity(0);
		}

		path = true;
		origin = "";
		end = "";
		originPoint = "";
		endPoint = "";
		
		
		gc.clearRect(canvas.getLayoutX(), canvas.getLayoutY(), canvas.getWidth(), canvas.getWidth());
	}
	
	public void refreshText() {
        originName="";
		
		isMouseIn=true;
		gc2.clearRect(canvas2.getLayoutX(), canvas2.getLayoutY(), canvas2.getWidth(), canvas2.getWidth());
	}

	public void tourUniversity() {

		ObservableList<String> items = FXCollections.observableArrayList();

		String []lista=icesi.kruskal();
		String[] info = icesi.primMTS();
		for (int i = 0; i < lista.length; i++) {
			items.add(info[i]+"         "+lista[i]);
		}

		ListTour.setItems(items);
	}

	public void fillListBuildings() {
		ObservableList<String> items = FXCollections.observableArrayList();
		String[] info = icesi.showAllBuildingBFS();
		for (int i = 0; i < info.length; i++) {
			items.add(info[i]);
		}

		listBuildings.setItems(items);

	}

}
