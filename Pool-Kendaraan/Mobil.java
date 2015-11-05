
/**
 * Write a description of class Mobil here.
 * 
 * @author (Nawal Nabila) 
 * @version (01 Nov 2015)
 */
public class Mobil implements Kendaraan
{
    private String plat;
    
    public Mobil(String plat){
        this.plat = plat;
    }
    public String plat(){
        return plat;
    }
    public String tipe(){
        String tipe = new String("Mobil");
        return tipe;
    }
}
