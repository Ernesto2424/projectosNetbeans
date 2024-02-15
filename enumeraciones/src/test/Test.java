package test;

import enumeracion.Dias;

public class Test {

    public static void main(String[] args) {
        System.out.println("Dia 1 "+Dias.LUNES);
        dias(Dias.MARTES);
    }
    
    private static void dias(Dias dias){
        switch(dias){
            case LUNES:
                System.out.println("PRIMER DIA");
                break;
                
                case MARTES:
                System.out.println("SEGUNDO DIA");
                break;
                
                case MIERCOLES:
                System.out.println("TERCERO DIA");
                break;
        }
    }
    
}
