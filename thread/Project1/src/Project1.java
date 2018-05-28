

import java.io.File; //Dosya ��lemleri k�t�phane
import java.io.FileNotFoundException; //Dosya ��lemleri K�t�phane
import java.io.FileReader;//Dosya okuma k�t�phane
import java.io.FileWriter;//Dosya yazma k�t�phane
import java.io.IOException;//input output k�t�phane
import java.util.Scanner; //Input Kutuphane


@SuppressWarnings("unused") //Compieler kendisi ekledi 


/*Program�n i�erisinde Faktoriyel i�lemi Hem MultiThread Hemde Normal olarak hesaplanm��t�r 
 * hesaplamalar sonucunda Veriler Metin Belgesine yaz�lm��t�r. Ve hesaplamalar s�ras�nda ge�en s�re 
 * hesaplanm�� ve ekrana ��kt� olarak verilmi�tir.
 * Program genel yap�s� olarak Main fonksiyonun i�erisinde �nce kullan�c�dan klavyeden fakt�riyelini hesaplayaca��n�z say�y� 
 * girmesini istiyor sonras�nda bu say�y� �nce Multithread i�lemler ile hesapl�yor Multithread hesaplama k�sm�nda Thread y�ntemi 
 * kullan�lm��t�r hesaplamalar�n hepsini metin belgesine kaydediyor sonras�nda main fonksiyondan bu metin belgelerini okuyarak 
 * bulunan de�erlerin her ikisinide birbiri ile �arp�p esas sonucu elde ediyor.
 * MultiThread i�lemindede say�y� 2 ye b�lerek her bir b�l�m� ayr� Thread'te hesaplat�yor.
 * Sonras�nda Normal olarak faktoriyel i�lemini yap�yor Bunun i�inde ge�en s�reyi ekrana yazd�rd�ktan sonra t�m sonu�lar� Result.txt 
 * diye bir metin belgesinde belgeliyor... */

class bir extends Thread //Threadlerin birincisi 
{
	public int a;//faktoriyelin yap�ld��� genel de�i�ken
	public void set(int deger) //Deger set etme 
	{
		this.a=deger;//set
	}
	public int get() //Deger get etme 
	{
		return this.a;//get
	}
	public int deneme() //Sistemin kontrol� i�in yazm��t�m gereksiz
	{
		iki obj=new iki();
		return obj.get()*get();
		
	}
	public static void yazma(String a) throws IOException //Yazma i�leminin yap�ld��� fonksiyon
	{
		File f1 = new File("D:\\Thread1.txt"); //Yazma konumu 
		FileWriter fw = new FileWriter(f1); // Yazma fonksiyonu 
		fw.write(a);//Yazma
		fw.close();
	}
	
	
	public void run()//�al��an thread 
	{
		long startTime=System.nanoTime();// S�re hesaplamaya ba�la 
		int faktor=1;
		
		for(int i=a;i>a/2;i--)// Faktoriyel hesaplama 
		{
			faktor=faktor*i;
		}
		String deneme;
		
		deneme=String.format("%d", faktor);// Yazma i�in gerekli string veri 
		try {
			yazma(deneme);// Yazma i�lemi try catch te ne olur ne olmaz 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long endTime=System.nanoTime();	// S�re hesaplamay� bitir 
		long zaman=(endTime-startTime)/1000000;// Zaman� hesapla ve milisaniyeye �evir 
		System.out.println("Thread 1 hesap s�resi:"+zaman+" ms");// S�reyi ekran yazd� 
	}
	
}




class iki extends Thread // �kinci thread 
{
	public void set(int deger)// Set i�lemi 
	{
		this.b=deger;
	}
	public int get()// Get i�lemi 
	{
		return b;
	}
	public static void yazma(String a) throws IOException//Yazma fonksiyonu 
	{
		File f1 = new File("D:\\Thread2.txt");//Yaz�lcak yer 
		FileWriter fw = new FileWriter(f1);// YazMa class� �a��r 
		fw.write(a);// Yaz 
		fw.close();
	}
	
	
	private int b;
	
	public  void run()// �al��an threadlerden ikincisi 
	{
		long startTime=System.nanoTime();// S�re hesapla
		int faktor=1;
		for(int i=b/2;i>0;i--)// Faktoriyel hesaplama 
		{
			faktor=faktor*i;//Faktoriyel hesaplama 
		}
		String deneme;
		deneme=String.format("%d", faktor);// Yazd�rmak i�in stringe �evir 
		try {
			yazma(deneme);// Bulunan sonucu yazd�rma 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime=System.nanoTime();// Zaman� durdur 
		long zaman=(endTime-startTime)/1000000;// Zaman� milisaniyeye �evir 
		System.out.println("Thread 2 hesap s�resi:"+zaman+" ms");// Zaman� ekrana yazd�r 
		
	}
	
	
	
}
public class Project1 {
		
	
	public static void yazma(String a) throws IOException// Yazma fonksiyonu 
	{
		File f1 = new File("D:\\Result.txt");// Yaz�lacak yer 
		FileWriter fw = new FileWriter(f1);// Yazd�rma class �a��r 
		fw.write(a);// Yaz 
		fw.close();
	}
	
	public static int faktor1(int a)// Faktoriyel hesaplama fonksiyonu 
	{
		long startTime=System.nanoTime();// Zamanlay�c� ba�lat 
		int faktor=1;
		for(int i=1;i<=a;i++)
		{
			faktor=faktor*i;// Faktoriyel hesapla 
		}
		long endTime=System.nanoTime();// Zamanlay�c� bitir 
		long zaman=(endTime-startTime)/1000000;
		System.out.println("Normal hesap s�resi:"+zaman+" ms");// Ge�en s�reyi ekrrana yazd�r 
		return faktor;		
	}	
	public static void main(String[] args) throws IOException {
		
		Scanner sd= new Scanner(System.in);//	Klavyeden de�er almak i�in gerekli class tan�mlamas� 
		System.out.println("Ka� Fakt�riyel hesaplans�n ?");
		int faktoriyel=sd.nextInt();// De�er al 
		bir obj1=new bir();// 	Thread1 i�in object olu�tur 
		obj1.set(faktoriyel);// 	Thread1 i�in de�er set et 
		iki obj2=new iki();// Thread2 i�in object olu�tur 
		obj2.set(faktoriyel);// Thread 2 i�in de�er set et 
		obj1.start();// 	Thread1 Ba�lat 
		obj2.start(); //  Thread2 Ba�lat 
		File f1 = new File("D:\\Thread1.txt");//Thread 1 �ekmek i�in kullan�l�yor 
		File f2 = new File("D:\\Thread2.txt");//Thread2 �ekmek i�in kullan�l�yor 
		FileReader fr1=new FileReader(f1); // Metin belgesinden okuma yapmak i�ni class tan�mlamalar� 
		FileReader fr2=new FileReader(f2);// Metin belgesinden okuma yapmak i�ni class tan�mlamalar� 
		char okunan[]=new char[(int)f1.length()];// Veriyi okunan char dizisine �ek 
		char okunan1[]=new char[(int)f2.length()];//  Veriyi okunan1 char dizisine �ek 
		fr1.read(okunan);		// Okuma 
		fr2.read(okunan1);   //Okuma 
		String sonuc1 = String.format("%c", okunan[0]);// Okunan de�i�keni String e �evir 
		for(int j=1;j<okunan.length;j++) //T�m elemanalr�n �evrilmesi
		{
			sonuc1=sonuc1+String.format("%c", okunan[j]);//�evrildi 
		}
		int sonuc11=Integer.parseInt(sonuc1);// integer �evir 
		String sonuc2 = String.format("%c", okunan1[0]);// Okunan de�i�kenin String e �evrilmesi 
		for(int k=1;k<okunan1.length;k++)// T�m elemanlar�n �evrilmesi 
		{
			sonuc2=sonuc2+String.format("%c", okunan1[k]);//�evrildi 
		}
		int sonuc12=Integer.parseInt(sonuc2);// String integer i�in �evir 
		int gercek_sonuc=sonuc11*sonuc12;// Multi Thread i�in ger�ek sonucu bul 
		String gercekMulti;
		gercekMulti=String.format("%d", gercek_sonuc);// Bulunan ger�ek sonucu String e �evir 
		String gercekNormal;
		gercekNormal=String.format("%d",faktor1(faktoriyel));// Normal faktoriyel hesab� yap ve string e �evir 
		yazma("Normal Sonuc: "+gercekNormal+ "  MultiThread Hesaplanan Sonu�: "+gercekNormal);// Ger�ek sonu�lar� Dosyaya yazd�rma 
		System.out.println("Hesaplanan Sonu� D:/Result.txt b�l�m�ne kaydedildi...");
				
		
	}

}
