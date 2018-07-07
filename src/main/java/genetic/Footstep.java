package genetic;

public class Footstep {
	private int axisX = 0;
	private int axisY = 0;
	private double position = 0;
	private String cardinal;

	public void setPosition(int axisX, int axisY) {
		this.axisX = axisX;
		this.axisY = axisY;

		// this.position = Math.sqrt(Math.pow(axisX, 2) * Math.pow(axisY, 2));

		if (axisX == 0 && axisY == 1)
			cardinal = PontosCardinais.EAST;
		else if (axisX == -1 && axisY == 1)
			cardinal = PontosCardinais.SOUTHEAST;
		else if (axisX == 0 && axisY == -1)
			cardinal = PontosCardinais.SOUTH;
		else if (axisX == -1 && axisY == -1)
			cardinal = PontosCardinais.SOUTHWEST;
		else if (axisX == -1 && axisY == 0)
			cardinal = PontosCardinais.WEST;
		else if (axisX == 1 && axisY == -1)
			cardinal = PontosCardinais.NORTHWEST;
		else if (axisX == 1 && axisY == 0)
			cardinal = PontosCardinais.NORTH;
		else if (axisX == 1 && axisY == 1)
			cardinal = PontosCardinais.NORTHEAST;
		else
			cardinal = PontosCardinais.WRONG;
	}

	public double getPosition() {
		return position;
	}

	public int getAxisX() {
		return axisX;
	}

	public int getAxisY() {
		return axisY;
	}

	public String getCardinal() {
		return cardinal;
	}

	public String toString() {
		return "X: " + axisX + " Y: " + axisY + " Cardinal: " + cardinal;
	}
}
