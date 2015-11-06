
/**
 * Write a description of class KopiBerkasBuffer here.
 * 
 * @author (Nawal Nabila) 
 * @version (a version number or a date)
 */
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class KopiBerkasBuffer
{ 
    public void kopi(String sumber, String sasaran) throws IOException {
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
                // Lakukan sesuatu dengan data yang dibaca => Tampikan
                keluaranBuffer.write(karakter);                
                karakter = masukanBuffer.read();
            }
            keluaranBuffer.flush();
        } 
        catch (IOException kesalahan){
            System.out.print("Terjadi kesalahan : %s, kesalahan");
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