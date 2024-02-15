
public class Inicio {
    
    public static void main(String [] args){
     
        Personaje p1 = new Personaje("ERNESTO", 100, 100);
        
        
        p1.agregaItem("espada0 ", 0);
        p1.agregaItem("espada1 ", 1);
        p1.agregaItem("espada2 ", 2);
        p1.agregaItem("espada3 ", 3);
        p1.agregaItem("espada4 ", 4);
        p1.agregaItem("espada5 ", 5);
        p1.agregaItem("espada6 ", 6);
        p1.agregaItem("espada7 ", 7);
        p1.agregaItem("espada8 ", 8);
        p1.agregaItem("espada9 ", 9);
        
        System.out.println(p1.convierteACadena());
        
    
    }
    
}
