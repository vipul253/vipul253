package samples.java;

public class DetailsNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DetailsNotFound(String msg) {
		super(msg);
	}
}
