import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> linkList = new ArrayList<>();
        linkList.add("https://www.farmatodo.com.co/");
        linkList.add("https://www.farmatodo.com.co/marcas/revitalift");
        linkList.add("https://www.farmatodo.com.co/destacados/47254?utm_source=cms&utm_medium=banner_home&utm_campaign=saleoff&utm_content=belleza&utm_term=mujer25ene");

        linkList.stream().forEach(link -> getWebContent(link));
        System.out.println("sucessfull");


    }

    private static String getWebContent(String link) {
        //Download web
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            String encoding = connection.getContentEncoding();

            InputStream inputStream = connection.getInputStream();
            String result = new BufferedReader(new InputStreamReader(inputStream))
                    .lines().collect(Collectors.joining());
            return result;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return "result";

    }
}
