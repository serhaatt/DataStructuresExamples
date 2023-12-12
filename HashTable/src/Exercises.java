import java.util.Arrays;

import hashTable.HashTable;
import hashTable.QuadraticProbingHashTable;
import hashTable.SeparateChainingHashTable;

//IndexEntry class for Exercise2: sort locations.
class IndexEntry<Type>{
	Type data;
	int index;
	
	public IndexEntry(Type data, int index) {
		this.data = data;
		this.index = index;
	}
	
	@SuppressWarnings("unchecked")
	public boolean equals(Object o) {
		if(o instanceof IndexEntry) {
			IndexEntry<Type> that = (IndexEntry<Type>) o;
			return this.data.equals(that.data);
		}
		return false;
	}
	
	public int hashCode() {
		return data.hashCode();
	}
}

public class Exercises {
	public static int pairsWithGivenSum(Integer[] vals, int sum) {
		HashTable<Integer> lookup = new QuadraticProbingHashTable<>(vals.length*2);
		int res = 0;
		//Note on insertion order: suppose x + y = sum. If we hit x first, 
		// then y = sum - x will be inside lookup when we hit y.
		// If y was hit first, then x should be inside lookup.
		for(int i = 0; i < vals.length; i++) {
			int partner = sum - vals[i];
			if(lookup.contains(vals[i])) //if the partner of vals[i] has already been inserted
				res++;
			else //insert partner
				lookup.insert(partner);
		}
		return res;
	}
	
	public static Integer[] sortLocations(Integer[] vals) {
		//hash the entries based on their values. each entry
		// will be a pair of (Integer, int): the first containing
		// sortedCopy[i], the second containing i - the index.
		//our purpose is to quickly lookup i (index in sortedCopy)  
		// using vals[i] after sorting is applied.
		
		//sort the values
		Integer[] sortedCopy = Arrays.copyOf(vals, vals.length);
		Arrays.sort(sortedCopy);
		
		//build the hash table using sortedCopy[i] & i
		HashTable<IndexEntry<Integer>> lookup = new SeparateChainingHashTable<>(vals.length);
		for(int i = 0; i < vals.length; i++) {
			lookup.insert(new IndexEntry<Integer>(sortedCopy[i], i));
		}
		
		//lookup and output
		Integer[] retVal = new Integer[vals.length];
		for(int i = 0; i < vals.length; i++) {
			IndexEntry<Integer> res = lookup.find(new IndexEntry<Integer>(vals[i], -1));
			retVal[i] = res.index;
		}
		return retVal;
	}
	
	public static int LCSN(Integer[] vals) {
		//insert values into the hash table
		HashTable<Integer> lookup = new SeparateChainingHashTable<>(vals.length);
		for(int i = 0; i < vals.length; i++)
			lookup.insert(vals[i]);
		
		int longest = 0; //longest sequence observed so far
		for(int i = 0; i < vals.length; i++) {
			int val = vals[i];
			if(!lookup.contains(val-1)) { //start of a sequence
				int next = val + 1; //next in the sequence
				while(lookup.contains(next)) { //sequence continues
					next++;
				}
				int len = next - val; //length of the sequence starting at val
				if(len > longest) //update longest
					longest = len;
			}
		}
		return longest;		
	}
	
	public static void main(String[] args) {
		//Exercise 1: pairs with given sum
		Integer[] vals = {3, 4, 1000000, 2, 5};
		int sum = 7;
		int numPairs = pairsWithGivenSum(vals, sum);
		System.out.println("Number of values that sum to " + sum + ": " + numPairs);
		System.out.println();
		
		//Exercise 2: sort locations
		System.out.print("Input array: ");
		printArray(vals);
		Integer[] sortLocations = sortLocations(vals);
		System.out.print("Sort loc.s:  ");
		printArray(sortLocations);
		System.out.println();
		
		//Exercise 3: 
		Integer[] vals2 = {1, 3, 8, 14, 4, 10, 2, 11}; 
		System.out.print("Input array: ");
		printArray(vals2);
		int res = LCSN(vals2);
		System.out.println("Longest subset with consecutive numbers has length " + res);
	}
	
	//simply prints an array
	public static void printArray(Integer[] vals) {
		if(vals.length == 0) {
			System.out.println("[]");
		} else if(vals.length == 1) {
			System.out.println("[" + vals[0] + "]");
		} else {
			System.out.print("[" + vals[0]);
			for(int i = 1; i  < vals.length; i++)
				System.out.print(", " + vals[i]);
			System.out.println("]");
		}
	}
}
