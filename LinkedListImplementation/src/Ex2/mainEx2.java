package Ex2;

public class mainEx2 {

	public static void main(String[] args) {
		
		DynamicListe dynamicListe=new DynamicListe();
		
		dynamicListe.ElemanEkle(4);
		dynamicListe.ElemanEkle(1);
		dynamicListe.ElemanEkle(2);
		dynamicListe.ElemanEkle(0);
		dynamicListe.ElemanEkle(3);
		
		dynamicListe.listele();
		dynamicListe.ElemanCikar(2);
		dynamicListe.ElemanEkle(5);
		dynamicListe.listele();
				

	}

}
