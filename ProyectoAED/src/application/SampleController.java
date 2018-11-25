package application;

import java.util.ArrayList;

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
import modelo.Building;
import modelo.Icesi;

public class SampleController {

	private Icesi icesi;
	@FXML
	private ImageView map;

	@FXML
	private Button butRute;

	@FXML
	private TextArea txtRute;
	
	@FXML
    private ListView<?> ListTour;

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

	private GraphicsContext gc;
	private String origin;

	private String end;

	private String originPoint;

	private String endPoint;

	private boolean isLine;
	/**
	 * True para inicio False para final
	 */
	private boolean path;

	public void initialize() {

		isLine = true;
		path = true;
		origin = "";
		end = "";
		icesi = new Icesi();
		verificateMap();
		coliseo1Click();
		LClick();
		CClick();
		AClick();
		BClick();
		EClick();
		NClick();
		samanClick();
		coliseo2Click();
		auditoriosClick();
		bibliotecaClick();
		bienestarClick();
		centralClick();
		GClick();
		DClick();
		canvas();
		// darL();

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
			if (originPoint != "" && endPoint != "") {
				if (isLine) {
					drawLines(originPoint, endPoint);
				}

			}
			way(origin, end);
			System.out.println("INICIO " + origin + " FIN " + end);
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

	private void coliseo2Click() {
		Coliseo2.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (origin != "" && end != "") {
					refresh();
				}
				Coliseo2.setVisible(true);
				Coliseo2.setOpacity(1);

				getBuilding(Coliseo2, "Coliseo2");
				origen("Coliseo2", Coliseo2.getLayoutX(), Coliseo2.getLayoutY());
			}

		});
	}

	private void centralClick() {
		Central.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (origin != "" && end != "") {
					refresh();
				}
				Central.setVisible(true);
				Central.setOpacity(1);

				getBuilding(Central, "Central");
				origen("Central", Central.getLayoutX(), Central.getLayoutY());
			}

		});
	}

	private void samanClick() {
		Saman.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (origin != "" && end != "") {
					refresh();
				}
				Saman.setVisible(true);
				Saman.setOpacity(1);

				getBuilding(Saman, "Saman");
				origen("Saman", Saman.getLayoutX(), Saman.getLayoutY());
			}

		});
	}

	private void auditoriosClick() {
		Auditorios.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (origin != "" && end != "") {
					refresh();
				}
				Auditorios.setVisible(true);
				Auditorios.setOpacity(1);

				getBuilding(Auditorios, "Auditorios");
				origen("Auditorios", Auditorios.getLayoutX(), Auditorios.getLayoutY());
			}

		});
	}

	private void LClick() {

		L.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (origin != "" && end != "") {
					refresh();
				}
				L.setVisible(true);
				L.setOpacity(1);

				lineCol1_L.setOpacity(1);
				origen("L", L.getLayoutX(), L.getLayoutY());
				getBuilding(L, "L");

			}

		});
	}

	private void CClick() {
		C.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				if (origin != "" && end != "") {
					refresh();
				}
				C.setVisible(true);
				C.setOpacity(1);

				lineCol1_L.setOpacity(1);
				origen("C", C.getLayoutX(), C.getLayoutY());
				getBuilding(C, "C");

			}

		});
	}

	private void AClick() {

		A.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (origin != "" && end != "") {
					refresh();
				}
				A.setVisible(true);
				A.setOpacity(1);

				origen("A", A.getLayoutX(), A.getLayoutY());
				getBuilding(A, "A");

			}

		});
	}

	private void BClick() {

		B.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (origin != "" && end != "") {
					refresh();
				}
				B.setVisible(true);
				B.setOpacity(1);

				origen("B", B.getLayoutX(), B.getLayoutY());
				getBuilding(B, "B");

			}

		});
	}

	private void DClick() {

		D.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (origin != "" && end != "") {
					refresh();
				}
				D.setVisible(true);
				D.setOpacity(1);

				origen("D", D.getLayoutX(), D.getLayoutY());
				getBuilding(D, "D");

			}

		});
	}

	private void EClick() {

		E.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (origin != "" && end != "") {
					refresh();
				}
				E.setVisible(true);
				E.setOpacity(1);

				origen("E", E.getLayoutX(), E.getLayoutY());
				getBuilding(E, "E");

			}

		});
	}

	private void GClick() {

		G.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (origin != "" && end != "") {
					refresh();
				}
				G.setVisible(true);
				G.setOpacity(1);

				origen("G", G.getLayoutX(), G.getLayoutY());
				getBuilding(G, "G");

			}

		});
	}

	private void NClick() {

		N.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (origin != "" && end != "") {
					refresh();
				}
				N.setVisible(true);
				N.setOpacity(1);

				origen("N", N.getLayoutX(), N.getLayoutY());
				getBuilding(N, "N");

			}

		});
	}

	private void bienestarClick() {

		I.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (origin != "" && end != "") {
					refresh();
				}
				I.setVisible(true);
				I.setOpacity(1);

				origen("Bienestar", I.getLayoutX(), I.getLayoutY());
				getBuilding(I, "Bienestar");

			}

		});
	}

	private void bibliotecaClick() {

		Biblioteca.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (origin != "" && end != "") {
					refresh();
				}
				Biblioteca.setVisible(true);
				Biblioteca.setOpacity(1);

				origen("Biblioteca", Biblioteca.getLayoutX(), Biblioteca.getLayoutY());
				getBuilding(Biblioteca, "Biblioteca");

			}

		});
	}

	public void refresh() {
		txtRute.setText(" ");
		icesi.cleanRoute();
		lineCol1_L.setOpacity(0);
		C.setOpacity(0);
		A.setOpacity(0);
		B.setOpacity(0);
		D.setOpacity(0);
		E.setOpacity(0);
		N.setOpacity(0);
		G.setOpacity(0);
		Coliseo1.setOpacity(0);
		Coliseo2.setOpacity(0);
		I.setOpacity(0);
		Auditorios.setOpacity(0);
		Central.setOpacity(0);
		Saman.setOpacity(0);
		Biblioteca.setOpacity(0);
		L.setOpacity(0);
		path = true;
		origin = "";
		end = "";
		originPoint = "";
		endPoint = "";
		gc.clearRect(canvas.getLayoutX(), canvas.getLayoutY(), canvas.getWidth(), canvas.getWidth());
	}

	public void way(String origin, String end) {
		
		String rute="";
		ArrayList<Building> lista = icesi.wayTo(origin, end);
		for (int i = 0; i < lista.size(); i++) {

			rute+=lista.get(i).getName() + " \n";
			System.out.println(lista.get(i).getName());

		}

		txtRute.setText(rute);
	}

}
