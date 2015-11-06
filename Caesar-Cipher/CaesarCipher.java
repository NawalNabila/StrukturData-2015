
/**
 * Write a description of class CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class CaesarCipher
{ 
    private int shift;
    public CaesarCipher(int shift){
        this.shift = shift;
    }
    public void enkripsi(String sumber, String sasaran) throws IOException {
        FileInputStream masukan = null;
        FileOutputStream keluaran = null;
        // Deklarasi variabel
        try {
            // Object stream untuk masukkan
            masukan = new FileInputStream(sumber);
            keluaran = new FileOutputStream(sasaran);
            // Coba baca  dari stream
            int karakter = masukan.read();
            
            // Selama masih ada data yang masih bisa dibaca
            while (karakter != -1) {
                // Lakukan sesuatu dengan data yang dibaca => Tampikan
                karakter += shift;
                keluaran.write((char)karakter);
                
                karakter = masukan.read();
            }
            keluaran.flush();
        } 
        catch (IOException kesalahan){
            System.out.print("Terjadi kesalahan : %s, kesalahan");
        }
        finally {
            // Tutup stream masukan
            if (masukan != null)
                masukan.close();
            if (keluaran != null)
                keluaran.close();
        }
    }
    public void dekripsi(String sumber, String sasaran) throws IOException {
        FileInputStream masukan = null;
        FileOutputStream keluaran = null;
        // Deklarasi variabel
        try {
            // Object stream untuk masukkan
            masukan = new FileInputStream(sumber);
            keluaran = new FileOutputStream(sasaran);
            // Coba baca  dari stream
            int karakter = masukan.read();
            
            // Selama masih ada data yang masih bisa dibaca
            while (karakter != -1) {
                // Lakukan sesuatu dengan data yang dibaca => Tampikan
                karakter -= shift;
                keluaran.write((char)karakter);         
                
                karakter = masukan.read();
            }
            keluaran.flush();
        } 
        catch (IOException kesalahan){
            System.out.print("Terjadi kesalahan : %s, kesalahan");
        }
        finally {
            // Tutup stream masukan
            if (masukan != null)
                masukan.close();
            if (keluaran != null)
                keluaran.close();
        }
    }
    

}
