

import java.io.File; //Dosya İşlemleri kütüphane
import java.io.FileNotFoundException; //Dosya İşlemleri Kütüphane
import java.io.FileReader;//Dosya okuma kütüphane
import java.io.FileWriter;//Dosya yazma kütüphane
import java.io.IOException;//input output kütüphane
import java.util.Scanner; //Input Kutuphane


@SuppressWarnings("unused") //Compieler kendisi ekledi 


/*Programın içerisinde Faktoriyel işlemi Hem MultiThread Hemde Normal olarak hesaplanmıştır 
 * hesaplamalar sonucunda Veriler Metin Belgesine yazılmıştır. Ve hesaplamalar sırasında geçen süre 
 * hesaplanmış ve ekrana çıktı olarak verilmiştir.
 * Program genel yapısı olarak Main fonksiyonun içerisinde önce kullanıcıdan klavyeden faktöriyelini hesaplayacağınız sayıyı 
 * girmesini istiyor sonrasında bu sayıyı önce Multithread işlemler ile hesaplıyor Multithread hesaplama kısmında Thread yöntemi 
 * kullanılmıştır hesaplamaların hepsini metin belgesine kaydediyor sonrasında main fonksiyondan bu metin belgelerini okuyarak 
 * bulunan değerlerin her ikisinide birbiri ile çarpıp esas sonucu elde ediyor.
 * MultiThread işlemindede sayıyı 2 ye bölerek her bir bölümü ayrı Thread'te hesaplatıyor.
 * Sonrasında Normal olarak faktoriyel işlemini yapıyor Bunun içinde geçen süreyi ekrana yazdırdıktan sonra tüm sonuçları Result.txt 
 * diye bir metin belgesinde belgeliyor... */

class bir extends Thread //Threadlerin birincisi 
{
	public int a;//faktoriyelin yapıldığı genel değişken
	public void set(int deger) //Deger set etme 
	{
		this.a=deger;//set
	}
	public int get() //Deger get etme 
	{
		return this.a;//get
	}
	public int deneme() //Sistemin kontrolü için yazmıştım gereksiz
	{
		iki obj=new iki();
		return obj.get()*get();
		
	}
	public static void yazma(String a) throws IOException //Yazma işleminin yapıldığı fonksiyon
	{
		File f1 = new File("D:\\Thread1.txt"); //Yazma konumu 
		FileWriter fw = new FileWriter(f1); // Yazma fonksiyonu 
		fw.write(a);//Yazma
		fw.close();
	}
	
	
	public void run()//Çalışan thread 
	{
		long startTime=System.nanoTime();// Süre hesaplamaya başla 
		int faktor=1;
		
		for(int i=a;i>a/2;i--)// Faktoriyel hesaplama 
		{
			faktor=faktor*i;
		}
		String deneme;
		
		deneme=String.format("%d", faktor);// Yazma için gerekli string veri 
		try {
			yazma(deneme);// Yazma işlemi try catch te ne olur ne olmaz 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long endTime=System.nanoTime();	// Süre hesaplamayı bitir 
		long zaman=(endTime-startTime)/1000000;// Zamanı hesapla ve milisaniyeye çevir 
		System.out.println("Thread 1 hesap süresi:"+zaman+" ms");// Süreyi ekran yazdı 
	}
	
}




class iki extends Thread // İkinci thread 
{
	public void set(int deger)// Set işlemi 
	{
		this.b=deger;
	}
	public int get()// Get işlemi 
	{
		return b;
	}
	public static void yazma(String a) throws IOException//Yazma fonksiyonu 
	{
		File f1 = new File("D:\\Thread2.txt");//Yazılcak yer 
		FileWriter fw = new FileWriter(f1);// YazMa classı çağır 
		fw.write(a);// Yaz 
		fw.close();
	}
	
	
	private int b;
	
	public  void run()// Çalışan threadlerden ikincisi 
	{
		long startTime=System.nanoTime();// Süre hesapla
		int faktor=1;
		for(int i=b/2;i>0;i--)// Faktoriyel hesaplama 
		{
			faktor=faktor*i;//Faktoriyel hesaplama 
		}
		String deneme;
		deneme=String.format("%d", faktor);// Yazdırmak için stringe çevir 
		try {
			yazma(deneme);// Bulunan sonucu yazdırma 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime=System.nanoTime();// Zamanı durdur 
		long zaman=(endTime-startTime)/1000000;// Zamanı milisaniyeye çevir 
		System.out.println("Thread 2 hesap süresi:"+zaman+" ms");// Zamanı ekrana yazdır 
		
	}
	
	
	
}
public class Project1 {
		
	
	public static void yazma(String a) throws IOException// Yazma fonksiyonu 
	{
		File f1 = new File("D:\\Result.txt");// Yazılacak yer 
		FileWriter fw = new FileWriter(f1);// Yazdırma class çağır 
		fw.write(a);// Yaz 
		fw.close();
	}
	
	public static int faktor1(int a)// Faktoriyel hesaplama fonksiyonu 
	{
		long startTime=System.nanoTime();// Zamanlayıcı başlat 
		int faktor=1;
		for(int i=1;i<=a;i++)
		{
			faktor=faktor*i;// Faktoriyel hesapla 
		}
		long endTime=System.nanoTime();// Zamanlayıcı bitir 
		long zaman=(endTime-startTime)/1000000;
		System.out.println("Normal hesap süresi:"+zaman+" ms");// Geçen süreyi ekrrana yazdır 
		return faktor;		
	}	
	public static void main(String[] args) throws IOException {
		
		Scanner sd= new Scanner(System.in);//	Klavyeden değer almak için gerekli class tanımlaması 
		System.out.println("Kaç Faktöriyel hesaplansın ?");
		int faktoriyel=sd.nextInt();// Değer al 
		bir obj1=new bir();// 	Thread1 için object oluştur 
		obj1.set(faktoriyel);// 	Thread1 için değer set et 
		iki obj2=new iki();// Thread2 için object oluştur 
		obj2.set(faktoriyel);// Thread 2 için değer set et 
		obj1.start();// 	Thread1 Başlat 
		obj2.start(); //  Thread2 Başlat 
		File f1 = new File("D:\\Thread1.txt");//Thread 1 çekmek için kullanılıyor 
		File f2 = new File("D:\\Thread2.txt");//Thread2 çekmek için kullanılıyor 
		FileReader fr1=new FileReader(f1); // Metin belgesinden okuma yapmak içni class tanımlamaları 
		FileReader fr2=new FileReader(f2);// Metin belgesinden okuma yapmak içni class tanımlamaları 
		char okunan[]=new char[(int)f1.length()];// Veriyi okunan char dizisine çek 
		char okunan1[]=new char[(int)f2.length()];//  Veriyi okunan1 char dizisine çek 
		fr1.read(okunan);		// Okuma 
		fr2.read(okunan1);   //Okuma 
		String sonuc1 = String.format("%c", okunan[0]);// Okunan değişkeni String e çevir 
		for(int j=1;j<okunan.length;j++) //Tüm elemanalrın Çevrilmesi
		{
			sonuc1=sonuc1+String.format("%c", okunan[j]);//Çevrildi 
		}
		int sonuc11=Integer.parseInt(sonuc1);// integer çevir 
		String sonuc2 = String.format("%c", okunan1[0]);// Okunan değişkenin String e çevrilmesi 
		for(int k=1;k<okunan1.length;k++)// Tüm elemanların çevrilmesi 
		{
			sonuc2=sonuc2+String.format("%c", okunan1[k]);//Çevrildi 
		}
		int sonuc12=Integer.parseInt(sonuc2);// String integer için çevir 
		int gercek_sonuc=sonuc11*sonuc12;// Multi Thread için gerçek sonucu bul 
		String gercekMulti;
		gercekMulti=String.format("%d", gercek_sonuc);// Bulunan gerçek sonucu String e çevir 
		String gercekNormal;
		gercekNormal=String.format("%d",faktor1(faktoriyel));// Normal faktoriyel hesabı yap ve string e çevir 
		yazma("Normal Sonuc: "+gercekNormal+ "  MultiThread Hesaplanan Sonuç: "+gercekNormal);// Gerçek sonuçları Dosyaya yazdırma 
		System.out.println("Hesaplanan Sonuç D:/Result.txt bölümüne kaydedildi...");
				
		
	}

}
