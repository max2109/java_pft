import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpRequest {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.mocky.io/v2/58af68a01200009904742270");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;
            while (null != (str = br.readLine())) {
                System.out.println(str);}
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}