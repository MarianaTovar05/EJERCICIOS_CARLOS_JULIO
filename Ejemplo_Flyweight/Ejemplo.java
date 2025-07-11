
public class Ejemplo {  
    public static void main(String[] args) {
        String texto = "ABABAC";

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            Letra letra = FabricaLetras.obtenerLetra(c);
            letra.mostrar(i);
        }
    }
}
