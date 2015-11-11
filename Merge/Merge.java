/**
 * Merge
 * 
 * @author (Nawal Nabila) 
 * @version (11 Nov 2015)
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Merge
{ 
    public static void main(String[] args)
    {
        try {
            Merge mer = new Merge();
            mer.merge("tes1.txt","tes2.txt","tes3.txt","output.txt");
        }
        catch (IOException kesalahan) {
            System.out.printf("Terjadi Kesalahan : %s", kesalahan);
        }
    }
    
    public void merge(String file1, String file2, String file3, String sasaran) throws IOException
    {
        FileInputStream FILE1 = null;
        FileInputStream FILE2 = null;
        FileInputStream FILE3 = null;
        FileOutputStream keluaran = null;
        // Deklarasi variabel
        try {
            // Object stream untuk masukkan
            FILE1 = new FileInputStream(file1);
            keluaran = new FileOutputStream(sasaran);
            int karakter = FILE1.read();
                        
            while (karakter != -1) {
                keluaran.write(karakter);                
                karakter = FILE1.read();
            }
            
            FILE2 = new FileInputStream(file2);
            keluaran = new FileOutputStream(sasaran,true);
            karakter = FILE2.read();
            
            while (karakter != -1) {
                keluaran.write(karakter);                
                karakter = FILE2.read();
            }
            
            FILE3 = new FileInputStream(file3);
            keluaran = new FileOutputStream(sasaran,true);
            karakter = FILE3.read();
            
            while (karakter != -1) {
                keluaran.write(karakter);                
                karakter = FILE3.read();
            }
            
            keluaran.flush();
        } 
        
        finally {
            // Tutup stream masukan
            if (FILE1 != null)
                FILE1.close();
            if (FILE2 != null)
                FILE2.close();
            if (FILE3 != null)
                FILE3.close();
            if (keluaran != null)
                keluaran.close();
        }
    }
}
