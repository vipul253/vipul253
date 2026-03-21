package samples.design.pattern.composite;

public class Test {

	public static void main(String[] args) {

		Folder folder1 = new Folder("Movies");
		folder1.add(new File("abc", 23.2, "avi"));
		folder1.add(new File("def", 12.3, "mp4"));

		Folder folder2 = new Folder("English Movies");
		folder1.add(folder2);
		// folder1 has a reference of folder2 so adding files in folder2 afterwards
		// still reflects in folder1
		folder2.add(new File("ghi", 11.3, "wmv"));
		folder2.add(new File("jkl", 22.3, "mp4"));

		folder1.add(new File("mno", 25.3, "mpeg"));
		folder1.add(new File("pqr", 21.3, "mpeg"));

		Folder folder3 = new Folder("Hindi Movies");
		folder1.add(folder3);
		folder3.add(new File("stu", 19.3, "wmv"));
		folder3.add(new File("vwx", 27.3, "mp4"));
		Folder folder4 = new Folder("old Movies");
		folder4.add(new File("yz", 1.12, "avi"));
		folder2.add(folder4);

		folder1.display(1);
	}
}
