

public class Main {
    public static void main(String[] args){
        Pelicula p[] =new Pelicula[10];
        p[0]=new Pelicula("CARS", "niños", "carreras", 105);
        p[1]=new Pelicula("Fast & Furios", "drama", "carreras", 110);

        System.out.println(p[0].CovierteCadena());
        System.out.println(p[1].CovierteCadena());

    }
    
}
