package Ex1;

public class mainEx1 {

	public static void main(String[] args) {
		
		FixedListe liste1=new FixedListe(5);
		
		liste1.ElemanEkle(3);
		liste1.ElemanEkle(1);
		liste1.ElemanEkle(2);
		liste1.ElemanEkle(0);
		liste1.ToString();
		
		liste1.ElemanCikar(0);
		liste1.ElemanCikar(2);
		
		liste1.ToString();
		

	}

}
