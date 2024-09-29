import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Api_2 {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://zelda.fanapis.com/api/games?limit=2");

            // Abrir la conexión
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("error: " + responseCode);
            }else {
                StringBuilder informacionString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNextLine()) {
                    informacionString.append(scanner.nextLine());
                }
                scanner.close();

                System.out.println(informacionString);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
