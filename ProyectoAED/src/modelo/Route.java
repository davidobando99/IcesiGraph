package modelo;

import java.io.Serializable;

public class Route implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double distance;
	
	public Route(double distance) {
		this.distance=distance;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	

}
