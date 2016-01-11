
/**
 * Write a description of class Client here.
 * 
 * @author (Nawal Nabila) 
 * @version (10 Jan 2016)
 */
import java.net.Socket;
import java.net.UnknownHostException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.BufferedWriter;

import java.util.Scanner;

public class Client {
    public void pohon()throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 33333);
        String perintah=null;

        try {
            Reader masukan = null;
            BufferedReader masukanBuff=null;
            String baris = null;
            // Ketik
            Scanner keyboard = new Scanner(System.in);
            System.out.println("============================");
            System.out.println("Welcome to Program PohonKu");
            System.out.println("============================");
            System.out.println("Perintah INSERT untuk input data pohon");
            System.out.println("Perintah SHOW untuk menampilkan data pohon");
            System.out.print("Masukkan Perintah : ");
            perintah = keyboard.nextLine();

            // Tulis ke socket
            Writer keluaranWriter = new OutputStreamWriter(socket.getOutputStream()); 
            BufferedWriter keluaranBuff = new BufferedWriter(keluaranWriter);
            keluaranBuff.write(perintah);
            keluaranBuff.write("\n");
            keluaranBuff.flush();

            if(perintah.equalsIgnoreCase("INSERT"))
            {
                String nama;
                int klbb, uv, nit, suhu;
                System.out.println("Masukkan Data Pohon");
                System.out.printf("Nama Pohon                 : ");
                nama = keyboard.nextLine();
                System.out.printf("Kelembaban Tanah <persen>  : ");
                klbb = keyboard.nextInt();
                System.out.printf("Intensitas UV <nm>         : ");
                uv = keyboard.nextInt();
                System.out.printf("Kadar Nitrogen <persen>    : ");
                nit = keyboard.nextInt();
                System.out.printf("Suhu <Celcius>             : ");
                suhu = keyboard.nextInt();
                // Tulis ke socket
                keluaranBuff.write(nama+";"+klbb+";"+uv+";"+nit+";"+suhu);
                keluaranBuff.write("\n");
                keluaranBuff.flush();

                // Baca dari Server
                System.out.print("Server ==>> ");
                masukan = new InputStreamReader(socket.getInputStream()); 
                masukanBuff = new BufferedReader(masukan);
                baris = masukanBuff.readLine();
                System.out.println(""+baris);
            }

            else if(perintah.equalsIgnoreCase("SHOW"))
            {
                String pohon, waktu;
                System.out.println("Masukkan Nama Pohon dan Waktu");
                System.out.printf("Nama Pohon     : ");
                pohon = keyboard.nextLine();
                System.out.printf("Waktu (HH:mm)  : ");
                waktu = keyboard.nextLine();
                
                // Tulis ke socket
                keluaranBuff.write(pohon+";"+waktu);
                keluaranBuff.write("\n");
                keluaranBuff.flush();

                // Baca dari Server
                masukan = new InputStreamReader(socket.getInputStream()); 
                masukanBuff = new BufferedReader(masukan);
                baris = masukanBuff.readLine();
                String [] brs = baris.split(";");

                if(brs.length < 2){    //jika nama atau waktu tidak terdaftar
                    System.out.println(baris);
                }else{
                    System.out.println("Data Pohon pada waktu tersebut adalah");
                    System.out.println("Nama Pohon                :  " +brs[0]);
                    System.out.println("Kelembaban Tanah <persen> :  " +brs[1]);
                    System.out.println("Intensitas UV <nm>        :  " +brs[2]);
                    System.out.println("Kadar Nitrogen <persen>   :  " +brs[3]);
                    System.out.println("Suhu <Celcius>            :  " +brs[4]);
                } 
            }

            else
            {
                //Tulis ke Socket
                keluaranBuff.write(perintah);
                keluaranBuff.write("\n");
                keluaranBuff.flush();

                // Baca dari Server
                System.out.print("Server ==>> ");
                masukan = new InputStreamReader(socket.getInputStream()); 
                masukanBuff = new BufferedReader(masukan);
                baris = masukanBuff.readLine();
                System.out.println(""+baris);
            }
        }
        catch(IOException salah) {
            System.out.println(salah);
        }

        finally {
            if (socket != null)
                socket.close();
        }
    }
}
