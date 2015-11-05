
/**
 * Write a description of class SepedaMotor here.
 * 
 * @author (Nawal Nabila) 
 * @version (01 Nov 2015)
 */
public class SepedaMotor implements Kendaraan
{
    private String plat;
    
    public SepedaMotor(String plat){
        this.plat = plat;
    }
    public String plat(){
        return plat;
    }
    public String tipe(){
        String tipe = new String("SepedaMotor");
        return tipe;
    }
}
