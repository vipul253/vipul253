package samples.design.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements StorageItem {
	private String name;
	private List<StorageItem> content;

	public Folder(String name) {
		this.name = name;
		content = new ArrayList<StorageItem>();
	}

	public void add(StorageItem item) {
		content.add(item);
	}

	@Override
	public void display(int indent) {
		for (int i = 0; i < indent; i++) {
			System.out.print("--");
		}
		System.out.println(this.name);
		for (StorageItem item : this.content) {
			if (item instanceof Folder) {
				item.display(indent + 1);
			} else {
				item.display(indent);
			}
		}
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
