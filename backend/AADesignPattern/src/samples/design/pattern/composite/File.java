package samples.design.pattern.composite;

public class File implements StorageItem {

	private String name;
	private double size;
	private String extension;

	public File(String name, double size, String extension) {
		this.name = name;
		this.size = size;
		this.extension = extension;
	}

	@Override
	public void display(int indent) {
		for (int i = 0; i < indent; i++) {
			System.out.print("--");
		}
		System.out.println("--" + this.name + "." + this.extension + " Size:" + this.size);
	}

	//manual getter setter
	public void setName(String name) {
		this.name = name;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getName() {
		return this.name;
	}

	public double getSize() {
		return this.size;
	}

	public String getExtension() {
		return this.extension;
	}
}
