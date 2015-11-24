
/**
 * Write a description of class kelompok here.
 * 
 * @author (Nawal Nabila) 
 * @version (20 Nov 2015)
 */
public class Kelompok implements Runnable
{
   private int awal;
   private int akhir;
   private double data[];
   private double nilaiHasil;
   
   public Kelompok (int awal, int akhir, double data[])
   {
       this.awal = awal;;
       this.akhir = akhir;
       this.data = data;
    }
    
   public double hasil()
   {
       return nilaiHasil;
    }
   
   public void hitung()
   {
       for(int i=awal; i<=akhir; i++)
           nilaiHasil += data[i];
    }
   
   public void run()
   {
       hitung();
       hasil();
    }
}
