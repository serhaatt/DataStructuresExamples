package Ex3;

import Ex2.DynamicListe;

public class mainEx3 {

	public static void main(String[] args) 
	
	{
ComprehensiveDynamicListe comprehensiveDynamicListe=new ComprehensiveDynamicListe();
		
comprehensiveDynamicListe.ElemanEkle(4);
comprehensiveDynamicListe.ElemanEkle(1);
comprehensiveDynamicListe.ElemanEkle(2);
comprehensiveDynamicListe.ElemanEkle(0);
comprehensiveDynamicListe.ElemanEkle(3);	
comprehensiveDynamicListe.listele();
comprehensiveDynamicListe.ElemanCikar(2);
comprehensiveDynamicListe.ElemanEkle(5);
comprehensiveDynamicListe.listele();

	}

}
