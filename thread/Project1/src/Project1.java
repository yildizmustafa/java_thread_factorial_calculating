

import java.io.File; //Dosya Ýþlemleri kütüphane
import java.io.FileNotFoundException; //Dosya Ýþlemleri Kütüphane
import java.io.FileReader;//Dosya okuma kütüphane
import java.io.FileWriter;//Dosya yazma kütüphane
import java.io.IOException;//input output kütüphane
import java.util.Scanner; //Input Kutuphane


@SuppressWarnings("unused") //Compieler kendisi ekledi 


/*Programýn içerisinde Faktoriyel iþlemi Hem MultiThread Hemde Normal olarak hesaplanmýþtýr 
 * hesaplamalar sonucunda Veriler Metin Belgesine yazýlmýþtýr. Ve hesaplamalar sýrasýnda geçen süre 
 * hesaplanmýþ ve ekrana çýktý olarak verilmiþtir.
 * Program genel yapýsý olarak Main fonksiyonun içerisinde önce kullanýcýdan klavyeden faktöriyelini hesaplayacaðýnýz sayýyý 
 * girmesini istiyor sonrasýnda bu sayýyý önce Multithread iþlemler ile hesaplýyor Multithread hesaplama kýsmýnda Thread yöntemi 
 * kullanýlmýþtýr hesaplamalarýn hepsini metin belgesine kaydediyor sonrasýnda main fonksiyondan bu metin belgelerini okuyarak 
 * bulunan deðerlerin her ikisinide birbiri ile çarpýp esas sonucu elde ediyor.
 * MultiThread iþlemindede sayýyý 2 ye bölerek her bir bölümü ayrý Thread'te hesaplatýyor.
 * Sonrasýnda Normal olarak faktoriyel iþlemini yapýyor Bunun içinde geçen süreyi ekrana yazdýrdýktan sonra tüm sonuçlarý Result.txt 
 * diye bir metin belgesinde belgeliyor... */

class bir extends Thread //Threadlerin birincisi 
{
	public int a;//faktoriyelin yapýldýðý genel deðiþken
	public void set(int deger) //Deger set etme 
	{
		this.a=deger;//set
	}
	public int get() //Deger get etme 
	{
		return this.a;//get
	}
	public int deneme() //Sistemin kontrolü için yazmýþtým gereksiz
	{
		iki obj=new iki();
		return obj.get()*get();
		
	}
	public static void yazma(String a) throws IOException //Yazma iþleminin yapýldýðý fonksiyon
	{
		File f1 = new File("D:\\Thread1.txt"); //Yazma konumu 
		FileWriter fw = new FileWriter(f1); // Yazma fonksiyonu 
		fw.write(a);//Yazma
		fw.close();
	}
	
	
	public void run()//Çalýþan thread 
	{
		long startTime=System.nanoTime();// Süre hesaplamaya baþla 
		int faktor=1;
		
		for(int i=a;i>a/2;i--)// Faktoriyel hesaplama 
		{
			faktor=faktor*i;
		}
		String deneme;
		
		deneme=String.format("%d", faktor);// Yazma için gerekli string veri 
		try {
			yazma(deneme);// Yazma iþlemi try catch te ne olur ne olmaz 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long endTime=System.nanoTime();	// Süre hesaplamayý bitir 
		long zaman=(endTime-startTime)/1000000;// Zamaný hesapla ve milisaniyeye çevir 
		System.out.println("Thread 1 hesap süresi:"+zaman+" ms");// Süreyi ekran yazdý 
	}
	
}




class iki extends Thread // Ýkinci thread 
{
	public void set(int deger)// Set iþlemi 
	{
		this.b=deger;
	}
	public int get()// Get iþlemi 
	{
		return b;
	}
	public static void yazma(String a) throws IOException//Yazma fonksiyonu 
	{
		File f1 = new File("D:\\Thread2.txt");//Yazýlcak yer 
		FileWriter fw = new FileWriter(f1);// YazMa classý çaðýr 
		fw.write(a);// Yaz 
		fw.close();
	}
	
	
	private int b;
	
	public  void run()// Çalýþan threadlerden ikincisi 
	{
		long startTime=System.nanoTime();// Süre hesapla
		int faktor=1;
		for(int i=b/2;i>0;i--)// Faktoriyel hesaplama 
		{
			faktor=faktor*i;//Faktoriyel hesaplama 
		}
		String deneme;
		deneme=String.format("%d", faktor);// Yazdýrmak için stringe çevir 
		try {
			yazma(deneme);// Bulunan sonucu yazdýrma 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime=System.nanoTime();// Zamaný durdur 
		long zaman=(endTime-startTime)/1000000;// Zamaný milisaniyeye çevir 
		System.out.println("Thread 2 hesap süresi:"+zaman+" ms");// Zamaný ekrana yazdýr 
		
	}
	
	
	
}
public class Project1 {
		
	
	public static void yazma(String a) throws IOException// Yazma fonksiyonu 
	{
		File f1 = new File("D:\\Result.txt");// Yazýlacak yer 
		FileWriter fw = new FileWriter(f1);// Yazdýrma class çaðýr 
		fw.write(a);// Yaz 
		fw.close();
	}
	
	public static int faktor1(int a)// Faktoriyel hesaplama fonksiyonu 
	{
		long startTime=System.nanoTime();// Zamanlayýcý baþlat 
		int faktor=1;
		for(int i=1;i<=a;i++)
		{
			faktor=faktor*i;// Faktoriyel hesapla 
		}
		long endTime=System.nanoTime();// Zamanlayýcý bitir 
		long zaman=(endTime-startTime)/1000000;
		System.out.println("Normal hesap süresi:"+zaman+" ms");// Geçen süreyi ekrrana yazdýr 
		return faktor;		
	}	
	public static void main(String[] args) throws IOException {
		
		Scanner sd= new Scanner(System.in);//	Klavyeden deðer almak için gerekli class tanýmlamasý 
		System.out.println("Kaç Faktöriyel hesaplansýn ?");
		int faktoriyel=sd.nextInt();// Deðer al 
		bir obj1=new bir();// 	Thread1 için object oluþtur 
		obj1.set(faktoriyel);// 	Thread1 için deðer set et 
		iki obj2=new iki();// Thread2 için object oluþtur 
		obj2.set(faktoriyel);// Thread 2 için deðer set et 
		obj1.start();// 	Thread1 Baþlat 
		obj2.start(); //  Thread2 Baþlat 
		File f1 = new File("D:\\Thread1.txt");//Thread 1 çekmek için kullanýlýyor 
		File f2 = new File("D:\\Thread2.txt");//Thread2 çekmek için kullanýlýyor 
		FileReader fr1=new FileReader(f1); // Metin belgesinden okuma yapmak içni class tanýmlamalarý 
		FileReader fr2=new FileReader(f2);// Metin belgesinden okuma yapmak içni class tanýmlamalarý 
		char okunan[]=new char[(int)f1.length()];// Veriyi okunan char dizisine çek 
		char okunan1[]=new char[(int)f2.length()];//  Veriyi okunan1 char dizisine çek 
		fr1.read(okunan);		// Okuma 
		fr2.read(okunan1);   //Okuma 
		String sonuc1 = String.format("%c", okunan[0]);// Okunan deðiþkeni String e çevir 
		for(int j=1;j<okunan.length;j++) //Tüm elemanalrýn Çevrilmesi
		{
			sonuc1=sonuc1+String.format("%c", okunan[j]);//Çevrildi 
		}
		int sonuc11=Integer.parseInt(sonuc1);// integer çevir 
		String sonuc2 = String.format("%c", okunan1[0]);// Okunan deðiþkenin String e çevrilmesi 
		for(int k=1;k<okunan1.length;k++)// Tüm elemanlarýn çevrilmesi 
		{
			sonuc2=sonuc2+String.format("%c", okunan1[k]);//Çevrildi 
		}
		int sonuc12=Integer.parseInt(sonuc2);// String integer için çevir 
		int gercek_sonuc=sonuc11*sonuc12;// Multi Thread için gerçek sonucu bul 
		String gercekMulti;
		gercekMulti=String.format("%d", gercek_sonuc);// Bulunan gerçek sonucu String e çevir 
		String gercekNormal;
		gercekNormal=String.format("%d",faktor1(faktoriyel));// Normal faktoriyel hesabý yap ve string e çevir 
		yazma("Normal Sonuc: "+gercekNormal+ "  MultiThread Hesaplanan Sonuç: "+gercekNormal);// Gerçek sonuçlarý Dosyaya yazdýrma 
		System.out.println("Hesaplanan Sonuç D:/Result.txt bölümüne kaydedildi...");
				
		
	}

}
