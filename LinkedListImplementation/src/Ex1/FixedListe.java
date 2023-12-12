package Ex1;

public class FixedListe {
    
	int elements[];
	int numOfElements;
	
	public FixedListe(int  kapasite)
	{
		
		elements=new int[kapasite];
		numOfElements=0;
		
		for (int i=0;i<kapasite;i++)
		{
			elements[i]=Integer.MIN_VALUE;
		}
		
	}
	
	
	public void ElemanEkle(int data)
	{
		if(numOfElements!=elements.length)
		{
			int index=numOfElements-1;
			 while(index>=0 && elements[index]>data)
			 {
				 elements[index+1]=elements[index];
				 index--;
			 }
			 
			 elements[index+1]=data;
			
			 numOfElements++;
		}   
		
	}
	
	public void ElemanCikar(int data)
	{
		if(numOfElements!=0)
		{
			// find index to be removed
			
			for(int i=0;i<numOfElements;i++)
			{
				if(elements[i]==data)
				{
					
					for(int index2=i;index2<numOfElements-1;index2++)
					{
						elements[index2]=elements[index2+1];
						
					}
					elements[numOfElements-1]=Integer.MIN_VALUE;
					
					numOfElements--;
				}
				
			}
			
		}	
	}
	
	public void ToString()
	{
		for (int i=0;i<numOfElements;i++)
		{
			System.out.println(elements[i]);
		}
		
	}
	
}
