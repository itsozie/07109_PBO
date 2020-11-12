package ManajemenLaundry;
import java.util.HashMap;

public class Katalog {
    public String Katalog;
    public HashMap<String, String> katalog = new HashMap<>();
    public Katalog() {
        katalog.put("CK", "Cuci Kering");
        katalog.put("CB", "Cuci Basah");
        katalog.put("CS", "Cuci Setrika");
    }
    public String cekTipe(String Katalog) {
        return katalog.getOrDefault(Katalog, "Katalog Salah");
    }
}
