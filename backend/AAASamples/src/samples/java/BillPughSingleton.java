package samples.java;

/*
 * 2. Bill Pugh Approach (Static Inner Class) 
 * This approach leverages the Java class loader mechanism to achieve thread-safe lazy initialization 
 * without explicit synchronization or volatile keywords. The inner class is only loaded when its 
 * static field INSTANCE is first accessed, which happens inside getInstance()
*/
public class BillPughSingleton {
	private BillPughSingleton() {
		// private constructor to prevent external instantiation
	}

	// Static inner class that holds the singleton instance
	private static class SingletonHelper {
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}

	// Public static method to provide access to the instance
	public static BillPughSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
}
