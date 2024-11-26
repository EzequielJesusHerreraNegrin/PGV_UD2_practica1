import com.salesianoslacuesta.resources.Crop;
import com.salesianoslacuesta.threads.Client;
import com.salesianoslacuesta.threads.Farmer;

public class App {
    public static void main(String[] args) throws Exception {
        Crop crop = new Crop();

        
        Farmer farmerr = new Farmer("luis", 5, crop);
        Client client = new Client("Pepe", 5, crop);

        farmerr.setPriority(Thread.MAX_PRIORITY);
        
        farmerr.start();
        client.start();

        farmerr.join();
        client.join();


        


    }

}
