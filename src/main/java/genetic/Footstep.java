package genetic;

public class Footstep {
	
	private int axisX = 0;
	private int axisY = 0;
	private double position = 0;
	private String cardinal;
	
	private static final String WEST = "\u2190";
	private static final String NORTH = "\u2191";
	private static final String EAST = "\u2192";
	private static final String SOUL = "\u2193";
	private static final String NORTHWEST = "\u2196";
	private static final String NORTHEAST = "\u2197";
	private static final String SOUTHEAST = "\u2198";
	private static final String SOUTHWEST = "\u2199";
	

	public void setPosition(int axisX, int axisY) {
		
		this.axisX = axisX;
		this.axisY = axisY;
		
		this.position = Math.sqrt(Math.pow(axisX, 2) * Math.pow(axisY, 2));
		
		// condiçoes
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

}
