import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class utamaChat {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(System.in);
            chat tanya = new chat();
            System.out.print("Message : ");
            String in = keyboard.next();
            tanya.whois(in);
        }
        catch (UnknownHostException ex) {
            System.err.println(ex);
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
