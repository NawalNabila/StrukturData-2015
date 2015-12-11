import java.io.IOException;
import java.net.UnknownHostException;

public class Utama {
    public static void main(String[] args) {
        try {
            Client tanya = new Client();
            tanya.whois("GET index.html\n");
        }
        catch (UnknownHostException ex) {
            System.err.println(ex);
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
