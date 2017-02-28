import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

public class CallingHttp {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.mocky.io/v2/58af769e1200000e0674227d");
        //Insert your JSON query request
        String query = "{'PARAM1': 'VALUE','PARAM2': 'VALUE','PARAM3': 'VALUE','PARAM4': 'VALUE'}";
        //It change the apostrophe char to double colon char, to form a correct JSON string
        query=query.replace("'", "\"");

        try{
            //make connection
            URLConnection urlc = url.openConnection();
            //It Content Type is so importan to support JSON call
            urlc.setRequestProperty("Content-Type", "application/xml");
            Msj("Conectando: " + url.toString());
            //use post mode
            urlc.setDoOutput(true);
            urlc.setAllowUserInteraction(false);

            //send query
            PrintStream ps = new PrintStream(urlc.getOutputStream());
            ps.print(query);
            Msj("Consulta: " + query);
            ps.close();

            //get result
            BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
            String l = null;
            while ((l=br.readLine())!=null) {
                Msj(l);
            }
            br.close();
        } catch (Exception e){
            Msj("Error ocurrido");
            Msj(e.toString());
        }
    }

    private static void Msj(String texto){
        System.out.println(texto);
    }
}