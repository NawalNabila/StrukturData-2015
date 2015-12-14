import java.net.Socket;
import java.net.InetAddress;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.Scanner;

public class ProcessServerThread implements Runnable {
    private String bilRahasia;
    public ProcessServerThread(Socket koneksiKiriman, int bilRahasia) {
        koneksi = koneksiKiriman;
        this.bilRahasia = ""+bilRahasia;
    }

    public void run() {
            try {
                if(koneksi != null)
                   prosesPermintaanClient();
            }
            catch(IOException err) {
                System.out.println(err);
            }
            
    }

    private void prosesPermintaanClient() 
                 throws IOException {
        String ip = koneksi.getInetAddress().getHostAddress();
        System.out.println("Dari: " + ip);
        int i=0;
        String pesanServer=null;
        OutputStream keluaran=null;
        BufferedWriter keluaranBuf=null;
        
        for(; i<3; i++)
        {
        // Ambil dan tampilkan masukan
        InputStream masukan = koneksi.getInputStream();
        BufferedReader masukanReader = new BufferedReader(new InputStreamReader(masukan)); 
        String baris = masukanReader.readLine();
        System.out.println("Tebak Bilangan Rahasia : "+baris);
        
        if(bilRahasia.equalsIgnoreCase(baris))
            pesanServer="Benar";
        
        else
            pesanServer="Salah";
            
        // Kirim ke Client
        keluaran = koneksi.getOutputStream();
        keluaranBuf = new BufferedWriter(new OutputStreamWriter(keluaran));
        keluaranBuf.write(pesanServer);
        keluaranBuf.newLine();
        keluaranBuf.flush();
        
        if(pesanServer.equalsIgnoreCase("Benar"))
            break;
        }
        if(i==3){
            pesanServer="Kalah, Bilangan Rahasia = "+bilRahasia;
            keluaranBuf.write(pesanServer);
            keluaranBuf.newLine();
            keluaranBuf.flush();
        }
    }
    private Socket koneksi; 
}