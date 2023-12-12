package hashTable;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class SeparateChainingHashTable<Type> implements HashTable<Type> {
	/**
	 * Size of the table.
	 */
	private static final int DEFAULT_TABLE_SIZE = 11;
	/**
	 * Number of elements contained in the hash table. Initially, 0.
	 */
	private int size;
	/**
	 * The table itself is an array of linked lists.
	 * Each list contains items with the given hash value. 
	 */
	private List<Type>[] table;
	
	public SeparateChainingHashTable() {
		//see the constructor below.
		this(DEFAULT_TABLE_SIZE);
	}
	
	@SuppressWarnings("unchecked")
	public SeparateChainingHashTable(int tableSize) {
		table = new LinkedList[nextPrime(tableSize)];
		for(int i = 0; i < table.length; i++) {
			table[i] = new LinkedList<>();
		}
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
	public void makeEmpty() {
		for(int i = 0; i < table.length; i++)
			table[i].clear();
		size = 0;
	}

	@Override
	public boolean contains(Type data) {
		int hash = getHashCode(data);
		List<Type> list = table[hash];
		return list.contains(data);
	}

	@Override
	public Type find(Type data) {
		int hash = getHashCode(data);
		List<Type> list = table[hash];
		if(list.indexOf(data) >= 0)
			return list.get(list.indexOf(data));
		return null;
	}

	@Override
	public void insert(Type data) {
		int hash = getHashCode(data);
		List<Type> list = table[hash];
		if(!list.contains(data)) {
			list.add(data);
			size++;
			
			//the check below could be parameterized to load factor
			//here any insertion that makes load factor > 1 causes a rehash.
			if(size > table.length) {
				rehash();
			}
		}
	}

	@Override
	public void remove(Type data) {
		int hash = getHashCode(data);
		List<Type> list = table[hash];
		if(list.contains(data)) {
			list.remove(data);
			size--;
		}
	}
	
	@SuppressWarnings("unchecked")
	private void rehash() {
		List<Type>[] oldTable = table;
		
		int newTableSize = nextPrime(2*table.length);
		table = new List[newTableSize];
		for(int i = 0; i < table.length; i++)
			table[i] = new LinkedList<>();
		size = 0;
		
		//insert existing items from oldTable into table
		for(int i = 0; i < oldTable.length; i++) {
			ListIterator<Type> iter = oldTable[i].listIterator();
			while(iter.hasNext())
				insert(iter.next());
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
