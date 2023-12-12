package Ex3;


public class Eleman
{
	
	protected int data;
	
	protected Eleman sonraki,onceki;
	
	public Eleman(int data,Eleman onceki,Eleman sonraki)
	{
		this.data=data;
		this.sonraki=sonraki;
		this.onceki=onceki;
	}
	
}
