package samples.java;

/* Double-Checked Locking (DCL): A more efficient lazy initialization approach that minimizes 
 * synchronization overhead by using a volatile instance variable and a synchronized block 
 * inside the if condition.
 */
public class DCLSingleton {
	private static volatile DCLSingleton instance; // 'volatile' ensures visibility and prevents instruction reordering

	private DCLSingleton() {
	}

	public static DCLSingleton getInstance() {
		if (instance == null) {
			synchronized (DCLSingleton.class) {
				if (instance == null) { // Double check
					instance = new DCLSingleton();
				}
			}
		}
		return instance;
	}
}

//Eager Initialization: Creates the instance when the class is loaded. It's thread-safe but not lazy, 
//potentially wasting resources if the instance is never used.
/*
 * public class EagerSingleton {
 * 
 * private static final EagerSingleton INSTANCE = new EagerSingleton();
 * 
 * private EagerSingleton() {}
 * 
 * public static EagerSingleton getInstance() { return INSTANCE; }
 * 
 * }
 */