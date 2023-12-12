package Ex3;



public class ComprehensiveDynamicListe 
{
	
	protected Eleman liste_basi,liste_sonu;;
	
	public ComprehensiveDynamicListe()
	{
		this.liste_basi=null;
		this.liste_sonu=null;
	}
	
	public Boolean BosMu()
	{
		return liste_basi==null ;
	}
	
	
	public void ElemanEkle(int data)
	{
       Eleman yeni=new Eleman(data,null,null);
		
		if (liste_basi==null  ) 
		{
			liste_basi=yeni;
			liste_sonu=yeni;
			
			
		}
		
		else if (liste_basi.data>data)//update liste_basi  
		{
			
			yeni.sonraki=liste_basi; 
			yeni.onceki=null;
			yeni.sonraki.onceki=yeni;
			
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
			
		
			Boolean isListeSonuUpdate=(tempEleman.sonraki==null);
		    
			if (isListeSonuUpdate==false)
			{
				yeni.onceki=tempEleman;
				yeni.sonraki=tempEleman.sonraki;
				
				tempEleman.sonraki=yeni;
				yeni.sonraki.onceki=yeni;
				
			}
			
			else 
			{
				
				yeni.onceki=liste_sonu;
				yeni.sonraki=null;
				
				liste_sonu.sonraki=yeni;
				liste_sonu=yeni;
				
				
			}
			
			
				
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
		Eleman silmeAdayEleman=liste_basi;
		while(silmeAdayEleman!=null)
		{
			if(silmeAdayEleman.data==data)
			{
				if(silmeAdayEleman.onceki==null)
				{
					
					liste_basi=liste_basi.sonraki;
					liste_basi.onceki=null;
					
				}
				else if(silmeAdayEleman.sonraki==null)
				{
					
					liste_sonu=liste_sonu.onceki;
					liste_sonu.sonraki=null;
				}
				
				
				else
				{
					silmeAdayEleman.onceki.sonraki=silmeAdayEleman.sonraki;
					silmeAdayEleman.sonraki.onceki=silmeAdayEleman.onceki;		
					
					
					
				}
				
				return true;	
				
			}
			silmeAdayEleman=silmeAdayEleman.sonraki;
		}
		return false;
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

}
