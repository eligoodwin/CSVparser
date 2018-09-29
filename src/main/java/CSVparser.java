import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CSVparser {
    private static final String REGEX_PATTERN = "\\[.*\\]";
    private static final String SPLIT_ON = ",";

    public ArrayList<ClientInfo> getClients(String fileName){
        String line = "";
        ArrayList<ClientInfo> clients = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            //get rid of the first line
            br.readLine();
            while((line = br.readLine()) != null){
                String[] clientInfo = line.split(SPLIT_ON);
                String testName = clientInfo[0].replaceAll(REGEX_PATTERN, "");
                clients.add(new ClientInfo(testName,
                        clientInfo[21],
                        clientInfo[23],
                        clientInfo[24],
                        clientInfo[25]));
            }
            return clients;
        }catch (IOException e){
            e.printStackTrace();
            return clients;
        }
    }

    public BeerInfo getBeerInfo(String fileName) throws IOException {
        String beerName = Files.readAllLines(Paths.get(fileName)).get(2).split(SPLIT_ON)[1];
        String beerStyle = Files.readAllLines(Paths.get(fileName)).get(4).split(SPLIT_ON)[1];
        String[] beerHopsArray = Files.readAllLines(Paths.get(fileName)).get(6).split(SPLIT_ON);
        StringBuilder holder = new StringBuilder();
        for (String hop: beerHopsArray) {
            if(!hop.equals("") && !hop.equals(",") && !hop.equals("Hops:")) {
                holder.append(hop);
            }
        }
        String beerHops = holder.toString();
        if(beerHops.contains(",")){
            beerHops = beerHops.substring(1, beerHops.length() -1);
        }
        String abv = Files.readAllLines(Paths.get(fileName)).get(10).split(SPLIT_ON)[1];
        String ibu = "0";
        System.out.printf("Beer name: %s\n" +
                "Beer style: %s\n" +
                "Beer hops: %s\n" +
                "Beer abv: %s\n" +
                "Beer ibu: %s\n", beerName, beerStyle, beerHops, abv, ibu
        );
        return new BeerInfo(beerName, beerStyle, beerHops, abv, ibu);
    }
}
