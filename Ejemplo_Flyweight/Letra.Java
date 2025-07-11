public class Letra {
    //caracter es el estado compartido (intrínseco)
    private char caracter;
    
    //Constructor que asigna el carácter a esta letra.
    public Letra(char caracter) {
        this.caracter = caracter;
    }
    /*posicion es el estado extrínseco: lo que cambia cada 
    vez y no se guarda dentro del objeto.*/
    public void mostrar(int posicion) {
        System.out.println("Letra '" + caracter + "' en posición " + posicion);
    }
}
