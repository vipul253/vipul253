package samples.java;

/* 
 * This is the simplest and safest method, recommended by experts like Joshua Bloch.
 * It provides inherent thread safety, handles serialization automatically, and is resistant to reflection-based attacks
 */
public enum EnumSingleton {
	INSTANCE;

	// Optional: Add methods and state as needed
	public void performAction() {
		System.out.println("Singleton action performed.");
	}
}
//usage : EnumSingleton.INSTANCE.performAction();

/*
 * Instances as Objects: Each enum constant you declare (e.g., MONDAY, TUESDAY
 * in a Day enum) is a public static final instance (object) of that enum type.
 * Inheritance: While an enum cannot extend any other class (because it already
 * extends java.lang.Enum), it can implement interfaces.
 */