import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class Api_3 {
    public static void main(String[] args) {


        try{
            URL url = new URL("https://rickandmortyapi.com/api/character/636");

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

}}
