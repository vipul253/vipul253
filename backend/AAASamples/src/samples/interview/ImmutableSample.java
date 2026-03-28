package samples.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// this is immutable not singleton
//1. Mark the class as final
public final class ImmutableSample {

	// 2. All fields are private and final
    private final int id;
    private final String name;
    private final List<String> hobbies;
    
    public ImmutableSample(int id, String name, List<String> hobbies) {
        this.id = id;
        this.name = name;
        
        // 3. Deep copy the list in the constructor to prevent external changes
        this.hobbies = new ArrayList<>(hobbies);
    }
    
    public int getId() { return id; }
    public String getName() { return name; }

    // 4. Return an unmodifiable or new list to maintain immutability
    public List<String> getHobbies() {
        return Collections.unmodifiableList(new ArrayList<>(this.hobbies));
    }
}
