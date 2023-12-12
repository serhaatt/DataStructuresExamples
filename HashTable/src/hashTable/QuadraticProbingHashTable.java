package hashTable;

class HashEntry<Type> {
	Type data;
	boolean isRemoved;
	
	public HashEntry(Type data) {
		this.data = data;
		isRemoved = false;
	}
}

public class QuadraticProbingHashTable<Type> implements HashTable<Type> {
	/**
	 * Size of the table.
	 */
	private static final int DEFAULT_TABLE_SIZE = 11;
	/**
	 * Number of elements contained in the hash table. Initially, 0.
	 */
	private int size;
	/**
	 * The table itself is an array of hash entries. 
	 */
	private HashEntry<Type>[] table;
	
	public QuadraticProbingHashTable() {
		this(DEFAULT_TABLE_SIZE);
	}
	
	@SuppressWarnings("unchecked")
	public QuadraticProbingHashTable(int tableSize) {
		table = new HashEntry[nextPrime(tableSize)];
		size = 0;
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public void makeEmpty() {
		table = new HashEntry[table.length];
		size = 0;
	}
	
	private int getHashCode(Type data) {
		int retVal = data.hashCode();  //Object!
	    retVal %= table.length;
	    if(retVal < 0) //wrap around negative modulus
	      retVal += table.length;
	    return retVal;
	}

	@Override
	public boolean contains(Type data) {
		return find(data) != null;
	}

	@Override
	public Type find(Type data) {
		int pos = findPos(data);
		
		if(table[pos] == null || table[pos].isRemoved)
			return null;
		return table[pos].data;
	}

	@Override
	public void insert(Type data) {
		int pos = findPos(data);
		
		if(table[pos] != null && !table[pos].isRemoved) //duplicate entry, do nothing
			return;
		
		//insertion at pos
		table[pos] = new HashEntry<>(data);
		size++;
		
		//check if rehashing is necessary (i.e., \lambda >= 0.5)
		if(size > table.length/2) {
			rehash();
		}
	}

	@Override
	public void remove(Type data) {
		int pos = findPos(data);
		//lazy deletion, only if necessary
		if(table[pos] != null && !table[pos].isRemoved) {
			table[pos].isRemoved = true;
		}		
	}
	
	private int findPos(Type data) {
		int offset = 1;
		int hash = getHashCode(data);
		
		while(table[hash] != null && ! table[hash].data.equals(data)) {
			hash += offset; //next probe
			offset += 2; //next offset
			if(offset >= table.length) //wrap around
				offset -= table.length; 
		}
		//notice that we terminate the above loop only when we hit a null
		// entry or a cell that contains the searched data.
		//with unsuccessful searches (i.e., termination requires table[hash] == null)
		// correctness relies on the existence of a null entry (i.e., \lambda < 1) and
		// probing such a null entry (i.e., \lambda < 0.5 and table.length is prime).
		return hash;
	}

	@SuppressWarnings("unchecked")
	private void rehash() {
		HashEntry<Type>[] oldTable = table;
		
		int newTableSize = nextPrime(2*table.length);
		table = new HashEntry[newTableSize];
		size = 0;
		
		for(int i = 0; i < oldTable.hashCode(); i++) {
			if(oldTable[i] != null && !oldTable[i].isRemoved) {
				insert(oldTable[i].data);
			}
		}
	}

	/**
	 * Returns the next table size for rehashing.
	 * This method is not implemented in an efficient way.
	 * @param n Current table size
	 * @return Next prime that is greater than n
	 */
	private static int nextPrime(int n) {
		if(n%2 == 0)
			n++;
		
		while(!isPrime(n))
			n += 2; //skip even numbers
		return n;
	}
	
	//source: Wikipedia
	private static boolean isPrime(int n) {
		// Corner cases 
        if (n <= 1) 
            return false; 
        if (n <= 3) 
            return true; 
  
        // This is checked so that we can skip 
        // middle five numbers in below loop 
        if (n % 2 == 0 || n % 3 == 0) 
            return false; 
  
        for (int i = 5; i * i <= n; i = i + 6) 
            if (n % i == 0 || n % (i + 2) == 0) 
                return false; 
  
        return true; 
	}
	
}
