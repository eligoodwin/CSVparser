
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        String filename = "./src/main/resources/private eyes.csv";
        String clientsFile = "./src/main/resources/invoice.csv";
        CSVparser parser = new CSVparser();
        try {
            BeerInfo beerInfo = parser.getBeerInfo(filename);
            System.out.println(beerInfo.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Printing out clients now");
        ArrayList<ClientInfo> clients = parser.getClients(clientsFile);
        clients.forEach(e -> {
            System.out.println(e.toString());
        });

        Set<String> cities = new HashSet<>();
        clients.forEach( e -> cities.add(e.getCity()));
        cities.forEach(System.out::println);

    }
}
