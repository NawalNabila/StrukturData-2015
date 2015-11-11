
/**
 * Upper
 * 
 * @author (Nawal Nabila) 
 * @version (11 Nov 2015)
 */
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Upper
{ 
    public static void main(String[]args) 
    {
        try {
            Upper kata = new Upper();
            kata.upper("ujisumber.txt","tes.txt");
        }
        catch (IOException kesalahan){
            System.out.print("Terjadi kesalahan : %s, kesalahan");
        }
    }
    
    public void upper(String sumber, String sasaran) throws IOException
    {
        FileInputStream masukan = null;
        BufferedInputStream masukanBuffer = null;
        FileOutputStream keluaran = null;
        BufferedOutputStream keluaranBuffer = null;
        // Deklarasi variabel
        try {
            // Object stream untuk masukkan
            masukan = new FileInputStream(sumber);
            masukanBuffer = new BufferedInputStream(masukan);
            keluaran = new FileOutputStream(sasaran);
            keluaranBuffer = new BufferedOutputStream(keluaran);
            // Coba baca  dari stream
            int karakter = masukanBuffer.read();
            
            // Selama masih ada data yang masih bisa dibaca
            while (karakter != -1) {
                // Melakukan upper case
                karakter = Character.toUpperCase(karakter);
                keluaranBuffer.write(karakter);                
                karakter = masukanBuffer.read();
            }
            keluaranBuffer.flush();
        } 
        
        finally {
            // Tutup stream masukan
            if (masukanBuffer != null)
                masukanBuffer.close();
            if (keluaranBuffer != null)
                keluaranBuffer.close();
        }
    }
    
}