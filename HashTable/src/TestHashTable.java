import hashTable.*;

class Employee {
	protected String name;
	protected double salary;
	protected int seniority;
	
	public Employee(String name, double salary, int seniority) {
		this.name = name;
		this.salary = salary;
		this.seniority = seniority;
	}
	
	public Employee(String name) {
		this.name = name;
	}
	
	//necessary for searching for an employee in the table
	public boolean equals(Object that)	{ 
		if(that instanceof Employee) {
			Employee e = (Employee) that;
			return name.equals(e.name);
		}
		return false;
	}

	//set like this, our employees will be hashed on their names
	public int hashCode( ) { 
		return name.hashCode(); 
	}
}

public class TestHashTable {	 
	public static void main(String[] args) {
		HashTable<Employee> table = new SeparateChainingHashTable<>();
		//HashTable<Employee> table = new QuadraticProbingHashTable<>();
		table.insert(new Employee("ali", 100, 3));
		table.insert(new Employee("veli", 120, 4));
		table.insert(new Employee("selami", 80, 2));
		Employee ali = table.find(new Employee("ali"));
		if(ali != null) {
			//give him a raise
			System.out.println("Existing salary: " + ali.salary);
			ali.salary *= 2;
			System.out.println("New salary: " + table.find(new Employee("ali")).salary);
		}
		Employee deli = table.find(new Employee("deli"));
		if(deli == null) {
			System.out.println("Cannot find \"deli\" in the table.");
		}
	}
}
