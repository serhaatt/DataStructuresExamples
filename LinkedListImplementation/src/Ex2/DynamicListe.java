package Ex2;

public class DynamicListe 
{
	
	protected Eleman liste_basi;
	
	public DynamicListe()
	{
		this.liste_basi=null;
	}
	
	public void ElemanEkle(int data)
	
	{
		Eleman yeni=new Eleman(data,null);
		
		if (liste_basi==null  || liste_basi.data>data) //update liste_basi
		{
			yeni.sonraki=liste_basi; 
			liste_basi=yeni;  
			
		}
		
		else // middle insert
		{
			Eleman tempEleman=liste_basi;
			
			//if(tempEleman.data>data) tempEleman=
			
			while(tempEleman.sonraki!=null)
			{
				if(tempEleman.sonraki.data>data) break; 
				                                        
				tempEleman=tempEleman.sonraki;
				
			}
					
				yeni.sonraki=tempEleman.sonraki;  
				tempEleman.sonraki=yeni;		 
				                                
		}		
		
	}
	
	public Eleman ElemanBul(int data)
	{
		Eleman tempEleman=liste_basi;
		while(tempEleman!=null)
		{
			if(tempEleman.data==data) return tempEleman;
			tempEleman=tempEleman.sonraki;
		}
		
		return null;
		
		
	}
	
	
	public Eleman OncekiElemanBul(int data)
	{
		Eleman tempEleman=liste_basi;
		while(tempEleman.sonraki!=null)
		{
			if(tempEleman.sonraki.data==data) return tempEleman;
			tempEleman=tempEleman.sonraki;
		}
		
		return null;
	}
	
	
	public Boolean ElemanCikar(int data)
	{
		Eleman cikarilacakOncesi=OncekiElemanBul(data);
		
		if(cikarilacakOncesi!=null)
		{
			cikarilacakOncesi.sonraki=cikarilacakOncesi.sonraki.sonraki;
					
			return true;
			
		}
		else
		{
			liste_basi=liste_basi.sonraki;
			return true;
		}
				
	}
	
	
	public void listele()
	{
		System.out.println("Listenin tüm elemanları:");
		Eleman tempEleman=liste_basi;
		while(tempEleman!=null)
		{
			System.out.println(tempEleman.data);
			tempEleman=tempEleman.sonraki;
		}
		
	}
	
	public Boolean BosMu()
	{
		return liste_basi==null;
	}	
		
}
