package samples.java;

public class RecordSample {
	public static void main(String[] args) {
		// Create a coordinate point
		Coordinate point = new Coordinate(10.5, 20.75);

		// Access the components using accessor methods (same name as components)
		System.out.println("X coordinate: " + point.x());
		System.out.println("Y coordinate: " + point.y());

		// The toString() method is automatically generated
		System.out.println("Point details: " + point.toString());

		// Records are immutable, so you cannot change the coordinates after creation
		// point.x(15.0); // This would cause a compilation error
	}
}
