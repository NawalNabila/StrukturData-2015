
/**
 * Write a description of class gabung here.
 * 
 * @author (Nawal Nabila) 
 * @version (20 Nov 2015)
 */
public class Gabung 
{
   private double data[];
   private Kelompok[] kelompok = new Kelompok[5];
   
   public Gabung(double[] data)
   {
      this.data = data;
      for (int i=0; i<5; i++)
      {
          int awal = (data.length/5)*i;
          int akhir = awal +(data.length/5)-1;
          kelompok[i] = new Kelompok (awal,akhir,data);
        }
        Thread t1 = new Thread(kelompok[0]);
        Thread t2 = new Thread(kelompok[1]);
        Thread t3 = new Thread(kelompok[2]);
        Thread t4 = new Thread(kelompok[3]);
        Thread t5 = new Thread(kelompok[4]);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
    
   public double hasil(){
       try {
           Thread.sleep(100);
       }
        catch(InterruptedException e){
       }
       double hasil = 0;
       for(int i=0; i<5; i++){
           hasil += kelompok[i].hasil();
        }
       
       return hasil;
    }
    
}
