
/**
 * Write a description of class Profil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Profil
{
    private String nama = new String("Nawal Nabila");
    private String nim = new String("1408107010013");
      
    public Profil(){
        this.nama = nama;
        this.nim = nim;
    }
    public Profil(String nama, String nim){
        this.nama = nama;
        this.nim = nim;
    }
    public String getNama(){
        return nama;
    }
    public String getNim(){
        return nim;
    }
    
    
}
