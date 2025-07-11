
import java.util.HashMap;

public class Fabricadeletras {
    private static final HashMap<Character, Letra> letras = new HashMap<>();
    
    //Esta función implementa el patrón Flyweight
    public static Letra obtenerLetra(char c) {
        if (!letras.containsKey(c)) {
            letras.put(c, new Letra(c));
            System.out.println("Creando nueva letra: " + c);
        }
        return letras.get(c);
    }
}
