public class Cat {
    public static void main(String[] args) {
     //Definición 
     gat Mufasa;
     //Instancia del objeto
     Mufasa= new gat();
     Mufasa.name="Mufasa";
     Mufasa.age=2;
     Mufasa.weigth=3;
     Mufasa.gender="Masculino";
      //atributo privado
      //Mufasa.color="Blanco";
      Mufasa.setColor("cafe");

    gat manchas= new gat();
     manchas.name="Manchas";
     manchas.age=2;
     manchas.weigth=3;
     manchas.gender="Masculino";
     //manchas.color="Blanco";
     manchas.setColor("Blanco");
     
    System.out.println("Gato 1");
    System.out.println("Nombre:"+ Mufasa.name);
    System.out.println("Edad: " + Mufasa.age + " años");
    System.out.println("Peso: "+ Mufasa.weigth + " Kg");
    System.out.println("Genero: " + Mufasa.gender);
    System.out.println("Color: " + Mufasa.getColor());
     Mufasa.breathe();
    Mufasa.eat("Comida"); 
    Mufasa.meow();
    Mufasa.run("la Scocina");

    System.out.println("Gato 2");
    System.out.println("Nombre: "+ manchas.name);
    System.out.println("Edad: " + manchas.age + " años");
    System.out.println("Peso : "+ manchas.weigth + " Kg");
    System.out.println("Genero : " + manchas.gender);
    System.out.println("Color :" + manchas.getColor());
}
}

