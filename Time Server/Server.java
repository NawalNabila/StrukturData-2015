
/**
 * Write a description of class Server here.
 * 
 * @author (Nawal Nabila) 
 * @version (23 December 2015)
 */
import java.net.Socket;
import java.net.ServerSocket;
import java.net.BindException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

import java.util.Scanner;

public class Server {
    public Server() 
           throws BindException, IOException {
        serverSocket = new ServerSocket(33333);
    }
    
    public void dengar() throws IOException {
        System.out.println("Menunggu koneksi...");
        while (true) {
            Socket koneksi = null;
            try {
                koneksi = serverSocket.accept();
                ProcessServerThread satuProcess = new ProcessServerThread(koneksi);
                Thread satuProcessThread = new Thread(satuProcess);
                satuProcessThread.start();
                
            }
            catch(IOException err) {
                System.out.println(err);
            }
            
        }
    }
    private ServerSocket serverSocket = null;
}
