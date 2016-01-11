/**
 * Write a description of class UtamaServer here.
 * 
 * @author (Nawal Nabila) 
 * @version (10 Jan 2016)
 */
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

import java.net.Socket;
import java.net.UnknownHostException;

public class UtamaServer {
    public static void main(String[] args) 
                       throws UnknownHostException, IOException {
        Server server = new Server();
        server.dengar();
    }
}
