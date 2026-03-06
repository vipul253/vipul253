package samples.ds;

public class CustomHashMap<K, V> {

	static class Node<K,V> {
		final int hash;
        final K key;
        V value;
        Node<K,V> next;
        
        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }
        public final void setValue(V newValue) { this.value = newValue; }
	}

	private int nodeCount; // total nodes count
	private int tableSize; // Nodes[] array size
	private Node<K, V>[] buckets;

	@SuppressWarnings("unchecked")
	public CustomHashMap() {
		this.nodeCount = 0;
		this.tableSize = 8;
		this.buckets = new Node[tableSize];
	}

	private int getBucketSize() {
		return buckets.length;
	}
	
	public int size() {
		return nodeCount;
	}

	public boolean isEmpty() {
		return nodeCount == 0;
	}
	// copied hash logic plus index mod
	private int hashedIndex(Object key) {
		if (key == null) return 0;
		int hash = key.hashCode();
		hash ^= (hash >>> 16); // h XOR h >>> 8;
		int index = (getBucketSize() - 1) & hash;
		return index;
	}

	// this casts Node<> to Node<K, V> so no warning
	Node<K, V> newNode(int hash, K key, V value, Node<K, V> next) {
		return new Node<>(hash, key, value, next);
	}

	public V get(Object key) {
		int h = hashedIndex(key);
		if (buckets[h] == null) {
			return null; // element does not Exist
		} else {
			Node<K, V> res = buckets[h];
			while (res.key != key && res != null) {
				res = res.next;
			}
			return res.value;
		}
	}

	public V put(K key, V value) {
		int h = hashedIndex(key);
		if (buckets[h] == null) {
			buckets[h] = newNode(h, key, value, null);
			nodeCount++;
		} else if (buckets[h].key == key) {
			buckets[h].value = value;
		} else {
			Node<K, V> nextNode = buckets[h];
			while (nextNode.next != null) {
				nextNode = nextNode.next;
			}
			nextNode.next = newNode(h, key, value, null);
			nodeCount++;
		}
		if (nodeCount / tableSize > 1.75) {
			// then resize
		}
		return null;
	}

	public V remove(Object key) {
		int h = hashedIndex(key);
		if (buckets[h] == null) {
			return null; // element does not Exist
		} else {
			Node<K, V> res = buckets[h];
			if (res.key == key) {
				buckets[h] = res.next;
				V val = res.value;
				nodeCount--;
				return val;
			} else {
				while (res.next != null && res.next.key != key) {
					res = res.next;
				}
				if (res.next.key == key && res.next.next != null) {
					V val = res.next.value;
					res.next = res.next.next;
					nodeCount--;
					return val;
				} else {
					return null;
				}
			}
		}
	}

	public boolean containsKey(Object key) {
		int h = hashedIndex(key);
		if (buckets[h] == null) {
			return false; // element does not Exist
		} else {
			Node<K, V> res = buckets[h];
			if (res.key == key) {
				return true;
			} else {
				while (res.next != null && res.key != key) {
					res = res.next;
				}
				if (res.key != key) {
					return true;
				} else {
					return false;
				}
			}
		}
	}
}
