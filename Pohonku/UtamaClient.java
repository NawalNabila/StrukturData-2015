
/**
 * Write a description of class UtamaClient here.
 * 
 * @author (Nawal Nabila) 
 * @version (10 Jan 2016)
 */
import java.io.IOException;

import java.net.UnknownHostException;

public class UtamaClient {
    public static void main(String[] args)
                  throws UnknownHostException, IOException {
        Client client = new Client();
        client.pohon();
    }
}
