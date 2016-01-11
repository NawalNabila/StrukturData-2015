
/**
 * Write a description of class ProcessThread here.
 * 
 * @author (Nawal Nabila) 
 * @version (10 Jan 2016)
 */
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
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ProcessServerThread implements Runnable {
    public ProcessServerThread(Socket koneksiKiriman, ArrayList<pohon> arrKiriman) {
        koneksi = koneksiKiriman;
        arr = arrKiriman;
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
        
        String baris=null;
        OutputStream keluaran=null;
        BufferedWriter keluaranBuf=null;
       
        // Ambil dan tampilkan masukan
        InputStream masukan = koneksi.getInputStream();
        BufferedReader masukanReader = new BufferedReader(new InputStreamReader(masukan)); 
        baris = masukanReader.readLine();
        
        Calendar kalender = Calendar.getInstance(); //untuk mendapatkan waktu
        
        if(baris.equalsIgnoreCase("INSERT"))
        {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); //format waktu hanya jam dan menit
            baris = masukanReader.readLine();//apel;40;30;40;50
            String [] ar = baris.split(";"); //baris yg diterima dari client di split kan
            // simpan data ke dalam class pohon berdasarkan variabel pd class tsb
            pohon phn = new pohon();
            phn.nama = ar[0];
            phn.lembab = Integer.parseInt(ar[1]); 
            phn.uv = Integer.parseInt(ar[2]);
            phn.nitro = Integer.parseInt(ar[3]);
            phn.suhu = Integer.parseInt(ar[4]);
            phn.waktu = sdf.format(kalender.getTime());
            //array kiriman masukkan kedalam phn
            arr.add(phn);
            
            // Kirim ke Client
            keluaran = koneksi.getOutputStream();
            keluaranBuf = new BufferedWriter(new OutputStreamWriter(keluaran));
            keluaranBuf.write("OK ! Data sudah disimpan");
            keluaranBuf.newLine();
            keluaranBuf.flush();
        }
        else if(baris.equalsIgnoreCase("SHOW"))
        {
            baris = masukanReader.readLine(); //apel;07:00
            String [] ar = baris.split(";"); // 0 = apel ; 1 = 07:00
            String [] waktuReq = ar[1].split(":"); // 0 = 07 ; 1 = 00
            String hasil = "";
            
            for(pohon phn : arr){ // perulangan ,selama arr masih ada isi, diisi ke phn
                String [] waktu = phn.waktu.split(":");
                if(phn.nama.equalsIgnoreCase(ar[0]) && waktu[0].equals(waktuReq[0])){
                    hasil += phn.nama;
                    hasil += ";";
                    hasil += Integer.toString(phn.lembab);
                    hasil += ";";
                    hasil += Integer.toString(phn.uv);
                    hasil += ";";
                    hasil += Integer.toString(phn.nitro);
                    hasil += ";";
                    hasil += Integer.toString(phn.suhu);
                    
                }
            }
            
            if(hasil.equals("")){
                hasil+="Data dengan nama pohon tersebut tidak terdaftar";
            }
      
            // Kirim ke Client
            keluaran = koneksi.getOutputStream();
            keluaranBuf = new BufferedWriter(new OutputStreamWriter(keluaran));
            keluaranBuf.write(""+hasil);
            keluaranBuf.newLine();
            keluaranBuf.flush();
        }else{
            // Kirim ke Client
            keluaran = koneksi.getOutputStream();
            keluaranBuf = new BufferedWriter(new OutputStreamWriter(keluaran));
            keluaranBuf.write("Perintah tidak dikenal !");
            keluaranBuf.newLine();
            keluaranBuf.flush();
        }
}
    private Socket koneksi; 
    private ArrayList<pohon> arr;
}
