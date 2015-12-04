
/**
 * Write a description of class utamaclient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.IOException;
import java.net.UnknownHostException;

public class UtamaClient
{
    public static void main(String[] args) {
        try {
            Client kirim = new Client();
            kirim.whois("");
        }
        catch (UnknownHostException ex) {
            System.err.println(ex);
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
