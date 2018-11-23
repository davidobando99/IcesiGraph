package application;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

	private String origin;

	private String end;
	/**
	 * True para inicio False para final
	 */
	private boolean path;

	MouseEvent event;
	EventHandler e;

	public void initialize() {
		
		
		path = true;
		origin = "";
		end = "";
		icesi = new Icesi();
//		verificateMap();
//		coliseoClick();
//		LClick();
//		CClick();
		canvas();
		// darL();
		
	}
	public void canvas() {
		Image image = new Image(getClass().getResourceAsStream("./imagenes/mapa.png"));
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(image, canvas.getLayoutX(), canvas.getLayoutY(), canvas.getWidth(), canvas.getHeight());
	}

	public void verificateMap() {

		map.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("kkkk");
				System.out.println(event.getX());
				System.out.println(event.getY());

			}

		});
	}

	public void origen(String building) {

		if (path) {
			origin = building;
			path = false;
		} else
			end = building;
		if (origin != "" && end != "") {

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

	private void coliseoClick() {
		// TODO Auto-generated method stub
		Coliseo1.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if (origin != "" && end != "") {
					refresh();
				}
				Coliseo1.setVisible(true);
				Coliseo1.setOpacity(1);

				getBuilding(Coliseo1, "Coliseo1");
				origen("Coliseo1");
			}

		});
	}

	private void LClick() {
		// TODO Auto-generated method stub

		L.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if (origin != "" && end != "") {
					refresh();
				}
				L.setVisible(true);
				L.setOpacity(1);

				lineCol1_L.setOpacity(1);
				origen("L");
				getBuilding(L, "L");

			}

		});
	}

	private void CClick() {
		// TODO Auto-generated method stub
		C.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub

				if (origin != "" && end != "") {
					refresh();
				}
				C.setVisible(true);
				C.setOpacity(1);

				lineCol1_L.setOpacity(1);
				origen("C");
				getBuilding(C, "C");

			}

		});
	}

	public void refresh() {

		lineCol1_L.setOpacity(0);
		C.setOpacity(0);
		Coliseo1.setOpacity(0);
		L.setOpacity(0);
		path = true;
		origin = "";
		end = "";
	}

}
